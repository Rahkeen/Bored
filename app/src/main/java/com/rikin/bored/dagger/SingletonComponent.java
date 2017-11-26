package com.rikin.bored.dagger;

import com.rikin.bored.base.MainActivity;
import com.rikin.bored.view.StreamListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ServiceModule.class)
public interface SingletonComponent {
    void inject(MainActivity activity);
    void inject(StreamListFragment fragment);
}
