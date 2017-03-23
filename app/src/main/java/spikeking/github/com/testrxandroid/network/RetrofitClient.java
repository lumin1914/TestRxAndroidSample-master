package spikeking.github.com.testrxandroid.network;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lumin on 2017/3/22.
 */

public class RetrofitClient<T> {

    private String HTTP_ADDRESS_BASE = "http://www.zhuangbi.info/";

    private Retrofit retrofit = null;

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(HTTP_ADDRESS_BASE)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static class RetrofitClientHolder{
        private static RetrofitClient mInstance = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return RetrofitClientHolder.mInstance;
    }


    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

}
