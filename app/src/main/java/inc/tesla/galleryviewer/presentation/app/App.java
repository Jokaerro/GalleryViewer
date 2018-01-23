package inc.tesla.galleryviewer.presentation.app;

import android.app.Application;

import inc.tesla.galleryviewer.presentation.di.AppComponent;
import inc.tesla.galleryviewer.presentation.di.AppModule;

/**
 * Created by TESLA on 23.01.2018.
 */

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

    }

    private void initComponent() {
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
