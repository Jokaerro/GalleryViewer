package inc.tesla.galleryviewer.presentation.di;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TESLA on 23.01.2018.
 */

@Module
public class AppModule {
    private Context context;
    private Picasso picasso;

    public AppModule(Context context) {
        this.context = context;
        this.picasso = Picasso.with(context);
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Picasso providePicasso() {
        return picasso;
    }
}
