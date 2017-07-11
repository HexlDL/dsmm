package com.dsmmjr.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.ui.discovery.widget.ExchangeRecordActivity;
import com.dsmmjr.ui.init.login.widget.LoginActivity;
import com.dsmmjr.ui.main.widget.MainActivity;
import com.dsmmjr.ui.product.widget.DebtBuyActivity;
import com.dsmmjr.ui.product.widget.InvestDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.INVEST_ACTIVITY;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.MAIN_ACTIVITY;

public class Util {

    /**
     * 获取屏幕分辨率
     *
     * @param context
     * @return 宽
     */
    public static int getDisplayWith(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    /**
     * 返回MainActivity
     *
     * @param currentActiviy 当前Activity
     */
    public static void showLogin(Activity currentActiviy) {
        Intent it = new Intent(currentActiviy, LoginActivity.class);
        if (currentActiviy instanceof MainActivity) {
            it.putExtra(MAIN_ACTIVITY, true);
        } else if (currentActiviy instanceof InvestDetailActivity || currentActiviy instanceof DebtBuyActivity) {
            it.putExtra(INVEST_ACTIVITY, true);
        } else if (currentActiviy instanceof ExchangeRecordActivity) {//避免从兑换记录跳转出现多个Login页面
            return;
        }
        currentActiviy.startActivity(it);
    }

    /**
     * 返回MainActivity
     *
     * @param currentActiviy 当前Activity
     */
    public static void gotoMain(Activity currentActiviy) {
        Intent it = new Intent(currentActiviy, MainActivity.class);
        //跳转到MainActivity之前先清除原来栈中的Activity
        //再跳转就相当于新启动了个MainActivity,避免出现当前Fragment显示在我的账户的tab
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        currentActiviy.startActivity(it);
        currentActiviy.finish();
    }

    /**
     * 获取SpannableString 最后一个缩小
     *
     * @param textSize
     * @param content
     * @return
     */
    public static SpannableString getGlobalSpanString(float textSize,
                                                      String content) {
        int stringLength = content.length();
        SpannableString ss = new SpannableString(content);
        if (stringLength > 0) {
            ss.setSpan(new StyleSpan(Typeface.NORMAL), 0, stringLength - 1,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan((int) (textSize * 0.5)),
                    stringLength - 1, stringLength,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            return ss;
        } else {
            return new SpannableString("");
        }
    }

    /**
     * 获取SpannableString 最后2个缩小
     *
     * @param textSize The TextSize of the TextView
     * @param content
     * @return
     */
    public static SpannableString getGlobalSpanStringLast2(float textSize,
                                                           String content) {
        int stringLength = content.length();
        SpannableString ss = new SpannableString(content);
        if (stringLength > 0) {
            ss.setSpan(new StyleSpan(Typeface.NORMAL), 0, stringLength - 2,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan((int) (textSize * 0.5)),
                    stringLength - 2, stringLength,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            return ss;
        } else {
            return new SpannableString("");
        }
    }

    /**
     * 获取SpannableString 通过 From(int)分割字符串
     *
     * @param textSize
     * @param content
     * @param from
     * @return
     */
    public static SpannableString getGlobalSpanString(float textSize,
                                                      String content, int from) {
        int stringLength = content.length();
        SpannableString ss = new SpannableString(content);
        if (stringLength > 0) {
            ss.setSpan(new StyleSpan(Typeface.BOLD), 0, from,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan((int) (textSize * 0.75)), from,
                    stringLength, SPAN_EXCLUSIVE_EXCLUSIVE);
            return ss;
        } else {
            return new SpannableString("");
        }
    }

    /**
     * 获取SpannableString 最后一个字符 缩小 改变颜色
     *
     * @param textSize 文字大小
     * @param content  文字内容
     * @return
     */
    public static SpannableString getGlobalSpanStringWithColor(float textSize,
                                                               String content) {
        int stringLength = content.length();
        SpannableString ss = new SpannableString(content);
        if (stringLength > 0) {
            ss.setSpan(new StyleSpan(Typeface.NORMAL), 0, stringLength - 1,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new ForegroundColorSpan(Color.GRAY), stringLength - 1,
                    stringLength, SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan((int) (textSize * 0.5)),
                    stringLength - 1, stringLength,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            return ss;
            /**/
        } else {
            return new SpannableString("");
        }
    }

    /**
     * 获取SpannableString 最后一个字符 缩小 改变颜色
     *
     * @param textSize 文字大小
     * @param content  文字内容
     * @param color    文字颜色
     * @return
     */
    public static SpannableString getGlobalSpanStringWithColor(float textSize,
                                                               String content, int color) {
        int stringLength = content.length();
        SpannableString ss = new SpannableString(content);
        if (stringLength > 0) {
            ss.setSpan(new StyleSpan(Typeface.NORMAL), 0, stringLength - 1,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new ForegroundColorSpan(color), stringLength - 1,
                    stringLength, SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new AbsoluteSizeSpan((int) (textSize * 0.75)),
                    stringLength - 1, stringLength,
                    SPAN_EXCLUSIVE_EXCLUSIVE);
            return ss;
        } else {
            return new SpannableString("");
        }
    }

    /**
     * 半角转为全角
     *
     * @param input
     * @return
     */
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }


    /**
     * 去除特殊字符或将所有中文标号替换为英文标号
     *
     * @param str
     * @return
     */

    public static String stringFilter(String str) {
        str = str.replaceAll("【", "[").replaceAll("】", "]")
                .replaceAll("！", "!").replaceAll("：", ":");// 替换中文标号
       /* String regEx = "[『』]"; // 清除掉特殊字符         
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();*/
        return str;
    }

    /**
     * 格式化日期
     *
     * @param date 日期
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sf.format(date);
    }

    /**
     * 时间戳
     *
     * @param date 日期
     * @return
     */
    public static long getTime(Date date) {
        return date.getTime();
    }

    /**
     * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
     * 要用到正则表达式
     */
    public static String digitUppercase(double n) {
        String fraction[] = {"角", "分"};
        String digit[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String unit[][] = {{"元", "万", "亿"},
                {"", "拾", "佰", "仟"}};

        String head = n < 0 ? "负" : "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if (s.length() < 1) {
            s = "整";
        }
        int integerPart = (int) Math.floor(n);

        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p = "";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart = integerPart / 10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }


    /**
     * 设置显示或隐藏密码
     *
     * @param isHidden     true 隐藏 false 显示
     * @param et_input_pwd 输入框
     * @param iv_hidden    image_view
     */
    public static void setPasswordShowOrHidden(boolean isHidden, EditText et_input_pwd,
                                               ImageView iv_hidden, int res_id) {
        if (isHidden) {
            et_input_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            iv_hidden.setImageResource(res_id);
        } else {
            et_input_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            iv_hidden.setImageResource(res_id);
        }
    }

    public static void setPasswordShowOrHidden(boolean isHidden, TextView tvTotalMoney, TextView tvUsableMoney,
                                               TextView tvBenefitMoney, TextView tvCollectionMoney,
                                               ImageView ivMoneyHidden, int pwd_hidden_violet) {
        if (isHidden) {
            tvTotalMoney.setTransformationMethod(PasswordTransformationMethod.getInstance());
            tvUsableMoney.setTransformationMethod(PasswordTransformationMethod.getInstance());
            tvBenefitMoney.setTransformationMethod(PasswordTransformationMethod.getInstance());
            tvCollectionMoney.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivMoneyHidden.setImageResource(pwd_hidden_violet);
        } else {
            tvTotalMoney.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            tvUsableMoney.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            tvBenefitMoney.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            tvCollectionMoney.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivMoneyHidden.setImageResource(pwd_hidden_violet);
        }

    }

    /**
     * 当列表没有数据时调用此方法
     *
     * @param list 数据
     * @param <T>  数据类型
     */
    public static <T> void noData(TextView tvNoData, List<T> list) {
        if (list.size() == 0) {
            tvNoData.setVisibility(View.VISIBLE);
        } else {
            tvNoData.setVisibility(View.GONE);
        }
    }

    /**
     * 将EditText
     *
     * @param et
     * @param len 字符串长度
     */
    public static void setEditTextCurIndex(EditText et, int len) {
        et.setSelection(len);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
