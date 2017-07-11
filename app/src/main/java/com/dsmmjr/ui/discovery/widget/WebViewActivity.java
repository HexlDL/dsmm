package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.AWARD_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.FEED_BACK;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HELP_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_BANNER_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TITLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TREE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.LOAN_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.NEWS_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.NOVICE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.OPEN_ACCOUNT_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.RECHARGE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.TEST;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;

/**
 * Created by Administrator on 2016/8/11.
 * WebView
 */
public class WebViewActivity extends BaseActivity {
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private String targetUrl;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.webview);
    }

    @Override
    protected void initData() {
        init();
    }

    //    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void init() {
        WebView webView = (WebView) findViewById(R.id.web_view);
        Intent it = getIntent();
        int webTitle = it.getIntExtra(WEB_VIEW_FROM, -1);

        switch (webTitle) {
            case 0:
                setHeaterTitle(R.string.title_help_center, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(HELP_URL);
                break;
            case 1:
                setHeaterTitle(R.string.title_feed_back, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(FEED_BACK);
                break;
            case 2:
                setHeaterTitle(R.string.title_fy_account, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(OPEN_ACCOUNT_URL);
                break;
            case 3:
                setHeaterTitle(R.string.title_fy_account, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(TEST);
                break;
            case 4:
                setHeaterTitle(R.string.title_recharge, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(RECHARGE_URL);
                break;
            case 5:
                setHeaterTitle(it.getStringExtra(HOME_TITLE), getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(HOME_BANNER_URL);
                break;
            case 6:
                setHeaterTitle(R.string.title_news, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(NEWS_URL);
                break;
            case 7:
                setHeaterTitle(R.string.title_notice, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(NOVICE_URL);
                break;
            case 8:
                setHeaterTitle(R.string.title_loan, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(LOAN_URL);
                break;
            case 9:
                setHeaterTitle(R.string.title_tree, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(HOME_TREE_URL);
                break;
            case 10:
                setHeaterTitle(R.string.title_award, getResources().getColor(R.color.font_white),
                        getResources().getColor(R.color.font_violet), View.VISIBLE);
                targetUrl = it.getStringExtra(AWARD_URL);
                break;
            default:
                break;
        }

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
//        settings.setAllowFileAccess(true);
//        settings.setSupportMultipleWindows(true);
//        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true); // 必须进行这个设置
        settings.setBuiltInZoomControls(true); // 支持缩放
        settings.setLoadWithOverviewMode(true); // 初始加载时，是web页面自适应屏幕
        int screenDensity = getResources().getDisplayMetrics().densityDpi;
        WebSettings.ZoomDensity zoomDensity = WebSettings.ZoomDensity.MEDIUM;

//        mWebView.addJavascriptInterface(new WebAppInterface(), "closeActivity");

        switch (screenDensity) {
            case DisplayMetrics.DENSITY_LOW:
                zoomDensity = WebSettings.ZoomDensity.CLOSE;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                zoomDensity = WebSettings.ZoomDensity.MEDIUM;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                zoomDensity = WebSettings.ZoomDensity.FAR;
                break;
        }
        settings.setDefaultZoom(zoomDensity);

        webView.requestFocus();
        webView.requestFocusFromTouch();

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100)
                    wv.setVisibility(View.GONE);
                else
                    wv.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                return false;
            }
        });

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                wv.setVisibility(View.VISIBLE);
//                if (url.equals("http://api.51daishu.com/mapi/Fuiou/testFuiou")) {
//                    wv.setVisibility(View.GONE);
//                }
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                super.onPageFinished(view, url);
                wv.setVisibility(View.GONE);

                switch (url) {//3秒后关闭当前页面
                    case "http://api.51daishu.com/mapi/fuiou/fuiou_page_notify":
                    case "http://api.51daishu.com/mapi/fuiou/fuiou_page_charge":
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                WebViewActivity.this.finish();
                            }
                        }, 3000);
                        break;
                }
            }
        });

        webView.setDownloadListener(new DownloadListener() { // 资源下载
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition,
                                        String mimetype, long contentLength) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        webView.loadUrl(targetUrl);
    }

   /* public class WebAppInterface {
        WebAppInterface() {
        }

        @JavascriptInterface
        public void closeActivity() {
            Log.d("WebAppInterface", "closeActivity");
            WebViewActivity.this.finish();
        }
    }*/
}
