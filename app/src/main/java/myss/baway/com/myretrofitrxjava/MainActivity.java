package myss.baway.com.myretrofitrxjava;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import myss.baway.com.myretrofitrxjava.fragment.Fragmentfour;
import myss.baway.com.myretrofitrxjava.fragment.Fragmentone;
import myss.baway.com.myretrofitrxjava.fragment.Fragmentthree;
import myss.baway.com.myretrofitrxjava.fragment.Fragmenttwo;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyl;



    private ViewPager viewpager;
    private String[] titles = new String[]{"精选","美容","美甲","我的"};
    private TabLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        table = (TabLayout) findViewById(R.id.table);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        table.setupWithViewPager(viewpager);



       viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
           public Fragment getItem(int position) {
               Fragment fragment = null;
               switch (position){
                   case 0:
                       fragment = new Fragmentone();
                       break;
                   case 1:
                       fragment = new Fragmenttwo();
                       break;
                   case 2:
                       fragment = new Fragmentthree();
                       break;
                   case 3:
                       fragment = new Fragmentfour();
                       break;
               }
             return  fragment;
           }

           @Override
           public CharSequence getPageTitle(int position) {
               return titles[position];
           }

           @Override
           public int getCount() {
               return 4;
           }
       });

    }


}
