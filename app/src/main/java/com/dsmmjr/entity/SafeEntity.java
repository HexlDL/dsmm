package com.dsmmjr.entity;

/**
 * Create time : 2017/4/19.
 * Author : Hexl
 * Depict :
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 */
public class SafeEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"minfo":{"id_status":"0","phone_status":"1","phone":"138****052","pinpass_status":"1"}}
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
         * minfo : {"id_status":"0","phone_status":"1","phone":"138****052","pinpass_status":"1"}
         */

        private MinfoBean minfo;

        public MinfoBean getMinfo() {
            return minfo;
        }

        public void setMinfo(MinfoBean minfo) {
            this.minfo = minfo;
        }

        public static class MinfoBean {
            /**
             * id_status : 0
             * phone_status : 1
             * phone : 138****052
             * pinpass_status : 1
             */

            private String id_status;
            private String phone_status;
            private String phone;
            private String pinpass_status;

            public String getId_status() {
                return id_status;
            }

            public void setId_status(String id_status) {
                this.id_status = id_status;
            }

            public String getPhone_status() {
                return phone_status;
            }

            public void setPhone_status(String phone_status) {
                this.phone_status = phone_status;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPinpass_status() {
                return pinpass_status;
            }

            public void setPinpass_status(String pinpass_status) {
                this.pinpass_status = pinpass_status;
            }
        }
    }
}
