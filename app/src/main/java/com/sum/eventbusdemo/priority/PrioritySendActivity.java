package com.sum.eventbusdemo.priority;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 事件优先级
 * 发送事件
 */
public class PrioritySendActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_send);
        findViewById(R.id.btn_send).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发送事件
                mTv_content.setText("对PriorityReceiveActivity发布事件");
                //4.发布事件
                EventBus.getDefault().post("接收到PrioritySendActivity发送过来的事件啦");
                break;
        }
    }
}
