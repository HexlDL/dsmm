package com.dsmmjr.entity;

/**
 * Create time : 2017/3/29.
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
public class FriendEntity{

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
         * invite_code : 5370925649364
         * count :
         * invite_des : 邀请好友一起签到赚现金，每天签到赚1元，直接到会员账户（可用于投资，提现等）；<br>请不要发送邀请信给不熟悉的人士,避免给别人带来不必要的困扰；<br>邀请好友成功投标（不包含秒还标、净值标、天标交易），立即送您千分之 0 的奖金。
         */

        private long invite_code;
        private String count;
        private String invite_des;

        public long getInvite_code() {
            return invite_code;
        }

        public void setInvite_code(long invite_code) {
            this.invite_code = invite_code;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getInvite_des() {
            return invite_des;
        }

        public void setInvite_des(String invite_des) {
            this.invite_des = invite_des;
        }
    }
}
