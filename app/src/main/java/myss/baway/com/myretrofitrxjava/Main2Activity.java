package myss.baway.com.myretrofitrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import io.vov.vitamio.widget.VideoView;
import myss.baway.com.myretrofitrxjava.bean.TryUser;

public class Main2Activity extends AppCompatActivity {


    private TextView ts_content;
    private ImageView ts_image;
    private ImageView ts_imageren;
    private TextView ts_name;
    private TextView ts_zhiye;
    private TextView ts_title;
    private ImageView zanting;
    private VideoView lol_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ts_content = (TextView) findViewById(R.id.ts_content);
        ts_imageren = (ImageView) findViewById(R.id.ts_imageren);
        ts_name = (TextView) findViewById(R.id.ts_name);
        ts_zhiye = (TextView) findViewById(R.id.ts_zhiye);
        ts_title= (TextView) findViewById(R.id.ts_title);
        zanting = (ImageView) findViewById(R.id.zanting);
        lol_video = (VideoView) findViewById(R.id.lol_video);
        Intent intent = getIntent();
        String object_id = intent.getStringExtra("object_id");
      //  lol_video.setVideoURI(object_id,);


        TryUser.DataBean.TryBean trybean = (TryUser.DataBean.TryBean) intent.getSerializableExtra("trybean");
    //    Glide.with(this).load(trybean.getImage()).into(ts_image);
        ts_title.setText(trybean.getTitle());

        //1.网络请求拿数据
        //2.做视频播放器
      /*  zanting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             lol_video.start();
            }
        });*/
  }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
