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
public class CashEntity {

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
         * money : 1194013
         * withdraw_des : 1. 会员单笔提现金额100元起；<br>2. 会员单笔提现金额小于等于10000的情况下，每笔收取1元提现手续费；<br>3. 会员单笔提现金额超过10000的，每笔收取2元提现手续费；<br>4. 会员单日单笔提现上限5万,单日提现资金上限30万；<br>5. 会员提现金额需有投资记录；<br>6. 若您的提现申请通过后，超过48小时提现金额未到账，请联系客服中心：400-611-2020。
         */

        private String money;
        private String withdraw_des;

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getWithdraw_des() {
            return withdraw_des;
        }

        public void setWithdraw_des(String withdraw_des) {
            this.withdraw_des = withdraw_des;
        }
    }
}
