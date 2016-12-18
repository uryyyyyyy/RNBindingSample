package com.rnbindingsample.slider;

import android.util.Log;
import android.widget.EditText;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MyEditTextManager extends SimpleViewManager<EditText> {

    private static final String REACT_CLASS = "MyEditText";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected EditText createViewInstance(ThemedReactContext context) {
        return new EditText(context);
    }

    @ReactProp(name = "value")
    public void setValue(EditText view, String value) {
        Log.w("myTag", "" + value);
        view.setText(value);
    }
}