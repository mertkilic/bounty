package com.mert.bounty.di;

import com.mert.bounty.BountyApp;
import com.mert.bounty.ui.MainBuilder;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Mert Kilic on 18.7.2017.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        MainBuilder.class})
public interface AppComponent extends AndroidInjector<BountyApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BountyApp> {
    }
}
