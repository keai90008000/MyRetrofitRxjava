package myss.baway.com.myretrofitrxjava.interfac;

import java.util.Map;

import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import myss.baway.com.myretrofitrxjava.bean.OneKeBean;
import myss.baway.com.myretrofitrxjava.bean.TryUser;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public interface RequestAPI {

  //轮播图
   @POST("app/v1/list_banner")
   @FormUrlEncoded
   Observable<NewsRoot> getNewsInfo(@FieldMap Map<String ,String> map );
    //免费试听
    @POST("app/v1/list_try")
    @FormUrlEncoded
    Observable<TryUser> getNewsInfo1(@FieldMap Map<String ,String> map );

   @POST("app/v1/detail_course")
    @FormUrlEncoded
    Observable<OneKeBean> getNewsInfol1(@FieldMap Map<String ,String> map);

}
