package myss.baway.com.myretrofitrxjava.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import myss.baway.com.myretrofitrxjava.Main2Activity;
import myss.baway.com.myretrofitrxjava.R;
import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import myss.baway.com.myretrofitrxjava.bean.TryUser;
import myss.baway.com.myretrofitrxjava.utils.GlideImageLoader;

/**
 * Created by 陈驰 on 2017/5/12.
 */

public class RecylerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private NewsRoot newsRoot;

    private TryUser tryUser;


    public int TYPE_ONE = 0;
    public int TYPE_TWO = 1;




    public void setData(TryUser tryUser) {
        this.tryUser = tryUser;
    }

    public void setBan(NewsRoot newsRoot) {
        this.newsRoot = newsRoot;
    }

    public RecylerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            Log.i("Ss", "DSFdsfs"+TYPE_ONE);
            return new MyViewHolder1(View.inflate(context, R.layout.item_layout, null));
        } else if (viewType == TYPE_TWO) {
            Log.i("Ss", "DSFdsfs"+TYPE_TWO);
            return new MyViewHolder2(View.inflate(context, R.layout.shitingduolayout, null));
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            ((MyViewHolder1) holder).bindHolder(newsRoot, context);
        } else if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).listview.setAdapter(new MyListviewAdapter(context, tryUser));
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        private Banner banner;
        List<String> list = new ArrayList<>();
         public MyViewHolder1(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }

        public void bindHolder(NewsRoot top_stories, Context context) {
            NewsRoot.DataBean data = top_stories.getData();
            List<NewsRoot.DataBean.BannerBean> banner1 = data.getBanner();
            for (int i = 0; i < banner1.size(); i++) {
                list.add(banner1.get(i).getImage());
                Log.i("ssss", banner1.get(0).getImage() + ",kljmojmjomomo");
            }
            banner.setImageLoader(new GlideImageLoader());
            banner.setImages(list);
            banner.setIndicatorGravity(BannerConfig.CENTER);
            banner.start();
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final RecyclerView listview;

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        public MyViewHolder2(View itemView) {
            super(itemView);
            listview = (RecyclerView) itemView.findViewById(R.id.listview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            listview.setLayoutManager(linearLayoutManager);
            ItemClickSupport.addTo(listview).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    Intent it = new Intent(context, Main2Activity.class);
                  String id = tryUser.getData().getTryX().get(position).getObject_id();
                   TryUser.DataBean.TryBean trss= tryUser.getData().getTryX().get(position);
                   it.putExtra("trybean",trss);
                   it.putExtra("object_id", id);
                  context.startActivity(it);
                }
            });

        }
    }

}
