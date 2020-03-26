package com.sum.eventbusdemo.priority;

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
 * 事件优先级
 * 注册并接收事件
 */
public class PriorityReceiveActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "PriorityReceiveActivity";
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_receive);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        //1.注册事件
        EventBus.getDefault().register(this);
    }

    //3.订阅者的接收事件处理函数, 事件优先级0,1,2
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 0)
    public void onMessageEvent(String str) {
        //TODO 接收事件后Do something
        mTv_content.setText("onMessageEvent:" + str);
        Log.e(TAG, "onMessageEvent：priority = 0 " + str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 1)
    public void onMessageEvent1(String str) {
        Log.e(TAG, "onMessageEvent：priority = 1 "+str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 2)
    public void onMessageEvent2(String str) {
        Log.e(TAG, "onMessageEvent：priority = 2 " + str);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip://跳转到PrioritySendActivity
                startActivity(new Intent(this, PrioritySendActivity.class));
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
