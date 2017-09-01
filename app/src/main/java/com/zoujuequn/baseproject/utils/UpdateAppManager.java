package com.zoujuequn.baseproject.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

import java.io.File;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : UpdateAPPManager版本更新管理（支持后台下载）
 *     email:15695947865@139.com
 * </pre>
 */
@SuppressWarnings("unused")
public class UpdateAppManager {

    public final static String SAVE_APP_NAME = "YouMeiLi.apk";

    public final static String SAVE_APP_LOCATION = "/download";


    public final static String APP_FILE_NAME = "/sdcard"+SAVE_APP_LOCATION+ File.separator + SAVE_APP_NAME;


    /**
     * 下载Apk, 并设置Apk地址,
     * 默认位置: /storage/sdcard0/Download
     *
     * @param context    上下文
     * @param downLoadUrl 下载地址
     * @param infoName   通知名称
     * @param description  通知描述
     */
    @SuppressWarnings("unused")
    public static void downloadApk(
            Context context,
            String downLoadUrl,
            String description,
            String infoName) {

        if (!isDownloadManagerAvailable()) {
            return;
        }

        String appUrl = downLoadUrl;
        if (appUrl == null || appUrl.isEmpty()) {

            return;
        }
        appUrl = appUrl.trim(); // 去掉首尾空格

        DownloadManager.Request request;
        try {
            request = new DownloadManager.Request(Uri.parse(appUrl));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        request.setTitle(infoName);
        request.setDescription(description);

        //在通知栏显示下载进度
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        //sdcard目录下的download文件夹
        request.setDestinationInExternalPublicDir(SAVE_APP_LOCATION, SAVE_APP_NAME);

        Context appContext = context.getApplicationContext();
        DownloadManager manager = (DownloadManager)
                appContext.getSystemService(Context.DOWNLOAD_SERVICE);

        manager.enqueue(request);

    }

    // 最小版本号大于9
    private static boolean isDownloadManagerAvailable() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

}