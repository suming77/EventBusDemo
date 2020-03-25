package com.sum.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content, mTv_content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        mTv_content2 = findViewById(R.id.tv_content2);
        //注册事件
        EventBus.getDefault().register(this);
    }

    //接收TwoActivity事件处理,无tag
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent message) {
        //TODO 接收事件后Do something
        mTv_content.setText("onMessageEvent:" + message.name);
        Toast.makeText(this, "onMessageEvent:" + message.name, Toast.LENGTH_SHORT).show();
    }

    //接收ThreeActivity事件处理,有tag
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventFromOtherActivity(MessageEvent message) {
        Toast.makeText(this, "onMessageEventFromOtherActivity:" + message.name, Toast.LENGTH_SHORT).show();
        mTv_content2.setText("onMessageEventFromOtherActivity:" + message.name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip://跳转到TwoActivity
                startActivity(new Intent(this, TwoActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册事件
        EventBus.getDefault().unregister(this);
    }
}
