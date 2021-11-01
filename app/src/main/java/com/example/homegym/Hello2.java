package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Hello2 extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    ImageButton femaleButton;
    ImageButton maleButton;
    Button next;
    private int gender_id;
    private final String gender = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        Init();

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(1);
                edit.putString(gender, "male");
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(2);
                edit.putString(gender, "female");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.apply();
                next.setBackgroundResource(R.drawable.custom_golden_element);
                Intent intent = new Intent(Hello2.this, Hello3.class);
                startActivity(intent);
            }
        });
    }

    private void ChangeColor(int gender_id) {
        if (gender_id == 1) {
            maleButton.setBackgroundResource(R.drawable.custom_golden_element);
            femaleButton.setBackgroundResource(R.drawable.custom_element);
        }
        else {
            femaleButton.setBackgroundResource(R.drawable.custom_golden_element);
            maleButton.setBackgroundResource(R.drawable.custom_element);
        }
    }

    private void Init() {
        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
        maleButton = findViewById(R.id.imageButton2);
        femaleButton = findViewById(R.id.imageButton);
        next = findViewById(R.id.nextButton1);
    }
}