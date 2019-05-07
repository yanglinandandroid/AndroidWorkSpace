package com.example.demo.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenLeiFragment extends BaseFragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_fen_lei;
    }
}
