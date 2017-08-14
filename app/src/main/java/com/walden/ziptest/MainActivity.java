package com.walden.ziptest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.walden.ziptest.Event.EventCallBack;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zipClick();
            }
        });
    }

    private void zipClick() {
        ZipUtils.Zip(getEvent(), getEvent(), getEvent(), new CallBack() {


            @Override
            public void getEventResult(Object o, Object o2, Object o3) {
                final int a1 = (Integer) o;
                final int a2 = (Integer) o2;
                final int a3 = (Integer) o3;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("param1 : " + a1 + "\nparam2 : " + a2 + "\nparam3 : "+a3);
                    }
                });
            }
        });
    }

    private Event<Integer> getEvent() {
        return Event.create(new EventCallBack<Integer>() {

            @Override
            public void dosomething(final Event.PostData<Integer> postData) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int rand = new Random().nextInt(4);
                        SystemClock.sleep(rand * 1000);
                        postData.post(rand * 2);
                    }
                }).start();
            }
        });
    }
}
