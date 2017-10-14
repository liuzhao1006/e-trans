package com.trans.controller;

import android.content.Context;

import com.trans.baselibrary.base.BaseManager;
import com.trans.baselibrary.net.api.NetApi;
import com.trans.baselibrary.net.api.NetResponseApi;

/**
 * 第三方:
 * 作者: 刘朝
 * 日期: 2017/10/14
 * 描述: 企业端网络管理工具
 */
public class TransCompanyManager extends BaseManager {

    private Context context;
    private NetResponseApi api;

    public TransCompanyManager(Context context, NetResponseApi api) {
        this.api = api;
        this.context = context;
    }


    @Override
    public void start(int what) {
        api.start(what);
    }

    @Override
    public void stop(int what) {
        api.stop(what);
    }

    @Override
    public void Failed(int what, String message) {
        api.Failed(what, message);
    }

    @Override
    public void Successed(int what, String data) {
        switch (what) {

        }
    }
}
