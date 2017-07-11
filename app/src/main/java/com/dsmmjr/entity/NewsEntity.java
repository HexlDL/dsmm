package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/3/30.
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
public class NewsEntity {
    /**
     * code : 1
     * msg : Success
     * data : {"total_page":"67","list":[{"id":"488","title":"一分钟了解袋鼠妈妈金融","art_time":"2017-01-11","url":"http://api.51daishu.com/mapi/news/detail/id/488.html"},{"id":"494","title":"以市委副书记、区委书记徐劼为首的市委领导莅临参观袋鼠妈妈茶馆！","art_time":"2017-03-06","url":"http://api.51daishu.com/mapi/news/detail/id/494.html"},{"id":"492","title":"袋鼠妈妈茶馆被设为\u201c同心实践基地\u201d啦！","art_time":"2017-02-14","url":"http://api.51daishu.com/mapi/news/detail/id/492.html"},{"id":"490","title":"袋鼠妈妈2017年会丨两周年庆暨新老客户回馈晚宴开席啦~~","art_time":"2017-01-12","url":"http://api.51daishu.com/mapi/news/detail/id/490.html"},{"id":"486","title":"袋鼠妈妈年会丨今天吹响集结号~~","art_time":"2017-01-10","url":"http://api.51daishu.com/mapi/news/detail/id/486.html"},{"id":"480","title":"网贷神州行南京站圆满落幕","art_time":"2016-11-29","url":"http://api.51daishu.com/mapi/news/detail/id/480.html"},{"id":"483","title":"2016，袋鼠妈妈大事件","art_time":"2017-01-04","url":"http://api.51daishu.com/mapi/news/detail/id/483.html"},{"id":"481","title":"网贷神州行南京站圆桌会议","art_time":"2016-11-30","url":"http://api.51daishu.com/mapi/news/detail/id/481.html"},{"id":"479","title":"【找寻妈妈的味道】第十一期 秘制干切牛肉","art_time":"2016-11-24","url":"http://api.51daishu.com/mapi/news/detail/id/479.html"},{"id":"478","title":"\u201c要要要爱\u201d相亲会","art_time":"2016-11-04","url":"http://api.51daishu.com/mapi/news/detail/id/478.html"},{"id":"477","title":"【找寻妈妈的味道】第十期 集美貌与才华于一身的缤纷虾仁","art_time":"2016-11-02","url":"http://api.51daishu.com/mapi/news/detail/id/477.html"},{"id":"476","title":"【找寻妈妈的味道】第九期 微微，大神喊你来吃虾","art_time":"2016-10-21","url":"http://api.51daishu.com/mapi/news/detail/id/476.html"},{"id":"474","title":"【找寻妈妈的味道】第八期 夏末的一道闪电，双椒鱼头","art_time":"2016-10-18","url":"http://api.51daishu.com/mapi/news/detail/id/474.html"},{"id":"469","title":"【找寻妈妈的味道】第七期 立秋时节，来一盆清蒸太湖白鱼","art_time":"2016-10-12","url":"http://api.51daishu.com/mapi/news/detail/id/469.html"},{"id":"467","title":"【找寻妈妈的味道】第六期 蒜泥粉皮，夏日的一道绿色","art_time":"2016-09-22","url":"http://api.51daishu.com/mapi/news/detail/id/467.html"},{"id":"453","title":"【找寻妈妈的味道】第五期 蜜桃炒肉，香香甜甜我最爱","art_time":"2016-08-18","url":"http://api.51daishu.com/mapi/news/detail/id/453.html"},{"id":"452","title":"【找寻妈妈的味道】第四期 洋葱抱大虾，满满都是爱","art_time":"2016-08-18","url":"http://api.51daishu.com/mapi/news/detail/id/452.html"},{"id":"451","title":"【找寻妈妈的味道】第三期 没什么坎是小龙虾解决不了的","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/451.html"},{"id":"450","title":"【找寻妈妈的味道】第二期 奶奶，我也要吃糖醋鲈鱼","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/450.html"},{"id":"449","title":" 【找寻妈妈的味道】第一期  丁姐私房红烧肉","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/449.html"}]}
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
         * total_page : 67
         * list : [{"id":"488","title":"一分钟了解袋鼠妈妈金融","art_time":"2017-01-11","url":"http://api.51daishu.com/mapi/news/detail/id/488.html"},{"id":"494","title":"以市委副书记、区委书记徐劼为首的市委领导莅临参观袋鼠妈妈茶馆！","art_time":"2017-03-06","url":"http://api.51daishu.com/mapi/news/detail/id/494.html"},{"id":"492","title":"袋鼠妈妈茶馆被设为\u201c同心实践基地\u201d啦！","art_time":"2017-02-14","url":"http://api.51daishu.com/mapi/news/detail/id/492.html"},{"id":"490","title":"袋鼠妈妈2017年会丨两周年庆暨新老客户回馈晚宴开席啦~~","art_time":"2017-01-12","url":"http://api.51daishu.com/mapi/news/detail/id/490.html"},{"id":"486","title":"袋鼠妈妈年会丨今天吹响集结号~~","art_time":"2017-01-10","url":"http://api.51daishu.com/mapi/news/detail/id/486.html"},{"id":"480","title":"网贷神州行南京站圆满落幕","art_time":"2016-11-29","url":"http://api.51daishu.com/mapi/news/detail/id/480.html"},{"id":"483","title":"2016，袋鼠妈妈大事件","art_time":"2017-01-04","url":"http://api.51daishu.com/mapi/news/detail/id/483.html"},{"id":"481","title":"网贷神州行南京站圆桌会议","art_time":"2016-11-30","url":"http://api.51daishu.com/mapi/news/detail/id/481.html"},{"id":"479","title":"【找寻妈妈的味道】第十一期 秘制干切牛肉","art_time":"2016-11-24","url":"http://api.51daishu.com/mapi/news/detail/id/479.html"},{"id":"478","title":"\u201c要要要爱\u201d相亲会","art_time":"2016-11-04","url":"http://api.51daishu.com/mapi/news/detail/id/478.html"},{"id":"477","title":"【找寻妈妈的味道】第十期 集美貌与才华于一身的缤纷虾仁","art_time":"2016-11-02","url":"http://api.51daishu.com/mapi/news/detail/id/477.html"},{"id":"476","title":"【找寻妈妈的味道】第九期 微微，大神喊你来吃虾","art_time":"2016-10-21","url":"http://api.51daishu.com/mapi/news/detail/id/476.html"},{"id":"474","title":"【找寻妈妈的味道】第八期 夏末的一道闪电，双椒鱼头","art_time":"2016-10-18","url":"http://api.51daishu.com/mapi/news/detail/id/474.html"},{"id":"469","title":"【找寻妈妈的味道】第七期 立秋时节，来一盆清蒸太湖白鱼","art_time":"2016-10-12","url":"http://api.51daishu.com/mapi/news/detail/id/469.html"},{"id":"467","title":"【找寻妈妈的味道】第六期 蒜泥粉皮，夏日的一道绿色","art_time":"2016-09-22","url":"http://api.51daishu.com/mapi/news/detail/id/467.html"},{"id":"453","title":"【找寻妈妈的味道】第五期 蜜桃炒肉，香香甜甜我最爱","art_time":"2016-08-18","url":"http://api.51daishu.com/mapi/news/detail/id/453.html"},{"id":"452","title":"【找寻妈妈的味道】第四期 洋葱抱大虾，满满都是爱","art_time":"2016-08-18","url":"http://api.51daishu.com/mapi/news/detail/id/452.html"},{"id":"451","title":"【找寻妈妈的味道】第三期 没什么坎是小龙虾解决不了的","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/451.html"},{"id":"450","title":"【找寻妈妈的味道】第二期 奶奶，我也要吃糖醋鲈鱼","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/450.html"},{"id":"449","title":" 【找寻妈妈的味道】第一期  丁姐私房红烧肉","art_time":"2016-07-27","url":"http://api.51daishu.com/mapi/news/detail/id/449.html"}]
         */

        private String total_page;
        private List<ListBean> list;

        public String getTotal_page() {
            return total_page;
        }

        public void setTotal_page(String total_page) {
            this.total_page = total_page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 488
             * title : 一分钟了解袋鼠妈妈金融
             * art_time : 2017-01-11
             * url : http://api.51daishu.com/mapi/news/detail/id/488.html
             */

            private String id;
            private String title;
            private String art_time;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getArt_time() {
                return art_time;
            }

            public void setArt_time(String art_time) {
                this.art_time = art_time;
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
