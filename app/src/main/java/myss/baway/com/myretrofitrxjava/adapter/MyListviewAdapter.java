package myss.baway.com.myretrofitrxjava.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import myss.baway.com.myretrofitrxjava.R;
import myss.baway.com.myretrofitrxjava.bean.TryUser;

/**
 * Created by 陈驰 on 2017/5/26.
 */

public class MyListviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public Context context;
    private TryUser tryUser;

    public MyListviewAdapter(Context context, TryUser tryUser) {
        this.context = context;
        this.tryUser = tryUser;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewholderone(View.inflate(context, R.layout.shiting_layout,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      if (holder instanceof  MyViewholderone){
          ((MyViewholderone) holder).tv_title.setText(tryUser.getData().getTryX().get(position).getTitle());
          ((MyViewholderone) holder).tv_teacher.setText(tryUser.getData().getTryX().get(position).getSpeaker());
          ((MyViewholderone) holder).tv_content.setText(tryUser.getData().getTryX().get(position).getTitle2());
          Glide.with(context).load(tryUser.getData().getTryX().get(position).getImage()).into(((MyViewholderone) holder).tv_image);
      }
    }

    @Override
    public int getItemCount() {
        return tryUser.getData().getTryX().size();
    }
   class MyViewholderone extends  RecyclerView.ViewHolder{

       private final ImageView tv_image;
       private final TextView tv_title;
       private final TextView tv_content;
       private final TextView tv_teacher;

       public MyViewholderone(View itemView) {
           super(itemView);
           tv_image = (ImageView) itemView.findViewById(R.id.tv_image);
           tv_title = (TextView) itemView.findViewById(R.id.title_tv);
           tv_content = (TextView) itemView.findViewById(R.id.content_tv);
           tv_teacher = (TextView) itemView.findViewById(R.id.teacher_tv);

       }
   }
   /* @Override
    public int getCount() {
        return tryUser.getData().getTryX().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Ss",""+position);
        convertView= View.inflate(context, R.layout.shiting_layout, null);
        ImageView tv_image = (ImageView) convertView.findViewById(R.id.tv_image);
        TextView tv_title = (TextView) convertView.findViewById(R.id.title_tv);
        TextView tv_content = (TextView) convertView.findViewById(R.id.content_tv);
        TextView tv_teacher = (TextView) convertView.findViewById(R.id.teacher_tv);
        tv_title.setText(tryUser.getData().getTryX().get(position).getTitle());
        tv_content.setText(tryUser.getData().getTryX().get(position).getTitle2());
        tv_teacher.setText(tryUser.getData().getTryX().get(position).getSpeaker());
        Glide.with(context).load(tryUser.getData().getTryX().get(position).getImage()).into(tv_image);
        return convertView;
    }*/
}
