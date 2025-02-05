package com.libmpv;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;

public class ReactWebView extends WebView {

    public ReactWebView(Context context) {
        super(context);
        configureComponent();
    }

    public ReactWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        configureComponent();
    }

    public ReactWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        configureComponent();
    }

    private void configureComponent() {
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        this.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                emitOnScriptLoaded(OnScriptLoadedEventResult.success);
            }
        });
    
}
