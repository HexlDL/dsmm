package com.dsmmjr.ui.account.widget.activitys;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.ToggleButton;
import com.dsmmjr.entity.AutoEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.AutoInvestPresenterImpl;
import com.dsmmjr.ui.account.view.IAutoInvest;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.utils.AlertUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 自动投标
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
public class AutoInvestActivity extends BaseActivity implements IAutoInvest, ToggleButton.ToggleOnListener {

    @BindView(R.id.toggle_button)
    ToggleButton toggleButton;
    @BindView(R.id.tv_use_money)
    TextView mTvUseMoney;
    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.tv_rules)
    TextView mTvRules;
    @BindView(R.id.tv_img1)
    TextView mTvImg1;
    @BindView(R.id.tv_img2)
    TextView mTvImg2;
    @BindView(R.id.tv_img3)
    TextView mTvImg3;
    @BindView(R.id.et_reserve_amount)
    EditText mEtReserveAmount;
    @BindView(R.id.et_year_apr)
    EditText mEtYearApr;
    @BindView(R.id.et_start_term)
    EditText mEtStartTerm;
    @BindView(R.id.et_end_term)
    EditText mEtEndTerm;
    @BindView(R.id.et_max_amount)
    EditText mEtMaxAmount;
    @BindView(R.id.et_min_amount)
    EditText mEtMinAmount;

    @BindView(R.id.waiting_view)
    LinearLayout wv;
    private AutoInvestPresenterImpl mPresenter;

    private int is_open;//是否开启
    private int count;

    public AutoInvestActivity() {
        is_open = 0;
        count = 0;
        mPresenter = new AutoInvestPresenterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_auto);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_auto_setting, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE/*, View.GONE, R.string.auto_record*/);

        toggleButton.setSwitchBackgroundResource(R.mipmap.sb_bg_pressed);//滑动背景图片
        toggleButton.setSlideBackgroundResource(R.mipmap.sb_open);//滑动块图片
        toggleButton.setToggleState(ToggleButton.ToggleState.Open);
        toggleButton.setToggleOnListener(this);

        mPresenter.loadAuto(PreferenceCache.getToken());

    }

    @OnClick({R.id.tv_right, R.id.btn_save_setting, R.id.imageView1, R.id.imageView2, R.id.imageView3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                showExplain(mTvImg1, true);
                showExplain(mTvImg2, false);
                showExplain(mTvImg3, false);
                downThread(mTvImg1);
                break;
            case R.id.imageView2:
                showExplain(mTvImg1, false);
                showExplain(mTvImg2, true);
                showExplain(mTvImg3, false);
                downThread(mTvImg2);
                break;
            case R.id.imageView3:
                showExplain(mTvImg1, false);
                showExplain(mTvImg2, false);
                showExplain(mTvImg3, true);
                downThread(mTvImg3);
                break;
            case R.id.btn_save_setting:
                save();
                break;
        }
    }

    private void showExplain(TextView textView, boolean visibility) {
        if (!visibility)
            textView.setVisibility(View.GONE);
        else {
            textView.setVisibility(View.VISIBLE);
//            count++;
//            if (count % 2 == 0)
//                textView.setVisibility(View.GONE);
//            else
//                textView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void resultSuccessData(AutoEntity entity) {
        AutoEntity.DataBean.AutoconfigBean bean = entity.getData().getAutoconfig();

        setToggleButton(bean.getIs_open() == 1 ? ToggleButton.ToggleState.Open
                : ToggleButton.ToggleState.Close);
        mTvUseMoney.setText(bean.getTotal_money());
        mEtReserveAmount.setText(bean.getAccount_money());
        mEtYearApr.setText(bean.getInterest_rate());
        mEtStartTerm.setText(bean.getDuration_from());
        mEtEndTerm.setText(bean.getDuration_to());
        mEtMinAmount.setText(bean.getMin_invest());
        mEtMaxAmount.setText(bean.getInvest_money());
        mTvRules.setText(entity.getData().getRules().replace("。", "。\n"));
    }

    @Override
    public void updateSuccessData(ResponseInfoEntity entity) {
        AlertUtil.t(this, entity.getMsg());
        finish();
    }

    @Override
    public void showProgress() {
        wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void onToggleStateChangeListener(ToggleButton.ToggleState state) {
        setToggleButton(state);
    }

    private void setToggleButton(ToggleButton.ToggleState state) {
        /**
         * 设置默认的图片和状态(开启)
         */
        if (state == ToggleButton.ToggleState.Open) {//开启
            is_open = 1;
            toggleButton.setSwitchBackgroundResource(R.mipmap.sb_bg_pressed);//滑动背景图片
            toggleButton.setSlideBackgroundResource(R.mipmap.sb_open);//滑动块图片
            toggleButton.setToggleState(ToggleButton.ToggleState.Open);
            mTvStatus.setText("开启");
        } else {//关闭
            is_open = 0;
            toggleButton.setSwitchBackgroundResource(R.mipmap.sb_bg_unpressed);//滑动背景图片
            toggleButton.setSlideBackgroundResource(R.mipmap.sb_close);//滑动块图片
            toggleButton.setToggleState(ToggleButton.ToggleState.Close);
            mTvStatus.setText("关闭");
        }

    }

    /**
     * 保存设置
     */
    private void save() {
        if (check()) {
            mPresenter.updateAuto(PreferenceCache.getToken(), is_open,
                    mEtReserveAmount.getText().toString(), mEtYearApr.getText().toString(),
                    mEtStartTerm.getText().toString(), mEtEndTerm.getText().toString(),
                    mEtMinAmount.getText().toString(), mEtMaxAmount.getText().toString());
        }
    }

    /**
     * 效验
     *
     * @return
     */
    private boolean check() {
       /* if (TextUtils.isEmpty(mEtReserveAmount.getText().toString())) {
            AlertUtil.t(this, R.string.input_receiver_amount);
            return false;
        }

        if (TextUtils.isEmpty(mEtYearApr.getText().toString())) {
            AlertUtil.t(this, R.string.input_apr);
            return false;
        }*/
        if (TextUtils.isEmpty(mEtStartTerm.getText().toString())) {
            AlertUtil.t(this, "请输入开始投标期限");
            return false;
        }

        if (TextUtils.isEmpty(mEtEndTerm.getText().toString())) {
            AlertUtil.t(this, "请输入结束投标期限");
            return false;
        }
        if (TextUtils.isEmpty(mEtMinAmount.getText().toString())) {
            AlertUtil.t(this, R.string.input_min_money);
            return false;
        }

        if (TextUtils.isEmpty(mEtMaxAmount.getText().toString())) {
            AlertUtil.t(this, R.string.input_max_money);
            return false;
        }

        return true;
    }

    private void downThread(final TextView textView) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                autoCancle(textView);
            }
        }, 3000);
    }

    /**
     * 自动取消
     *
     * @param textView
     */
    private void autoCancle(TextView textView) {
        textView.setVisibility(View.GONE);
    }

}
