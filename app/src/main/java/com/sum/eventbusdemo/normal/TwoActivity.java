package com.sum.eventbusdemo.normal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.sum.eventbusdemo.MessageEvent;
import com.sum.eventbusdemo.R;
import org.greenrobot.eventbus.EventBus;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 发送普通事件
 */
public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        findViewById(R.id.btn_send).setOnClickListener(this);
        mTv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send://发布事件
                mTv_content.setText("对OneActivity发布事件");
                //4.发布事件
                EventBus.getDefault().post(new MessageEvent("接收到TwoActivity发送过来的事件啦"));
                break;
            default:
                break;
        }
    }
}
