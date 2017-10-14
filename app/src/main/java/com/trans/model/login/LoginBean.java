package com.trans.model.login;

import com.trans.baselibrary.base.BaseBean;

/**
 * 第三方:
 * 作者: 刘朝
 * 日期: 2017/10/14
 * 描述: 将登录信息封装到这个对象中请求数据
 */
public class LoginBean extends BaseBean {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 类型: 学员:0, 企业:1
     */
    private String userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
