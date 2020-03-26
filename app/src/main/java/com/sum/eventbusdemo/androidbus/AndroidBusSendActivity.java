package com.sum.eventbusdemo.androidbus;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sum.eventbusdemo.MessageEvent;
import com.sum.eventbusdemo.R;

import org.simple.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AndroidEventBus
 * 发送消息页面
 */
public class AndroidBusSendActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_send);
        findViewById(R.id.btn_send).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发布事件
                mTv_content.setText("对AndroidBusReceiveActivity发布事件");
                //4.发布事件,tag为from_three
                EventBus.getDefault().post(new MessageEvent("接收到AndroidBusSendActivity发送过来的事件啦"), "from_three");
                break;
            default:
                break;
        }
    }
}
