package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/4/5.
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
public class PointEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"ads":[{"title":"广告1","thumb":"https://www.51daishu.com/Style/M/images/k1.jpg","url":"http://api.51daishu.com/m/about/sign.html"},{"title":"广告2","thumb":"https://www.51daishu.com/Style/active/ads/m_home_coupon.jpg","url":"http://api.51daishu.com/m/active/exchange_coupon.html"},{"title":"广告3","thumb":"https://www.51daishu.com/Style/redpassword/images/kv_redpass.jpg","url":"http://api.51daishu.com/m/about/redpassword.html"},{"title":"广告4","thumb":"https://www.51daishu.com/Style/M/images/k2.jpg","url":"http://api.51daishu.com/m/about/invite.html"}],"integralAll":"0","entity_list":[{"id":"141","name":"森鸿源糯米","small_img":"https://www.51daishu.comsmall-wCJ8q-1478072753.png","cost":"1725"},{"id":"142","name":"森鸿源小米","small_img":"https://www.51daishu.comsmall-Wz3fB-1478072782.png","cost":"1725"},{"id":"143","name":"森鸿源绿豆","small_img":"https://www.51daishu.comsmall-f4b3w-1478072818.png","cost":"1725"},{"id":"144","name":"森鸿源黑豆","small_img":"https://www.51daishu.comsmall-4qH4g-1478072833.png","cost":"1725"},{"id":"145","name":"森鸿源椴树蜜","small_img":"https://www.51daishu.comsmall-Dfvi7-1478072864.png","cost":"9775"},{"id":"146","name":"瑞米轩五常大米","small_img":"https://www.51daishu.comsmall-W5GJc-1481093916.png","cost":"15000"},{"id":"147","name":"福禄寿喜米桶","small_img":"https://www.51daishu.comsmall-WrcCs-1478072898.png","cost":"28750"},{"id":"135","name":"森鸿源玉米粉","small_img":"https://www.51daishu.comsmall-SWH1U-1478072944.png","cost":"1035"},{"id":"136","name":"森鸿源黄豆","small_img":"https://www.51daishu.comsmall-Yi40P-1478072957.png","cost":"1035"},{"id":"137","name":"森鸿源燕麦米","small_img":"https://www.51daishu.comsmall-p5THP-1478072987.png","cost":"1265"}],"virtual_list":[{"id":"148","name":"188元红包","small_img":"https://www.51daishu.com","cost":"10000"}]}
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
         * ads : [{"title":"广告1","thumb":"https://www.51daishu.com/Style/M/images/k1.jpg","url":"http://api.51daishu.com/m/about/sign.html"},{"title":"广告2","thumb":"https://www.51daishu.com/Style/active/ads/m_home_coupon.jpg","url":"http://api.51daishu.com/m/active/exchange_coupon.html"},{"title":"广告3","thumb":"https://www.51daishu.com/Style/redpassword/images/kv_redpass.jpg","url":"http://api.51daishu.com/m/about/redpassword.html"},{"title":"广告4","thumb":"https://www.51daishu.com/Style/M/images/k2.jpg","url":"http://api.51daishu.com/m/about/invite.html"}]
         * integralAll : 0
         * entity_list : [{"id":"141","name":"森鸿源糯米","small_img":"https://www.51daishu.comsmall-wCJ8q-1478072753.png","cost":"1725"},{"id":"142","name":"森鸿源小米","small_img":"https://www.51daishu.comsmall-Wz3fB-1478072782.png","cost":"1725"},{"id":"143","name":"森鸿源绿豆","small_img":"https://www.51daishu.comsmall-f4b3w-1478072818.png","cost":"1725"},{"id":"144","name":"森鸿源黑豆","small_img":"https://www.51daishu.comsmall-4qH4g-1478072833.png","cost":"1725"},{"id":"145","name":"森鸿源椴树蜜","small_img":"https://www.51daishu.comsmall-Dfvi7-1478072864.png","cost":"9775"},{"id":"146","name":"瑞米轩五常大米","small_img":"https://www.51daishu.comsmall-W5GJc-1481093916.png","cost":"15000"},{"id":"147","name":"福禄寿喜米桶","small_img":"https://www.51daishu.comsmall-WrcCs-1478072898.png","cost":"28750"},{"id":"135","name":"森鸿源玉米粉","small_img":"https://www.51daishu.comsmall-SWH1U-1478072944.png","cost":"1035"},{"id":"136","name":"森鸿源黄豆","small_img":"https://www.51daishu.comsmall-Yi40P-1478072957.png","cost":"1035"},{"id":"137","name":"森鸿源燕麦米","small_img":"https://www.51daishu.comsmall-p5THP-1478072987.png","cost":"1265"}]
         * virtual_list : [{"id":"148","name":"188元红包","small_img":"https://www.51daishu.com","cost":"10000"}]
         */

        private String integralAll;
        private List<AdsBean> ads;
        private List<EntityListBean> entity_list;
        private List<VirtualListBean> virtual_list;

        public String getIntegralAll() {
            return integralAll;
        }

        public void setIntegralAll(String integralAll) {
            this.integralAll = integralAll;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<EntityListBean> getEntity_list() {
            return entity_list;
        }

        public void setEntity_list(List<EntityListBean> entity_list) {
            this.entity_list = entity_list;
        }

        public List<VirtualListBean> getVirtual_list() {
            return virtual_list;
        }

        public void setVirtual_list(List<VirtualListBean> virtual_list) {
            this.virtual_list = virtual_list;
        }

        public static class AdsBean {
            /**
             * title : 广告1
             * thumb : https://www.51daishu.com/Style/M/images/k1.jpg
             * url : http://api.51daishu.com/m/about/sign.html
             */

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
        }

        public static class EntityListBean {
            /**
             * id : 141
             * name : 森鸿源糯米
             * small_img : https://www.51daishu.comsmall-wCJ8q-1478072753.png
             * cost : 1725
             */

            private String id;
            private String name;
            private String small_img;
            private String cost;

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

            public String getSmall_img() {
                return small_img;
            }

            public void setSmall_img(String small_img) {
                this.small_img = small_img;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }
        }

        public static class VirtualListBean {
            /**
             * id : 148
             * name : 188元红包
             * small_img : https://www.51daishu.com
             * cost : 10000
             */

            private String id;
            private String name;
            private String small_img;
            private String cost;

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

            public String getSmall_img() {
                return small_img;
            }

            public void setSmall_img(String small_img) {
                this.small_img = small_img;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }
        }
    }
}
