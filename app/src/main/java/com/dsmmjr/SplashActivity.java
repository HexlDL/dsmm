package com.dsmmjr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.widget.activitys.GestureVerifyActivity;
import com.dsmmjr.ui.main.widget.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GESTURE_FLAG;

/**
 * 欢迎页
 *
 * @author lenovo
 */
public class SplashActivity extends FragmentActivity {

    @BindView(R.id.welcome_four)
    ImageView mWelcomeFour;
    @BindView(R.id.tv_skip_flash)
    TextView mTvSkipFlash;

    private CountDownTimer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);

//        if (!PreferenceCache.getGuidePage()) {
//            startActivity(new Intent(SplashActivity.this, ActivityGuide.class));
//        } else {
//            PreferenceCache.putGuidePage(true);


        /**
         * 不设置为3秒整是因为下面要进行四舍五入
         * 不然只会显示2秒
         */
        mTimer = new CountDownTimer(3100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvSkipFlash.setText(Math.round((float) millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinish() {
                gesturePwd();
            }
        }.start();
    }

    private void gesturePwd() {
        Intent intent = new Intent();
        /**
         * 判断是否设置过手势密码
         */
        if (PreferenceCache.isGestureFlag()) {
            intent.setClass(this, GestureVerifyActivity.class);
            intent.putExtra(GESTURE_FLAG,1);
        } else {
            intent.setClass(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
