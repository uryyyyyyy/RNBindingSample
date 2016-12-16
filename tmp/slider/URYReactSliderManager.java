package com.rnbindingsample.slider;

import java.util.Map;

import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNodeAPI;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Manages instances of {@code ReactSlider}.
 *
 * Note that the slider is _not_ a controlled component.
 */
public class URYReactSliderManager extends SimpleViewManager<URYReactSlider> {

    private static final int STYLE = android.R.attr.seekBarStyle;

    private static final String REACT_CLASS = "URYSlider";

    static class ReactSliderShadowNode extends LayoutShadowNode implements
            CSSNodeAPI.MeasureFunction {

        private int mWidth;
        private int mHeight;
        private boolean mMeasured;

        private ReactSliderShadowNode() {
            setMeasureFunction(this);
        }

        @Override
        public void measure(
                CSSNodeAPI node,
                float width,
                CSSMeasureMode widthMode,
                float height,
                CSSMeasureMode heightMode,
                MeasureOutput measureOutput) {
            if (!mMeasured) {
                SeekBar reactSlider = new URYReactSlider(getThemedContext(), null, STYLE);
                final int spec = View.MeasureSpec.makeMeasureSpec(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        View.MeasureSpec.UNSPECIFIED);
                reactSlider.measure(spec, spec);
                mWidth = reactSlider.getMeasuredWidth();
                mHeight = reactSlider.getMeasuredHeight();
                mMeasured = true;
            }
            measureOutput.width = mWidth;
            measureOutput.height = mHeight;
        }
    }

    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
                    ReactContext reactContext = (ReactContext) seekbar.getContext();
                    reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                            new URYReactSliderEvent(
                                    seekbar.getId(),
                                    ((URYReactSlider)seekbar).toRealProgress(progress),
                                    fromUser));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekbar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekbar) {
                    ReactContext reactContext = (ReactContext) seekbar.getContext();
                    reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                            new URYReactSlidingCompleteEvent(
                                    seekbar.getId(),
                                    ((URYReactSlider)seekbar).toRealProgress(seekbar.getProgress())));
                }
            };

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode();
    }

    @Override
    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    @Override
    protected URYReactSlider createViewInstance(ThemedReactContext context) {
        return new URYReactSlider(context, null, STYLE);
    }

    @ReactProp(name = ViewProps.ENABLED, defaultBoolean = true)
    public void setEnabled(URYReactSlider view, boolean enabled) {
        view.setEnabled(enabled);
    }

    @ReactProp(name = "value", defaultDouble = 0d)
    public void setValue(URYReactSlider view, double value) {
        view.setOnSeekBarChangeListener(null);
        view.setValue(value);
        view.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @ReactProp(name = "minimumValue", defaultDouble = 0d)
    public void setMinimumValue(URYReactSlider view, double value) {
        view.setMinValue(value);
    }

    @ReactProp(name = "maximumValue", defaultDouble = 1d)
    public void setMaximumValue(URYReactSlider view, double value) {
        view.setMaxValue(value);
    }

    @ReactProp(name = "step", defaultDouble = 0d)
    public void setStep(URYReactSlider view, double value) {
        view.setStep(value);
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final URYReactSlider view) {
        view.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
                URYReactSlidingCompleteEvent.EVENT_NAME,
                MapBuilder.of("registrationName", "onSlidingComplete"));
    }
}