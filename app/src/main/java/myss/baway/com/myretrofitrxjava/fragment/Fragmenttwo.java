package myss.baway.com.myretrofitrxjava.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myss.baway.com.myretrofitrxjava.R;

/**
 * Created by 陈驰 on 2017/5/26.
 */

public class Fragmenttwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_one,null);
        return view;
    }
}
