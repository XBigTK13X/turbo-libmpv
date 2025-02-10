package com.libmpv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;

public class LibmpvSurfaceView extends SurfaceView {

    private SurfaceView _surfaceView;
    private Context _context;

    public LibmpvSurfaceView(Context context) {
        super(context);
        _context = context;
        configureComponent();
    }

    public LibmpvSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _context = context;
        configureComponent();
    }

    public LibmpvSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _context = context;
        configureComponent();
    }

    private void configureComponent() {
        _surfaceView = new SurfaceView(_context);
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }
}
