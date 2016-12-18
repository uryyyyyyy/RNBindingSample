package com.rnbindingsample.slider;

import android.util.Log;
import android.widget.TextView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MyTextViewManager extends SimpleViewManager<TextView> {

    private static final String REACT_CLASS = "MyTextView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected TextView createViewInstance(ThemedReactContext context) {
        return new TextView(context);
    }

    @ReactProp(name = "value")
    public void setValue(TextView view, String value) {
        view.setText(value);
    }
}