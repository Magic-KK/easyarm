package com.example.easyframe.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by tamrylei on 2018/1/17.
 */
public class EasyStateTextView extends AppCompatTextView {

    public EasyStateTextView(Context context) {
        super(context);
    }

    public EasyStateTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EasyStateTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        if (isPressed() || !isEnabled()) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
    }
}
