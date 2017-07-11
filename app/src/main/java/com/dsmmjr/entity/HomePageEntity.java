package com.dsmmjr.entity;

import java.util.List;

/**
 * Created by hexl
 * 首页
 */
public class HomePageEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"borrow":{"id":"906","name":"铜鼠宝c-1341","apr":"7.20","time_limit":"3个月","account":"100000.00","account_leave":0,"scaleValue":"100.00"},"ads":[{"title":"每日签到赚现金","thumb":"https://www.51daishu.com/Style/M/images/k1.jpg","url":"http://api.51daishu.com/m/about/sign.html"},{"title":"加息券兑换","thumb":"https://www.51daishu.com/Style/active/ads/m_home_coupon.jpg","url":"http://api.51daishu.com/m/active/exchange_coupon.html"},{"title":"红包口令兑换","thumb":"https://www.51daishu.com/Style/redpassword/images/kv_redpass.jpg","url":"http://api.51daishu.com/m/about/redpassword.html"},{"title":"邀请好友","thumb":"https://www.51daishu.com/Style/M/images/k2.jpg","url":"http://api.51daishu.com/m/about/invite.html"}],"dsmmdata":{"onlinedays":717,"total_amount":"143190740"}}
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
         * borrow : {"id":"906","name":"铜鼠宝c-1341","apr":"7.20","time_limit":"3个月","account":"100000.00","account_leave":0,"scaleValue":"100.00"}
         * ads : [{"title":"每日签到赚现金","thumb":"https://www.51daishu.com/Style/M/images/k1.jpg","url":"http://api.51daishu.com/m/about/sign.html"},{"title":"加息券兑换","thumb":"https://www.51daishu.com/Style/active/ads/m_home_coupon.jpg","url":"http://api.51daishu.com/m/active/exchange_coupon.html"},{"title":"红包口令兑换","thumb":"https://www.51daishu.com/Style/redpassword/images/kv_redpass.jpg","url":"http://api.51daishu.com/m/about/redpassword.html"},{"title":"邀请好友","thumb":"https://www.51daishu.com/Style/M/images/k2.jpg","url":"http://api.51daishu.com/m/about/invite.html"}]
         * dsmmdata : {"onlinedays":717,"total_amount":"143190740"}
         */

        private BorrowBean borrow;
        private DsmmdataBean dsmmdata;
        private List<BannerEntity> ads;

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public DsmmdataBean getDsmmdata() {
            return dsmmdata;
        }

        public void setDsmmdata(DsmmdataBean dsmmdata) {
            this.dsmmdata = dsmmdata;
        }

        public List<BannerEntity> getAds() {
            return ads;
        }

        public void setAds(List<BannerEntity> ads) {
            this.ads = ads;
        }

        public static class BorrowBean {
            /**
             * id : 906
             * name : 铜鼠宝c-1341
             * apr : 7.20
             * time_limit : 3个月
             * account : 100000.00
             * account_leave : 0
             * scaleValue : 100.00
             */

            private String id;
            private String name;
            private String apr;
            private String time_limit;
            private String account;
            private String account_leave;
            private String scaleValue;

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

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getAccount_leave() {
                return account_leave;
            }

            public void setAccount_leave(String account_leave) {
                this.account_leave = account_leave;
            }

            public String getScaleValue() {
                return scaleValue;
            }

            public void setScaleValue(String scaleValue) {
                this.scaleValue = scaleValue;
            }
        }

        public static class DsmmdataBean {
            /**
             * onlinedays : 717
             * total_amount : 143190740
             */

            private int onlinedays;
            private String total_amount;

            public int getOnlinedays() {
                return onlinedays;
            }

            public void setOnlinedays(int onlinedays) {
                this.onlinedays = onlinedays;
            }

            public String getTotal_amount() {
                return total_amount;
            }

            public void setTotal_amount(String total_amount) {
                this.total_amount = total_amount;
            }
        }

        /*public static class AdsBean {
            *//**
             * title : 每日签到赚现金
             * thumb : https://www.51daishu.com/Style/M/images/k1.jpg
             * url : http://api.51daishu.com/m/about/sign.html
             *//*

            private String title;
            private String thumb;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }*/
    }
}
