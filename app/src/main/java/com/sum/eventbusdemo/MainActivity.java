package com.sum.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sum.eventbusdemo.androidbus.AndroidBusReceiveActivity;
import com.sum.eventbusdemo.androidsticky.AndroidStickySendActivity;
import com.sum.eventbusdemo.normal.OneActivity;
import com.sum.eventbusdemo.priority.PriorityReceiveActivity;
import com.sum.eventbusdemo.sticky.StickySendActivity;
import com.sum.eventbusdemo.threadmode.ModeReceiveActivity;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 我的博客：https://blog.csdn.net/m0_37796683
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_sticky).setOnClickListener(this);
        findViewById(R.id.btn_thread_mode).setOnClickListener(this);
        findViewById(R.id.btn_priority).setOnClickListener(this);
        findViewById(R.id.btn_android).setOnClickListener(this);
        findViewById(R.id.btn_android_sticky).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class<?> cls = null;
        switch (v.getId()) {
            case R.id.btn_normal://普通使用
                cls = OneActivity.class;
                break;
            case R.id.btn_sticky://粘性事件
                cls = StickySendActivity.class;
                break;
            case R.id.btn_thread_mode://几种线程模式
                cls = ModeReceiveActivity.class;
                break;
            case R.id.btn_priority://事件优先级
                cls = PriorityReceiveActivity.class;
                break;
            case R.id.btn_android://AndroidEventBus
                cls = AndroidBusReceiveActivity.class;
                break;
            case R.id.btn_android_sticky://AndroidEventBus粘性事件
                cls = AndroidStickySendActivity.class;
                break;
        }

        if (cls != null) {
            startActivity(new Intent(this, cls));
        }
    }
}
