package com.example.demo.myapplication.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.adapter.DrawerAdapter;
import com.example.demo.myapplication.base.BaseActivity;
import com.example.demo.myapplication.base.BaseRecyclerAdapter;
import com.example.demo.myapplication.fragment.FenLeiFragment;
import com.example.demo.myapplication.fragment.HomeFragment;
import com.example.demo.myapplication.fragment.MeFragment;
import com.example.demo.myapplication.fragment.ShopCartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BaseRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.btn_home)
    Button btnHome;
    @BindView(R.id.btn_fenlei)
    Button btnFenlei;
    @BindView(R.id.btn_car)
    Button btnCar;
    @BindView(R.id.btn_me)
    Button btnMe;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.ly_content)
    FrameLayout lyContent;
    @BindView(R.id.drawer_rv)
    RecyclerView drawerRv;
    private FragmentTransaction transaction;
    private HomeFragment home;
    private FenLeiFragment fenlei;
    private ShopCartFragment shopCart;
    private MeFragment me;
    private FragmentTransaction transaction1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        List<String>drawerList=new ArrayList<String>();
        for(int i=0;i<10;i++){
            drawerList.add("item"+i);
        }
        DrawerAdapter drawerAdapter=new DrawerAdapter(this,R.layout.drawer_items,drawerList);
        drawerRv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        drawerRv.addItemDecoration(itemDecoration);
        drawerAdapter.setOnItemClickListener(this);
        drawerRv.setAdapter(drawerAdapter);
    }

    @Override
    protected void initView() {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        home = new HomeFragment();
        fenlei = new FenLeiFragment();
        shopCart = new ShopCartFragment();
        me = new MeFragment();
        fragmentList.add(home);
        fragmentList.add(fenlei);
        fragmentList.add(shopCart);
        fragmentList.add(me);
        btnHome.performClick();
    }

    @OnClick({R.id.btn_home, R.id.btn_fenlei, R.id.btn_car, R.id.btn_me})
    public void onViewClicked(View view) {
        transaction = getFragmentManager().beginTransaction();
        hideFragment();
        switch (view.getId()) {
            case R.id.btn_home:
                if (!home.isAdded()) {
                    transaction.add(R.id.fl_container, home);
                }
                transaction.show(home);
                tvTitle.setText("首页");
                break;
            case R.id.btn_fenlei:
                if (!fenlei.isAdded()) {
                    transaction.add(R.id.fl_container, fenlei);
                }
                transaction.show(fenlei);
                tvTitle.setText("分类");
                break;
            case R.id.btn_car:
                if (!shopCart.isAdded()) {
                    transaction.add(R.id.fl_container, shopCart);
                }
                transaction.show(shopCart);
                tvTitle.setText("购物车");
                break;
            case R.id.btn_me:
                if (!me.isAdded()) {
                    transaction.add(R.id.fl_container, me);
                }
                transaction.show(me);
                tvTitle.setText("我的");
                break;
        }
        transaction.commit();
    }

    private void hideFragment() {
        if (home != null) {
            transaction.hide(home);
        }
        if (fenlei != null) {
            transaction.hide(fenlei);
        }
        if (shopCart != null) {
            transaction.hide(shopCart);
        }
        if (me != null) {
            transaction.hide(me);
        }
    }

    private long time = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - time > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出！", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
                return false;
            } else {
                System.exit(0);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onItemClickListener(View view, int position) {

    }
}
