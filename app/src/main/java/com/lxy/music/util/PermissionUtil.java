package com.lxy.music.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.lxy.music.base.BaseActivity;
import com.lxy.music.base.BaseApplication;

import java.util.ArrayList;

/**
 * Created by lxy on 2017/4/26.
 */

public class PermissionUtil {

    public static final int PERMISSION_REQ_CODE = 100;

    /**
     * 判断是否具备所有权限
     *
     * @param permissions
     * @return
     */
    public static boolean isHasPermissions(String... permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;
        for (String permission : permissions) {
            if (!isHasPermission(permission))
                return false;
        }
        return true;
    }

    /**
     * 判断该权限是否已经被授予
     *
     * @param permission
     * @return
     */
    private static boolean isHasPermission(String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;
        return ContextCompat.checkSelfPermission(BaseApplication.getInstance().getApplicationContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 请求权限
     */
    public static void requestPermissions(Object object, int requestCode, String... permissions) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String permission : permissions) {
            if (!isHasPermissions(permission)) {
                arrayList.add(permission);
            }
        }
        if (arrayList.size() > 0) {
            if (object instanceof Activity) {
                Activity activity = (Activity) object;
                Activity activity1 = activity.getParent() != null && activity.getParent() instanceof BaseActivity ? activity.getParent() : activity;
                ActivityCompat.requestPermissions(activity1, arrayList.toArray(new String[]{}), requestCode);
            } else if (object instanceof Fragment) {
                Fragment fragment = (Fragment) object;
                //当Fragment嵌套Fragment时使用getParentFragment(),然后在父Fragment进行分发，否则回调不执行
                Fragment fragment1 = fragment.getParentFragment() != null ? fragment.getParentFragment() : fragment;
                fragment1.requestPermissions(arrayList.toArray(new String[]{}), requestCode);
            } else {
                throw new RuntimeException("the object must be Activity or Fragment");
            }
        }
    }

    /**
     * 展示自定义UI提示用户申请该权限
     *
     * @param object
     * @param permissions
     * @return
     */
    public static boolean shouldShowRequestPermissionRationale(@NonNull Object object, String... permissions) {
        for (String permission : permissions) {
            if (object instanceof Activity) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, permission)) {
                    return true;
                }
            } else if (object instanceof Fragment) {
                if (((Fragment) object).shouldShowRequestPermissionRationale(permission)) {
                    return true;
                }
            } else {
                throw new RuntimeException("the object must be Activity or Fragment");
            }


        }
        return false;
    }

    /**
     * 二次申请权限时，弹出自定义提示对话框
     */
    public static void showDialog(Activity activity, String message, final IPermissionRequest iPermissionRequest) {
        new AlertDialog.Builder(activity)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        iPermissionRequest.agree();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        iPermissionRequest.refuse();
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .setMessage(message)
                .show();
    }

    public interface IPermissionRequest {
        void agree();

        void refuse();
    }

}
