package com.ngyb.pulltorefresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        Intent intent = new Intent(this, P2RefreshGridViewActivity.class);
        startActivity(intent);
    }

    public void click2(View view) {
        Intent intent = new Intent(this, P2ScrollViewActivity.class);
        startActivity(intent);
    }
}
