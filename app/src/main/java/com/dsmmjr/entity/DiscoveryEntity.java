package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/5/23.
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
public class DiscoveryEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"module":[{"title":"黄金树","desc":"每日浇水赚现金","thumb":"https://www.51daishu.com/static/mapi/images/sign.png"},{"title":"会员福利社","desc":"乐兑豪华礼","thumb":"https://www.51daishu.com/static/mapi/images/shop.png"},{"title":"网站公告","desc":"不错过任何活动","thumb":"https://www.51daishu.com/static/mapi/images/notice.png"},{"title":"袋鼠新闻","desc":"了解最新动态","thumb":"https://www.51daishu.com/static/mapi/images/news.png"},{"title":"帮助中心","desc":"不懂的点这里","thumb":"https://www.51daishu.com/static/mapi/images/help.png","url":"http://api.51daishu.com/m/about/help.html"},{"title":"在线反馈","desc":"有问题点这里","thumb":"https://www.51daishu.com/static/mapi/images/feedback.png","url":"http://api.51daishu.com/m/page/feedback.html"},{"title":"我要借款","desc":"最快当日放款","thumb":"https://www.51daishu.com/static/mapi/images/borrow.png","url":"http://api.51daishu.com/m/borrow/index.html"},{"title":"黄金树","desc":"养树兑豪华礼包","thumb":"https://www.51daishu.com/static/mapi/images/tree.png","url":"http://api.51daishu.com/m/app/goldtree.html"},{"title":"邀请好友","desc":"邀请好友一起赚","thumb":"https://www.51daishu.com/static/mapi/images/invite.png","url":"http://api.51daishu.com/m/about/invite.html"}],"ads":[{"title":"富养黄金树 乐兑豪华礼","thumb":"https://www.51daishu.com/static/mapi/ads/tree.jpg","url":"http://api.51daishu.com/m/active/tree.html"},{"title":"会员福利社","thumb":"https://www.51daishu.com/static/mapi/ads/mall.jpg","url":"http://api.51daishu.com/m/active/exchange_coupon.html"},{"title":"红包口令兑换","thumb":"https://www.51daishu.com/static/mapi/ads/hongbao.jpg","url":"http://api.51daishu.com/m/about/redpassword.html"},{"title":"加息券兑换","thumb":"https://www.51daishu.com/static/mapi/ads/jiaxi.jpg","url":"http://api.51daishu.com/m/about/invite.html"}]}
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
        private List<ModuleBean> module;
        private List<BannerEntity> ads;

        public List<ModuleBean> getModule() {
            return module;
        }

        public List<BannerEntity> getAds() {
            return ads;
        }

        public void setAds(List<BannerEntity> ads) {
            this.ads = ads;
        }

        public void setModule(List<ModuleBean> module) {
            this.module = module;
        }

        public static class ModuleBean {
            /**
             * title : 黄金树
             * desc : 每日浇水赚现金
             * thumb : https://www.51daishu.com/static/mapi/images/sign.png
             * url : http://api.51daishu.com/m/about/help.html
             */

            private String title;
            private String desc;
            private String thumb;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
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
    }
}
