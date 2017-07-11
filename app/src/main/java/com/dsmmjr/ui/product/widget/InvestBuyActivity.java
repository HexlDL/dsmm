package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.MyPopupAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.Alert;
import com.dsmmjr.customer.CustomerPopup;
import com.dsmmjr.entity.AllTotalEntity;
import com.dsmmjr.entity.CardVolumeEntity;
import com.dsmmjr.entity.InvestDetailEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.widget.activitys.ForgetPwdActivity;
import com.dsmmjr.ui.account.widget.activitys.PaymentPwdUpdateActivity;
import com.dsmmjr.ui.account.widget.activitys.RealnameAuthenticationActivity;
import com.dsmmjr.ui.account.widget.activitys.RechargeActivity;
import com.dsmmjr.ui.product.presenter.InvestBuyPresenterImpl;
import com.dsmmjr.ui.product.view.IInvestBuy;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;

import java.text.DecimalFormat;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.Gravity.CENTER;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_BEAN;
import static com.dsmmjr.ui.product.ProductListFragment.sFlag;

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
public class InvestBuyActivity extends BaseActivity implements IInvestBuy, TextWatcher {
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.tv_account_money)
    TextView mTvAccountMoney;
    @BindView(R.id.tv_invest)
    TextView mTvInvest;
    @BindView(R.id.et_min_amount)
    EditText mEtMinAmount;
    @BindView(R.id.tv_expected)
    TextView mTvExpected;
    @BindView(R.id.tv_card_volume)
    TextView mTvCardVolume;
    @BindView(R.id.tv_card)
    TextView mTvCard;
    @BindView(R.id.tv_use)
    TextView mTvUse;
    @BindView(R.id.ll_use_red)
    LinearLayout mllUseRed;
    @BindView(R.id.et_is_pwd)
    EditText mEtIsPwd;
    @BindView(R.id.et_pay_pwd)
    EditText mEtPayPwd;
    @BindView(R.id.tv_card_value)
    TextView mTvCardValue;
    @BindView(R.id.btn_invest)
    Button mBtnInvest;

    private InvestBuyPresenterImpl mPresenter;

    private CardVolumeEntity entity;
    private InvestDetailEntity.DataBean.BorrowBean mBorrowBean;
    private CustomerPopup<CardVolumeEntity.DataBean.CouponsBean> mCustomerPopup;

    private MyPopupAdapter mMyPopupAdapter;

    private HashMap<Integer, Boolean> isSelected;
    private String mCardId;
    private double mBorrow_interest_rate;
    private double mBorrow_duration;
    private boolean isRun;

    public InvestBuyActivity() {
        mCustomerPopup = new CustomerPopup<>(this);
        mPresenter = new InvestBuyPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_invest_buy);
    }

    @Override
    protected void initData() {
        mBorrowBean = getIntent().getParcelableExtra(BORROW_BEAN);

        setHeaterTitle(mBorrowBean.getBorrow_name(), getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), VISIBLE);

        //标的id
        mBorrow_interest_rate = Double.parseDouble(mBorrowBean.getBorrow_interest_rate().replace("%", "")) / 100;
        mBorrow_duration = Integer.parseInt(mBorrowBean.getBorrow_duration().replace("个月", ""));

        mPresenter.loadCardVolume(PreferenceCache.getToken(), mBorrowBean.getId());

        mEtMinAmount.addTextChangedListener(this);

        //防止EditText栈溢出
