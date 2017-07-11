package com.dsmmjr.ui.product.presenter;


interface IProductPresenter {
    /**
     * 加载债权和投资列表
     *
     * @param type    1 投资
     * @param p       当前页
     * @param epage   每页记录数
     * @param product 项目状态
     * @param term    项目期限
     * @param style   还款方式
     * @param grade   信用等级
     */
    void loadInvest(int type, int p, int epage, String product, String term, String style, String grade);

    /**
     * 债权转让列表页
     *
     * @param page             当前页
     * @param defualtPageCount 每页记录数
     */
    void getDebtList(int page, int defualtPageCount);
}
