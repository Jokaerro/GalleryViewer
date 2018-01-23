package inc.tesla.galleryviewer.data;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by TESLA on 23.01.2018.
 */

public class DataMapper {

    public static ImageGalleryItem fromCursorImageGalleryItem(Cursor cursor) {
        ImageGalleryItem imageGalleryItem = new ImageGalleryItem();
        imageGalleryItem.setImageName(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
        imageGalleryItem.setImageSize(cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.SIZE)));

        Uri imageUri = ContentUris
                        .withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                cursor.getInt(cursor.getColumnIndex(MediaStore.Images.ImageColumns._ID)));
        imageGalleryItem.setImageUri(imageUri);

        return imageGalleryItem;
    }
}
