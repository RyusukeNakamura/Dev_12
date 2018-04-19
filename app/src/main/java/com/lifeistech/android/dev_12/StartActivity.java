package com.lifeistech.android.dev_12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void button(View v){
        Intent intent=new Intent(this,MainActivity.class);

        intent.putExtra("a",10);

        startActivity(intent);
    }
    public void five(View v){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("a",5);
        startActivity(intent);

    }
    public void twenty(View v){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("a",20);
        startActivity(intent);

    }
}
