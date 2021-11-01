package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

public class Hello3 extends AppCompatActivity {

    ImageView image;
    SharedPreferences pref;
    String gender;
    private final String genderPref = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Init();
    }

    private void Init() {
//        пока что не работает
//        image = findViewById(R.id.shadow);
//        pref = getSharedPreferences("Values", MODE_PRIVATE);
//        gender = pref.getString(genderPref, "null");
//
//        if (gender.equals("male")) {
//            image.setBackgroundResource(R.drawable.male);
//        }
//        else {
//            image.setBackgroundResource(R.drawable.female);
//        }
    }
}