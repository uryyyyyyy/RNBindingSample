package com.rnbindingsample.slider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

public class MyEditTextManager extends SimpleViewManager<EditText> {

    private static final String MY_EVENT_NAME = "myOnChangeEvent";

    private static final String REACT_CLASS = "MyEditText";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected EditText createViewInstance(ThemedReactContext context) {
        final EditText view = new EditText(context);

        view.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(final Editable s) {
                ReactContext reactContext = (ReactContext) view.getContext();
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new Event(view.getId()) {
                            @Override
                            public String getEventName() {
                                return MY_EVENT_NAME;
                            }

                            @Override
                            public void dispatch(RCTEventEmitter rctEventEmitter) {
                                WritableMap eventData = Arguments.createMap();
                                eventData.putString("value", s.toString());
                                rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
                            }
                        });
            }
        });
        return view;
    }

    @ReactProp(name = "value")
    public void setValue(EditText view, String value) {
        view.setText(value);
    }

    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(MY_EVENT_NAME, MapBuilder.of("registrationName", "myChange"));
    }
}