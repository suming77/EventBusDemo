package com.sum.eventbusdemo.normal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sum.eventbusdemo.MessageEvent;
import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 注册并接收普通事件
 */
public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "OneActivity";
    private TextView mTv_content, mTv_content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        findViewById(R.id.btn_skip).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
        mTv_content2 = findViewById(R.id.tv_content2);
        //1.注册事件
        EventBus.getDefault().register(this);
    }

    //3.接收TwoActivity事件处理
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent message) {
        //TODO 接收事件后Do something
        mTv_content.setText("onMessageEvent:" + message.name);
        Toast.makeText(this, "onMessageEvent:" + message.name, Toast.LENGTH_SHORT).show();
    }

    //接收OtherActivity事件处理
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventFromOtherActivity(String s) {
        Toast.makeText(this, "onMessageEventFromOtherActivity:" + s, Toast.LENGTH_SHORT).show();
        mTv_content2.setText("onMessageEventFromOtherActivity:" + s);
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
        //2.反注册事件
        EventBus.getDefault().unregister(this);
    }
}
