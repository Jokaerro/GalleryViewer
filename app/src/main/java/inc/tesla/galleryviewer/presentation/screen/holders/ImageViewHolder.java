package inc.tesla.galleryviewer.presentation.screen.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.squareup.picasso.Picasso;

import inc.tesla.galleryviewer.data.ImageGalleryItem;
import inc.tesla.galleryviewer.presentation.screen.view.ImageGalleryView;

/**
 * Created by TESLA on 23.01.2018.
 */

public class ImageViewHolder  extends RecyclerView.ViewHolder {

    public ImageViewHolder(View itemView) {

        super(itemView);
    }

    public void fill(final ImageGalleryItem item) {
        ImageGalleryView imageGalleryView = (ImageGalleryView)itemView;

        imageGalleryView.getImageName().setText(item.getImageName());
        imageGalleryView.getImageSize().setText(String.valueOf(item.getImageSize()));
        imageGalleryView.getImageHash().setText("hash");

        Picasso.with(itemView.getContext())
                .load(item.getImageUri())
                .into(imageGalleryView.getImageView());
    }

}
