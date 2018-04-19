package com.lifeistech.android.dev_12;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ImageActivity extends AppCompatActivity {
    ImageView image;
    Intent intent;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        layout=(RelativeLayout)findViewById(R.id.layout);
        

        image=new ImageView(this);
        intent=getIntent();
        if(intent.getIntExtra("result",0)==0){

            image.setImageResource(R.drawable.cleared);
            layout.addView(image);
        }else{
            image.setImageResource(R.drawable.failed);
            layout.addView(image);
        }
    }

}
