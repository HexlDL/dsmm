package com.dsmmjr.entity;

import java.util.List;

/**
 * Create time : 2017/4/6.
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
public class MyPointEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"integralAll":"Array","list":[{"title":"完善个人信息，奖励积分","value":"10","url":""},{"title":"手机认证通过，奖励积分","value":"300","url":""},{"title":"上传住房公积金，奖励积分","value":"100","url":""},{"title":"投资奖励积分","value":"80","url":""},{"title":"近三个月银行代发工资记录或个人转账存款记录","value":"50","url":""},{"title":"上传学位证书或者毕业证书","value":"50","url":""}]}
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
         * integralAll : Array
         * list : [{"title":"完善个人信息，奖励积分","value":"10","url":""},{"title":"手机认证通过，奖励积分","value":"300","url":""},{"title":"上传住房公积金，奖励积分","value":"100","url":""},{"title":"投资奖励积分","value":"80","url":""},{"title":"近三个月银行代发工资记录或个人转账存款记录","value":"50","url":""},{"title":"上传学位证书或者毕业证书","value":"50","url":""}]
         */

        private String integralAll;
        private List<ListBean> loglist;

        public String getIntegralAll() {
            return integralAll;
        }

        public void setIntegralAll(String integralAll) {
            this.integralAll = integralAll;
        }

        public List<ListBean> getList() {
            return loglist;
        }

        public void setList(List<ListBean> list) {
            this.loglist = list;
        }

        public static class ListBean {
            /**
             * title : 完善个人信息，奖励积分
             * value : 10
             * url :
             */

            private String info;
            private String affect_integral;
            private String add_time;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getAffect_integral() {
                return affect_integral;
            }

            public void setAffect_integral(String affect_integral) {
                this.affect_integral = affect_integral;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }
        }
    }
}
