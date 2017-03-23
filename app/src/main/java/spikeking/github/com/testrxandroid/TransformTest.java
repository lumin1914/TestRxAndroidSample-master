package spikeking.github.com.testrxandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lumin on 2017/3/21.
 */

public class TransformTest {


    public void testTransform(Context context, TextView bact) {
        Observable.just(R.mipmap.ic_launcher) // 输入类型 int
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(Schedulers.io())
                .map(new Func1<Integer, Bitmap>() {
                    @Override
                    public Bitmap call(Integer filePath) { // 参数类型 String
                        Resources res = context.getResources();
                        Bitmap bmp = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
                        return bmp; // 返回类型 Bitmap
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) { // 参数类型 Bitmap
                        bact.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                });
    }


    public void transFormOb() {
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        };

        Student[] students = {new Student("cc"), new Student("gg")};
        Observable.from(students)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                        Log.e("--------", "----map----" + s);
                    }
                });
    }


    public void transFitMap() {
        Student[] students = {new Student("cc", new Course[]{new Course("语文1"), new Course("语文2")}),
                new Student("gg", new Course[]{new Course("数学1"), new Course("数学2")})};
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.courses);
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course courses) {
                        Log.e("--------", "----flatMap----" + courses.coutseName);
                    }
                });
    }


}
