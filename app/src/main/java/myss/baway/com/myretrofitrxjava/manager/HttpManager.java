package myss.baway.com.myretrofitrxjava.manager;

import java.util.Map;

import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import myss.baway.com.myretrofitrxjava.bean.TryUser;
import myss.baway.com.myretrofitrxjava.interfac.ProjectApI;
import myss.baway.com.myretrofitrxjava.interfac.RequestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 陈驰 on 2017/5/12.
*/

public class HttpManager {
    public static void getMethod(String baseUrl, String url, final Callback<String> callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(ScalarsConverterFactory.create()).build();
      //java 动态
        ProjectApI projectApI = retrofit.create(ProjectApI.class);
        Call<String> call = projectApI.getMethod(url);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
            callback.onResponse(call,response);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
              callback.onFailure(call,t);
            }
        });
    }

    public static void getMethod3(String baseUrl, Map<String,String> map, Observer observer){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(baseUrl).build();
        RequestAPI projectApI = retrofit.create(RequestAPI.class);
        Observable<NewsRoot> newsInfo = projectApI.getNewsInfo(map);
        newsInfo.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public static void getMethod2(String baseUrl, Map<String,String> map, Observer observer){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(baseUrl).build();
        RequestAPI projectApI = retrofit.create(RequestAPI.class);
        Observable<TryUser> newsInfo = projectApI.getNewsInfo1(map);
       newsInfo.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
