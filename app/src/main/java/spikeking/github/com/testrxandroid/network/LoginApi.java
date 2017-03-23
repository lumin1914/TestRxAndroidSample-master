package spikeking.github.com.testrxandroid.network;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import spikeking.github.com.testrxandroid.network.module.UserInfo;
import spikeking.github.com.testrxandroid.network.module.infoTest;

/**
 * Created by lumin on 2017/3/22.
 */

public interface LoginApi {

    @GET("user/login")
    Observable<UserInfo> LoginAngel(@Query("user") String user, @Query("password") String password);

    @GET("search")
    Observable<List<infoTest>> search(@Query("q") String query);


}
