package inc.tesla.galleryviewer.presentation.screen.adapters;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.provider.BaseColumns;
import android.support.v7.widget.RecyclerView;

import inc.tesla.galleryviewer.data.BaseModel;

/**
 * Created by TESLA on 23.01.2018.
 */

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private Cursor cursor;
    private boolean dataValid;
    private ChangeObservable dataSetObserver;

    public BaseAdapter(Cursor cursor) {
        this.cursor = cursor;
        this.dataValid = cursor != null;
        this.dataSetObserver = new ChangeObservable();
        if (cursor != null) {
            cursor.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override
    public int getItemCount() {
        if (dataValid && cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public abstract void onBindViewHolder(T viewHolder, Cursor cursor);

    @Override
    public void onBindViewHolder(T viewHolder, int position) {
        if (!dataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!cursor.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        onBindViewHolder(viewHolder, cursor);
    }

    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == cursor) {
            return null;
        }
        final Cursor oldCursor = cursor;
        if (oldCursor != null && dataSetObserver != null) {
            oldCursor.unregisterDataSetObserver(dataSetObserver);
        }
        cursor = newCursor;
        if (cursor != null) {
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
            dataValid = true;
            notifyDataSetChanged();
        } else {
            dataValid = false;
            notifyDataSetChanged();
        }
        return oldCursor;
    }

    protected Cursor getCursor() {
        return cursor;
    }

    public <RI extends BaseModel> RI getItem(int position) {
        Cursor cursor = getItemCursor(position);
        if (cursor == null) {
            return null;
        }
        return getItemModel(cursor);
    }

    protected abstract <RI extends BaseModel> RI getItemModel(Cursor cursor);

    protected Cursor getItemCursor(int position) {
        if (dataValid && cursor != null && cursor.moveToPosition(position)) {
            return cursor;
        } else {
            return null;
        }
    }

    public class ChangeObservable extends DataSetObserver {
        @Override
        public void onChanged() {
            super.onChanged();
            notifyDataSetChanged();
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
            notifyDataSetChanged();
        }
    }
}
