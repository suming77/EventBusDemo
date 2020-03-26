package com.sum.eventbusdemo.androidsticky;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sum.eventbusdemo.R;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AndroidEventBus粘性事件
 * 接收消息页面
 */
public class AndroidStickyReceiveActivity extends AppCompatActivity {
    public static final String TAG = "StickyReceiveActivity";
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_receive_sticky);
        mTv_content = findViewById(R.id.tv_content);

        //1.注册粘性事件
        EventBus.getDefault().registerSticky(this);
    }

    //3.接收粘性事件处理, 有tag为from_three
    @Subscriber(tag = "from_android_sticky", mode = ThreadMode.MAIN)
    public void eventAndroidEventBus(String message) {
        mTv_content.setText("eventAndroidEventBus ==  tag = from_android_sticky | " + message);
        Log.e(TAG, "eventAndroidEventBus ==  tag = from_android_sticky | " + message);

        //5.移除粘性事件
        EventBus.getDefault().removeStickyEvent(String.class, "from_android_sticky");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.反注册事件
        EventBus.getDefault().unregister(this);
    }
}
