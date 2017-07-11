package com.dsmmjr.entity;

/**
 * Create time : 2017/3/23.
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
public class AutoEntity {

    /**
     * code : 1
     * msg : 没有配置
     * data : {"rules":"<ul><li>1、单笔借出金额最小投资金额为50元，最大投资金额必须大于或等于200元。<\/li><li>2、设置的自动投标金额<=可用金额-账户保留金额，否则不能自动投标。<\/li><li>3、每次自动投标的金额需<=所投标额的100%，若超出，投标金额就是所投标额度的100%。<\/li><li>例如:您设置自动投标金额为3万，如果有借款人借款20万，那么您最高投标金额为20*100/100万。<\/li><\/ul>","autoconfig":{"is_open":0,"total_money":null,"account_money":"","interest_rate":"","duration_from":"6","duration_to":"12","min_invest":"50","invest_money":"200"}}
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
         * rules : <ul><li>1、单笔借出金额最小投资金额为50元，最大投资金额必须大于或等于200元。</li><li>2、设置的自动投标金额<=可用金额-账户保留金额，否则不能自动投标。</li><li>3、每次自动投标的金额需<=所投标额的100%，若超出，投标金额就是所投标额度的100%。</li><li>例如:您设置自动投标金额为3万，如果有借款人借款20万，那么您最高投标金额为20*100/100万。</li></ul>
         * autoconfig : {"is_open":0,"total_money":null,"account_money":"","interest_rate":"","duration_from":"6","duration_to":"12","min_invest":"50","invest_money":"200"}
         */

        private String rules;
        private AutoconfigBean autoconfig;

        public String getRules() {
            return rules;
        }

        public void setRules(String rules) {
            this.rules = rules;
        }

        public AutoconfigBean getAutoconfig() {
            return autoconfig;
        }

        public void setAutoconfig(AutoconfigBean autoconfig) {
            this.autoconfig = autoconfig;
        }

        public static class AutoconfigBean {
            /**
             * is_open : 0
             * total_money : null
             * account_money :
             * interest_rate :
             * duration_from : 6
             * duration_to : 12
             * min_invest : 50
             * invest_money : 200
             */

            private int is_open;
            private String total_money;
            private String account_money;
            private String interest_rate;
            private String duration_from;
            private String duration_to;
            private String min_invest;
            private String invest_money;

            public int getIs_open() {
                return is_open;
            }

            public void setIs_open(int is_open) {
                this.is_open = is_open;
            }

            public String getTotal_money() {
                return total_money;
            }

            public void setTotal_money(String total_money) {
                this.total_money = total_money;
            }

            public String getAccount_money() {
                return account_money;
            }

            public void setAccount_money(String account_money) {
                this.account_money = account_money;
            }

            public String getInterest_rate() {
                return interest_rate;
            }

            public void setInterest_rate(String interest_rate) {
                this.interest_rate = interest_rate;
            }

            public String getDuration_from() {
                return duration_from;
            }

            public void setDuration_from(String duration_from) {
                this.duration_from = duration_from;
            }

            public String getDuration_to() {
                return duration_to;
            }

            public void setDuration_to(String duration_to) {
                this.duration_to = duration_to;
            }

            public String getMin_invest() {
                return min_invest;
            }

            public void setMin_invest(String min_invest) {
                this.min_invest = min_invest;
            }

            public String getInvest_money() {
                return invest_money;
            }

            public void setInvest_money(String invest_money) {
                this.invest_money = invest_money;
            }
        }
    }
}
