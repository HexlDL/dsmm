package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/4/7.
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
public class CapitalDetailEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"list":[{"type":"会员线上充值","affect_money":"200,000.00","account_money":"余额1,194,013.00元","add_time":"2017/05/31 13:27:55"},{"type":"投标冻结","affect_money":"-500","account_money":"余额994,013.00元","add_time":"2017/05/16 14:36:42"},{"type":"投标冻结","affect_money":"-500","account_money":"余额994,513.00元","add_time":"2017/05/15 16:37:41"},{"type":"投标冻结","affect_money":"-5,000","account_money":"余额995,013.00元","add_time":"2017/05/15 16:30:43"},{"type":"流标返还","affect_money":"500.00","account_money":"余额1,000,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额999,513.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额999,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额998,513.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额998,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"投标冻结","affect_money":"-500","account_money":"余额997,513.00元","add_time":"2017/05/10 14:40:26"}],"page":{"total":"20","nowPage":1}}
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
         * list : [{"type":"会员线上充值","affect_money":"200,000.00","account_money":"余额1,194,013.00元","add_time":"2017/05/31 13:27:55"},{"type":"投标冻结","affect_money":"-500","account_money":"余额994,013.00元","add_time":"2017/05/16 14:36:42"},{"type":"投标冻结","affect_money":"-500","account_money":"余额994,513.00元","add_time":"2017/05/15 16:37:41"},{"type":"投标冻结","affect_money":"-5,000","account_money":"余额995,013.00元","add_time":"2017/05/15 16:30:43"},{"type":"流标返还","affect_money":"500.00","account_money":"余额1,000,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额999,513.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额999,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额998,513.00元","add_time":"2017/05/11 14:59:55"},{"type":"流标返还","affect_money":"500.00","account_money":"余额998,013.00元","add_time":"2017/05/11 14:59:55"},{"type":"投标冻结","affect_money":"-500","account_money":"余额997,513.00元","add_time":"2017/05/10 14:40:26"}]
         * page : {"total":"20","nowPage":1}
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
             * total : 20
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
             * type : 会员线上充值
             * affect_money : 200,000.00
             * account_money : 余额1,194,013.00元
             * add_time : 2017/05/31 13:27:55
             */

            private String type;
            private String affect_money;
            private String account_money;
            private String add_time;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAffect_money() {
                return affect_money;
            }

            public void setAffect_money(String affect_money) {
                this.affect_money = affect_money;
            }

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }
        }
    }
}
