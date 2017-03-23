package spikeking.github.com.testrxandroid.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import spikeking.github.com.testrxandroid.R;
import spikeking.github.com.testrxandroid.network.module.UserInfo;
import spikeking.github.com.testrxandroid.network.module.infoTest;

/**
 * Created by lumin on 2017/3/22.
 */

public class NetActivityTest extends AppCompatActivity {


    @Bind(R.id.test11)
    TextView test11;

    @Bind(R.id.progress)
    ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_net_result);
        ButterKnife.bind(this);
        search();

    }


    public void search() {
        Observer<List<infoTest>> observer = new Observer<List<infoTest>>() {
            @Override
            public void onCompleted() {
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onNext(List<infoTest> images) {
                test11.setText(images.get(0).description);
                Toast.makeText(NetActivityTest.this, "success", Toast.LENGTH_SHORT).show();
            }
        };

        try{
            LoginApi moduleService = (LoginApi) RetrofitClient.getInstance().create(LoginApi.class);
            moduleService.search("可爱")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }catch (Exception e){
            e.printStackTrace();
        }


    }



    public void login(){

        LoginApi moduleService = (LoginApi) RetrofitClient.getInstance().create(LoginApi.class);
        moduleService.LoginAngel("15001336113", "123456")
                .flatMap(new Func1<UserInfo, Observable<String>>() {
                    @Override
                    public Observable<String> call(UserInfo userInfo) {
                        return Observable.just(userInfo.getNickName());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        progress.setVisibility(View.GONE);
                        test11.setText("erro");
                    }

                    @Override
                    public void onNext(String s) {
                        test11.setText(s);

                    }
                });
    }



}
