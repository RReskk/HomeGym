package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hello3 extends AppCompatActivity {

    ImageView man_image;
    ImageView woman_image;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    String gender;
    String value;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    Intent intent;

    private final String genderPref = "gender";
    private final String Work = "work";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Init();
        Button[] buttons = {button1, button2, button3, button4};

        if (gender.equals("male")) {
            man_image.setVisibility(View.VISIBLE);
        }
        else if (gender.equals("female")) {
            woman_image.setVisibility(View.VISIBLE);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button1, buttons);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button2, buttons);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button3, buttons);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button4, buttons);
            }
        });
    }

    private void ChangeColor(Button pushedBtn, Button[] mas) {
        for (Button btn : mas) {
            if (btn.equals(pushedBtn)) {
                btn.setBackgroundResource(R.drawable.custom_golden_element);
                value = btn.getText().toString();
                edit.putString(Work, value);
                edit.apply();
            } else
                btn.setBackgroundResource(R.drawable.custom_element);
            startActivity(intent);
        }
    }

    private void Init() {
        man_image = findViewById(R.id.man_shadow);
        woman_image = findViewById(R.id.woman_shadow);
        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
        gender = pref.getString(genderPref, "");

        button1 = findViewById(R.id.handsButton);
        button2 = findViewById(R.id.spineButton);
        button3 = findViewById(R.id.torsoButton);
        button4 = findViewById(R.id.legsButton);

        intent = new Intent(Hello3.this, Hello4.class);
    }
}