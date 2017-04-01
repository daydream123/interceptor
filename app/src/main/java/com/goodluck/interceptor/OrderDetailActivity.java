package com.goodluck.interceptor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.goodluck.interceptor.interceptor.InterceptWith;
import com.goodluck.interceptor.interceptor.InterceptorActivity;
import com.goodluck.interceptor.interceptor.LoginInterceptor;

@InterceptWith(LoginInterceptor.class)
public class OrderDetailActivity extends InterceptorActivity {
    private static final String EXTRA_ORDER_ID = "orderId";

    private TextView mOrderInfoText;
    private String mOrderId;

    public static void startActivity(Context context, String orderId) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_ORDER_ID, orderId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        mOrderId = getIntent().getStringExtra(EXTRA_ORDER_ID);
        mOrderInfoText = (TextView) findViewById(R.id.orderInfo);
    }

    @Override
    protected void invoked() {
        super.invoked();
        mOrderInfoText.setText("订单信息(order id: " + mOrderId + ")");
        // 根据orderId请求完整的订单信息
    }
}
