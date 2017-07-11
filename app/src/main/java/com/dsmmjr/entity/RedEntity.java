package com.dsmmjr.entity;

import com.dsmmjr.base.BaseEntity;

import java.util.List;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 红包
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
public class RedEntity extends BaseEntity {

    /**
     * code : 1
     * msg : 获取成功
     * data : {"list":[{"id":"27","hb_amount":"1","hb_limit":"50","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"28","hb_amount":"2","hb_limit":"100","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"29","hb_amount":"5","hb_limit":"500","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"30","hb_amount":"10","hb_limit":"1000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"31","hb_amount":"15","hb_limit":"2000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"32","hb_amount":"15","hb_limit":"2000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"33","hb_amount":"20","hb_limit":"4000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"34","hb_amount":"20","hb_limit":"4000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"35","hb_amount":"30","hb_limit":"8000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"36","hb_amount":"30","hb_limit":"8000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"37","hb_amount":"40","hb_limit":"12500","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"}],"page":{"total":"37","nowPage":1}}
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
         * list : [{"id":"27","hb_amount":"1","hb_limit":"50","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"28","hb_amount":"2","hb_limit":"100","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"29","hb_amount":"5","hb_limit":"500","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"30","hb_amount":"10","hb_limit":"1000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"31","hb_amount":"15","hb_limit":"2000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"32","hb_amount":"15","hb_limit":"2000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"33","hb_amount":"20","hb_limit":"4000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"34","hb_amount":"20","hb_limit":"4000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"35","hb_amount":"30","hb_limit":"8000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"36","hb_amount":"30","hb_limit":"8000","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"},{"id":"37","hb_amount":"40","hb_limit":"12500","hb_begintime":"2017-04-21","hb_expiretime":"2017-09-17","hb_range":"金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝","status":"0"}]
         * page : {"total":"37","nowPage":1}
         */

        private PageBean page;
        private List<ListBean> list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PageBean {
            /**
             * total : 37
             * nowPage : 1
             */

            private String total;
            private int nowPage;

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public int getNowPage() {
                return nowPage;
            }

            public void setNowPage(int nowPage) {
                this.nowPage = nowPage;
            }
        }

        public static class ListBean {
            /**
             * id : 27
             * hb_amount : 1
             * hb_limit : 50
             * hb_begintime : 2017-04-21
             * hb_expiretime : 2017-09-17
             * hb_range : 金鼠宝B,金鼠宝A,银鼠宝,铜鼠宝
             * status : 0
             */

            private String id;
            private String hb_amount;
            private String hb_limit;
            private String hb_begintime;
            private String hb_expiretime;
            private String hb_range;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getHb_amount() {
                return hb_amount;
            }

            public void setHb_amount(String hb_amount) {
                this.hb_amount = hb_amount;
            }

            public String getHb_limit() {
                return hb_limit;
            }

            public void setHb_limit(String hb_limit) {
                this.hb_limit = hb_limit;
            }

            public String getHb_begintime() {
                return hb_begintime;
            }

            public void setHb_begintime(String hb_begintime) {
                this.hb_begintime = hb_begintime;
            }

            public String getHb_expiretime() {
                return hb_expiretime;
            }

            public void setHb_expiretime(String hb_expiretime) {
                this.hb_expiretime = hb_expiretime;
            }

            public String getHb_range() {
                return hb_range;
            }

            public void setHb_range(String hb_range) {
                this.hb_range = hb_range;
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
