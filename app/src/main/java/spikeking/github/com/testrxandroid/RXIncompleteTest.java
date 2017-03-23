package spikeking.github.com.testrxandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;

/**
 * 支持不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber
 */

public class RXIncompleteTest {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void testIncompletes() {

        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                Log.e("----", "Incomplete-----" + s);
            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };


        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                Log.e("----", "Incomplete-----" + "completed");
            }
        };


        /**
         * 这段代码中出现的 Action1 和 Action0。 Action0 是 RxJava 的一个接口，它只有一个方法 call()，
         * 这个方法是无参无返回值的；由于 onCompleted() 方法也是无参无返回值的，
         * 因此 Action0 可以被当成一个包装对象，将 onCompleted() 的内容打包起来将自己作为一个参数传入 subscribe()
         * 以实现不完整定义的回调。这样其实也可以看做将 onCompleted() 方法作为参数传进了 subscribe()。
         * Action1 也是一个接口，它同样只有一个方法 call(T param)，这个方法也无返回值，
         * 但有一个参数；与 Action0 同理，由于 onNext(T obj) 和 onError(Throwable error) 也是单参数无返回值的，
         * 因此 Action1 可以将 onNext(obj) 和 onError(error) 打包起来传入 subscribe() 以实现不完整定义的回调。
         */
        Observable observable = Observable.just("IncompleteObs11", "IncompleteObs22");
        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction
        // 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);


        String[] names = {"aa", "bb", "cc"};
        Observable.from(names)
                .subscribe(s -> {
                    Log.e("----", "from-----" + s);
                });
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void getAction1Test(Context context) {
        int drawableRes = R.mipmap.ic_launcher;

        Action1<Drawable> action1 = new Action1<Drawable>() {
            @Override
            public void call(Drawable o) {

                Log.e("----", "action1-----" + o.toString());
            }
        };

        Observable.just(context.getDrawable(drawableRes))
                .subscribe(action1);
    }


}
