package com.example.demo.myapplication.base;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {
    public Context context;
    private int layoutRes;
    private List<T> items;
    private OnItemClickListener mOnItemClickListener;
    private OnLongItemClickListener mOnLongItemClickListener;

    public BaseRecyclerAdapter(Context context, @LayoutRes int layoutRes) {
        this.context = context;
        this.layoutRes = layoutRes;
        items = new ArrayList<T>();
    }

    public BaseRecyclerAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<T> data) {
        this.context = context;
        this.items = data == null ? new ArrayList<T>() : data;
        if (layoutResId != 0) {
            this.layoutRes = layoutResId;
        }
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRecyclerHolder(LayoutInflater.from(context).inflate(layoutRes, null));
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        convert(holder, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void setData(List<T> items) {
        this.items = items == null ? new ArrayList<T>() : items;
        notifyDataSetChanged();
    }

    public void addData(@IntRange(from = 0) int position, @NonNull T data) {
        items.add(position, data);
        notifyItemInserted(position);
        compatibilityDataSizeChanged(1);
    }

    public void addData(@NonNull T data) {
        items.add(data);
        notifyItemInserted(items.size());
    }


    public void remove(int position) {
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size() - position);
    }

    private void compatibilityDataSizeChanged(int size) {
        final int dataSize = items == null ? 0 : items.size();
        if (dataSize == size) {
            notifyDataSetChanged();
        }
    }

    /**
     * 需要重写的方法
     *
     * @param holder
     * @param position
     */
    public abstract void convert(BaseRecyclerHolder holder, int position);

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    public interface OnLongItemClickListener {
        void onLongItemClickListener(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnLongItemClickListener(OnLongItemClickListener onLongItemClickListener) {
        mOnLongItemClickListener = onLongItemClickListener;
    }
}
