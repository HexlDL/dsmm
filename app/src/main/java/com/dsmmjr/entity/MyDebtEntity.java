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
public class MyDebtEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"total_count":"14","list":[{"id":"11","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"5000.00","interest":"500.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"12","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"50.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"13","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"54.96","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"22","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"54.96","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"23","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"1000.00","interest":"110.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"24","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"1900.00","interest":"209.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"25","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"400.00","interest":"44.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"26","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"800.00","interest":"80.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"27","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"2222.00","interest":"222.24","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"32","borrow_id":"907","borrow_name":"金鼠宝A c-0001","period":"0","total_period":"0","capital":null,"interest":null,"borrow_interest_rate":"10.00%","dateline":"1970-01-01"},{"id":"35","borrow_id":"909","borrow_name":"金鼠宝A c-0003","period":"1","total_period":"1","capital":"2000.00","interest":"200.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"36","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"54145.00","interest":"5414.52","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"37","borrow_id":"909","borrow_name":"金鼠宝A c-0003","period":"1","total_period":"1","capital":"26000.00","interest":"2600.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"38","borrow_id":"910","borrow_name":"金鼠宝A c-0004","period":"1","total_period":"1","capital":"170000.00","interest":"17000.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"}]}
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
         * total_count : 14
         * list : [{"id":"11","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"5000.00","interest":"500.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"12","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"50.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"13","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"54.96","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"22","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"500.00","interest":"54.96","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"23","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"1000.00","interest":"110.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"24","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"1900.00","interest":"209.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"25","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"400.00","interest":"44.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"26","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"800.00","interest":"80.04","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"27","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"2222.00","interest":"222.24","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"32","borrow_id":"907","borrow_name":"金鼠宝A c-0001","period":"0","total_period":"0","capital":null,"interest":null,"borrow_interest_rate":"10.00%","dateline":"1970-01-01"},{"id":"35","borrow_id":"909","borrow_name":"金鼠宝A c-0003","period":"1","total_period":"1","capital":"2000.00","interest":"200.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"36","borrow_id":"908","borrow_name":"金鼠宝A c-0002","period":"12","total_period":"12","capital":"54145.00","interest":"5414.52","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"37","borrow_id":"909","borrow_name":"金鼠宝A c-0003","period":"1","total_period":"1","capital":"26000.00","interest":"2600.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"},{"id":"38","borrow_id":"910","borrow_name":"金鼠宝A c-0004","period":"1","total_period":"1","capital":"170000.00","interest":"17000.00","borrow_interest_rate":"10.00%","dateline":"2018-06-01"}]
         */

        private String total_count;
        private List<ListBean> list;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 11
             * borrow_id : 908
             * borrow_name : 金鼠宝A c-0002
             * period : 12
             * total_period : 12
             * capital : 5000.00
             * interest : 500.04
             * borrow_interest_rate : 10.00%
             * dateline : 2018-06-01
             */

            private String id;
            private String borrow_id;
            private String borrow_name;
            private String period;
            private String total_period;
            private String capital;
            private String money;
            private String interest;
            private String borrow_interest_rate;
            private String dateline;
            private String transfer_price;
            private String cancel_times;
            private String status;

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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getBorrow_interest_rate() {
                return borrow_interest_rate;
            }

            public void setBorrow_interest_rate(String borrow_interest_rate) {
                this.borrow_interest_rate = borrow_interest_rate;
            }

            public String getDateline() {
                return dateline;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public String getCancel_times() {
                return cancel_times;
            }

            public String getStatus() {
                return status;
            }
        }
    }
}
