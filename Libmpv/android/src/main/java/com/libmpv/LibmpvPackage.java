package com.libmpv;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.BaseReactPackage;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class LibmpvPackage extends BaseReactPackage {

  @Nullable
  @Override
  public NativeModule getModule(String name, ReactApplicationContext reactContext) {
     if (name.equals(CalculatorModule.NAME)) {
         return new CalculatorModule(reactContext);
     } else {
          return null;
     }
  }


  @Override
  public ReactModuleInfoProvider getReactModuleInfoProvider() {
     return null;
     return () -> {
         final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
         moduleInfos.put(
                 CalculatorModule.NAME,
                 new ReactModuleInfo(
                         CalculatorModule.NAME,
                         CalculatorModule.NAME,
                         false, // canOverrideExistingModule
                         false, // needsEagerInit
                         false, // isCxxModule
                         true // isTurboModule
         ));
         return moduleInfos;
     };
  }
}