package com.example.seele.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.seele.R;
import com.example.seele.bean.UserInfoBean;
import com.example.seele.interfaces.view.IUserLoginView;
import com.example.seele.presenter.UserLoginPresenter;

public class MainActivity extends BaseActivity<UserLoginPresenter> implements IUserLoginView {
    private EditText user_name_edit, user_pwd_edit;
    private Button user_login_btn, user_clear_btn;
    private ProgressBar user_login_bar;

    @Override
    public UserLoginPresenter initPresenter() {
        return new UserLoginPresenter(this);
    }

    @Override
    protected int setMvcView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        user_name_edit = (EditText) findViewById(R.id.user_name_edit);
        user_pwd_edit = (EditText) findViewById(R.id.user_pwd_edit);
        user_login_btn = (Button) findViewById(R.id.user_login_btn);
        user_clear_btn = (Button) findViewById(R.id.user_clear_btn);
        user_login_bar = (ProgressBar) findViewById(R.id.user_login_bar);
        user_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
        user_clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return user_name_edit.getText().toString();
    }

    @Override
    public String getPassword() {
        return user_pwd_edit.getText().toString();
    }

    @Override
    public void clearUserName() {
        user_name_edit.setText("");
    }

    @Override
    public void clearPassword() {
        user_pwd_edit.setText("");
    }

    @Override
    public void showLoading() {
        user_login_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        user_login_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(UserInfoBean user) {
        Toast.makeText(this, user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
