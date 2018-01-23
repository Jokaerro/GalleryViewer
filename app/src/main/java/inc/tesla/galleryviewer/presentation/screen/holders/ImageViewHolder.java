package inc.tesla.galleryviewer.presentation.screen.holders;

import android.net.Uri;
import android.os.AsyncTask;
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

    private CalcMd5Task calcMd5Task;

    public ImageViewHolder(View itemView) {

        super(itemView);
    }

    public void fill(final ImageGalleryItem item) {
        ImageGalleryView imageGalleryView = (ImageGalleryView)itemView;

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
                        progressView.setVisibility(View.GONE);
                    }
                });

        imageGalleryView.getImageName().setText(item.getImageName());

        calcMd5Task = new CalcMd5Task();
        calcMd5Task.execute(item.getImageUri());

        float fileSizeInMB = item.getImageSize() / 1024.0f / 1024.0f;
        imageGalleryView.getImageSize().setText(itemView.getContext().getResources().getString(R.string.image_size, fileSizeInMB));
    }

    public void reset() {
        calcMd5Task.cancel(true);
    }

    private class CalcMd5Task extends AsyncTask<Uri, Void, String> {

        @Override
        protected String doInBackground(Uri... uris) {
            Uri path = uris[0];
            return Utils.fileToMD5(path, itemView.getContext());
        }

        @Override
        protected void onPostExecute(String s) {
            ((ImageGalleryView)itemView).getImageHash().setText(itemView.getContext().getResources().getString(R.string.image_hash, s));
        }
    }

}
