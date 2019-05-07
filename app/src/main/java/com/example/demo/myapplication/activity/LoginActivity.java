package com.example.demo.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.demo.myapplication.MyApplication;
import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseActivity;
import com.example.demo.myapplication.bean.User;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_account)
    AppCompatEditText etAccount;
    @BindView(R.id.et_pwd)
    AppCompatEditText etPwd;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login2;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        final SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        String account = sharedPreferences.getString("Account", "");
        if(!TextUtils.isEmpty(account)){
            etAccount.setText(account);
        }

    }

    @OnClick(R.id.btn_login)
    protected   void login() {
        String account = etAccount.getText().toString();
        String pwd = etPwd.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(LoginActivity.this, "account is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "pwd is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (account.equals("123") && pwd.equals("123")) {
            final SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Account",account);
            editor.commit();

            User user=new User();
            user.setAccount(account);
            user.setPwd(pwd);
            MyApplication application = (MyApplication) getApplicationContext();
            application.setUser(user);
            application.setLogin(true);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(intent);
            LoginActivity.this.finish();
        }
    }

}
