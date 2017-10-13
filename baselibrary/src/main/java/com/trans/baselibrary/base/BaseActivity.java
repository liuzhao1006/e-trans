package com.trans.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.trans.baselibrary.R;
import com.trans.baselibrary.widget.StatusBarUtil;

/**
 * 作者: 刘朝
 * 日期: 2017/10/12
 * 描述: 所有activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    private long showTime = 0;
    protected Toast moToastInstance;
    private static final int SHORT_TOAST = Toast.LENGTH_SHORT;
    private static final int LONG_TOAST = Toast.LENGTH_LONG;

    @Override
    public void setContentView(int layoutResID) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(layoutResID);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInit();
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            setStatusBar();
            initView(savedInstanceState);
        }
    }


    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent));
    }

    /**
     * 获取布局ID
     *
     * @return 布局id
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 界面初始化前期准备
     */
    protected void beforeInit() {

    }

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);


    /**
     * Toast 短时间,常用
     *
     * @param message
     */
    public void showToast(String message) {
        if (System.currentTimeMillis() - showTime > 3000) {
            if (moToastInstance == null)
                moToastInstance = Toast.makeText(this, message, SHORT_TOAST);
            else {
                moToastInstance.setDuration(SHORT_TOAST);
                moToastInstance.setText(message);
            }
            moToastInstance.show();
            showTime = System.currentTimeMillis();
        }
    }


    /**
     * Toast 长时间,不常用
     *
     * @param message
     * @param isShort
     */
    public void showToast(String message, boolean isShort) {
        if (System.currentTimeMillis() - showTime > 3000) {

            if (isShort) {
                if (moToastInstance == null)
                    moToastInstance = Toast.makeText(this, message, SHORT_TOAST);
                else {
                    moToastInstance.setDuration(SHORT_TOAST);
                    moToastInstance.setText(message);
                }
            } else {
                if (moToastInstance == null)
                    moToastInstance = Toast.makeText(this, message, LONG_TOAST);
                else {
                    moToastInstance.setDuration(LONG_TOAST);
                    moToastInstance.setText(message);
                }
            }

            moToastInstance.show();
            showTime = System.currentTimeMillis();
        }
    }

    /**
     * 启动Activity
     */
    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
