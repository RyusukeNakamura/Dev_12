package com.lifeistech.android.dev_12;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView mTimeTextView, mResultTextView;
    Handler mHandler;
    int mTime = 0;
    Timer mTimer;
    int mDefaultTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView) findViewById(R.id.textView);
        mResultTextView = (TextView) findViewById(R.id.textView2);

        mHandler = new Handler();
        Intent intent = getIntent();
        mDefaultTime = intent.getIntExtra("a", 0);

    }


    public void start(View v) {
        mTimeTextView.setText("start");

        if (mTimer == null) {
            Toast.makeText(this, mDefaultTime + "秒当ててね", Toast.LENGTH_LONG).show();
            mTime = mDefaultTime;

            mTimer = new Timer(false);
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mTime--;

                            Log.d("timeの数字＝", String.valueOf(mTime));
                        }
                    });

                }
            }, 0, 1000);
        }
    }

    public void stop(View v) {
        if (mTimer != null) {
            mTimeTextView.setText(String.valueOf(mTime));
            mTimer.cancel();
            mTimer = null;
            if (mTime == 0) {
               //mResultTextView.setTextColor(Color.RED);
                //mResultTextView.setText("おめでとう！");
                Intent intent=new Intent(this,ImageActivity.class);
                intent.putExtra("result",0);
                startActivity(intent);

            } else {
                //mResultTextView.setTextColor(Color.BLUE);
                //mResultTextView.setText("残念");
                Intent intent=new Intent(this,ImageActivity.class);
                intent.putExtra("result",1);
                startActivity(intent);

            }
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mTimer!=null){
            mTimer.cancel();
            mTimer=null;
        }
    }
}
