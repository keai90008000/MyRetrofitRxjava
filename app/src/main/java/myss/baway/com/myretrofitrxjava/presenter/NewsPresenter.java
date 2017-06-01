package myss.baway.com.myretrofitrxjava.presenter;

import android.content.Context;
import android.util.Log;

import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import myss.baway.com.myretrofitrxjava.bean.TryUser;
import myss.baway.com.myretrofitrxjava.module.NewsModule;
import myss.baway.com.myretrofitrxjava.moduleimpl.NewsModulelmpl;
import myss.baway.com.myretrofitrxjava.view.INewsView;
import rx.Observer;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public class NewsPresenter {
  //轮播图
    private INewsView<NewsRoot,TryUser> iNewsView;
    private final Context context;
    private boolean banner = false;
    private boolean tryu = false;
    private boolean okeBean = false;
    NewsModule  newsModule =new NewsModulelmpl();
    public NewsPresenter(INewsView iNewsView,Context context){
        this.iNewsView = iNewsView;
        this.context = context;
    }

    public void getNewsData(){
        newsModule.getNews(context, "2", new Observer<NewsRoot>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("dddd","new" + e.toString());
            }

            @Override
            public void onNext(NewsRoot s) {
              assert s!=null;
                banner = true;
                Log.i("dddd","dsadsadas");
                iNewsView.onSuccess(s);
            }
        });
        newsModule.getNews1(context, "top", new Observer<TryUser>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("dddd","try" + e.toString());
            }

            @Override
            public void onNext(TryUser s) {
                assert s!=null;
                Log.i("dddd","dsadsadas"+s.toString());
                tryu = true;
                iNewsView.onSuccessL(s);
            }
        });
       /* newsModule.getNews11(context, "top", new Observer<OneKeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("dddd","try" + e.toString());
            }

            @Override
            public void onNext(OneKeBean s) {
                assert s!=null;
                Log.i("dddd","dsadsadas"+s.toString());
                okeBean = true;
                iNewsView.onSuccessLs(s);
            }
        });
*/
    }

    public void boolea(){
        Log.i("dddd", tryu + ":banner=" + banner);
        if(tryu&&banner){
            Log.i("dddd","dsadsadas");
            iNewsView.setAd();
        }
    }
}
