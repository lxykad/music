package com.lxy.music.home.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivityMainBinding;
import com.lxy.music.home.find.ui.FindFragment;
import com.lxy.music.home.left.local.ui.LocalMusicActivity;
import com.lxy.music.home.main.iview.MainLocalMusicListener;
import com.lxy.music.home.my.ui.MyFragment;
import com.lxy.music.home.recommend.ui.RecommendFragment;
import com.lxy.music.util.PermissionUtil;
import com.lxy.music.util.UiUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainLocalMusicListener {

    private ActivityMainBinding mBinding;
    private final String[] mTitles = {"热门推荐", "我的", "发现"};
    private ArrayList<Fragment> mFragments;
    private HomePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        int h = UiUtils.getStatusBarHeight(this);

        mBinding.coorLayout.setPadding(0, h, 0, 0);
        //mBinding.ivHeader.setPadding(0, h, 0, 0);

        initData();
        initEvents();

        MainViewModel mainViewModel = new MainViewModel(mBinding, this);
    }

    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new RecommendFragment());
        mFragments.add(new MyFragment());
        mFragments.add(new FindFragment());
    }

    public void initEvents() {
        mAdapter = new HomePagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mBinding.viewPager.setAdapter(mAdapter);
        mBinding.slidingTabLayout.setViewPager(mBinding.viewPager);

    }

    @Override
    public void setFitsWindow(boolean fits) {
        super.setFitsWindow(false);
    }

    @Override
    public void localClick() {
        //跳转本地音乐
        //showToast("local");
        checkAndRequestPermission();
        //关闭侧滑
        mBinding.drawerLayout.closeDrawers();
    }

    private void checkAndRequestPermission() {
        if (PermissionUtil.isHasPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //已经获取权限
            startToActivity(LocalMusicActivity.class);
        } else {
            //
            if (PermissionUtil.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                PermissionUtil.showDialog(this, "扫描", new PermissionUtil.IPermissionRequest() {
                    @Override
                    public void agree() {
                        //Toast.makeText(MainActivity.this, "agree", Toast.LENGTH_SHORT).show();
                        PermissionUtil.requestPermissions(MainActivity.this, PermissionUtil.PERMISSION_REQ_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
                    }

                    @Override
                    public void refuse() {
                        //Toast.makeText(MainActivity.this, "refuse", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                PermissionUtil.requestPermissions(this, PermissionUtil.PERMISSION_REQ_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PermissionUtil.PERMISSION_REQ_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    //showToast("agree");
                    startToActivity(LocalMusicActivity.class);
                } else {
                    // Permission Denied
                    //showToast("refuse");

                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

}
