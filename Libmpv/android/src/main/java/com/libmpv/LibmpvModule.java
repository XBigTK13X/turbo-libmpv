package com.libmpv;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import com.rtncalculator.NativeRTNCalculatorSpec;

public class LibmpvModule extends NativeRTNCalculatorSpec {

    public static String NAME = "Libmpv";

    LibmpvrModule(ReactApplicationContext context) {
        super(context);
        LibmpvWrapper.getInstance().setContext(context);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public void create(Promise promise) {
        LibmpvWrapper.getInstance().create();
        promise.resolve(true);
    }

    @Override
    public void setOptionString(String option, String setting, Promise promise) {
        LibmpvWrapper.getInstance().setOptionString(option, setting);
        promise.resolve(true);
    }

    @Override
    public void useDefaultOptions(Promise promise) {
        LibmpvWrapper.getInstance().useDefaultOptions();
        promise.resolve(true);
    }

    @Override
    public void init(Promise promise) {
        LibmpvWrapper.getInstance().init();
        promise.resolve(true);
    }

    @Override
    public void command(String[] orders, Promise promise) {
        LibmpvWrapper.getInstance().command(orders);
        promise.resolve(true);
    }

    public void attachSurface(SurfaceView surfaceView, Promise promise) {
        LibmpvWrapper.getInstance().attachSurface(surfaceView);
        promise.resolve(true);
    }

    public void defaultSetup(SurfaceView surfaceView, Promise promise) {
        LibmpvWrapper.getInstance().defaultSetup(surfaceView);
        promise.resolve(true);
    }

    @Override
    public void play(String url, Promise promise) {
        LibmpvWrapper.getInstance().play(url);
        promise.resolve(true);
    }

    @Override
    public void destroy(Promise promise) {
        LibmpvWrapper.getInstance().destroy();
        promise.resolve(true);
    }

    @Override
    public void detachSurface(Promise promise) {
        LibmpvWrapper.getInstance().detachSurface();
        promise.resolve(true);
    }

    @Override
    public void cleanup(Promise promise) {
        LibmpvWrapper.getInstance().cleanup();
        promise.resolve(true);
    }
}
