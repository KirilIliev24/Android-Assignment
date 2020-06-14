package com.example.and_final_project.API;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//https://www.thecocktaildb.com/api/json/v1/1/random.php
public class ServiceGenerator {
    private static OkHttpClient OkHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                final String apikey = "1";

                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl httpUrl = original.url();

                    HttpUrl newUrl = httpUrl.newBuilder().addQueryParameter("key", apikey).build();

                    Request.Builder requestBuilder = original.newBuilder().url(newUrl);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            })
            .build();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/")
            .client(OkHttpClient)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();
    private static DrinkApi drinkApi = retrofit.create(DrinkApi.class);

    public static DrinkApi getDrinkApi()
    {
        return drinkApi;
    }
}
