package com.trans;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.trans.baselibrary.base.BaseActivity;
import com.trans.company.CompanyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.login_user)
    EditText mLoginUser;
    @BindView(R.id.login_password)
    EditText mLoginPassword;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.login_info)
    TextView mLoginInfo;
    @BindView(R.id.guideline)
    Guideline guideline;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        mLoginInfo.setText("密码有误");
    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        startActivity(CompanyActivity.class);
    }


}
