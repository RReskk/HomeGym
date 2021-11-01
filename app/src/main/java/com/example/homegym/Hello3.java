package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Hello3 extends AppCompatActivity {

    ImageView man_image;
    ImageView woman_image;
    SharedPreferences pref;
    String gender;
    private final String genderPref = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Init();

        if (gender.equals("male")) {
            man_image.setVisibility(View.VISIBLE);
        }
        else if (gender.equals("female")) {
            woman_image.setVisibility(View.VISIBLE);
        }
    }

    private void Init() {
        man_image = findViewById(R.id.man_shadow);
        woman_image = findViewById(R.id.woman_shadow);
        pref = getSharedPreferences("Values", MODE_PRIVATE);
        gender = pref.getString(genderPref, "");
    }
}