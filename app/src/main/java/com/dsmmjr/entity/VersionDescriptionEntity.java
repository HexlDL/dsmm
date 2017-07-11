package com.dsmmjr.entity;

/**
 * Created by hexl
 * 版本更新
 */
public class VersionDescriptionEntity {
    private int code;
    private String msg;
    /**
     * iphone : 1.0.1
     * android : 1.0.1
     * iphone_update_message :
     * android_update_message :
     * iphone_download_link :
     * android_download_link : http://m.changjiudai.cn/Uploads/APK/1.0.1/app-release.apk
     * android_force_update :
     */

    private UserinfoBean userinfo;

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

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public static class UserinfoBean {
        private String iphone;
        private String android;
        private String iphone_update_message;
        private String android_update_message;
        private String iphone_download_link;
        private String android_download_link;
        private String android_force_update;

        public String getIphone() {
            return iphone;
        }

        public void setIphone(String iphone) {
            this.iphone = iphone;
        }

        public String getAndroid() {
            return android;
        }

        public void setAndroid(String android) {
            this.android = android;
        }

        public String getIphone_update_message() {
            return iphone_update_message;
        }

        public void setIphone_update_message(String iphone_update_message) {
            this.iphone_update_message = iphone_update_message;
        }

        public String getAndroid_update_message() {
            return android_update_message;
        }

        public void setAndroid_update_message(String android_update_message) {
            this.android_update_message = android_update_message;
        }

        public String getIphone_download_link() {
            return iphone_download_link;
        }

        public void setIphone_download_link(String iphone_download_link) {
            this.iphone_download_link = iphone_download_link;
        }

        public String getAndroid_download_link() {
            return android_download_link;
        }

        public void setAndroid_download_link(String android_download_link) {
            this.android_download_link = android_download_link;
        }

        public String getAndroid_force_update() {
            return android_force_update;
        }

        public void setAndroid_force_update(String android_force_update) {
            this.android_force_update = android_force_update;
        }
    }
}
