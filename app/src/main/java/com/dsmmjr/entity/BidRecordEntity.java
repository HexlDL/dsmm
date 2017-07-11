package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/28.
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
public class BidRecordEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"total_page":"11","investrecord":[{"user_name":"156****787","investor_capital":"￥5,000.00","invest_time":"2017-05-15 16:30"},{"user_name":"156****787","investor_capital":"￥500.00","invest_time":"2017-05-15 16:37"},{"user_name":"156****787","investor_capital":"￥500.00","invest_time":"2017-05-16 14:36"},{"user_name":"185****936","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:31"},{"user_name":"185****936","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:31"},{"user_name":"189****236","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:45"},{"user_name":"189****236","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:49"},{"user_name":"182****090","investor_capital":"￥4,000.00","invest_time":"2017-05-18 13:24"},{"user_name":"182****090","investor_capital":"￥5,000.00","invest_time":"2017-05-18 13:25"},{"user_name":"138****052","investor_capital":"￥100.00","invest_time":"2017-05-18 17:05"},{"user_name":"185****936","investor_capital":"￥600.00","invest_time":"2017-05-18 17:09"}]}
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
         * total_page : 11
         * investrecord : [{"user_name":"156****787","investor_capital":"￥5,000.00","invest_time":"2017-05-15 16:30"},{"user_name":"156****787","investor_capital":"￥500.00","invest_time":"2017-05-15 16:37"},{"user_name":"156****787","investor_capital":"￥500.00","invest_time":"2017-05-16 14:36"},{"user_name":"185****936","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:31"},{"user_name":"185****936","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:31"},{"user_name":"189****236","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:45"},{"user_name":"189****236","investor_capital":"￥5,000.00","invest_time":"2017-05-18 10:49"},{"user_name":"182****090","investor_capital":"￥4,000.00","invest_time":"2017-05-18 13:24"},{"user_name":"182****090","investor_capital":"￥5,000.00","invest_time":"2017-05-18 13:25"},{"user_name":"138****052","investor_capital":"￥100.00","invest_time":"2017-05-18 17:05"},{"user_name":"185****936","investor_capital":"￥600.00","invest_time":"2017-05-18 17:09"}]
         */

        private String total_page;
        private List<InvestrecordBean> investrecord;

        public String getTotal_page() {
            return total_page;
        }

        public void setTotal_page(String total_page) {
            this.total_page = total_page;
        }

        public List<InvestrecordBean> getInvestrecord() {
            return investrecord;
        }

        public void setInvestrecord(List<InvestrecordBean> investrecord) {
            this.investrecord = investrecord;
        }

        public static class InvestrecordBean {
            /**
             * user_name : 156****787
             * investor_capital : ￥5,000.00
             * invest_time : 2017-05-15 16:30
             */

            private String user_name;
            private String investor_capital;
            private String invest_time;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getInvestor_capital() {
                return investor_capital;
            }

            public void setInvestor_capital(String investor_capital) {
                this.investor_capital = investor_capital;
            }

            public String getInvest_time() {
                return invest_time;
            }

            public void setInvest_time(String invest_time) {
                this.invest_time = invest_time;
            }
        }
    }
}
