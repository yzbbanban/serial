package com.yzb.serial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.yzb.serial.R;
import com.yzb.serial.app.SerialApplication;
import com.yzb.serial.entity.User;
import com.yzb.serial.model.SharedPreModel;
import com.yzb.serial.ui.CleanEditText;
import com.yzb.serial.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_login_username)
    CleanEditText etLoginUsername;
    @BindView(R.id.et_login_password)
    CleanEditText etLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        User user = SharedPreModel.getUserSp(this);
        if (StringUtil.isNotBlank(user.getName()) && StringUtil.isNotBlank(user.getPassword())) {
            etLoginUsername.setText(user.getName());
            etLoginPassword.setText(user.getPassword());
        }

    }

    @OnClick(R.id.btn_login)
    public void btnLogin() {
        login();
    }


    private void login() {

        if ("admin".equals(etLoginUsername.getText().toString())) {
            if ("123456".equals(etLoginPassword.getText().toString())) {
                SerialApplication.USER_NAME = "admin";
                SharedPreModel.saveUserSp(this, "admin", "123456");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        }

        if ("user".equals(etLoginUsername.getText().toString())) {
            if ("111111".equals(etLoginPassword.getText().toString())) {
                SerialApplication.USER_NAME = "user";
                SharedPreModel.saveUserSp(this, "user", "111111");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        }

    }


}
