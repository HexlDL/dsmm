package com.dsmmjr.entity;

import com.dsmmjr.base.BaseEntity;

/**
 * Create time : 2017/3/21.
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

public class AccountEntity extends BaseEntity {
    /**
     * code : 1
     * msg : OK
     * data : {"userinfo":{"username":"15640200787","phone_status":"1","real_status":"1","fuiou_status":"0","bank_status":"0","autoinvest":"0","hongbao":"0","unread":"240"},"account":{"total_money":"994013","account_money":"994013","collect_money":"0.00","benefit_money":"0"}}
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
         * userinfo : {"username":"15640200787","phone_status":"1","real_status":"1","fuiou_status":"0","bank_status":"0","autoinvest":"0","hongbao":"0","unread":"240"}
         * account : {"total_money":"994013","account_money":"994013","collect_money":"0.00","benefit_money":"0"}
         */

        private UserinfoBean userinfo;
        private AccountBean account;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public AccountBean getAccount() {
            return account;
        }

        public void setAccount(AccountBean account) {
            this.account = account;
        }

        public static class UserinfoBean {
            /**
             * username : 15640200787
             * phone_status : 1
             * real_status : 1
             * fuiou_status : 0
             * bank_status : 0
             * autoinvest : 0
             * hongbao : 0
             * unread : 240
             */

            private String username;
            private String phone_status;
            private String real_status;
            private String fuiou_status;
            private String bank_status;
            private String autoinvest;
            private String hongbao;
            private String unread;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPhone_status() {
                return phone_status;
            }

            public void setPhone_status(String phone_status) {
                this.phone_status = phone_status;
            }

            public String getReal_status() {
                return real_status;
            }

            public void setReal_status(String real_status) {
                this.real_status = real_status;
            }

            public String getFuiou_status() {
                return fuiou_status;
            }

            public void setFuiou_status(String fuiou_status) {
                this.fuiou_status = fuiou_status;
            }

            public String getBank_status() {
                return bank_status;
            }

            public void setBank_status(String bank_status) {
                this.bank_status = bank_status;
            }

            public String getAutoinvest() {
                return autoinvest;
            }

            public void setAutoinvest(String autoinvest) {
                this.autoinvest = autoinvest;
            }

            public String getHongbao() {
                return hongbao;
            }

            public void setHongbao(String hongbao) {
                this.hongbao = hongbao;
            }

            public String getUnread() {
                return unread;
            }

            public void setUnread(String unread) {
                this.unread = unread;
            }
        }

        public static class AccountBean {
            /**
             * total_money : 994013
             * account_money : 994013
             * collect_money : 0.00
             * benefit_money : 0
             */

            private String total_money;
            private String account_money;
            private String collect_money;
            private String benefit_money;

            public String getTotal_money() {
                return total_money;
            }

            public void setTotal_money(String total_money) {
                this.total_money = total_money;
            }

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }

            public String getCollect_money() {
                return collect_money;
            }

            public void setCollect_money(String collect_money) {
                this.collect_money = collect_money;
            }

            public String getBenefit_money() {
                return benefit_money;
            }

            public void setBenefit_money(String benefit_money) {
                this.benefit_money = benefit_money;
            }
        }
    }
}