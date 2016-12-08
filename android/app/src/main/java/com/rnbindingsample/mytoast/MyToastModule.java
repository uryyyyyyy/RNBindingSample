package com.rnbindingsample.mytoast;

import android.view.Gravity;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;

import java.util.Map;

public class MyToastModule extends ReactContextBaseJavaModule {

    public MyToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "MyToastAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = MapBuilder.newHashMap();
        constants.put("SHORT", Toast.LENGTH_SHORT);
        constants.put("LONG", Toast.LENGTH_LONG);
        constants.put("TOP", Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        constants.put("BOTTOM", Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        constants.put("CENTER", Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        return constants;
    }

    @ReactMethod
    public void show(final String message, final int duration) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getReactApplicationContext(), message, duration).show();
            }
        });
    }

    @ReactMethod
    public void showWithCallback(final String message, final int duration, final Callback callback) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getReactApplicationContext(), message, duration).show();
                callback.invoke("callback");
            }
        });
    }
}
