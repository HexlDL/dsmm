package com.dsmmjr.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Create time : 2017/3/24.
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
public class MyInvestEntity implements Parcelable {
    /**
     * code : 1
     * msg : Success
     * data : {"total_page":"1","list":[{"borrow_id":"907","borrow_name":"金鼠宝A c-0001","investor_capital":"9000.00","investor_capital_interest":"9900","apr":"10.00","borrow_duration":"12个月","invest_time":"2017-04-11","borrow_type":"抵押"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected MyInvestEntity(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<MyInvestEntity> CREATOR = new Creator<MyInvestEntity>() {
        @Override
        public MyInvestEntity createFromParcel(Parcel in) {
            return new MyInvestEntity(in);
        }

        @Override
        public MyInvestEntity[] newArray(int size) {
            return new MyInvestEntity[size];
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
    }

    public static class DataBean implements Parcelable{
        /**
         * total_page : 1
         * list : [{"borrow_id":"907","borrow_name":"金鼠宝A c-0001","investor_capital":"9000.00","investor_capital_interest":"9900","apr":"10.00","borrow_duration":"12个月","invest_time":"2017-04-11","borrow_type":"抵押"}]
         */

        private String total_page;
        private List<ListBean> list;

        protected DataBean(Parcel in) {
            total_page = in.readString();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(total_page);
        }

        public static class ListBean implements Parcelable{
            /**
             * borrow_id : 907
             * borrow_name : 金鼠宝A c-0001
             * investor_capital : 9000.00
             * investor_capital_interest : 9900
             * apr : 10.00
             * borrow_duration : 12个月
             * invest_time : 2017-04-11
             * borrow_type : 抵押
             */
            private String id;
            private String borrow_id;
            private String borrow_name;
            private String investor_capital;
            private String investor_capital_interest;
            private String apr;
            private String borrow_duration;
            private String invest_time;
            private String borrow_type;
            private String repayment_money;
            private String total;
            private String back;
            private String repayment_time;
            private String capital;
            private String interest;
            private String breakday;
            private String total_period;
            private String cur_period;
            private String receive_capital;
            private String receive_interest;

            protected ListBean(Parcel in) {
                id = in.readString();
                borrow_id = in.readString();
                borrow_name = in.readString();
                investor_capital = in.readString();
                investor_capital_interest = in.readString();
                apr = in.readString();
                borrow_duration = in.readString();
                invest_time = in.readString();
                borrow_type = in.readString();
                repayment_money = in.readString();
                total = in.readString();
                back = in.readString();
                repayment_time = in.readString();
                capital = in.readString();
                interest = in.readString();
                breakday = in.readString();
                total_period = in.readString();
                cur_period = in.readString();
                receive_capital = in.readString();
                receive_interest = in.readString();
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel in) {
                    return new ListBean(in);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBreakday() {
                return breakday;
            }

            public void setBreakday(String breakday) {
                this.breakday = breakday;
            }

            public String getCapital() {
                return capital;
            }

            public void setCapital(String capital) {
                this.capital = capital;
            }

            public String getCur_period() {
                return cur_period;
            }

            public void setCur_period(String cur_period) {
                this.cur_period = cur_period;
            }

            public String getInterest() {
                return interest;
            }

            public void setInterest(String interest) {
                this.interest = interest;
            }

            public String getReceive_capital() {
                return receive_capital;
            }

            public void setReceive_capital(String receive_capital) {
                this.receive_capital = receive_capital;
            }

            public String getReceive_interest() {
                return receive_interest;
            }

            public void setReceive_interest(String receive_interest) {
                this.receive_interest = receive_interest;
            }

            public String getTotal_period() {
                return total_period;
            }

            public void setTotal_period(String total_period) {
                this.total_period = total_period;
            }

            public String getBack() {
                return back;
            }

            public void setBack(String back) {
                this.back = back;
            }

            public String getRepayment_money() {
                return repayment_money;
            }

            public void setRepayment_money(String repayment_money) {
                this.repayment_money = repayment_money;
            }

            public String getRepayment_time() {
                return repayment_time;
            }

            public void setRepayment_time(String repayment_time) {
                this.repayment_time = repayment_time;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getBorrow_id() {
                return borrow_id;
            }

            public void setBorrow_id(String borrow_id) {
                this.borrow_id = borrow_id;
            }

            public String getBorrow_name() {
                return borrow_name;
            }

            public void setBorrow_name(String borrow_name) {
                this.borrow_name = borrow_name;
            }

            public String getInvestor_capital() {
                return investor_capital;
            }

            public void setInvestor_capital(String investor_capital) {
                this.investor_capital = investor_capital;
            }

            public String getInvestor_capital_interest() {
                return investor_capital_interest;
            }

            public void setInvestor_capital_interest(String investor_capital_interest) {
                this.investor_capital_interest = investor_capital_interest;
            }

            public String getApr() {
                return apr;
            }

            public void setApr(String apr) {
                this.apr = apr;
            }

            public String getBorrow_duration() {
                return borrow_duration;
            }

            public void setBorrow_duration(String borrow_duration) {
                this.borrow_duration = borrow_duration;
            }

            public String getInvest_time() {
                return invest_time;
            }

            public void setInvest_time(String invest_time) {
                this.invest_time = invest_time;
            }

            public String getBorrow_type() {
                return borrow_type;
            }

            public void setBorrow_type(String borrow_type) {
                this.borrow_type = borrow_type;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(borrow_id);
                dest.writeString(borrow_name);
                dest.writeString(investor_capital);
                dest.writeString(investor_capital_interest);
                dest.writeString(apr);
                dest.writeString(borrow_duration);
                dest.writeString(invest_time);
                dest.writeString(borrow_type);
                dest.writeString(repayment_money);
                dest.writeString(total);
                dest.writeString(back);
                dest.writeString(repayment_time);
                dest.writeString(capital);
                dest.writeString(interest);
                dest.writeString(breakday);
                dest.writeString(total_period);
                dest.writeString(cur_period);
                dest.writeString(receive_capital);
                dest.writeString(receive_interest);
            }
        }
    }
}
