package com.dsmmjr.entity;

/**
 * Create time : 2017/6/13.
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
public class TransferEntity {
    /**
     * code : 1
     * msg : 债权转让信息获取成功
     * data : {"debt":{"borrow_name":"金鼠宝A c-0002","transfer_price":5500.04,"debt_fee":27.5002,"datag":"0.5","price":5500.04,"has_pin":"1"}}
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
         * debt : {"borrow_name":"金鼠宝A c-0002","transfer_price":5500.04,"debt_fee":27.5002,"datag":"0.5","price":5500.04,"has_pin":"1"}
         */

        private DebtBean debt;

        public DebtBean getDebt() {
            return debt;
        }

        public void setDebt(DebtBean debt) {
            this.debt = debt;
        }

        public static class DebtBean {
            /**
             * borrow_name : 金鼠宝A c-0002
             * transfer_price : 5500.04
             * debt_fee : 27.5002
             * datag : 0.5
             * price : 5500.04
             * has_pin : 1
             */

            private String borrow_name;
            private String transfer_price;
            private String debt_fee;
            private String datag;
            private String price;
            private String has_pin;

            public String getBorrow_name() {
                return borrow_name;
            }

            public void setBorrow_name(String borrow_name) {
                this.borrow_name = borrow_name;
            }

            public String getDatag() {
                return datag;
            }

            public void setDatag(String datag) {
                this.datag = datag;
            }

            public String getDebt_fee() {
                return debt_fee;
            }

            public void setDebt_fee(String debt_fee) {
                this.debt_fee = debt_fee;
            }

            public String getHas_pin() {
                return has_pin;
            }

            public void setHas_pin(String has_pin) {
                this.has_pin = has_pin;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTransfer_price() {
                return transfer_price;
            }

            public void setTransfer_price(String transfer_price) {
                this.transfer_price = transfer_price;
            }
        }
    }
}