//        mEtMinAmount.setInputType(InputType.TYPE_CLASS_TEXT
//                | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
//                | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadCardVolume(PreferenceCache.getToken(), mBorrowBean.getId());
    }

    /*
     * 用户未设置过支付密码,设置成功后回调此方法刷新页面
     * @param requestCode
     * @param resultCode
     * @param data
     */
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PAY_PASSWORD && requestCode == RESULT_OK) {
            mPresenter.loadCardVolume(PreferenceCache.getToken(), mBorrowBean.getId());
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    */

    @OnClick({R.id.ll_use_red, R.id.btn_invest, R.id.tv_target_pwd,
            R.id.btn_all_invest, R.id.btn_recharge, R.id.iv_left_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_use_red://红包卡券
                if (!TextUtils.isEmpty(mEtMinAmount.getText())) {
                    showPopup(entity, mEtMinAmount.getText().toString());
                } else {
                    AlertUtil.t(this, "请输入投资金额");
                }
                break;
            case R.id.tv_target_pwd://忘记支付密码
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
            case R.id.btn_all_invest://全投
                mPresenter.getInvestTotal(PreferenceCache.getToken(), mBorrowBean.getId());
                break;
            case R.id.btn_recharge://充值
                startActivity(new Intent(this, RechargeActivity.class));
                break;
            case R.id.btn_invest://确认投资
                invest();
                break;
            case R.id.iv_left_back://返回详情页面
                Intent it = new Intent(this, InvestDetailActivity.class);
                it.putExtra(BID_ID, mBorrowBean.getId());
                it.putExtra(BID_NAME, mBorrowBean.getBorrow_name());
                startActivity(it);
                finish();
                break;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            mTvExpected.setVisibility(VISIBLE);
            mTvExpected.setText("预期总收益约"
                    + new DecimalFormat("0.00")
                    .format(Double.parseDouble(s.toString())
                            + Double.parseDouble(s.toString())
                            * (mBorrow_interest_rate / 12)
                            * mBorrow_duration)
                    + "元");
        } else {
            mTvExpected.setVisibility(GONE);
            if (isRun) {//必须添加此判断 ,不然会引发堆栈溢出
                isRun = false;
                return;
            }
            isRun = true;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void resultSuccessData(CardVolumeEntity entity) {
        this.entity = entity;
        mllUseRed.setVisibility(VISIBLE);
        mBtnInvest.setVisibility(VISIBLE);

        mTvAccountMoney.setText(entity.getData().getUserinfo().getAccount_money());

        /**
         * 0 未实名
         * 1 已实名
         */
        if (entity.getData().getUserinfo().getId_status().equals("0")) {
            alertUnRealname();
        } else {
            /**
             * 0 未设置支付密码
             * 1 设置支付密码
             */
            if (entity.getData().getUserinfo().getPin_pass().equals("0"))
                alertUnPayPwd();
        }

        String coupon_count = entity.getData().getCoupon_count();
        if (coupon_count.equals("0")) {//无卡券
            mllUseRed.setVisibility(GONE);
//            mllUseRed.setEnabled(false);
        } else {
            mllUseRed.setVisibility(VISIBLE);
        }
        mTvCard.setText("您有" + coupon_count + "张卡券");

        if (entity.getData().getBorrow().getIs_password().equals("0")) //是否是定向标 1是  0不是
            mEtIsPwd.setVisibility(GONE);
        else
            mEtIsPwd.setVisibility(VISIBLE);
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {//投资成功返回列表
            sFlag = true;
            finish();
        }
    }

    @Override
    public void resultSuccessData(AllTotalEntity entity) {
        mEtMinAmount.setText(entity.getData().getBorrow().getInvest_money());

        Util.setEditTextCurIndex(mEtMinAmount, mEtMinAmount.getText().length());

        String coupon_count = this.entity.getData().getCoupon_count();
        if (coupon_count.equals("0")) {//无卡券
            mllUseRed.setVisibility(GONE);
            mllUseRed.setEnabled(false);
        }
        mTvCardValue.setText("");
        mTvCardValue.setVisibility(GONE);
        mTvCard.setVisibility(VISIBLE);
        mTvCard.setText("您有" + coupon_count + "张卡券");
    }

    @Override
    public void showProgress() {
        if (ll_wv != null) ll_wv.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (ll_wv != null) ll_wv.setVisibility(GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (ll_wv != null) ll_wv.setVisibility(GONE);
    }

    /**
     * 显示红包卡券
     *
     * @param entity       卡券
     * @param invest_money 投资金额
     */
    private void showPopup(CardVolumeEntity entity, String invest_money) {
        View view = LayoutInflater.from(this).inflate(R.layout.popup_select_card_volume, null);

        ListView lv = (ListView) view.findViewById(R.id.lv_popup_redpackets_select);
        ImageView iv_close = (ImageView) view.findViewById(R.id.iv_close);
        Button btn_confirm = (Button) view.findViewById(R.id.btn_confirm);

        if (isSelected != null)
            isSelected = null;
        isSelected = new HashMap<>();

        for (int i = 0; i < entity.getData().getCoupons().size(); i++) {//初始化为false全部不选中
            isSelected.put(i, false);
        }

        mMyPopupAdapter = new MyPopupAdapter(entity.getData().getCoupons(), isSelected, this);
        mMyPopupAdapter.setInvestMoney(invest_money);
        lv.setAdapter(mMyPopupAdapter);
        mCustomerPopup.showPopupWindow(view, MATCH_PARENT, MATCH_PARENT, CENTER);


        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomerPopup.dismiss();
            }
        });

        //使用红包
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFlag = false;
                /**
                 * 遍历所有的value,赋值给 isFlag
                 * 判断如果其中如果有一个value为true就代表被选中就break,
                 * 否则就继续执行for循环,
                 */
                for (Integer key : isSelected.keySet()) {
                    isFlag = isSelected.get(key);
                    if (isFlag) break;
                }
                if (isFlag) {//被选中执行
                    mCardId = mMyPopupAdapter.getCardId();
                    mTvCard.setVisibility(GONE);
                    mTvCardValue.setVisibility(VISIBLE);
                    mTvCardValue.setText(mMyPopupAdapter.getCardMoney());
                    mTvCardValue.setTextColor(Color.rgb(255, 132, 0));
                    mTvUse.setText("\"使用其他卡券\"");
                    mCustomerPopup.dismiss();
                } else {//未选中执行
                    AlertUtil.t(InvestBuyActivity.this, "请选择卡券");
                }
            }
        });
    }

    /**
     * 立即投资
     */
    private void invest() {
        String invest_money = mEtMinAmount.getText().toString();
        String paypass = mEtPayPwd.getText().toString();
        String invest_pass = mEtIsPwd.getText().toString();

        if (check(invest_money, paypass, invest_pass)) {
            mPresenter.doInvest(PreferenceCache.getToken(),
                    mBorrowBean.getId(), invest_money,
                    paypass, invest_pass, mCardId);
        }
    }

    /**
     * 检查是否输入值
     *
     * @param invest_money 投资金额
     * @param paypass      支付密码
     * @param invest_pass  定向密码
     */
    private boolean check(String invest_money, String paypass, String invest_pass) {
        if (TextUtils.isEmpty(invest_money)) {
            AlertUtil.t(this, "请输入投资金额");
            return false;
        }
        if (Double.parseDouble(invest_money) < 50) {
            AlertUtil.t(this, "最小投资金额50元");
            return false;
        }
        if (mEtIsPwd.getVisibility() == 0) {//该值为0的时候定向密码显示,需要判断空值
            if (TextUtils.isEmpty(invest_pass)) {
                AlertUtil.t(this, "请输入定向密码");
                return false;
            }
        }
        if (TextUtils.isEmpty(paypass)) {
            AlertUtil.t(this, "请输入支付密码");
            return false;
        }
        return true;
    }

    private void alertUnPayPwd() {
        new Alert(this) {
            @Override
            public void confirm() {
                Intent intent = new Intent(InvestBuyActivity.this, PaymentPwdUpdateActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected void dismiss() {
            }

        }.alert("提示", "请您先进行设置支付密码", 1);
    }

    private void alertUnRealname() {
        new Alert(this) {
            @Override
            public void confirm() {
                Intent intent = new Intent(InvestBuyActivity.this, RealnameAuthenticationActivity.class);
//                intent.putExtra(INVESTREALNAME, 1);
                startActivity(intent);
                finish();
            }

            @Override
            protected void dismiss() {
            }

        }.alert("提示", "您还未实名认证，请先实名认证", 0);
    }
}