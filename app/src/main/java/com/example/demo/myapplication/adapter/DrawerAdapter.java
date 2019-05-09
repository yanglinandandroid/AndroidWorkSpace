package com.example.demo.myapplication.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.demo.myapplication.base.BaseRecyclerAdapter;
import com.example.demo.myapplication.base.BaseRecyclerHolder;

import java.util.List;

public class DrawerAdapter extends BaseRecyclerAdapter<String> {
    public DrawerAdapter(Context context, int layoutResId, @Nullable List<String> data) {
        super(context, layoutResId, data);
    }

    public DrawerAdapter(Context context, int layoutResId){
        super(context, layoutResId);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, int position) {

    }
}
