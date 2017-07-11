package com.dsmmjr.entity;

/**
 * Create time : 2017/6/14.
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
public class DebtBuyEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"debt":{"invest_id":"39","transfer_price":"2000.00","money":"2200.00"},"userinfo":{"account_money":"874636元"}}
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
         * debt : {"invest_id":"39","transfer_price":"2000.00","money":"2200.00"}
         * userinfo : {"account_money":"874636元"}
         */

        private DebtBean debt;
        private UserinfoBean userinfo;

        public DebtBean getDebt() {
            return debt;
        }

        public void setDebt(DebtBean debt) {
            this.debt = debt;
        }

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class DebtBean {
            /**
             * invest_id : 39
             * transfer_price : 2000.00
             * money : 2200.00
             */

            private String invest_id;
            private String transfer_price;
            private String money;

            public String getInvest_id() {
                return invest_id;
            }

            public void setInvest_id(String invest_id) {
                this.invest_id = invest_id;
            }

            public String getTransfer_price() {
                return transfer_price;
            }

            public void setTransfer_price(String transfer_price) {
                this.transfer_price = transfer_price;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }
        }

        public static class UserinfoBean {
            /**
             * account_money : 874636元
             */

            private String account_money;

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }
        }
    }
}
