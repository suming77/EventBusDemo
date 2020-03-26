package com.sum.eventbusdemo.threadmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 几种线程模式
 * 注册并接收事件
 */
public class ModeReceiveActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ModeReceiveActivity";
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_receive);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        //1.注册事件
        EventBus.getDefault().register(this);
    }

    //3.订阅者的接收事件处理函数

    //处理函数执行线程与发布线程一致
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(String str) {
        //TODO 接收事件后Do something
        mTv_content.setText("onMessageEvent:" + str);
        Log.e(TAG, "onMessageEventPosting：" + Thread.currentThread().getName());
    }

    //处理函数执行线程为主线程
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventMain(String str) {
        Log.e(TAG, "onMessageEventMain：" + Thread.currentThread().getName());
    }

    //处理函数执行线程为主线程
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMessageEventMainOrdered(String str) {
        Log.e(TAG, "onMessageEventMainOrdered：" + Thread.currentThread().getName());
    }

    //处理函数执行线程为后台线程
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageEventBackground(String str) {
        Log.e(TAG, "onMessageEventBackground：" + Thread.currentThread().getName());
    }

    //处理函数执行线程为后台线程
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageEventAsync(String str) {
        Log.e(TAG, "onMessageEventAsync：" + Thread.currentThread().getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip://跳转到ModeSendActivity
                startActivity(new Intent(this, ModeSendActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.反注册事件
        EventBus.getDefault().unregister(this);
    }
}
