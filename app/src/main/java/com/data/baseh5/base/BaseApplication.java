package com.data.baseh5.base;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jidaojiuyou
 * @date 2021-04-22
 * @since 2021-04-22
 */
public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        // dex2oat
        Map<String, Object> map = new HashMap<>(2);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
        // 允许流量下载核心
        QbSdk.setDownloadWithoutWifi(true);
        // 加载内核回调
        QbSdk.PreInitCallback preInitCallback = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.i(TAG, "内核核心初始化完成");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.e(TAG, "内核初始化成功:" + b);
            }
        };
        // 加载内核
        if (!QbSdk.isTbsCoreInited()) {
            QbSdk.initX5Environment(this, preInitCallback);
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }
}