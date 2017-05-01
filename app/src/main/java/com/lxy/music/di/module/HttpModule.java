package com.lxy.music.di.module;

import com.lxy.music.data.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lxy on 2017/5/1.
 */

@Module
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provieOkHttpClient() {

        // log用拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 如果使用到HTTPS，我们需要创建SSLSocketFactory，并设置到client
        //  SSLSocketFactory sslSocketFactory = null;

        return new OkHttpClient.Builder()
        // HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
//                .addInterceptor(new HeadInterceptor())
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10,TimeUnit.SECONDS)
                    .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        return builder.build();

    }

    @Provides
    @Singleton
    public ApiService provideApiservice(Retrofit retrofit){

        return retrofit.create(ApiService.class);
    }
}
