package com.sum.eventbusdemo.androidbus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sum.eventbusdemo.MessageEvent;
import com.sum.eventbusdemo.R;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AndroidEventBus
 * 接收消息页面
 */
public class AndroidBusReceiveActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "AndroidBusReceive";
    private TextView mTv_content, mTv_content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_receive);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        mTv_content2 = findViewById(R.id.tv_content2);

        //1.注册事件
        EventBus.getDefault().register(this);
    }

    //3.接收事件处理, 有tag为from_three
    @Subscriber(tag = "from_three", mode = ThreadMode.MAIN)
    public void eventAndroidEventBus(MessageEvent message) {
        Toast.makeText(this, "eventAndroidEventBus:" + message.name, Toast.LENGTH_SHORT).show();
        mTv_content2.setText("eventAndroidEventBus: tag = from_three | " + message.name);
        Log.e(TAG, "eventAndroidEventBus ==  tag = from_three | " + message.name);
    }

    //接收事件处理,有tag为FROM_THREE
    @Subscriber(tag = "FROM_THREE", mode = ThreadMode.MAIN)
    public void eventAndroidEventBus1(MessageEvent message) {
        Toast.makeText(this, "eventAndroidEventBus:" + message.name, Toast.LENGTH_SHORT).show();
        mTv_content.setText("eventAndroidEventBus1: tag = FROM_THREE | " + message.name);
        Log.e(TAG, "eventAndroidEventBus1 ==  tag = FROM_THREE | " + message.name);
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
        //3.反注册事件
        EventBus.getDefault().unregister(this);
    }
}
