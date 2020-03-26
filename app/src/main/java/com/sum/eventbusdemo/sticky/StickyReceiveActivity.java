package com.sum.eventbusdemo.sticky;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.sum.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 接收粘性事件
 */
public class StickyReceiveActivity extends AppCompatActivity{
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_receive);
        mTv_content = findViewById(R.id.tv_content);

        //1.注册事件
        EventBus.getDefault().register(this);
    }

    //3.接收StickySendActivity粘性事件处理,sticky = true表示是粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEvent(String str) {
        //TODO 接收事件后Do something
        mTv_content.setText("onStickyEvent:接收到" + str);
        Toast.makeText(this, "onStickyEvent:接收到" + str, Toast.LENGTH_SHORT).show();

        EventBus.getDefault().removeStickyEvent(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.反注册事件
        EventBus.getDefault().unregister(this);
    }
}
