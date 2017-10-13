package com.trans.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liuchao on 2017/10/14.
 */

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    public View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        mActivity = getActivity();
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        initViewSaved(mRootView, savedInstanceState);
        return mRootView;
    }


    /**
     * 初始化布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 保存状态
     *
     * @param mRootView
     * @param savedInstanceState
     */
    public abstract void initViewSaved(View mRootView, Bundle savedInstanceState);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initData() {
    }

}
