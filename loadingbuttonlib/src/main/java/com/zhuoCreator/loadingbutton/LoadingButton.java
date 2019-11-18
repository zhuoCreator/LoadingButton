package com.zhuoCreator.loadingbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.loadingbuttonlib.R;

/*-------------------------------------------------------------------------
 * 作者：zhuoEr
 * 创建时间： 2019/11/5
 * 版本号：v1.0
 * 本类主要用途描述：
 *
 *-------------------------------------------------------------------------*/

/**
 * 带loading的button
 */
public class LoadingButton extends FrameLayout {

    private Drawable loadingButton_loadingButton_drawableLeft;
    private float loadingButton_loadingButton_drawablePadding;

    public LoadingButton(@NonNull Context context) {
        super(context);
        init(null, 0);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleRes);
    }

    @Override
    public void setEnabled(boolean enabled) {
        app_button_layout.setEnabled(enabled);
        super.setEnabled(enabled);
    }

    TextView app_button_text;
    ProgressBar app_button_loading;
    FrameLayout app_button_layout;

    private void init(AttributeSet attrs, int defStyleRes) {
        loadAttributes(attrs, defStyleRes);
        LayoutInflater.from(getContext()).inflate(R.layout.my_loading_button_layout, this, true);
        app_button_layout = findViewById(R.id.app_button_layout);
        app_button_text = findViewById(R.id.app_button_text);
        app_button_loading = findViewById(R.id.app_button_loading);
        app_button_text.setText(text);
        app_button_text.setTextColor(textColor);

        if (loadingButton_loadingButton_drawablePadding != 0) {
            app_button_text.setCompoundDrawablePadding((int) loadingButton_loadingButton_drawablePadding);
        }
        if (loadingButton_loadingButton_drawableLeft != null) {
            app_button_text.setCompoundDrawablesWithIntrinsicBounds(loadingButton_loadingButton_drawableLeft, null, null, null);
        }

        app_button_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        app_button_text.setEnabled(isEnabled());
        app_button_layout.setBackgroundResource(background);
    }

    private CharSequence text;
    private ColorStateList textColor;
    private float textSize;
    private int background;

    public void setTextColor(int textColor) {
        if (app_button_text == null) return;
        app_button_text.setTextColor(textColor);
    }

    public void setBackgroundResource(int backgroundResource) {
        if (app_button_layout == null) return;
        app_button_layout.setBackgroundResource(backgroundResource);
    }

    public void setText(CharSequence text) {
        this.text = text;
        app_button_text.setText(text);
    }

    public String getText() {
        if (app_button_text == null) return "";
        return app_button_text.getText().toString().trim();
    }


    public void startLoading() {
        if (app_button_text != null) app_button_text.setVisibility(INVISIBLE);
        if (app_button_loading != null) app_button_loading.setVisibility(VISIBLE);
        setEnabled(false);

    }

    public void stopLoading() {
        if (app_button_text != null) app_button_text.setVisibility(VISIBLE);
        if (app_button_loading != null) app_button_loading.setVisibility(GONE);
        setEnabled(true);
    }

    private void loadAttributes(AttributeSet attrs, int defStyleRes) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingButton, defStyleRes, 0);
        text = a.getText(R.styleable.LoadingButton_LoadingButton_text);
        textColor = a.getColorStateList(R.styleable.LoadingButton_LoadingButton_textColor);
        if (textColor == null) {
            textColor = new ColorStateList(new int[][]{{android.R.attr.state_enabled}}, new int[]{Color.WHITE});
        }
        textSize = a.getDimensionPixelSize(R.styleable.LoadingButton_LoadingButton_textSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics()));
        background = a.getResourceId(R.styleable.LoadingButton_LoadingButton_background, R.drawable.gradient_btn_shape);
        loadingButton_loadingButton_drawableLeft = a.getDrawable(R.styleable.LoadingButton_LoadingButton_drawableLeft);

        loadingButton_loadingButton_drawablePadding = a.getDimension(R.styleable.LoadingButton_LoadingButton_drawablePadding, 0);
        a.recycle();
    }
}
