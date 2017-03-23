package spikeking.github.com.testrxandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import spikeking.github.com.testrxandroid.network.NetActivityTest;

public class AMainActivity extends AppCompatActivity {

    @Bind(R.id.main_root_view)
    RelativeLayout mRootView;

    @Bind(R.id.main_thread)
    Button mThreadButton;

    @Bind(R.id.main_async)
    Button mAsyncButton;

    @Bind(R.id.main_rx)
    Button mRxButton;
    @OnClick(R.id.main_rx)
    public void gotoTest(){
        startActivity(new Intent(AMainActivity.this,NetActivityTest.class));
        finish();
    }

    @Bind(R.id.bact)
    TextView bact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 线程运行
        mThreadButton.setOnClickListener(v -> {
            mThreadButton.setEnabled(false);
            longRunningOperation();
            Snackbar.make(mRootView, longRunningOperation(), Snackbar.LENGTH_LONG).show();
            mThreadButton.setEnabled(true);
        });

        // 异步运行
        mAsyncButton.setOnClickListener(v -> {
            mAsyncButton.setEnabled(false);
            new MyAsyncTasks().execute();
        });

        new RXBasicTest().obsJustT();

        new RXBasicTest().normalObs();

        new RXIncompleteTest().testIncompletes();

        new RXIncompleteTest().getAction1Test(this);

        new RXSchedulerTest().onSubscribeTest();

        new TransformTest().testTransform(this,bact);

        new TransformTest().transFormOb();

        new TransformTest().transFitMap();

        // 使用IO线程处理, 主线程响应
        Observable<String> observable2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(longRunningOperation());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }

    // 异步线程
    private class MyAsyncTasks extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            Snackbar.make(mRootView, s, Snackbar.LENGTH_LONG).show();
            mAsyncButton.setEnabled(true);
        }

        @Override
        protected String doInBackground(Void... params) {
            return longRunningOperation();
        }
    }

    // 长时间运行的任务
    private String longRunningOperation() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            Log.e("DEBUG", e.toString());
        }

        return "Complete!";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
