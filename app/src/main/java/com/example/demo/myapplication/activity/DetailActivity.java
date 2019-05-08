package com.example.demo.myapplication.activity;

import android.support.v7.widget.AppCompatTextView;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseActivity;
import com.example.demo.myapplication.bean.News;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {
    @BindView(R.id.tv_detail_title)
    AppCompatTextView tvDetailTitle;
    @BindView(R.id.wv_deatil)
    WebView wvDeatil;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        News news = (News) getIntent().getExtras().get("News");
        WebSettings settings = wvDeatil.getSettings();
        wvDeatil.loadUrl(news.getPath());
        settings.setJavaScriptEnabled(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_deatil;
    }


}
