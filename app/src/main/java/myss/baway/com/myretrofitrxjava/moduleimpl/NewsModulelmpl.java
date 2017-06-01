package myss.baway.com.myretrofitrxjava.moduleimpl;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import myss.baway.com.myretrofitrxjava.manager.HttpManager;
import myss.baway.com.myretrofitrxjava.module.NewsModule;
import myss.baway.com.myretrofitrxjava.url.URLutils;
import myss.baway.com.myretrofitrxjava.utils.BaseData;
import myss.baway.com.myretrofitrxjava.utils.MD5Utils;
import rx.Observer;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public class NewsModulelmpl implements NewsModule  {
//轮播图
    @Override
    public void getNews(Context context, String type, Observer observer) {
        Map<String,String> map = new HashMap<>();
        map.put("app_id", BaseData.app_id);
        map.put("dev_id",BaseData.dev_id);
        map.put("ver_code",BaseData.ver_code);
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        String sign = MD5Utils.getMD5(BaseData.private_key + BaseData.app_id+BaseData.dev_id+BaseData.ver_code + str);
        map.put("tick",str);
        map.put("sign",sign);
        HttpManager.getMethod3(URLutils.gerBaseUrl(false),map,observer);
    }

    //免费试听
    @Override
    public void getNews1(Context context, String type, Observer observer) {
        Map<String,String> map = new HashMap<>();
        map.put("app_id", BaseData.app_id);
        map.put("dev_id",BaseData.dev_id);
        map.put("ver_code",BaseData.ver_code);
        map.put("session","");
        map.put("category","");
        map.put("page_size","10");
        map.put("page_index","0");;
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        String sign = MD5Utils.getMD5(BaseData.private_key + BaseData.app_id+BaseData.dev_id+BaseData.ver_code + str+100);
        map.put("tick",str);
        map.put("sign",sign);
        HttpManager.getMethod2(URLutils.gerBaseUrl(false),map,observer);
    }



    //精选课程详情界面

    @Override
    public void getNews11(Context context, String type, Observer observer) {
        Map<String,String> map = new HashMap<>();
        map.put("app_id", BaseData.app_id);
        map.put("dev_id",BaseData.dev_id);
        map.put("ver_code",BaseData.ver_code);
        map.put("session","");
        map.put("category","");
        map.put("object_id","");
        map.put("page_size","10");
        map.put("page_index","0");;
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        String sign = MD5Utils.getMD5(BaseData.private_key + BaseData.app_id+BaseData.dev_id+BaseData.ver_code + str+100);
        map.put("tick",str);
        map.put("sign",sign);
        HttpManager.getMethod2("https://pretty.f8cam.com:17213/",map,observer);
    }
}
