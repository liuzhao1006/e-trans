package com.trans.controller;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.trans.baselibrary.base.BaseManager;
import com.trans.baselibrary.net.api.NetResponseApi;
import com.trans.baselibrary.net.request.ResponseData;
import com.trans.baselibrary.utils.Utils;
import com.trans.model.login.LoginBean;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;

import static com.trans.constant.NetConstant.LOGIN;

/**
 * 第三方:
 * 作者: 刘朝
 * 日期: 2017/10/14
 * 描述: 与功能业务关系不大的网络管理类
 */
public class TransGlobalManager extends BaseManager {
    private Context context;
    private NetResponseApi api;
    private ResponseData data;

    public TransGlobalManager(NetResponseApi api, Context context) {
        this.context = context;
        this.api = api;
        data = new ResponseData(context, this);
    }

    public void login(LoginBean bean) {
        String url = getProperties(context, "ip") + getProperties(context, "login");
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.POST);
        request.add("userName", bean.getUserName());
        request.add("password", Utils.MD5(bean.getPassWord()));
        request.add("userType", bean.getUserType());
        request(LOGIN, request, data);
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
            case LOGIN:
//                login.login(what, JSON.parseArray(data,));
                break;
        }
    }

    private Login login;

    public interface Login {
        void login();
    }

    private void setOnLoginListener(Login login) {
        this.login = login;
    }

}
