package com.sum.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;
//接收消息页面
public class AndroidEventBusReceiveActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content, mTv_content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_receive);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        mTv_content2 = findViewById(R.id.tv_content2);

        //注册事件
        EventBus.getDefault().register(this);
    }

    //接收ThreeActivity事件处理,有tag
    @Subscriber(tag = "from_three", mode = ThreadMode.MAIN)
    public void eventAndroidEventBus(MessageEvent message) {
        Toast.makeText(this, "eventAndroidEventBus:" + message.name, Toast.LENGTH_SHORT).show();
        mTv_content2.setText("eventAndroidEventBus:" + message.name);
    }

    //接收ThreeActivity事件处理,有tag
    @Subscriber(tag = "FROM_THREE", mode = ThreadMode.MAIN)
    public void eventAndroidEventBus1(MessageEvent message) {
        Toast.makeText(this, "eventAndroidEventBus:" + message.name, Toast.LENGTH_SHORT).show();
        mTv_content.setText("eventAndroidEventBus:" + message.name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip://跳转到AndroidBusSendActivity
                startActivity(new Intent(this, AndroidBusSendActivity.class));
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
