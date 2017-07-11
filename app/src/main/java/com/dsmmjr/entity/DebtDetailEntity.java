package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/29.
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
public class DebtDetailEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"borrow":{"borrow_id":"911","borrow_name":"金鼠宝A c-0005","borrow_duration":"12个月","borrow_money":"90000元","borrow_interest_rate":"10.00%","borrow_times":"","repayment_type":"一次性还款","add_time":"2017-06-02","progress":"6.62","borrow_status":"2","invest_award_rate":""},"debtinfo":{"invest_id":"39","transfer_price":"2000.00","money":"2200.00","period":"12","total_period":"12","buy_uid":"0","buy_time":"0"},"loglist":[]}
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
         * borrow : {"borrow_id":"911","borrow_name":"金鼠宝A c-0005","borrow_duration":"12个月","borrow_money":"90000元","borrow_interest_rate":"10.00%","borrow_times":"","repayment_type":"一次性还款","add_time":"2017-06-02","progress":"6.62","borrow_status":"2","invest_award_rate":""}
         * debtinfo : {"invest_id":"39","transfer_price":"2000.00","money":"2200.00","period":"12","total_period":"12","buy_uid":"0","buy_time":"0"}
         * loglist : []
         */

        private BorrowBean borrow;
        private DebtinfoBean debtinfo;
        private List<?> loglist;

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public DebtinfoBean getDebtinfo() {
            return debtinfo;
        }

        public void setDebtinfo(DebtinfoBean debtinfo) {
            this.debtinfo = debtinfo;
        }

        public List<?> getLoglist() {
            return loglist;
        }

        public void setLoglist(List<?> loglist) {
            this.loglist = loglist;
        }

        public static class BorrowBean {
            /**
             * borrow_id : 911
             * borrow_name : 金鼠宝A c-0005
             * borrow_duration : 12个月
             * borrow_money : 90000元
             * borrow_interest_rate : 10.00%
             * borrow_times :
             * repayment_type : 一次性还款
             * add_time : 2017-06-02
             * progress : 6.62
             * borrow_status : 2
             * invest_award_rate :
             */

            private String borrow_id;
            private String borrow_name;
            private String borrow_duration;
            private String borrow_money;
            private String borrow_interest_rate;
            private String borrow_times;
            private String repayment_type;
            private String add_time;
            private String progress;
            private String borrow_status;
            private String invest_award_rate;

            public String getBorrow_id() {
                return borrow_id;
            }

            public void setBorrow_id(String borrow_id) {
                this.borrow_id = borrow_id;
            }

            public String getBorrow_name() {
                return borrow_name;
            }

            public void setBorrow_name(String borrow_name) {
                this.borrow_name = borrow_name;
            }

            public String getBorrow_duration() {
                return borrow_duration;
            }

            public void setBorrow_duration(String borrow_duration) {
                this.borrow_duration = borrow_duration;
            }

            public String getBorrow_money() {
                return borrow_money;
            }

            public void setBorrow_money(String borrow_money) {
                this.borrow_money = borrow_money;
            }

            public String getBorrow_interest_rate() {
                return borrow_interest_rate;
            }

            public void setBorrow_interest_rate(String borrow_interest_rate) {
                this.borrow_interest_rate = borrow_interest_rate;
            }

            public String getBorrow_times() {
                return borrow_times;
            }

            public void setBorrow_times(String borrow_times) {
                this.borrow_times = borrow_times;
            }

            public String getRepayment_type() {
                return repayment_type;
            }

            public void setRepayment_type(String repayment_type) {
                this.repayment_type = repayment_type;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getProgress() {
                return progress;
            }

            public void setProgress(String progress) {
                this.progress = progress;
            }

            public String getBorrow_status() {
                return borrow_status;
            }

            public void setBorrow_status(String borrow_status) {
                this.borrow_status = borrow_status;
            }

            public String getInvest_award_rate() {
                return invest_award_rate;
            }

            public void setInvest_award_rate(String invest_award_rate) {
                this.invest_award_rate = invest_award_rate;
            }
        }

        public static class DebtinfoBean {
            /**
             * invest_id : 39
             * transfer_price : 2000.00
             * money : 2200.00
             * period : 12
             * total_period : 12
             * buy_uid : 0
             * buy_time : 0
             */

            private String invest_id;
            private String transfer_price;
            private String money;
            private String period;
            private String total_period;
            private String buy_uid;
            private String buy_time;

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

            public String getPeriod() {
                return period;
            }

            public void setPeriod(String period) {
                this.period = period;
            }

            public String getTotal_period() {
                return total_period;
            }

            public void setTotal_period(String total_period) {
                this.total_period = total_period;
            }

            public String getBuy_uid() {
                return buy_uid;
            }

            public void setBuy_uid(String buy_uid) {
                this.buy_uid = buy_uid;
            }

            public String getBuy_time() {
                return buy_time;
            }

            public void setBuy_time(String buy_time) {
                this.buy_time = buy_time;
            }
        }
    }
}
