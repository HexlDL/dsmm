package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.GradeListAdapter;
import com.dsmmjr.adapter.ProductStateAdapter;
import com.dsmmjr.adapter.StyleAdapter;
import com.dsmmjr.adapter.TermAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.utils.ToolsUtil;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.VISIBLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.GRADE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.PRODUCT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.STYLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.TERM;
import static com.dsmmjr.utils.ToolsUtil.binarySearch;

public class SelectActivity extends BaseActivity {

    @BindView(R.id.gv_product)
    GridView gv_sProduct;
    @BindView(R.id.gv_grade)
    GridView gv_sGrade;
    @BindView(R.id.gv_term)
    GridView gv_term;
    @BindView(R.id.gv_style)
    GridView gv_style;

    private ProductStateAdapter mProductStateAdapter;
    private GradeListAdapter mGradeListAdapter;
    private TermAdapter mTermAdapter;
    private StyleAdapter mStyleAdapter;

    //项目状态
    private String[] productArray = {"不限制", "进行中", "复审中", "还款中", "已还完"};
    //信用等级
    private String[] gradeArray = {"不限制", "HR", "E", "D", "C", "B", "A"};
    //项目期限
    private String[] termArray = {"不限制", "天标", "3个月以内", "3-6个月", "6-12个月", "12-24个月"};
    //回款方式
    private String[] styleArray = {"不限制", "按天到期还款", "按月分期还款", "按季分期还款", "每月还息到期还本", "一次性还款"};

    private String product;
    private String grade;
    private String term;
    private String style;

    private String mResultProduct;
    private String mResultLevel;
    private String mResultTerm;
    private String mResultStyle;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.popup_select_bid);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();

        setHeaterTitle(R.string.selector, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), VISIBLE);

        /**
         * 接收从ProductFragment页面传递的值进行重新赋值,
         * 确保再次进入页面是用户之前选过的position
         */
        product = intent.getStringExtra(PRODUCT);
        grade = intent.getStringExtra(GRADE);
        term = intent.getStringExtra(TERM);
        style = intent.getStringExtra(STYLE);

        initAdapter();

    }

    private void initAdapter() {
        mProductStateAdapter = new ProductStateAdapter(this, Arrays.asList(productArray));
        mGradeListAdapter = new GradeListAdapter(this, Arrays.asList(gradeArray));
        mTermAdapter = new TermAdapter(this, Arrays.asList(termArray));
        mStyleAdapter = new StyleAdapter(this, Arrays.asList(styleArray));

        gv_sProduct.setAdapter(mProductStateAdapter);
        gv_sGrade.setAdapter(mGradeListAdapter);
        gv_term.setAdapter(mTermAdapter);
        gv_style.setAdapter(mStyleAdapter);

        setCheckItem();

        /**
         * 设置从上个页面传递过来的值
         */
        mProductStateAdapter.setCheckItem(findArrayIndex(product, productArray));
        mGradeListAdapter.setCheckItem(findArrayIndex(grade, gradeArray));
        mTermAdapter.setCheckItem(findArrayIndex(term, termArray));
        mStyleAdapter.setCheckItem(findArrayIndex(style, styleArray));
    }

    private void setCheckItem() {
        gv_sProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mProductStateAdapter.setCheckItem(position);
                mResultProduct = ToolsUtil.binarySearch(productArray, position);
            }
        });

        gv_sGrade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGradeListAdapter.setCheckItem(position);
                mResultLevel = ToolsUtil.binarySearch(gradeArray, position);
            }
        });

        gv_term.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTermAdapter.setCheckItem(position);
                mResultTerm = ToolsUtil.binarySearch(termArray, position);
            }
        });

        gv_style.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStyleAdapter.setCheckItem(position);
                mResultStyle = ToolsUtil.binarySearch(styleArray, position);
            }
        });
    }

    /**
     * 查找指定元素的索引值
     *
     * @return position
     */
    private int findArrayIndex(String str, String... array) {
        return binarySearch(array, str);
    }

    /**
     * 根据索引值查找到指定元素
     *
     * @param index 索引位置
     * @param array 数组
     * @return 元素
     */
    private String findElement(int index, String... array) {
        return binarySearch(array, index);
    }

    @OnClick(R.id.btn_submit)
    public void onClick() {
        /**
         * 如果Result值不为空 用户点击了item 就搜索 mResult 这个值
         */
        if (!TextUtils.isEmpty(mResultProduct)) {
            mResultProduct = findElement(findArrayIndex(mResultProduct, productArray), productArray);
        } else {
            mResultProduct = findElement(findArrayIndex(product, productArray), productArray);
        }
        if (!TextUtils.isEmpty(mResultLevel)) {
            mResultLevel = findElement(findArrayIndex(mResultLevel, gradeArray), gradeArray);
        } else {
            mResultLevel = findElement(findArrayIndex(grade, gradeArray), gradeArray);
        }
        if (!TextUtils.isEmpty(mResultTerm)) {
            mResultTerm = findElement(findArrayIndex(mResultTerm, termArray), termArray);
        } else {
            mResultTerm = findElement(findArrayIndex(term, termArray), termArray);
        }
        if (!TextUtils.isEmpty(mResultStyle)) {
            mResultStyle = findElement(findArrayIndex(mResultStyle, styleArray), styleArray);
        } else {
            mResultStyle = findElement(findArrayIndex(style, styleArray), styleArray);
        }

        Intent intent = new Intent();

        intent.putExtra(PRODUCT, mResultProduct);
        intent.putExtra(GRADE, mResultLevel);
        intent.putExtra(TERM, mResultTerm);
        intent.putExtra(STYLE, mResultStyle);

        setResult(RESULT_OK, intent);

        finish();
    }
}
