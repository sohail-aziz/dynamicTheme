package com.example.sohailaziz.dynamictheming;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.airbnb.paris.Paris;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    Toolbar toolbar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        button = findViewById(R.id.button);


        updateTheme();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTheme();
            }
        });


    }

    private void updateTheme() {
        int themeColorPrimary = getColor();

        getWindow().setStatusBarColor(getColor());

        Paris.styleBuilder(toolbar)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

        setSupportActionBar(toolbar);


        Paris.styleBuilder(button)
                .background(new ColorDrawable(themeColorPrimary))
                .apply();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private int getColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

}
