package spikeking.github.com.testrxandroid;

import android.graphics.Bitmap;
import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lumin on 2017/3/20.
 */

public class RXSchedulerTest {


    public void onSubscribeTest() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Log.e("-------", "number:" + number);
                    }
                });
    }


    public void mapTest() {

        Observable.just("images/logo.png") // 输入类型 String
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) { // 参数类型 String
                        return null; //getBitmapFromPath(filePath); // 返回类型 Bitmap
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) { // 参数类型 Bitmap
                        //showBitmap(bitmap);
                    }
                });


    }

}
