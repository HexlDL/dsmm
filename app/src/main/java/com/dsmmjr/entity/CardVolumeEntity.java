package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 红包卡卷
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
public class CardVolumeEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"borrow":{"borrow_need":"91000","is_password":"0"},"userinfo":{"account_money":"1000000"},"coupon_count":"40","coupons":[{"id":"coupon_1","value":"1%","lastHour":"1329小时"},{"id":"coupon_13","value":"1%","lastHour":"1329小时"},{"id":"coupon_14","value":"1%","lastHour":"1329小时"},{"id":"1","value":"1元","limit":"50"},{"id":"2","value":"2元","limit":"100"},{"id":"3","value":"5元","limit":"200"},{"id":"4","value":"10元","limit":"500"},{"id":"5","value":"20元","limit":"1000"},{"id":"6","value":"20元","limit":"1000"},{"id":"7","value":"30元","limit":"5000"},{"id":"8","value":"50元","limit":"10000"},{"id":"9","value":"50元","limit":"10000"},{"id":"10","value":"1元","limit":"50"},{"id":"11","value":"2元","limit":"100"},{"id":"12","value":"5元","limit":"200"},{"id":"13","value":"10元","limit":"500"},{"id":"14","value":"10元","limit":"500"},{"id":"15","value":"20元","limit":"1000"},{"id":"16","value":"30元","limit":"5000"},{"id":"17","value":"50元","limit":"10000"},{"id":"18","value":"1元","limit":"50"},{"id":"19","value":"2元","limit":"100"},{"id":"20","value":"5元","limit":"200"},{"id":"21","value":"10元","limit":"500"},{"id":"22","value":"20元","limit":"1000"},{"id":"23","value":"20元","limit":"1000"},{"id":"24","value":"30元","limit":"5000"},{"id":"25","value":"50元","limit":"10000"},{"id":"26","value":"50元","limit":"10000"},{"id":"27","value":"1元","limit":"50"},{"id":"28","value":"2元","limit":"100"},{"id":"29","value":"5元","limit":"500"},{"id":"30","value":"10元","limit":"1000"},{"id":"31","value":"15元","limit":"2000"},{"id":"32","value":"15元","limit":"2000"},{"id":"33","value":"20元","limit":"4000"},{"id":"34","value":"20元","limit":"4000"},{"id":"35","value":"30元","limit":"8000"},{"id":"36","value":"30元","limit":"8000"},{"id":"37","value":"40元","limit":"12500"}]}
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
         * borrow : {"borrow_need":"91000","is_password":"0"}
         * userinfo : {"account_money":"1000000"}
         * coupon_count : 40
         * coupons : [{"id":"coupon_1","value":"1%","lastHour":"1329小时"},{"id":"coupon_13","value":"1%","lastHour":"1329小时"},{"id":"coupon_14","value":"1%","lastHour":"1329小时"},{"id":"1","value":"1元","limit":"50"},{"id":"2","value":"2元","limit":"100"},{"id":"3","value":"5元","limit":"200"},{"id":"4","value":"10元","limit":"500"},{"id":"5","value":"20元","limit":"1000"},{"id":"6","value":"20元","limit":"1000"},{"id":"7","value":"30元","limit":"5000"},{"id":"8","value":"50元","limit":"10000"},{"id":"9","value":"50元","limit":"10000"},{"id":"10","value":"1元","limit":"50"},{"id":"11","value":"2元","limit":"100"},{"id":"12","value":"5元","limit":"200"},{"id":"13","value":"10元","limit":"500"},{"id":"14","value":"10元","limit":"500"},{"id":"15","value":"20元","limit":"1000"},{"id":"16","value":"30元","limit":"5000"},{"id":"17","value":"50元","limit":"10000"},{"id":"18","value":"1元","limit":"50"},{"id":"19","value":"2元","limit":"100"},{"id":"20","value":"5元","limit":"200"},{"id":"21","value":"10元","limit":"500"},{"id":"22","value":"20元","limit":"1000"},{"id":"23","value":"20元","limit":"1000"},{"id":"24","value":"30元","limit":"5000"},{"id":"25","value":"50元","limit":"10000"},{"id":"26","value":"50元","limit":"10000"},{"id":"27","value":"1元","limit":"50"},{"id":"28","value":"2元","limit":"100"},{"id":"29","value":"5元","limit":"500"},{"id":"30","value":"10元","limit":"1000"},{"id":"31","value":"15元","limit":"2000"},{"id":"32","value":"15元","limit":"2000"},{"id":"33","value":"20元","limit":"4000"},{"id":"34","value":"20元","limit":"4000"},{"id":"35","value":"30元","limit":"8000"},{"id":"36","value":"30元","limit":"8000"},{"id":"37","value":"40元","limit":"12500"}]
         */

        private BorrowBean borrow;
        private UserinfoBean userinfo;
        private String coupon_count;
        private List<CouponsBean> coupons;

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public String getCoupon_count() {
            return coupon_count;
        }

        public void setCoupon_count(String coupon_count) {
            this.coupon_count = coupon_count;
        }

        public List<CouponsBean> getCoupons() {
            return coupons;
        }

        public void setCoupons(List<CouponsBean> coupons) {
            this.coupons = coupons;
        }

        public static class BorrowBean {
            /**
             * borrow_need : 91000
             * is_password : 0
             */

            private String borrow_need;
            private String is_password;

            public String getBorrow_need() {
                return borrow_need;
            }

            public void setBorrow_need(String borrow_need) {
                this.borrow_need = borrow_need;
            }

            public String getIs_password() {
                return is_password;
            }

            public void setIs_password(String is_password) {
                this.is_password = is_password;
            }
        }

        public static class UserinfoBean {
            /**
             * account_money : 1000000
             */

            private String account_money;
            private String pin_pass;
            private String id_status;
            private String fuiou_status;

            public String getFuiou_status() {
                return fuiou_status;
            }

            public void setFuiou_status(String fuiou_status) {
                this.fuiou_status = fuiou_status;
            }

            public String getId_status() {
                return id_status;
            }

            public void setId_status(String id_status) {
                this.id_status = id_status;
            }

            public String getPin_pass() {
                return pin_pass;
            }

            public void setPin_pass(String pin_pass) {
                this.pin_pass = pin_pass;
            }

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }
        }

        public static class CouponsBean {
            /**
             * id : coupon_1
             * value : 1%
             * lastHour : 1329小时
             * limit : 50
             */

            private String id;
            private String value;
            private String lastHour;
            private String limit;
            private String flag;
            private String expire;

            public String getExpire() {
                return expire;
            }

            public void setExpire(String expire) {
                this.expire = expire;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLastHour() {
                return lastHour;
            }

            public void setLastHour(String lastHour) {
                this.lastHour = lastHour;
            }

            public String getLimit() {
                return limit;
            }

            public void setLimit(String limit) {
                this.limit = limit;
            }
        }
    }
}
