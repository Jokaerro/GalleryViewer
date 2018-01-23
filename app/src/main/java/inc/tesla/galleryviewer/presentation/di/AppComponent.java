package inc.tesla.galleryviewer.presentation.di;

import javax.inject.Singleton;

import dagger.Component;
import inc.tesla.galleryviewer.presentation.screen.MainActivity;

/**
 * Created by TESLA on 23.01.2018.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
