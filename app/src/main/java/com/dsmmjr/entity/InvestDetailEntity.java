package com.dsmmjr.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Create time : 2017/3/28.
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
public class InvestDetailEntity implements Parcelable {

    /**
     * code : 1
     * msg : Success
     * data : {"borrow":{"id":"907","borrow_name":"金鼠宝A c-0001","borrow_duration":"12","borrow_money":"100000.00","borrow_interest_rate":"10.00","repayment_type":"每月还息到期还本","borrow_use":"生意周转","borrow_need":"91000","add_time":"2017-04-11","progress":"9.00","borrow_info":"借款人因生意周转，暂缺资金，以小型轿车13年奇瑞牌，国产，车身颜色黑，抵押借款20000元整，时间12个月。详细资料请点击\u201c审核资料\u201d查阅。","borrow_status":"2","verify_imglist":[{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/201703010954285.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095430310.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095433211.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095436594.jpg","info":"","attachtype":"others"}],"verify":[{"name":"身份证"},{"name":"车辆评估报告"},{"name":"机动车登记证"},{"name":"行驶证"},{"name":"借款合同"},{"name":"平台服务合同"}],"borrow_ico":""}}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected InvestDetailEntity(Parcel in) {
        code = in.readInt();
        msg = in.readString();
        data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Creator<InvestDetailEntity> CREATOR = new Creator<InvestDetailEntity>() {
        @Override
        public InvestDetailEntity createFromParcel(Parcel in) {
            return new InvestDetailEntity(in);
        }

        @Override
        public InvestDetailEntity[] newArray(int size) {
            return new InvestDetailEntity[size];
        }
    };

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
        dest.writeInt(code);
        dest.writeString(msg);
        dest.writeParcelable(data, flags);
    }

    public static class DataBean implements Parcelable{

        private BorrowBean borrow;

        protected DataBean(Parcel in) {
            borrow = in.readParcelable(BorrowBean.class.getClassLoader());
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(borrow, flags);
        }

        public static class BorrowBean implements Parcelable{
            /**
             * id : 907
             * borrow_name : 金鼠宝A c-0001
             * borrow_duration : 12
             * borrow_money : 100000.00
             * borrow_interest_rate : 10.00
             * repayment_type : 每月还息到期还本
             * borrow_use : 生意周转
             * borrow_need : 91000
             * add_time : 2017-04-11
             * progress : 9.00
             * borrow_info : 借款人因生意周转，暂缺资金，以小型轿车13年奇瑞牌，国产，车身颜色黑，抵押借款20000元整，时间12个月。详细资料请点击“审核资料”查阅。
             * borrow_status : 2
             * verify_imglist : [{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/201703010954285.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095430310.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095433211.jpg","info":"","attachtype":"others"},{"img":"https://www.51daishu.com/UF/Uploads/zhaiquan/20170301095436594.jpg","info":"","attachtype":"others"}]
             * verify : [{"name":"身份证"},{"name":"车辆评估报告"},{"name":"机动车登记证"},{"name":"行驶证"},{"name":"借款合同"},{"name":"平台服务合同"}]
             * invest_count
             * borrow_ico :
             */

            private String id;
            private String borrow_name;
            private String borrow_duration;
            private String borrow_money;
            private String borrow_interest_rate;
            private String repayment_type;
            private String borrow_use;
            private String borrow_need;
            private String add_time;
            private String progress;
            private String borrow_info;
            private String borrow_status;
            private String invest_count;
            private String borrow_ico;
            private String invest_award_rate;
            private List<VerifyImglistBean> verify_imglist;
            private List<VerifyBean> verify;

            protected BorrowBean(Parcel in) {
                id = in.readString();
                borrow_name = in.readString();
                borrow_duration = in.readString();
                borrow_money = in.readString();
                borrow_interest_rate = in.readString();
                repayment_type = in.readString();
                borrow_use = in.readString();
                borrow_need = in.readString();
                add_time = in.readString();
                progress = in.readString();
                borrow_info = in.readString();
                invest_count = in.readString();
                borrow_status = in.readString();
                borrow_ico = in.readString();
            }

            public static final Creator<BorrowBean> CREATOR = new Creator<BorrowBean>() {
                @Override
                public BorrowBean createFromParcel(Parcel in) {
                    return new BorrowBean(in);
                }

                @Override
                public BorrowBean[] newArray(int size) {
                    return new BorrowBean[size];
                }
            };

            public String getInvest_award_rate() {
                return invest_award_rate;
            }

