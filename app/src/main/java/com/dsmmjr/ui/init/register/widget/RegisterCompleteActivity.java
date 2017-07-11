package com.dsmmjr.ui.init.register.widget;

import android.content.Intent;
import android.view.View;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.ui.account.widget.activitys.RealnameAuthenticationActivity;
import com.dsmmjr.utils.Util;

import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.REG_COMPLETE_REALNAME;

/**
 * Create time : 2017/3/30.
 * Author : Hexl
 * Depict : 注册完成
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
public class RegisterCompleteActivity extends BaseActivity {

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_register_complete);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_reg, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
    }

    @OnClick({R.id.btn_complete, R.id.back_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete://完成注册,
                Intent intent = new Intent(this, RealnameAuthenticationActivity.class);
                intent.putExtra(REG_COMPLETE_REALNAME, 1);
                startActivity(intent);
                break;
            case R.id.back_home://返回首页
                Util.gotoMain(this);
                break;
        }
        finish();
    }


}