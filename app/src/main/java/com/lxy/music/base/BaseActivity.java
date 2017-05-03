package com.lxy.music.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lxy.music.R;
import com.lxy.music.di.component.ActivityComponent;
import com.lxy.music.di.component.AppComponent;
import com.lxy.music.di.component.DaggerActivityComponent;
import com.lxy.music.di.module.ActivityMoudle;
import com.lxy.music.util.ActivityManager;
import com.lxy.music.util.UiUtils;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {


    private ActivityComponent mActivityComponent;

    public ActivityComponent getmActivityComponent(){

        return mActivityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //固定为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //
        ActivityManager.getInstance().addActivity(this);
        //设置状态栏颜色
        setStatusTranslucent();
        setFitsWindow(true);

        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getInstance().getAppComponent())
                .activityMoudle(new ActivityMoudle(this))
                .build();
        //mActivityComponent.inject(this);

        setupActivityComponent(BaseApplication.getInstance().getAppComponent());
    }

    //snack
    public void showSnackBar(View view, @Nullable String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
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

    public void setStatusTranslucent() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    public void setFitsWindow(boolean fits) {

        if (!fits) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color));

            View viewById = findViewById(android.R.id.content);
            ViewCompat.setFitsSystemWindows(viewById, false);
            viewById.setPadding(0, UiUtils.getStatusBarHeight(this), 0, 0);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            //此方法 4.4以上通用
            View viewById = findViewById(android.R.id.content);
            ViewCompat.setFitsSystemWindows(viewById, false);
            viewById.setBackgroundColor(ContextCompat.getColor(this, R.color.status_bar_color));
            viewById.setPadding(0, UiUtils.getStatusBarHeight(this), 0, 0);
        }

    }

    public abstract void setupActivityComponent(AppComponent appComponent);

}
