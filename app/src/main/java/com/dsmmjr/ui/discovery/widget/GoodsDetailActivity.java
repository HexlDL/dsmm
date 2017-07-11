package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.graphics.Paint;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.GoodsDetailEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.presenter.GoodsDetailPresenterImpl;
import com.dsmmjr.ui.discovery.view.IGoodsDetail;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.GONE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.GOODS_DETAIL_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.USERBEAN;
import static com.dsmmjr.ExtraConfig.RequestCode.ADDRESS;
import static com.dsmmjr.utils.ToolsUtil.formartString;

/**
 * Create time : 2017/4/5.
 * Author : Hexl
 * Depict : 实物商品详情
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
public class GoodsDetailActivity extends BaseActivity implements IGoodsDetail {

    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_cost)
    TextView mTvCost;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_convert)
    TextView mTvConvert;
    @BindView(R.id.tv_username)
    TextView mTvUsername;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_un_address)
    TextView mTvUnAddress;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    private GoodsDetailPresenterImpl mPresenter;
    private String mId;
    private GoodsDetailEntity.DataBean.UserinfoBean mUserBean;

    public GoodsDetailActivity() {
        mPresenter = new GoodsDetailPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_goods_detail);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_point_detail, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), GONE);

        //商品详情id
        mId = getIntent().getStringExtra(GOODS_DETAIL_ID);
        mPresenter.getGoodDetail(PreferenceCache.getToken(), mId);
    }

    @OnClick({R.id.rl_address, R.id.btn_exchange})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_address://更改收货地址
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra(USERBEAN, mUserBean);
                startActivityForResult(intent, ADDRESS);
                break;
            case R.id.btn_exchange://立即兑换
                mPresenter.exchangeGood(PreferenceCache.getToken(), mId);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADDRESS && resultCode == RESULT_OK && data != null) {
            mTvUsername.setVisibility(View.VISIBLE);
            mTvAddress.setVisibility(View.VISIBLE);
            mTvUnAddress.setVisibility(View.GONE);

            String username = data.getStringExtra("username");
            String mobile = data.getStringExtra("mobile");
            String pro_city = data.getStringExtra("procity");
            String address = data.getStringExtra("address");

            mUserBean.setUsername(username);
            mUserBean.setMobile(mobile);
            mUserBean.setArea(pro_city);
            mUserBean.setAddress(address);

            mTvUsername.setText(username + "  " + mobile);
            mTvAddress.setText(pro_city + "  " + address);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void resultSuccessData(GoodsDetailEntity entity) {
        GoodsDetailEntity.DataBean.DetailBean detailBean = entity.getData().getDetail();
        mUserBean = entity.getData().getUserinfo();

        if (!mUserBean.getUsername().equals("")) {//用户填写了地址
            mTvUsername.setVisibility(View.VISIBLE);
            mTvAddress.setVisibility(View.VISIBLE);
            mTvUnAddress.setVisibility(View.GONE);

            mTvUsername.setText(mUserBean.getUsername() + "  " + mUserBean.getMobile());
            mTvAddress.setText(mUserBean.getArea() + mUserBean.getAddress());
        } else {//用户未填写地址
            mTvUsername.setVisibility(View.GONE);
            mTvAddress.setVisibility(View.GONE);

            mTvUnAddress.setVisibility(View.VISIBLE);
        }

        mTvName.setText(detailBean.getName());
        mTvCost.setText(formartString(detailBean.getCost() + "分", 0.5f));
        mTvPrice.setText(detailBean.getPrice());
        mTvPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置干扰线
        mTvConvert.setText(detailBean.getSurplus());
//        mTvConvert.setText("剩余" + detailBean.getConvert() + "份");
        mTvContent.setText(Html.fromHtml(detailBean.getContent()));

        Glide.with(this)
                .load(detailBean.getThumb())
                .placeholder(R.mipmap.img_loading)//站位图
                .error(R.mipmap.img_faile)//没有网络
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//启动缓存
                .into(mIvImg);
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {
//            PointActivity.sFalgResume = true;
            AlertUtil.t(this, entity.getMsg());
//            finish();
        }
    }

    @Override
    public void showProgress() {
        if (ll_wv != null) ll_wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (ll_wv != null) ll_wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (ll_wv != null) ll_wv.setVisibility(View.GONE);
    }
}
