package com.mert.bounty.di;

import android.app.Application;
import android.content.Context;

import com.mert.bounty.data.api.BountyApiClient;
import com.mert.bounty.data.BountyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mert.bounty.data.api.GettyClientConfig.BASE_ENDPOINT;

/**
 * Created by Mert Kilic on 18.7.2017.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    BountyService provideBountyService(OkHttpClient client) {

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_ENDPOINT)
                .client(client)
                .build().create(BountyService.class);


    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    BountyApiClient provideBountyApiClient(BountyService bountyService) {
        return new BountyApiClient(bountyService);
    }

    /*@Provides
    @Singleton
    Interceptor provideInterceptor() {
        return new OfflineMockInterceptor();
    }*/

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
