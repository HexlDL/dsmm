package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/24.
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
public class RepaymentDetailEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"borrow":{"borrow_name":"金鼠宝A c-0004","apr":"10.00","investor_capital":"170000.00","borrow_duration":"12个月","repayment_type":"一次性还款"},"list":[{"id":"332","capital":"170000.00","interest":"17000.00","status":"7","deadline":"2017-06-01"}]}
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
         * borrow : {"borrow_name":"金鼠宝A c-0004","apr":"10.00","investor_capital":"170000.00","borrow_duration":"12个月","repayment_type":"一次性还款"}
         * list : [{"id":"332","capital":"170000.00","interest":"17000.00","status":"7","deadline":"2017-06-01"}]
         */

        private BorrowBean borrow;
        private List<ListBean> list;

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class BorrowBean {
            /**
             * borrow_name : 金鼠宝A c-0004
             * apr : 10.00
             * investor_capital : 170000.00
             * borrow_duration : 12个月
             * repayment_type : 一次性还款
             */

            private String borrow_name;
            private String apr;
            private String investor_capital;
            private String borrow_duration;
            private String repayment_type;

            public String getBorrow_name() {
                return borrow_name;
            }

            public void setBorrow_name(String borrow_name) {
                this.borrow_name = borrow_name;
            }

            public String getApr() {
                return apr;
            }

            public void setApr(String apr) {
                this.apr = apr;
            }

            public String getInvestor_capital() {
                return investor_capital;
            }

            public void setInvestor_capital(String investor_capital) {
                this.investor_capital = investor_capital;
            }

            public String getBorrow_duration() {
                return borrow_duration;
            }

            public void setBorrow_duration(String borrow_duration) {
                this.borrow_duration = borrow_duration;
            }

            public String getRepayment_type() {
                return repayment_type;
            }

            public void setRepayment_type(String repayment_type) {
                this.repayment_type = repayment_type;
            }
        }

        public static class ListBean {
            /**
             * id : 332
             * capital : 170000.00
             * interest : 17000.00
             * status : 7
             * deadline : 2017-06-01
             */

            private String id;
            private String capital;
            private String interest;
            private String status;
            private String deadline;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCapital() {
                return capital;
            }

            public void setCapital(String capital) {
                this.capital = capital;
            }

            public String getInterest() {
                return interest;
            }

            public void setInterest(String interest) {
                this.interest = interest;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDeadline() {
                return deadline;
            }

            public void setDeadline(String deadline) {
                this.deadline = deadline;
            }
        }
    }
}
