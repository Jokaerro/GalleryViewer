package inc.tesla.galleryviewer.presentation.screen.adapters;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inc.tesla.galleryviewer.R;
import inc.tesla.galleryviewer.data.DataMapper;
import inc.tesla.galleryviewer.data.ImageGalleryItem;
import inc.tesla.galleryviewer.presentation.screen.holders.ImageViewHolder;

/**
 * Created by TESLA on 23.01.2018.
 */

public class ImageGalleryAdapter extends BaseAdapter<ImageViewHolder> {
    public ImageGalleryAdapter(Cursor cursor) {
        super(cursor);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, Cursor cursor) {
        viewHolder.fill(DataMapper.fromCursorImageGalleryItem(cursor));
    }

    @Override
    protected ImageGalleryItem getItemModel(Cursor cursor) {
        return DataMapper.fromCursorImageGalleryItem(cursor);
    }

    @Override
    public void onViewRecycled(ImageViewHolder holder) {
        super.onViewRecycled(holder);
        holder.reset();
    }
}
