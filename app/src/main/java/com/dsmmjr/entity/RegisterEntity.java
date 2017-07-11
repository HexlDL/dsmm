package com.dsmmjr.entity;

import com.dsmmjr.base.BaseEntity;

/**
 * Created by hexl
 * 注册
 */
public class RegisterEntity extends BaseEntity {

    /**
     * code : 1
     * msg : 发送成功！
     * userinfo : null
     */
    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
