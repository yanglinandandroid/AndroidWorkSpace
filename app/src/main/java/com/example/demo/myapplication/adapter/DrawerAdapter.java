package com.example.demo.myapplication.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseRecyclerAdapter;
import com.example.demo.myapplication.base.BaseRecyclerHolder;

import java.util.List;

public class DrawerAdapter extends BaseRecyclerAdapter<String> {
   private  List<String> data;
    public DrawerAdapter(Context context, int layoutResId, @Nullable List<String> data) {
        super(context, layoutResId, data);
        this.data=data;
    }

    public DrawerAdapter(Context context, int layoutResId){
        super(context, layoutResId);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, int position) {
        AppCompatTextView login = holder.getView(R.id.drawer_login);
        AppCompatTextView about = holder.getView(R.id.drawer_about);
        AppCompatTextView setting = holder.getView(R.id.drawer_setting);
        AppCompatTextView me = holder.getView(R.id.drawer_me);
        login.setText(data.get(0));
        about.setText(data.get(1));
        setting.setText(data.get(2));
        me.setText(data.get(3));
    }



}
