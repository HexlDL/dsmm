package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.CARD_RULE;

/**
 * Create time : 2017/6/20.
 * Author : Hexl
 * Depict : 卡券使用规则
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
public class CardRuleActivity extends BaseActivity {

    @BindView(R.id.tv_rule)
    TextView mTvRule;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_rule);
    }

    @Override
    protected void initData() {
        int index = getIntent().getIntExtra(CARD_RULE, -1);

        if (index == 0) {
            setHeaterTitle(R.string.title_red_rule, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet), View.VISIBLE);
            mTvTitle.setText("红包使用说明：");
            mTvRule.setText(R.string.red_rule);
        } else {
            setHeaterTitle(R.string.title_rate_rule, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet), View.VISIBLE, View.VISIBLE, R.string.cash_record);
            mTvTitle.setText("现金券使用说明：");
            mTvRule.setText(R.string.rate_rule);
        }
    }
}
