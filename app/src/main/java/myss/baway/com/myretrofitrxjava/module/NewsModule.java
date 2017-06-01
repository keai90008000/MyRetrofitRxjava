package myss.baway.com.myretrofitrxjava.module;

import android.content.Context;

import rx.Observer;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public interface NewsModule {
      void getNews(Context context, String type, Observer  observer);
      void getNews1(Context context, String type, Observer  observer);
      void getNews11(Context context, String type, Observer  observer);


}
