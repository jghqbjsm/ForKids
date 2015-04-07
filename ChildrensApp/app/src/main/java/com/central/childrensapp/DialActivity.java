package com.central.childrensapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/*
This Activity class is to be used as the video-player activity
Intent should ALWAYS have String Extra "path" as the directory
 */

public class DialActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        //Get path from intent
        Intent fromIntent = getIntent();
        String path = (String) fromIntent.getStringExtra("path");

        //PLACEHOLDER
        TextView tv = (TextView) findViewById(R.id.title);
        tv.setText(path);

    }
}
