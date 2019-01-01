package com.example.sohailaziz.dynamictheming;

import android.graphics.Color;

import java.util.Random;

public class ThemeColors {

    public static int colorPrimary(){
        return getColor();
    }
    public static int buttonTextColor(){
        return getColor();
    }
    public static int buttonBackgroundTint(){
        return getColor();
    }
    public static int buttonOutlineColor(){
        return getColor();
    }
    public static int textColor(){
        return getColor();
    }

    private static int getColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
