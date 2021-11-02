package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Hello4 extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor edit;
    LinearLayout button1;
    LinearLayout button2;
    LinearLayout button3;
    Button button4;
    Intent intent;

    final String key = "Level";
    Boolean pushed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello4);
        Init();
        LinearLayout[] buttons = {button1, button2, button3};

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button1, buttons, "Newbie");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button2, buttons, "Keep on");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(button3, buttons, "Advanced");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pushed == true) {
                    button4.setBackgroundResource(R.drawable.custom_golden_element);
                    edit.apply();
                    startActivity(intent);
                }
            }
        });
    }

    private void ChangeColor(LinearLayout pushedLayout, LinearLayout[] layouts, String value) {
        for (LinearLayout layout: layouts) {
            if (layout.equals(pushedLayout)) {
                layout.setBackgroundResource(R.drawable.custom_golden_element);
                edit.putString(key, value);
            } else
                layout.setBackgroundResource(R.drawable.custom_element);
        }
        pushed = true;
    }

    private void Init() {
        button1 = findViewById(R.id.button_layout1);
        button2 = findViewById(R.id.button_layout2);
        button3 = findViewById(R.id.button_layout3);
        button4 = findViewById(R.id.nxtButton);

        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
        intent = new Intent(Hello4.this, Hello5.class);
    }
}