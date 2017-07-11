package com.dsmmjr.entity;

/**
 * Created by Administrator on 2016/10/10.
 * 登录
 */
public class LoginEntity {

    /**
     * code : 1
     * msg : 登陆成功
     * data : {"userinfo":{"username":"13861756052","token":"73116bb23af371f01c1b8065fc9fff25"}}
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userinfo : {"username":"13861756052","token":"73116bb23af371f01c1b8065fc9fff25"}
         */

        private UserinfoBean userinfo;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class UserinfoBean {
            /**
             * username : 13861756052
             * token : 73116bb23af371f01c1b8065fc9fff25
             */

            private String username;
            private String token;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }
    }
}
