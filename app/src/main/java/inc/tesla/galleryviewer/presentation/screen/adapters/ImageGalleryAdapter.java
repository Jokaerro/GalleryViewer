package inc.tesla.galleryviewer.presentation.screen.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import inc.tesla.galleryviewer.R;
import inc.tesla.galleryviewer.data.BaseModel;
import inc.tesla.galleryviewer.data.DataMapper;
import inc.tesla.galleryviewer.data.ImageGalleryItem;
import inc.tesla.galleryviewer.presentation.screen.holders.ImageViewHolder;

/**
 * Created by TESLA on 23.01.2018.
 */

public class ImageGalleryAdapter extends BaseAdapter<ImageViewHolder> {

    @Inject
    public Context context;
    @Inject
    public Picasso picasso;
    private Cursor cursor;
    private boolean dataValid;
    private ChangeObservable dataSetObserver;

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
}
