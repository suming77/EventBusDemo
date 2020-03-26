package com.sum.eventbusdemo.threadmode;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 几种线程模式
 * 发送事件
 */
public class ModeSendActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_send);
        findViewById(R.id.btn_send).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发布事件
                mTv_content.setText("对ModeReceiveActivity发布事件");
                //4.发布事件
                EventBus.getDefault().post("接收到ModeSendActivity发送过来的事件啦");
                break;
        }
    }
}
