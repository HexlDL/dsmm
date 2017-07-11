package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/22.
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
public class RechargeRecodeEntity {

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
         * charge : [{"info":"充值金额10000元","time":"2017-05-31 13:50:21","status":"充值未完成"},{"info":"充值金额100000元","time":"2017-05-31 13:31:09","status":"充值未完成"},{"info":"充值金额200000元","time":"2017-05-31 13:27:32","status":"充值成功"},{"info":"充值金额200000元","time":"2017-05-31 12:17:12","status":"充值未完成"},{"info":"充值金额11111元","time":"2017-05-31 12:13:13","status":"充值未完成"},{"info":"充值金额100元","time":"2017-05-31 11:54:34","status":"充值未完成"},{"info":"充值金额100元","time":"2017-05-31 11:53:48","status":"充值未完成"}]
         * total_count : 7
         */

        private String total_count;
        private List<ChargeBean> charge;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public List<ChargeBean> getCharge() {
            return charge;
        }

        public void setCharge(List<ChargeBean> charge) {
            this.charge = charge;
        }

        public static class ChargeBean {
            /**
             * info : 充值金额10000元
             * time : 2017-05-31 13:50:21
             * status : 充值未完成
             */

            private String info;
            private String time;
            private String status;

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
        }
    }
}
