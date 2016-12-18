package com.rnbindingsample.slider;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNodeAPI;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Manages instances of {@code ReactSlider}.
 *
 * Note that the slider is _not_ a controlled component.
 */
public class URYReactSliderManager extends SimpleViewManager<SeekBar> {

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
        public long measure(
                CSSNodeAPI node,
                float width,
                CSSMeasureMode widthMode,
                float height,
                CSSMeasureMode heightMode) {
            if (!mMeasured) {
                SeekBar reactSlider = new SeekBar(getThemedContext(), null, STYLE);
                final int spec = View.MeasureSpec.makeMeasureSpec(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        View.MeasureSpec.UNSPECIFIED);
                reactSlider.measure(spec, spec);
                mWidth = reactSlider.getMeasuredWidth();
                mHeight = reactSlider.getMeasuredHeight();
                mMeasured = true;
            }

            return MeasureOutput.make(mWidth, mHeight);
        }
    }

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
    protected SeekBar createViewInstance(ThemedReactContext context) {
        return new SeekBar(context, null, STYLE);
    }

    @ReactProp(name = "value", defaultDouble = 0d)
    public void setValue(SeekBar view, double value) {
        Log.w("myTag", "" + value);
    }
}