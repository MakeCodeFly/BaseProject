package com.zoujuequn.baseproject.utils;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


/**
 * 安装下载接收器
 * Created by MakeCodeFly
 */

public class AppInstallReceiver extends BroadcastReceiver {


    // 安装下载接收器
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            long downloadApkId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            installApk(context, downloadApkId);
        }
    }

    // 安装Apk
    private void installApk(Context context, long downloadApkId) {

        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            String filePath = UpdateAppManager.APP_FILE_NAME;
            i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}