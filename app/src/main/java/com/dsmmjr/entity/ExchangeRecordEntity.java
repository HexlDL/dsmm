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
public class ExchangeRecordEntity {

    /**
     * code : 1
     * msg : Success
     * data : {"list":[{"id":"307","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-09 10:50:01"},{"id":"306","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-09 10:49:58"},{"id":"304","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-07 14:56:55"},{"id":"303","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-07 14:56:53"},{"id":"302","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-07 14:56:50"},{"id":"301","name":"瑞米轩五常大米","cost":"15000","add_time":"2016-12-07 14:56:46"},{"id":"300","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-12-07 13:51:45"},{"id":"294","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-26 03:26:49"},{"id":"293","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-26 03:26:44"},{"id":"292","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-26 03:25:35"},{"id":"291","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-24 17:03:57"},{"id":"290","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-24 17:03:48"},{"id":"289","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-21 20:39:10"},{"id":"288","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-21 20:38:11"},{"id":"287","name":"森鸿源糯米","cost":"1725","add_time":"2016-11-21 20:36:36"},{"id":"286","name":"森鸿源糯米","cost":"1725","add_time":"2016-11-21 20:36:30"},{"id":"285","name":"森鸿源小米","cost":"1725","add_time":"2016-11-21 20:34:46"},{"id":"284","name":"森鸿源小米","cost":"1725","add_time":"2016-11-21 20:34:28"},{"id":"283","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-18 16:51:48"},{"id":"282","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-18 16:51:45"},{"id":"281","name":"瑞米轩五常大米","cost":"12600","add_time":"2016-11-18 16:51:10"},{"id":"280","name":"森鸿源薏米","cost":"1495","add_time":"2016-11-18 14:23:52"},{"id":"279","name":"森鸿源玉米粉","cost":"1035","add_time":"2016-11-18 14:23:46"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 307
             * name : 瑞米轩五常大米
             * cost : 15000
             * add_time : 2016-12-09 10:50:01
             */

            private String id;
            private String name;
            private String cost;
            private String add_time;

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

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
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
