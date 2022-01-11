package com.example.easyframe.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.easyframe.R;


/**
 * Created by guogansheng on 2017/12/25.
 */
public class EasyStateRelaView extends RelativeLayout {

    private static final float DEFAULT_PRESS_ALPHA_RATIO = 0.5f;

    private float mDefaultAlpha = 1.0f;
    private float mPressAlphaRatio;

    public EasyStateRelaView(Context context) {
        this(context, null);
    }

    public EasyStateRelaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyStateRelaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray typedArray = context.obtainStyledAttributes(
                attrs, R.styleable.EasyBaseUIStateImageView, defStyleAttr, 0);

        mPressAlphaRatio = typedArray.getFloat(
            R.styleable.EasyBaseUIStateImageView_easyBaseUIStateImageView_pressAlphaRatio, DEFAULT_PRESS_ALPHA_RATIO);

        typedArray.recycle();
    }

    public void setDefaultAlpha(float alpha) {
        mDefaultAlpha = alpha;

        updateAlpha(false);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        boolean isPressed = false;

        final int[] states = getDrawableState();
        if (states != null) {
            for (int state : states) {
                if (state == android.R.attr.state_pressed) {
                    isPressed = true;
                    break;
                }
            }
        }

        updateAlpha(isPressed);
    }

    private void updateAlpha(boolean isPressed) {
        if (isPressed || !isEnabled()) {
            setAlpha(mDefaultAlpha * mPressAlphaRatio);
        } else {
            setAlpha(mDefaultAlpha);
        }
    }
}
