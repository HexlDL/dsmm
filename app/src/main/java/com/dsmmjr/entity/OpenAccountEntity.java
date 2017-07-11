package com.dsmmjr.entity;

/**
 * Create time : 2017/6/2.
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
public class OpenAccountEntity {

    /**
     * code : 1
     * msg : OK
     * data : {"fuiouInfo":{"real_name":"何旭龙","idcard":"210************5214","user_phone":"15640200787","bank_name":"兴业银行股份有限公司沈阳五里河支行","bank_num":"**************1014","fuiou_sign_status":"未签约"}}
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
         * fuiouInfo : {"real_name":"何旭龙","idcard":"210************5214","user_phone":"15640200787","bank_name":"兴业银行股份有限公司沈阳五里河支行","bank_num":"**************1014","fuiou_sign_status":"未签约"}
         */

        private FuiouInfoBean fuiouInfo;

        public FuiouInfoBean getFuiouInfo() {
            return fuiouInfo;
        }

        public void setFuiouInfo(FuiouInfoBean fuiouInfo) {
            this.fuiouInfo = fuiouInfo;
        }

        public static class FuiouInfoBean {
            /**
             * real_name : 何旭龙
             * idcard : 210************5214
             * user_phone : 15640200787
             * bank_name : 兴业银行股份有限公司沈阳五里河支行
             * bank_num : **************1014
             * fuiou_sign_status : 未签约
             */

            private String real_name;
            private String idcard;
            private String user_phone;
            private String bank_name;
            private String bank_num;
            private String fuiou_sign_status;

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public String getUser_phone() {
                return user_phone;
            }

            public void setUser_phone(String user_phone) {
                this.user_phone = user_phone;
            }

            public String getBank_name() {
                return bank_name;
            }

            public void setBank_name(String bank_name) {
                this.bank_name = bank_name;
            }

            public String getBank_num() {
                return bank_num;
            }

            public void setBank_num(String bank_num) {
                this.bank_num = bank_num;
            }

            public String getFuiou_sign_status() {
                return fuiou_sign_status;
            }

            public void setFuiou_sign_status(String fuiou_sign_status) {
                this.fuiou_sign_status = fuiou_sign_status;
            }
        }
    }
}
