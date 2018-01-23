package inc.tesla.galleryviewer.presentation.screen.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import inc.tesla.galleryviewer.R;
import inc.tesla.galleryviewer.data.ImageGalleryItem;
import inc.tesla.galleryviewer.presentation.screen.view.ImageGalleryView;
import inc.tesla.galleryviewer.presentation.util.Utils;

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

        imageGalleryView
                .getImageHash()
                .setText(itemView.getContext().getResources().getString(R.string.image_hash,
                        Utils.fileToMD5(item.getImageUri(), itemView.getContext())));

        float fileSizeInMB = item.getImageSize() / 1024.0f / 1024.0f;
        imageGalleryView.getImageSize().setText(itemView.getContext().getResources().getString(R.string.image_size, fileSizeInMB));

        final ProgressBar progressView = imageGalleryView.getProgressView();
        Picasso.with(itemView.getContext())
                .load(item.getImageUri())
                .resize(200, 200)
                .centerCrop()
                .into(imageGalleryView.getImageView(), new Callback() {
                    @Override
                    public void onSuccess() {
                        progressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

}
