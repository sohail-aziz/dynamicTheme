package com.example.sohailaziz.dynamictheming;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.paris.Paris;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main3ActivityFragment extends Fragment {


    Button button;
    ProgressButton progressButton;

    TextView textViewHeadingOne, textViewHeadingTwo;

    public Main3ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressButton=view.findViewById(R.id.progressbutton);
        textViewHeadingOne = view.findViewById(R.id.textview_heading_one);
        textViewHeadingTwo = view.findViewById(R.id.textview_heading_two);
        button = view.findViewById(R.id.buttonLogin);
        view.findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTheme();
            }
        });

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressButton.startProgress();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton.stopProgress();
                    }
                },2000);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateTheme();
    }

    private void updateTheme() {
        int themeColorPrimary = getColor();

        getActivity().getWindow().setStatusBarColor(getColor());

        Toolbar toolbar = getActivityToolbar();
        Paris.styleBuilder(toolbar)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

        setActivityToolbar(toolbar);


        Paris.styleBuilder(button)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

        Paris.styleBuilder(textViewHeadingOne)
                .textColor(getColor())
                .apply();

        Paris.styleBuilder(textViewHeadingTwo)
                .textColor(getColor())
                .apply();

    }

    private Toolbar getActivityToolbar() {
        return ((Main3Activity) getActivity()).getToolbar();
    }

    private void setActivityToolbar(Toolbar toolbar) {
        ((Main3Activity) getActivity()).setToolbar(toolbar);
    }

    private int getColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
