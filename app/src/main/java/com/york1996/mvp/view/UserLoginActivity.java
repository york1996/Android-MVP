package com.york1996.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.york1996.mvp.R;
import com.york1996.mvp.bean.User;
import com.york1996.mvp.presenter.UserLoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.clean)
    Button clean;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
//    R.layout.activity_user_login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.login();
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void cleanUsername() {
        username.setText("");
    }

    @Override
    public void cleanPassword() {
        password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " 登陆成功，进入首页", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "登录失败", Toast.LENGTH_SHORT).show();
    }
}
