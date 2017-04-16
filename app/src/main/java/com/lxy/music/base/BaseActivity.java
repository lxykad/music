package com.lxy.music.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lxy.music.R;
import com.lxy.music.util.ActivityManager;
import com.lxy.music.util.SystemBarTintManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //固定为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //
        ActivityManager.getInstance().addActivity(this);
        //
        setTransLucentStatus(true);
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.status_bar_color);//通知栏所需颜色
    }

    public void setTransLucentStatus(boolean on) {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            params.flags |= bits;
        } else {
            params.flags &= ~bits;
        }
        window.setAttributes(params);

    }


    //snack
    public void showSnackBar(View view, @Nullable String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }

    //页面跳转
    public void startToActivity(Class toActivity) {
        Intent intent = new Intent();
        intent.setClass(this, toActivity);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ActivityManager.getInstance().removeActivity(this);

    }
}
