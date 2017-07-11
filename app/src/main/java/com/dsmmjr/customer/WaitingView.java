package com.dsmmjr.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.dsmmjr.R;


/**
 * @Author GL
 * @Description
 * @Date 2012-12-22
 */
public class WaitingView extends LinearLayout {
    public static final int WAITING_VIEW_ID = R.id.waiting_view;

    private Context context;

    public WaitingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public WaitingView(Context context) {
        this(context, null);
    }

    private void init() {
        this.setVisibility(View.VISIBLE);

        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        LinearLayout llLoading = (LinearLayout) View.inflate(context, R.layout.waiting_view, null);

        this.addView(llLoading, new LinearLayout.LayoutParams(-1, -1));
    }

    public void show() {
        this.setVisibility(View.VISIBLE);
    }

}
