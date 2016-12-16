package com.rnbindingsample.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by a URYReactSliderManager when user changes slider position.
 */
public class URYReactSliderEvent extends Event<URYReactSliderEvent> {

    public static final String EVENT_NAME = "topChange";

    private final double mValue;
    private final boolean mFromUser;

    public URYReactSliderEvent(int viewId, double value, boolean fromUser) {
        super(viewId);
        mValue = value;
        mFromUser = fromUser;
    }

    public double getValue() {
        return mValue;
    }

    public boolean isFromUser() {
        return mFromUser;
    }


    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }
    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("target", getViewTag());
        eventData.putDouble("value", getValue());
        eventData.putBoolean("fromUser", isFromUser());
        return eventData;
    }
}