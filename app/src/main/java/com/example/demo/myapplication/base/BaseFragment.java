package com.example.demo.myapplication.base;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.myapplication.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment extends Fragment {


    private Unbinder binder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        binder = ButterKnife.bind(this, view);
        return view;
    }

    protected int getLayoutID() {
        return 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }
}
