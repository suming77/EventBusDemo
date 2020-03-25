package com.sum.eventbusdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

public class ThreeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("ThreeActivity");
        findViewById(R.id.btn_send).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发送事件
                mTv_content.setText("对OneActivity发送事件");
                //发送事件
                EventBus.getDefault().post(new MessageEvent("接收到ThreeActivity发送过来的事件啦"));
                break;
            default:
                break;
        }
    }
}
