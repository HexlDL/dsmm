package com.dsmmjr.entity;

import android.os.Parcel;
import android.os.Parcelable;

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
public class GoodsDetailEntity implements Parcelable {
    /**
     * code : 1
     * msg : OK
     * data : {"userinfo":{"uid":"9","user_integral":"8275","username":"丁秋珊","mobile":"133*****2222","address":"辽宁省大连市高新园区三星大厦1701室"},"detail":{"id":"174","name":"德国双立人中式炒锅套装","thumb":"https://www.51daishu.com/Style/ajax-image-uploader/images/middle-r4p71-1494985622.jpg","price":"3000元","cost":"183000","number":"9999","convert":"0","surplus":"剩余9999份","content":""}}
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static class DataBean implements Parcelable{
        /**
         * userinfo : {"uid":"9","user_integral":"8275","username":"丁秋珊","mobile":"133*****2222","address":"辽宁省大连市高新园区三星大厦1701室"}
         * detail : {"id":"174","name":"德国双立人中式炒锅套装","thumb":"https://www.51daishu.com/Style/ajax-image-uploader/images/middle-r4p71-1494985622.jpg","price":"3000元","cost":"183000","number":"9999","convert":"0","surplus":"剩余9999份","content":""}
         */

        private UserinfoBean userinfo;
        private DetailBean detail;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public static class UserinfoBean implements Parcelable{
            /**
             * uid : 9
             * user_integral : 8275
             * username : 丁秋珊
             * mobile : 133*****2222
             * address : 辽宁省大连市高新园区三星大厦1701室
             */

            private String uid;
            private String user_integral;
            private String username;
            private String mobile;
            private String area;
            private String address;

            protected UserinfoBean(Parcel in) {
                uid = in.readString();
                user_integral = in.readString();
                username = in.readString();
                mobile = in.readString();
                area = in.readString();
                address = in.readString();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(uid);
                dest.writeString(user_integral);
                dest.writeString(username);
                dest.writeString(mobile);
                dest.writeString(area);
                dest.writeString(address);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<UserinfoBean> CREATOR = new Creator<UserinfoBean>() {
                @Override
                public UserinfoBean createFromParcel(Parcel in) {
                    return new UserinfoBean(in);
                }

                @Override
                public UserinfoBean[] newArray(int size) {
                    return new UserinfoBean[size];
                }
            };

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUser_integral() {
                return user_integral;
            }

            public void setUser_integral(String user_integral) {
                this.user_integral = user_integral;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }

        public static class DetailBean {
            /**
             * id : 174
             * name : 德国双立人中式炒锅套装
             * thumb : https://www.51daishu.com/Style/ajax-image-uploader/images/middle-r4p71-1494985622.jpg
             * price : 3000元
             * cost : 183000
             * number : 9999
             * convert : 0
             * surplus : 剩余9999份
             * content :
             */

            private String id;
            private String name;
            private String thumb;
            private String price;
            private String cost;
            private String number;
            private String convert;
            private String surplus;
            private String content;

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

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getConvert() {
                return convert;
            }

            public void setConvert(String convert) {
                this.convert = convert;
            }

            public String getSurplus() {
                return surplus;
            }

            public void setSurplus(String surplus) {
                this.surplus = surplus;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
