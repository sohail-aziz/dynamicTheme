package com.example.sohailaziz.dynamictheming;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.airbnb.paris.Paris;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


/**
 * Created by sohailaziz on 29/5/18.
 */

public class ProgressButton extends FrameLayout {

    private static final int UNDEFINED = -1;

    @Px
    private static final int DEFAULT_STROKE_WIDTH = 3; //PX

    FrameLayout progressLayout;
    Button progressButton;
    ProgressBar progressBar;

    public ProgressButton(Context context) {
        super(context);
        init(context, null);
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        final View view = LayoutInflater.from(context).inflate(R.layout.custom_progress_button, this);
        bindViews(view);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressButton);

            String buttonTitle = typedArray.getString(R.styleable.ProgressButton_buttonText);


            @DimenRes final int outlineWidth =
                    typedArray.getDimensionPixelSize(R.styleable.ProgressButton_buttonOutlineWidth,
                            DEFAULT_STROKE_WIDTH
                    );

            @DrawableRes final int backgroundDrawableRes =
                    typedArray.getResourceId(R.styleable.ProgressButton_buttonBackground, UNDEFINED);

            //set text
            if (buttonTitle != null) {
                progressButton.setText(buttonTitle);
            }
            //set text color

            int textColor = ThemeColors.buttonTextColor();
            //progressButton.setTextColor(textColor);


            //set background
            int backgroundColor = ThemeColors.buttonBackgroundTint();
           /* if (backgroundDrawableRes != UNDEFINED) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), backgroundDrawableRes).mutate();
                //set background tint

                int backgroundColor = ThemeColors.buttonBackgroundTint;
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(drawable, backgroundColor);
                progressButton.setBackground(drawable);
            }*/

            //tint outline

            int outlineColor = ThemeColors.buttonOutlineColor();
            tintViewOutline(progressButton, outlineColor, outlineWidth);


            Paris.styleBuilder(progressButton)
                    .backgroundTint(backgroundColor)
                    .textColor(textColor)
                    .apply();
            typedArray.recycle();
        }

        setupDefaults();
    }

    private void bindViews(View view) {
        progressLayout = view.findViewById(R.id.progress_button_layout);
        progressButton = view.findViewById(R.id.progress_button);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void setupDefaults() {
        showButton();
        hideProgress();
    }

    public void startProgress() {
        hideButton();
        showProgress();
    }

    public void stopProgress() {
        hideProgress();
        showButton();
    }

    @Override
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        progressLayout.setOnClickListener(l);
    }

    private void hideProgress() {
        hide(progressBar);
    }

    private void showProgress() {
        show(progressBar);
    }

    private void hideButton() {
        hide(progressButton);
    }

    private void showButton() {
        show(progressButton);
    }

    private void hide(View view) {
        view.setVisibility(GONE);
    }

    private void show(View view) {
        view.setVisibility(VISIBLE);
    }

    public static void tintViewOutline(@NonNull View view, int color, int strokeWidth) {

        GradientDrawable drawable = (GradientDrawable) view.getBackground();
        if (drawable != null) {
            drawable.setStroke(strokeWidth, color); // set stroke width and stroke color
        }
    }
}
