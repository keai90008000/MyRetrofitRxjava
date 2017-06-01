package myss.baway.com.myretrofitrxjava.interfac;


import java.util.Map;

import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public interface ProjectApI {
  //http://news-at.zhihu.com/api/4/news/latest
    @GET
    Call<String> getMethod(@Url String url);

    @FormUrlEncoded
    @POST
   Call<String> postMethod(@Url String url, @FieldMap Map<String,String> map);

    @GET
    Observable<NewsRoot> getMethod2(@Url String url);
}
