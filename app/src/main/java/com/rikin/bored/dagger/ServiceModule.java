package com.rikin.bored.dagger;

import android.support.annotation.NonNull;

import com.rikin.bored.com.rikin.bored.model.repository.TwitchService;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    private static final String TWITCH_CLIENT_ID = "cwv523u1mq9semkkd4sn4uvaayan61";

    @Provides
    @Singleton
    public OkHttpClient providesOkHttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request original = chain.request();
                        Request modified = original.newBuilder()
                                .addHeader("Client-ID", TWITCH_CLIENT_ID)
                                .build();
                        return chain.proceed(modified);
                    }
                })
                .build();
    }

    @Provides
    @Singleton
    @Named("Twitch")
    public Retrofit providesRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://api.twitch.tv/helix/")
                .build();
    }

    @Provides
    @Singleton
    public TwitchService providesTwitchService(@Named("Twitch") Retrofit retrofit) {
        return retrofit.create(TwitchService.class);
    }
}
