package com.trans.baselibrary.net.request;

import android.content.Context;

import com.trans.baselibrary.log.Logs;
import com.trans.baselibrary.net.api.NetApi;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * 作者: 刘朝
 * 日期: 2017/10/7
 * 描述: 网络请求返回的数据处理类
 */

public class ResponseData implements OnResponseListener<String> {

    private Context context;
    private NetApi api;

    public ResponseData(Context context, NetApi api) {
        this.api = api;
        this.context = context;
    }

    @Override
    public void onStart(int what) {
        api.start(what);
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        if (response.responseCode() == 200) {
            Logs.i(response.get());
//            ResponseBean result = JSON.parseObject(JSONObject.parseObject(response.get()).toJSONString(), ResponseBean.class);
//            if (result.code.equals("1")) {
//                api.Failed(what, result.message);
//                return;
//            }
//            api.Successed(what, result.data);
        } else if (response.responseCode() == 404) {
            api.Failed(what, "404");
        } else {
            api.Failed(what, "服务器给了个:" + response.responseCode() + ",我也不知道怎么了,反正就是找不到您要的资源......");
        }
    }

    @Override
    public void onFailed(int what, Response<String> response) {
        //访问网络路径发生改变,比如response.responseCode() == 400
        api.Failed(what, response.get());

    }

    @Override
    public void onFinish(int what) {
        api.stop(what);
    }
}
