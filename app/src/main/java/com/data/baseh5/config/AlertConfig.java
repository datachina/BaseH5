package com.data.baseh5.config;


import android.view.Gravity;

import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.util.TextInfo;

/**
 * @author jidaojiuyou
 * @date 2021-04-23
 * @since 2021-04-23
 */
public class AlertConfig {
    public static void init() {
        TextInfo textInfo = new TextInfo();
        textInfo.setGravity(Gravity.START);
        //是否开启模态窗口模式，一次显示多个对话框将以队列形式一个一个显示，默认关闭
        DialogSettings.modalDialog = true;
        // 全局正文样式
        DialogSettings.contentTextInfo = textInfo;
        //全局主题风格，提供三种可选风格，STYLE_MATERIAL, STYLE_KONGZUE, STYLE_IOS, STYLE_MIUI
        DialogSettings.style = DialogSettings.STYLE.STYLE_IOS;
        //全局对话框默认是否可以点击外围遮罩区域或返回键关闭，此开关不影响提示框（TipDialog）以及等待框（TipDialog）
        DialogSettings.cancelable = false;
        //全局提示框及等待框（WaitDialog、TipDialog）默认是否可以关闭
        DialogSettings.cancelableTipDialog = false;
        //是否允许打印日志
        DialogSettings.DEBUGMODE = true;
        //初始化清空 BaseDialog 队列
        DialogSettings.init();
    }
}