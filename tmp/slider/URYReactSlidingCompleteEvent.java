package com.rnbindingsample.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted when the user finishes dragging the slider.
 */
public class URYReactSlidingCompleteEvent extends Event<URYReactSlidingCompleteEvent> {

    public static final String EVENT_NAME = "topSlidingComplete";

    private final double mValue;

    public URYReactSlidingCompleteEvent(int viewId, double value) {
        super(viewId);
        mValue = value;
    }

    public double getValue() {
        return mValue;
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
    public boolean canCoalesce() {
        return false;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("target", getViewTag());
        eventData.putDouble("value", getValue());
        return eventData;
    }

}