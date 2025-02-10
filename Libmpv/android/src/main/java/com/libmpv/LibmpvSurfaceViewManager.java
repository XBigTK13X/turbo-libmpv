package com.libmpv;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.LibmpvSurfaceViewManagerInterface;
import com.facebook.react.viewmanagers.LibmpvSurfaceViewManagerDelegate;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = LibmpvSurfaceViewManager.REACT_CLASS)
class LibmpvSurfaceViewManager extends SimpleViewManager<LibmpvSurfaceView> implements LibmpvSurfaceViewManagerInterface<ReactWebView> {

    private final LibmpvSurfaceViewManagerDelegate<LibmpvSurfaceView, LibmpvSurfaceViewManager> delegate
            = new LibmpvSurfaceViewManagerDelegate<>(this);

    @Override
    public ViewManagerDelegate<LibmpvSurfaceView> getDelegate() {
        return delegate;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public LibmpvSurfaceView createViewInstance(ThemedReactContext context) {
        return new ReactWebView(context);
    }

    @ReactProp(name = "sourceUrl")
    @Override
    public void setSourceURL(LibmpvSurfaceView view, String sourceURL) {
        if (sourceURL == null) {
            return;
        }
        view.loadUrl(sourceURL, new HashMap<>());
    }

    public static final String REACT_CLASS = "LibmpvSurfaceView";

    @Override
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> bubblingMap = new HashMap<>();
        bubblingMap.put("phasedRegistrationNames", new HashMap<String, String>() {
            {
                put("bubbled", "onScriptLoaded");
                put("captured", "onScriptLoadedCapture");
            }
        });
        map.put("onScriptLoaded", bubblingMap);
        return map;
    }
}
