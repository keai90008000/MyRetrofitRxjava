package myss.baway.com.myretrofitrxjava.view;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public interface INewsView<T,L> {
    public void onSuccess(T s);
    public void onSuccessL(L s);

    public void setAd();
    public void onError(String error);


}
