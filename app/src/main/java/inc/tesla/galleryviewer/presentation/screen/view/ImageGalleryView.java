package inc.tesla.galleryviewer.presentation.screen.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import inc.tesla.galleryviewer.R;

/**
 * Created by TESLA on 23.01.2018.
 */

public class ImageGalleryView extends LinearLayout {

    private ImageView imageView;
    private TextView imageName;
    private TextView imageHash;
    private TextView imageSize;

    public ImageGalleryView(Context context) {
        super(context);
    }

    public ImageGalleryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageGalleryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if(isInEditMode()){
            return;
        }
        onInit();
    }

    private void onInit() {
        imageView = findViewById(R.id.image);
        imageName = findViewById(R.id.name);
        imageHash = findViewById(R.id.md5);
        imageSize = findViewById(R.id.size);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getImageName() {
        return imageName;
    }

    public TextView getImageHash() {
        return imageHash;
    }

    public TextView getImageSize() {
        return imageSize;
    }
}
