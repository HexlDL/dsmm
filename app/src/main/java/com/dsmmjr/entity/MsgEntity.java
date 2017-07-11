package com.dsmmjr.entity;

import android.os.Parcel;

import com.dsmmjr.base.BaseEntity;

import java.util.List;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 站内消息
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
public class MsgEntity extends BaseEntity {

    /**
     * code : 1
     * msg : 获取成功
     * data : {"list":[{"id":"27241","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27240","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27239","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27238","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27237","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27236","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27235","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27234","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27233","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27232","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27231","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27230","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27229","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27228","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27227","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27226","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27225","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27224","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27223","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27222","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27221","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27220","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27219","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27218","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27217","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27216","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27145","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27144","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27143","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27142","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"}],"page":{"total":"244","nowPage":1}}
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
         * list : [{"id":"27241","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27240","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27239","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27238","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27237","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27236","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27235","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27234","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27233","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27232","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27231","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27230","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27229","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27228","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27227","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27226","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27225","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27224","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27223","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27222","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27221","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27220","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27219","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27218","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27217","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27216","title":"您借出的第814号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27145","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27144","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27143","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"},{"id":"27142","title":"您借出的第806号借款收到了新的还款","status":"0","send_time":"2017-03-06"}]
         * page : {"total":"244","nowPage":1}
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
             * total : 244
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
             * id : 27241
             * title : 您借出的第814号借款收到了新的还款
             * status : 0
             * send_time : 2017-03-06
             */

            private String id;
            private String title;
            private String status;
            private String send_time;

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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSend_time() {
                return send_time;
            }

            public void setSend_time(String send_time) {
                this.send_time = send_time;
            }
        }
    }
}
