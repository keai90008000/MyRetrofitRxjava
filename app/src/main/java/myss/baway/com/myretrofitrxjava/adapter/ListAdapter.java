package myss.baway.com.myretrofitrxjava.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import myss.baway.com.myretrofitrxjava.R;
import myss.baway.com.myretrofitrxjava.bean.TryUser;

/**
 * Created by 陈驰 on 2017/5/27.
 */

public class ListAdapter extends BaseAdapter {

    public Context context;
    private List<TryUser.DataBean.TryBean> tryBeans;

    public ListAdapter(Context context, TryUser tryUser) {
        this.context = context;
        Log.i("Ss","tryUser"+ tryUser.getRet());
        this.tryBeans = tryUser.getData().getTryX();
    }
    @Override
    public int getCount() {
        return tryBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return tryBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Ss",""+position);
        convertView= View.inflate(context, R.layout.shiting_layout, null);
        ImageView tv_image = (ImageView) convertView.findViewById(R.id.tv_image);
        TextView tv_title = (TextView) convertView.findViewById(R.id.title_tv);
        TextView tv_content = (TextView) convertView.findViewById(R.id.content_tv);
        TextView tv_teacher = (TextView) convertView.findViewById(R.id.teacher_tv);
        tv_title.setText(tryBeans.get(position).getTitle());
        tv_content.setText(tryBeans.get(position).getTitle2());
        tv_teacher.setText(tryBeans.get(position).getSpeaker());
        Glide.with(context).load(tryBeans.get(position).getImage()).into(tv_image);
        return convertView;
    }
}
