package com.dsmmjr;


public class ExtraConfig {

    /**
     * 每页显示记录数
     */
    public static final int DEFUALT_PAGE_COUNT = 20;

    /**
     * 失效时间
     */
    public static final int COUNT_TIME = 120;

    public static int forgetGesturePwd = 0;

    public static class BaseReceiverAction {
        /**
         * token过期
         */
        public static final String ACTION_TOKEN_EXPIRE = "token";
    }

    public static class IntentExtraKey {
        public static final String PHONE = "phone";
        public static final String VERIFY_CODE = "verify_code";
        public static final String MAIN_ACTIVITY = "main_activity";
        public static final String INVEST_ACTIVITY = "invest_activity";
        public static final String REG_COMPLETE_REALNAME = "reg_complete_realname";
        public static final String BORROW_BEAN = "borrow_bean";
        public static final String WEB_VIEW_FROM = "webview";
        public static final String HELP_URL = "help_url";
        public static final String OPEN_ACCOUNT_URL = "open_account_url";
        public static final String FEED_BACK = "feed_back";
        public static final String MSG_ID = "msg_id";
        public static final String BID_ID = "bid_id";
        public static final String BORROW_ID = "borrow_id";
        public static final String INVEST_ID = "invest_id";
        public static final String DEBT_ID = "debt_id";
        public static final String BORROW_STATUS = "borrow_status";
        public static final String BID_NAME = "bid_name";
        public static final String BORROW_NAME = "borrow_name";
        public static final String GOODS_DETAIL_ID = "goods_detail_id";
        public static final String RECHARGE_URL = "recharge_url";
        public static final String HOME_BANNER_URL = "home_banner_url";
        public static final String HOME_TITLE = "home_title";
        public static final String USERBEAN = "userbean";
        public static final String NEWS_URL = "news_url";
        public static final String NOVICE_URL = "novice_url";
        public static final String LOAN_URL = "loan_url";
        public static final String AWARD_URL = "award_url";
        public static final String HOME_TREE_URL = "home_tree_url";
        public static final String MOBILE = "mobile";
        public static final String TEST = "test";
        public static final String PRODUCT = "product";
        public static final String GRADE = "grade";
        public static final String TERM = "term";
        public static final String STYLE = "style";
        public static final String CARD_RULE = "card_rule";
        public static final String GESTURE_FLAG = "GESTURE_FLAG";
//        public static final String INVESTREALNAME = "investrealname";
    }

    public static class RequestCode {
        public static final int ADDRESS = 0x0001;
        public static final int MSG = 0x0002;
        public static final int TRANSFER_REQ = 0x0003;
        public static final int SELECTOR_REQ = 0x0004;
    }
}