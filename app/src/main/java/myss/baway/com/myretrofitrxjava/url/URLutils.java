package myss.baway.com.myretrofitrxjava.url;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public class URLutils {

    public static final String Base_url= "https://pretty.f8cam.com:17213/";
    public static final String Base_urlw= "https://pretty.f8cam.com:17213/";

    public static  String gerBaseUrl (boolean a){
        return  a== true ? Base_url : Base_urlw;
    }



}
