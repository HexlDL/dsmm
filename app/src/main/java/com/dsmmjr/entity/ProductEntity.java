package com.dsmmjr.entity;

import com.dsmmjr.base.BaseEntity;

import java.util.List;

/**
 * Create time : 2017/3/20.
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

public class ProductEntity extends BaseEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"total_page":89,"list":[{"id":"903","name":"铜鼠宝 c-1338","account":"15000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"56.03","surplus":6596,"style":"4"},{"id":"906","name":"铜鼠宝c-1341","account":"100000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"100.00","surplus":0,"style":"4"},{"id":"902","name":"银鼠宝c-1337","account":"50000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"901","name":"银鼠宝 c-1336","account":"20000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"900","name":"银鼠宝c-1335","account":"150000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"899","name":"金鼠宝B c-1333","account":"190000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"898","name":"金鼠宝B c-1334","account":"200000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"897","name":"金鼠宝B c-1332","account":"80000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"896","name":"金鼠宝B c-1331","account":"145000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"895","name":"铜鼠宝c-1330","account":"35000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"100.00","surplus":0,"style":"4"}]}
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
         * total_page : 89
         * list : [{"id":"903","name":"铜鼠宝 c-1338","account":"15000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"56.03","surplus":6596,"style":"4"},{"id":"906","name":"铜鼠宝c-1341","account":"100000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"100.00","surplus":0,"style":"4"},{"id":"902","name":"银鼠宝c-1337","account":"50000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"901","name":"银鼠宝 c-1336","account":"20000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"900","name":"银鼠宝c-1335","account":"150000.00","stype":0,"apr":"8.40","time_limit":"6个月","scale":"100.00","surplus":0,"style":"4"},{"id":"899","name":"金鼠宝B c-1333","account":"190000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"898","name":"金鼠宝B c-1334","account":"200000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"897","name":"金鼠宝B c-1332","account":"80000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"896","name":"金鼠宝B c-1331","account":"145000.00","stype":0,"apr":"10.50","time_limit":"12个月","scale":"100.00","surplus":0,"style":"5"},{"id":"895","name":"铜鼠宝c-1330","account":"35000.00","stype":0,"apr":"7.20","time_limit":"3个月","scale":"100.00","surplus":0,"style":"4"}]
         */

        private int total_page;
        private int type;


        private List<ListBean> list;

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 903
             * name : 铜鼠宝 c-1338
             * account : 15000.00
             * stype : 0
             * apr : 7.20
             * time_limit : 3个月
             * scale : 56.03
             * surplus : 6596
             * style : 4
             * type : 1投资 2债权
             * transfer_price：转让价格
             * status：债权状态
             * money：债权待收本息
             * total_period：总期数
             * period：未还期数
             */

            private String id;
            private String name;
            private String account;
            private int stype;
            private String apr;
            private String time_limit;
            private String scale;
            private String surplus;
            private String style;
            private String borrow_status;
            private String borrow_ico;
            private String transfer_price;
            private String status;
            private String money;
            private String total_period;
            private String period;
            private String valid;
            private String invest_id;
            private String borrow_id;

            public String getValid() {
                return valid;
            }

            public void setValid(String valid) {
                this.valid = valid;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTotal_period() {
                return total_period;
            }

            public void setTotal_period(String total_period) {
                this.total_period = total_period;
            }

            public String getTransfer_price() {
                return transfer_price;
            }

            public void setTransfer_price(String transfer_price) {
                this.transfer_price = transfer_price;
            }

            public String getBorrow_ico() {
                return borrow_ico;
            }

            public void setBorrow_ico(String borrow_ico) {
                this.borrow_ico = borrow_ico;
            }

            public String getBorrow_status() {
                return borrow_status;
            }

            public void setBorrow_status(String borrow_status) {
                this.borrow_status = borrow_status;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public int getStype() {
                return stype;
            }

            public void setStype(int stype) {
                this.stype = stype;
            }

            public String getApr() {
                return apr;
            }

            public void setApr(String apr) {
                this.apr = apr;
            }

            public String getTime_limit() {
                return time_limit;
            }

            public void setTime_limit(String time_limit) {
                this.time_limit = time_limit;
            }

            public String getScale() {
                return scale;
            }

            public void setScale(String scale) {
                this.scale = scale;
            }

            public String getSurplus() {
                return surplus;
            }

            public void setSurplus(String surplus) {
                this.surplus = surplus;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getBorrow_id() {
                return borrow_id;
            }

            public String getInvest_id() {
                return invest_id;
            }
        }
    }
}
