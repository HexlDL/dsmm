package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/4/24.
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
public class RateEntity {
    /**
     * code : 1
     * msg : 获取成功
     * data : {"list":[{"id":"1","rate":"1","begintime":"2017-01-08","expiretime":"2017-06-28","description":"兑换时间为1个月，使用时间为1天（在使用时间内可重复使用）","status":"2"}],"page":{"total":"1","nowPage":1}}
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
         * list : [{"id":"1","rate":"1","begintime":"2017-01-08","expiretime":"2017-06-28","description":"兑换时间为1个月，使用时间为1天（在使用时间内可重复使用）","status":"2"}]
         * page : {"total":"1","nowPage":1}
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
             * total : 1
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
             * id : 1
             * rate : 1
             * begintime : 2017-01-08
             * expiretime : 2017-06-28
             * description : 兑换时间为1个月，使用时间为1天（在使用时间内可重复使用）
             * status : 2
             */

            private String id;
            private String rate;
            private String begintime;
            private String expiretime;
            private String description;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getBegintime() {
                return begintime;
            }

            public void setBegintime(String begintime) {
                this.begintime = begintime;
            }

            public String getExpiretime() {
                return expiretime;
            }

            public void setExpiretime(String expiretime) {
                this.expiretime = expiretime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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
