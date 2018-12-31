package com.example.sohailaziz.dynamictheming;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

        button = view.findViewById(R.id.buttonLogin);
        view.findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTheme();
            }
        });
    }

    private void updateTheme() {
        int themeColorPrimary = getColor();

        getActivity().getWindow().setStatusBarColor(getColor());

        Toolbar toolbar=getActivityToolbar();
        Paris.styleBuilder(toolbar)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

        setActivityToolbar(toolbar);


        Paris.styleBuilder(button)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

    }

    private Toolbar getActivityToolbar() {
       return  ((Main3Activity)getActivity()).getToolbar();
    }

    private void setActivityToolbar(Toolbar toolbar) {
        ((Main3Activity) getActivity()).setToolbar(toolbar);
    }

    private int getColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
