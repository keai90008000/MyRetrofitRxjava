package myss.baway.com.myretrofitrxjava.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import myss.baway.com.myretrofitrxjava.R;
import myss.baway.com.myretrofitrxjava.adapter.RecylerAdapter;
import myss.baway.com.myretrofitrxjava.bean.NewsRoot;
import myss.baway.com.myretrofitrxjava.bean.TryUser;
import myss.baway.com.myretrofitrxjava.presenter.NewsPresenter;
import myss.baway.com.myretrofitrxjava.view.INewsView;

/**
 * Created by 陈驰 on 2017/5/26.
 */

public class Fragmentone extends Fragment implements INewsView<NewsRoot,TryUser> {

    private RecyclerView recy1;
    private NewsPresenter newsPresenter;
    private RecylerAdapter recylerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = View.inflate(getContext(), R.layout.fragment_one,null);
        recy1 = (RecyclerView) view.findViewById(R.id.recyl);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsPresenter = new NewsPresenter(this,getActivity());
        newsPresenter.getNewsData();
     //   newsPresenter.getNewsData1();

        recy1.setLayoutManager(new LinearLayoutManager(getActivity()));

        recylerAdapter = new RecylerAdapter(getContext());


    }

    @Override
    public void onSuccess(NewsRoot s) {
        Log.e("Ss",s.getData().getBanner().get(0).getImage()+"");
        recylerAdapter.setBan(s);
        newsPresenter.boolea();
    }

    @Override
    public void setAd(){
        recy1.setAdapter(recylerAdapter);
    }

    @Override
    public void onSuccessL(TryUser s) {
        Log.e("Ss", s.getData()+"ssssssssssss");
        recylerAdapter.setData(s);
        newsPresenter.boolea();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
