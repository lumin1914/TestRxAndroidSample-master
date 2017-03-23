package spikeking.github.com.testrxandroid;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by lumin on 2017/3/20.
 */

public class RXBasicTest {

    public void normalObs() {
        //创建观察者
        //Subscriber 即观察者，它决定事件触发的时候将有怎样的行为
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

                //事件队列完结,不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志
            }

            @Override
            public void onError(Throwable e) {
                //onError(): 事件队列异常
            }

            @Override
            public void onNext(String so) {

                //普通事件
                Log.e("---------", "-----" + so);
            }
        };


        //创建被观察者
        /**
         * 这里传入了一个 OnSubscribe 对象作为参数。OnSubscribe 会被存储在返回的 Observable 对象中，
         * 它的作用相当于一个计划表，当 Observable 被订阅的时候，OnSubscribe 的 call() 方法会自动被调用，
         * 事件序列就会依照设定依次触发
         * （对于上面的代码，就是观察者Subscriber 将会被调用三次 onNext() 和一次 onCompleted()）。这样，
         * 由被观察者调用了观察者的回调方法，就实现了由被观察者向观察者的事件传递，即观察者模式
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("00");
                subscriber.onNext("11");
                subscriber.onNext("22");
                subscriber.onCompleted();
            }

        });

        observable.subscribe(subscriber);

    }


    /**
     * create() 方法是 RxJava 最基本的创造事件序列的方法。基于这个方法，
     * RxJava 还提供了一些方法用来快捷创建事件队列
     * just(T...): 将传入的参数依次发送出来。
     */
    public void obsJustT() {
        //创建观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String so) {

                Log.e("---------", "-----" + so);
            }
        };


        /*** 等价 create(OnSubscribe) */
        Observable observable = Observable.just("Hello", "Hi", "Aloha");
        // 将会依次调用：
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();

        observable.subscribe(observer);


        /*** 等价 create(OnSubscribe) */
        /**
         * from(T[]) / from(Iterable<? extends T>) : 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
         */
        String[] words = {"11", "22", "333"};
        Observable observables = Observable.from(words);
        Subscription subscriber = observables.subscribe(observer);

    }


}
