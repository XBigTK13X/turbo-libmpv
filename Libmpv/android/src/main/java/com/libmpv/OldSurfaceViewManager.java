package com.libmpv;

import android.graphics.Color;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import dev.jdtech.mpv.MPVLib;
import java.util.Map;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class LibmpvSurfaceViewManager extends SimpleViewManager<SurfaceView> {

    public static final String REACT_CLASS = "LibmpvSurfaceView";

    @Override
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    @NonNull
    public SurfaceView createViewInstance(ThemedReactContext reactContext) {
        return new SurfaceView(reactContext);
    }

    @ReactProp(name = "playUrl")
    public void register(SurfaceView view, String playUrl) {
        ThemedReactContext reactContext = (ThemedReactContext) view.getContext();
        DeviceEventManagerModule.RCTDeviceEventEmitter reactEventEmitter = reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        LibmpvWrapper.getInstance().defaultSetup(view);
        LibmpvWrapper.getInstance().addEventObserver(new MPVLib.EventObserver() {
            @Override
            public void eventProperty(@NonNull String property) {
                WritableMap event = Arguments.createMap();
                event.putString("property", property);
                event.putString("kind", "none");
                reactEventEmitter.emit("libmpv", event);
            }

            @Override
            public void eventProperty(@NonNull String property, long value) {
                WritableMap event = Arguments.createMap();
                event.putString("property", property);
                event.putString("kind", "long");
                event.putString("value", "" + value);
                reactEventEmitter.emit("libmpv", event);
            }

            @Override
            public void eventProperty(@NonNull String property, double value) {
                WritableMap event = Arguments.createMap();
                event.putString("property", property);
                event.putString("kind", "double");
                event.putString("value", "" + value);
                reactEventEmitter.emit("libmpv", event);
            }

            @Override
            public void eventProperty(@NonNull String property, boolean value) {
                WritableMap event = Arguments.createMap();
                event.putString("property", property);
                event.putString("value", value ? "true" : "false");
                event.putString("kind", "boolean");
                reactEventEmitter.emit("libmpv", event);
            }

            @Override
            public void eventProperty(@NonNull String property, @NonNull String value) {
                WritableMap event = Arguments.createMap();
                event.putString("property", property);
                event.putString("value", value);
                event.putString("kind", "string");
                reactEventEmitter.emit("libmpv", event);
            }

            @Override
            public void event(@MPVLib.Event int eventId) {
                WritableMap event = Arguments.createMap();
                event.putString("eventId", "" + eventId);
                event.putString("kind", "eventId");
                reactEventEmitter.emit("libmpv", event);
            }
        });
        LibmpvWrapper.getInstance().play(playUrl);
    }
}
