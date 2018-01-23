package inc.tesla.galleryviewer.data;

import android.net.Uri;

import java.io.Serializable;


/**
 * Created by TESLA on 23.01.2018.
 */

public class ImageGalleryItem extends BaseModel {
    private Uri imageUri;
    private String imageName;
    private long imageSize;

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public long getImageSize() {
        return imageSize;
    }

    public void setImageSize(long imageSize) {
        this.imageSize = imageSize;
    }
}
