package com.sum.eventbusdemo.sticky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 发布粘性事件
 */
public class StickySendActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_send);
        findViewById(R.id.btn_send).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                //发布事件
                EventBus.getDefault().postSticky("StickySendActivity发送粘性事件");
                startActivity(new Intent(this, StickyReceiveActivity.class));
                break;
        }
    }
}
