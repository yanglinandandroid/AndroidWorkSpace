package com.example.demo.myapplication.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Toast;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseFragment;
import com.example.demo.myapplication.common.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import butterknife.BindView;
import butterknife.Unbinder;

import static java.lang.Thread.sleep;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.home_banner)
    Banner banner;
    Unbinder unbinder;
    private String format;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initData();
        srl.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);


        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Thread(() -> {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    srl.post(() -> {
                        Date date = new Date();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dataTime = format.format(date);
                        Toast.makeText(getActivity(), dataTime, Toast.LENGTH_SHORT).show();
                        srl.setRefreshing(false);
                    });

                }).start();

            }
        });
    }

    private void initView() {
        String[] images={"http://5b0988e595225.cdn.sohucs.com/images/20190508/e769514b4c2b49a5b90d87402e4e06f0.jpeg",
                "http://5b0988e595225.cdn.sohucs.com/images/20190508/cb9d9ad486004b51a5c7c7a5355bd107.jpeg",
        "http://5b0988e595225.cdn.sohucs.com/images/20190508/11c9fb2608924f61b7c17a7c6dd7bf40.png"};
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(Arrays.asList(images));
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        String[] titles={"币安遭黑客攻击被盗7000比特币","台军士兵酒后街上斗殴","柬埔寨一中国人被枪杀身亡"};
        banner.setBannerTitles(Arrays.asList(titles));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }
    private void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