            public void setInvest_award_rate(String invest_award_rate) {
                this.invest_award_rate = invest_award_rate;
            }

            public String getInvest_count() {
                return invest_count;
            }

            public void setInvest_count(String invest_count) {
                this.invest_count = invest_count;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBorrow_name() {
                return borrow_name;
            }

            public void setBorrow_name(String borrow_name) {
                this.borrow_name = borrow_name;
            }

            public String getBorrow_duration() {
                return borrow_duration;
            }

            public void setBorrow_duration(String borrow_duration) {
                this.borrow_duration = borrow_duration;
            }

            public String getBorrow_money() {
                return borrow_money;
            }

            public void setBorrow_money(String borrow_money) {
                this.borrow_money = borrow_money;
            }

            public String getBorrow_interest_rate() {
                return borrow_interest_rate;
            }

            public void setBorrow_interest_rate(String borrow_interest_rate) {
                this.borrow_interest_rate = borrow_interest_rate;
            }

            public String getRepayment_type() {
                return repayment_type;
            }

            public void setRepayment_type(String repayment_type) {
                this.repayment_type = repayment_type;
            }

            public String getBorrow_use() {
                return borrow_use;
            }

            public void setBorrow_use(String borrow_use) {
                this.borrow_use = borrow_use;
            }

            public String getBorrow_need() {
                return borrow_need;
            }

            public void setBorrow_need(String borrow_need) {
                this.borrow_need = borrow_need;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getProgress() {
                return progress;
            }

            public void setProgress(String progress) {
                this.progress = progress;
            }

            public String getBorrow_info() {
                return borrow_info;
            }

            public void setBorrow_info(String borrow_info) {
                this.borrow_info = borrow_info;
            }

            public String getBorrow_status() {
                return borrow_status;
            }

            public void setBorrow_status(String borrow_status) {
                this.borrow_status = borrow_status;
            }

            public String getBorrow_ico() {
                return borrow_ico;
            }

            public void setBorrow_ico(String borrow_ico) {
                this.borrow_ico = borrow_ico;
            }

            public List<VerifyImglistBean> getVerify_imglist() {
                return verify_imglist;
            }

            public void setVerify_imglist(List<VerifyImglistBean> verify_imglist) {
                this.verify_imglist = verify_imglist;
            }

            public List<VerifyBean> getVerify() {
                return verify;
            }

            public void setVerify(List<VerifyBean> verify) {
                this.verify = verify;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(borrow_name);
                dest.writeString(borrow_duration);
                dest.writeString(borrow_money);
                dest.writeString(borrow_interest_rate);
                dest.writeString(repayment_type);
                dest.writeString(borrow_use);
                dest.writeString(borrow_need);
                dest.writeString(add_time);
                dest.writeString(progress);
                dest.writeString(borrow_info);
                dest.writeString(borrow_status);
                dest.writeString(invest_count);
                dest.writeString(borrow_ico);
            }

            public static class VerifyImglistBean implements Parcelable{
                /**
                 * img : https://www.51daishu.com/UF/Uploads/zhaiquan/201703010954285.jpg
                 * info :
                 * attachtype : others
                 */

                private String img;
                private String info;
                private String attachtype;

                protected VerifyImglistBean(Parcel in) {
                    img = in.readString();
                    info = in.readString();
                    attachtype = in.readString();
                }

                public static final Creator<VerifyImglistBean> CREATOR = new Creator<VerifyImglistBean>() {
                    @Override
                    public VerifyImglistBean createFromParcel(Parcel in) {
                        return new VerifyImglistBean(in);
                    }

                    @Override
                    public VerifyImglistBean[] newArray(int size) {
                        return new VerifyImglistBean[size];
                    }
                };

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getAttachtype() {
                    return attachtype;
                }

                public void setAttachtype(String attachtype) {
                    this.attachtype = attachtype;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(img);
                    dest.writeString(info);
                    dest.writeString(attachtype);
                }
            }

            public static class VerifyBean implements Parcelable{
                /**
                 * name : 身份证
                 */

                private String name;

                protected VerifyBean(Parcel in) {
                    name = in.readString();
                }

                public static final Creator<VerifyBean> CREATOR = new Creator<VerifyBean>() {
                    @Override
                    public VerifyBean createFromParcel(Parcel in) {
                        return new VerifyBean(in);
                    }

                    @Override
                    public VerifyBean[] newArray(int size) {
                        return new VerifyBean[size];
                    }
                };

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(name);
                }
            }
        }
    }
}
