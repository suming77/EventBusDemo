package com.sum.eventbusdemo.androidsticky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sum.eventbusdemo.R;

import org.simple.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AndroidEventBus粘性事件
 * 发送消息页面
 */
public class AndroidStickySendActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_send_sticky);
        findViewById(R.id.btn_send).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发布事件
                //4.发布粘性事件,tag为from_three
                EventBus.getDefault().postSticky("接收到AndroidStickySendActivity发送过来的事件啦", "from_android_sticky");
                startActivity(new Intent(this, AndroidStickyReceiveActivity.class));
                break;
            default:
                break;
        }
    }
}
