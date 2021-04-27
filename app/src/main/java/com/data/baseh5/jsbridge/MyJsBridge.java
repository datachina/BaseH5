package com.data.baseh5.jsbridge;

import android.content.Context;

import com.tencent.smtt.sdk.WebView;

/**
 * @author jidaojiuyou
 * @date 2021-04-23
 * @since 2021-04-23
 */
public class MyJsBridge {
    /**
     * Context
     */
    private final Context context;
    /**
     * WebView
     */
    private final WebView webView;

    public MyJsBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }
}