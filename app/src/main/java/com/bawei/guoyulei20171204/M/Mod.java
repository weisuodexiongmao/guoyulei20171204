package com.bawei.guoyulei20171204.M;

import com.bawei.guoyulei20171204.Bean.Bean;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/4.
 */

public class Mod {
    public void getData(final showData data){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.Url)
                .addConverterFactory(GsonConverterFactory.create())
                //支持Rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Dataapi dataapi = retrofit.create(Dataapi.class);
        //得到Observable被观察者      生产事件 得到数据源
        Observable<Bean> observable = dataapi.Data();
        //被观察者订阅观察者  默认在同一个线程
        observable
                //指定io线程做耗时操作
                .subscribeOn(Schedulers.io())
                //指定更新UI在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {//完成

                    }

                    @Override
                    public void onError(Throwable e) {//失败

                    }

                    @Override  //消费事件
                    public void onNext(Bean bean) {
                        data.shuju(bean);
                    }


                });

    }
    public interface showData{
        void shuju(Bean bean);
    }
}
