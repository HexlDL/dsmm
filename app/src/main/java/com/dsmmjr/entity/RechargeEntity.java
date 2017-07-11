package com.dsmmjr.entity;

/**
 * Create time : 2017/5/31.
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
public class RechargeEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"userinfo":{"account_money":"994013.00","is_fuiou_reg":"1","is_fuiou_sign":"0"},"incharge_des":"1.最低起充金额50元，请注意您的银行卡充值限制，以免造成不便。<br>2.充值免手续费！充值资金可用于进行验证、投标、还款等。充值成功后资金会立刻划拨到您的帐户。<br>3.禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，资金将退回原卡并封停账号30天。<br>4.大额充值请通过PC端网银操作。<br>5.充值金额，需投标后才可以提现。<br>6.如果充值金额没有及时到账，请联系客服：400-611-2020。","incharge_rule":"1.快速充值只支持已签约用户，如需签约，请联系客服；<br>2.未在富友金账户开户的；<br>3.富友网银充值支持以下银行卡：中行、工行、建行、交行、招行、民生、兴业、广发、中信、华夏、光大、邮储、浦发、银联（部分银行的银行卡号不支持充值交易，具体详情参考帮助中心）。"}
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
         * userinfo : {"account_money":"994013.00","is_fuiou_reg":"1","is_fuiou_sign":"0"}
         * incharge_des : 1.最低起充金额50元，请注意您的银行卡充值限制，以免造成不便。<br>2.充值免手续费！充值资金可用于进行验证、投标、还款等。充值成功后资金会立刻划拨到您的帐户。<br>3.禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，资金将退回原卡并封停账号30天。<br>4.大额充值请通过PC端网银操作。<br>5.充值金额，需投标后才可以提现。<br>6.如果充值金额没有及时到账，请联系客服：400-611-2020。
         * incharge_rule : 1.快速充值只支持已签约用户，如需签约，请联系客服；<br>2.未在富友金账户开户的；<br>3.富友网银充值支持以下银行卡：中行、工行、建行、交行、招行、民生、兴业、广发、中信、华夏、光大、邮储、浦发、银联（部分银行的银行卡号不支持充值交易，具体详情参考帮助中心）。
         */

        private UserinfoBean userinfo;
        private String incharge_des;
        private String incharge_rule;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public String getIncharge_des() {
            return incharge_des;
        }

        public void setIncharge_des(String incharge_des) {
            this.incharge_des = incharge_des;
        }

        public String getIncharge_rule() {
            return incharge_rule;
        }

        public void setIncharge_rule(String incharge_rule) {
            this.incharge_rule = incharge_rule;
        }

        public static class UserinfoBean {
            /**
             * account_money : 994013.00
             * is_fuiou_reg : 1
             * is_fuiou_sign : 0
             */

            private String account_money;
            private String is_fuiou_reg;
            private String is_fuiou_sign;

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }

            public String getIs_fuiou_reg() {
                return is_fuiou_reg;
            }

            public void setIs_fuiou_reg(String is_fuiou_reg) {
                this.is_fuiou_reg = is_fuiou_reg;
            }

            public String getIs_fuiou_sign() {
                return is_fuiou_sign;
            }

            public void setIs_fuiou_sign(String is_fuiou_sign) {
                this.is_fuiou_sign = is_fuiou_sign;
            }
        }
    }
}
