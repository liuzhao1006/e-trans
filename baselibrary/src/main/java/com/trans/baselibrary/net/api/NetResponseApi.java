package com.trans.baselibrary.net.api;

/**
 * 作者: 刘朝
 * 日期: 2017/10/7
 * 描述: 请求回调接口, 成功的方法需要自己实现
 */

public interface NetResponseApi {
    /**
     * 请求开始,展示进度条之类的.
     *
     * @param what 确定身份
     */
    void start(int what);

    /**
     * 请求结束,取消进度条之类的.
     *
     * @param what 确定身份
     */
    void stop(int what);

    /**
     * 请求失败的回调.
     *
     * @param what    确定身份
     * @param message 失败原因
     */
    void Failed(int what, String message);

}
