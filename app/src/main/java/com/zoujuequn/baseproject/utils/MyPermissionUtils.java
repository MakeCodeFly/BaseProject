package com.zoujuequn.baseproject.utils;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;


import com.zoujuequn.baseproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 6.0权限申请帮助类
 *     email:15695947865@139.com
 * 使用：
MyPermissionUtils.requestMultiPermissions(this,mPermissionGrant);

  @Override
public void onRequestPermissionsResult(final int requestCode, @NonNull String[] permissions,
@NonNull int[] grantResults) {
MyPermissionUtils.requestPermissionsResult(this, requestCode, permissions, grantResults, mPermissionGrant);
}
private MyPermissionUtils.PermissionGrant mPermissionGrant = new MyPermissionUtils.PermissionGrant() {
@Override public void onPermissionGranted(int requestCode) {
switch (requestCode) {
case MyPermissionUtils.CODE_MULTI_PERMISSION:
break;
default:
break;
}
}
};
 @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
switch (requestCode) {
case MyPermissionUtils.REQUEST_CODE_SETTING: {
newPermission();
break;
}
}
}
 */
public class MyPermissionUtils {

    private static final String TAG = MyPermissionUtils.class.getSimpleName();
    public static final int CODE_READ_EXTERNAL_STORAGE = 0;
    public static final int CODE_READ_PHONE_STATE = 1;
    public static final int CODE_WRITE_EXTERNAL_STORAGE = 2;
    public static final int CODE_RECORD_AUDIO = 3;
    public static final int CODE_ACCESS_FINE_LOCATION = 4;
    public static final int CODE_ACCESS_COARSE_LOCATION = 5;
    public static final int CODE_CALL_PHONE = 6;
    public static final int CODE_CAMERA = 7;
    public static final int CODE_MULTI_PERMISSION = 0x22;
    public static final int REQUEST_CODE_SETTING = 0x33;


    public static final String PERMISSION_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String PERMISSION_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String PERMISSION_ACCESS_FINE_LOCATION= Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String PERMISSION_ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;


    private static final String[] requestPermissions = {
            PERMISSION_READ_EXTERNAL_STORAGE,
            PERMISSION_READ_PHONE_STATE,
            PERMISSION_WRITE_EXTERNAL_STORAGE,
            PERMISSION_RECORD_AUDIO,
            PERMISSION_ACCESS_FINE_LOCATION,
            PERMISSION_ACCESS_COARSE_LOCATION,
            PERMISSION_CALL_PHONE,
            PERMISSION_CAMERA,
    };

    public interface PermissionGrant {
        void onPermissionGranted(int requestCode);
    }

    /**
     * Requests permission.
     *
     * @param activity
     * @param requestCode request code, e.g. if you need request CAMERA permission,parameters is PermissionUtils.CODE_CAMERA
     */
    public static void requestPermission(final Activity activity, final int requestCode, PermissionGrant permissionGrant) {
        if (activity == null) {
            return;
        }
        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            return;
        }

        final String requestPermission = requestPermissions[requestCode];
        int checkSelfPermission;
        try {
            checkSelfPermission = ActivityCompat.checkSelfPermission(activity, requestPermission);
        } catch (RuntimeException e) {
            return;
        }

        if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, requestPermission)) {
                shouldShowRationale(activity, requestCode, requestPermission);

            } else {
                ActivityCompat.requestPermissions(activity, new String[]{requestPermission}, requestCode);
            }

        } else {
            permissionGrant.onPermissionGranted(requestCode);
        }
    }

    private static void requestMultiResult(Activity activity, String[] permissions, int[] grantResults, PermissionGrant permissionGrant) {

        if (activity == null) {
            return;
        }

        Map<String, Integer> perms = new HashMap<>();

        ArrayList<String> notGranted = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            perms.put(permissions[i], grantResults[i]);
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                notGranted.add(permissions[i]);
            }
        }

        if (notGranted.size() == 0) {
            permissionGrant.onPermissionGranted(CODE_MULTI_PERMISSION);
        } else {
            openSettingActivity(activity, activity.getResources().getString(R.string.no_permission));
        }

    }


    /**
     * 一次申请多个权限
     */
    public static void requestMultiPermissions(final Activity activity, PermissionGrant grant) {

        final List<String> permissionsList = getNoGrantedPermission(activity, false);
        final List<String> shouldRationalePermissionsList = getNoGrantedPermission(activity, true);

        //TODO checkSelfPermission
        if (permissionsList == null || shouldRationalePermissionsList == null) {
            return;
        }

        if (permissionsList.size() > 0) {
            ActivityCompat.requestPermissions(activity, permissionsList.toArray(new String[permissionsList.size()]),
                    CODE_MULTI_PERMISSION);

        } else if (shouldRationalePermissionsList.size() > 0) {
            showMessageOKCancel(activity, "should open those permission",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(activity, shouldRationalePermissionsList.toArray(new String[shouldRationalePermissionsList.size()]),
                                    CODE_MULTI_PERMISSION);
                        }
                    });
        } else {
            grant.onPermissionGranted(CODE_MULTI_PERMISSION);
        }

    }


    private static void shouldShowRationale(final Activity activity, final int requestCode, final String requestPermission) {
        //TODO
        showMessageOKCancel(activity, activity.getResources().getString(R.string.no_permission), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{requestPermission},
                        requestCode);
            }
        });
    }

    private static void showMessageOKCancel(final Activity context, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("确定", okListener)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.finish();
                    }
                })
                .create()
                .show();

    }

    /**
     * @param activity
     * @param requestCode  Need consistent with requestPermission
     * @param permissions
     * @param grantResults
     */
    public static void requestPermissionsResult(final Activity activity, final int requestCode, @NonNull String[] permissions,
                                                @NonNull int[] grantResults, PermissionGrant permissionGrant) {

        if (activity == null) {
            return;
        }

        if (requestCode == CODE_MULTI_PERMISSION) {
            requestMultiResult(activity, permissions, grantResults, permissionGrant);
            return;
        }

        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            return;
        }

        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //TODO success, do something, can use callback
            permissionGrant.onPermissionGranted(requestCode);

        } else {
            //TODO hint user this permission function
            openSettingActivity(activity, "Result" + activity.getResources().getString(R.string.no_permission));
        }

    }

    private static void openSettingActivity(final Activity activity, String message) {

        showMessageOKCancel(activity, message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivityForResult(intent,REQUEST_CODE_SETTING);
            }
        });
    }


    /**
     * @param activity
     * @param isShouldRationale true: return no granted and shouldShowRequestPermissionRationale permissions, false:return no granted and !shouldShowRequestPermissionRationale
     * @return
     */
    public static ArrayList<String> getNoGrantedPermission(Activity activity, boolean isShouldRationale) {

        ArrayList<String> permissions = new ArrayList<>();

        for (int i = 0; i < requestPermissions.length; i++) {
            String requestPermission = requestPermissions[i];
            //TODO checkSelfPermission
            int checkSelfPermission = -1;
            try {
                checkSelfPermission = ActivityCompat.checkSelfPermission(activity, requestPermission);
            } catch (RuntimeException e) {
                return null;
            }

            if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, requestPermission)) {
                    if (isShouldRationale) {
                        permissions.add(requestPermission);
                    }

                } else {
                    if (!isShouldRationale) {
                        permissions.add(requestPermission);
                    }
                }

            }
        }

        return permissions;
    }

}
