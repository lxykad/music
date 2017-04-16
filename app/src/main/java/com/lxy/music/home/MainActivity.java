package com.lxy.music.home;

import android.os.Bundle;
import android.view.View;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        showSnackBar(view, "click");
    }
}
