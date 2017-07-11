package com.dsmmjr.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @Author GL
 * @Description 控制软键盘的工具类
 * @Date 2013-1-21
 */
public class SoftInputUtil {

	/**
	 * @Description 软件盘始终隐藏
	 * @param activity
	 */
	public static void setSoftInputAlwaysHidden(Activity activity) {
		activity.getWindow()
				.setSoftInputMode(
						WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
								| WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

	/**
	 * @Description 软件盘始终显示
	 * @param activity
	 */
	public static void setSoftInputAlwaysVisiable(Activity activity) {
		activity.getWindow()
				.setSoftInputMode(
						WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
								| WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
	}

	/**
	 * @Description 隐藏软键盘
	 */
	public static void hideSoftKeyboard(EditText editText) {
		InputMethodManager localInputMethodManager = (InputMethodManager) editText
				.getContext().getSystemService("input_method");
		localInputMethodManager.hideSoftInputFromWindow(
				editText.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
	}
	
	public static void hideSoftKeyboard(View view) {
		InputMethodManager localInputMethodManager = (InputMethodManager) view
				.getContext().getSystemService("input_method");
		localInputMethodManager.hideSoftInputFromWindow(
				view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
	}
	
	public static void showSoftKeyboard(EditText editText) {
		InputMethodManager imm = (InputMethodManager)editText.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
	}

}
