package com.rnbindingsample.textfield;

import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNodeAPI;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;


public class MyTextFieldManager extends SimpleViewManager<SeekBar> {

    private static final String REACT_CLASS = "MyTextView";

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
                SeekBar reactSlider = new SeekBar(getThemedContext());
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
    protected SeekBar createViewInstance(ThemedReactContext context) {
        return new SeekBar(context);
    }
}