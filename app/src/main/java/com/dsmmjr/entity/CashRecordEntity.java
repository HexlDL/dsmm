package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/23.
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
public class CashRecordEntity {

    /**
     * code : 1
     * msg : OK
     * data : {"withdraw":[{"info":"提现金额100元","time":"2016-08-31 09:53:00","status":"审核未通过","fee":"手续费0元","success_money":"到账金额0元"},{"info":"提现金额2605元","time":"2016-08-08 10:58:31","status":"提现成功","fee":"手续费1元","success_money":"到账金额2604元"},{"info":"提现金额7926元","time":"2016-08-05 09:33:28","status":"提现成功","fee":"手续费1元","success_money":"到账金额7925元"},{"info":"提现金额902元","time":"2016-04-20 13:51:46","status":"审核未通过","fee":"手续费1元","success_money":"到账金额0元"},{"info":"提现金额1029元","time":"2016-04-18 14:25:06","status":"提现成功","fee":"手续费1元","success_money":"到账金额1028元"},{"info":"提现金额149元","time":"2016-01-14 14:57:50","status":"提现成功","fee":"手续费1元","success_money":"到账金额148元"},{"info":"提现金额9286元","time":"2015-11-03 15:36:21","status":"提现成功","fee":"手续费7元","success_money":"到账金额9278元"},{"info":"提现金额500元","time":"2015-05-29 16:25:05","status":"审核未通过","fee":"手续费1元","success_money":"到账金额0元"},{"info":"提现金额100元","time":"2015-05-29 10:32:49","status":"审核未通过","fee":"手续费0元","success_money":"到账金额0元"}],"total_count":"9"}
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
         * withdraw : [{"info":"提现金额100元","time":"2016-08-31 09:53:00","status":"审核未通过","fee":"手续费0元","success_money":"到账金额0元"},{"info":"提现金额2605元","time":"2016-08-08 10:58:31","status":"提现成功","fee":"手续费1元","success_money":"到账金额2604元"},{"info":"提现金额7926元","time":"2016-08-05 09:33:28","status":"提现成功","fee":"手续费1元","success_money":"到账金额7925元"},{"info":"提现金额902元","time":"2016-04-20 13:51:46","status":"审核未通过","fee":"手续费1元","success_money":"到账金额0元"},{"info":"提现金额1029元","time":"2016-04-18 14:25:06","status":"提现成功","fee":"手续费1元","success_money":"到账金额1028元"},{"info":"提现金额149元","time":"2016-01-14 14:57:50","status":"提现成功","fee":"手续费1元","success_money":"到账金额148元"},{"info":"提现金额9286元","time":"2015-11-03 15:36:21","status":"提现成功","fee":"手续费7元","success_money":"到账金额9278元"},{"info":"提现金额500元","time":"2015-05-29 16:25:05","status":"审核未通过","fee":"手续费1元","success_money":"到账金额0元"},{"info":"提现金额100元","time":"2015-05-29 10:32:49","status":"审核未通过","fee":"手续费0元","success_money":"到账金额0元"}]
         * total_count : 9
         */

        private String total_count;
        private List<WithdrawBean> withdraw;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public List<WithdrawBean> getWithdraw() {
            return withdraw;
        }

        public void setWithdraw(List<WithdrawBean> withdraw) {
            this.withdraw = withdraw;
        }

        public static class WithdrawBean {
            /**
             * info : 提现金额100元
             * time : 2016-08-31 09:53:00
             * status : 审核未通过
             * fee : 手续费0元
             * success_money : 到账金额0元
             */

            private String info;
            private String time;
            private String status;
            private String fee;
            private String success_money;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getFee() {
                return fee;
            }

            public void setFee(String fee) {
                this.fee = fee;
            }

            public String getSuccess_money() {
                return success_money;
            }

            public void setSuccess_money(String success_money) {
                this.success_money = success_money;
            }
        }
    }
}
