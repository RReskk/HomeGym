package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello1 extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    private final String save_key = "Purpose";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello1);
        Init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button1, button2, button3);
                edit.putString(save_key, "Weight loss");
                edit.apply();
                GoNext();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button2, button1, button3);
                edit.putString(save_key, "Keeping fit");
                edit.apply();
                GoNext();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button3, button2, button1);
                edit.putString(save_key, "Build muscle");
                edit.apply();
                GoNext();
            }
        });
    }

    private void GoNext() {
        Intent intent = new Intent(Hello1.this, Hello2.class);
        startActivity(intent);
    }

    private void ColorChange(Button button_g, Button button_w_1, Button button_w_2) {
        button_g.setBackgroundResource(R.drawable.custom_golden_element);
        button_w_1.setBackgroundResource(R.drawable.custom_element);
        button_w_2.setBackgroundResource(R.drawable.custom_element);
    }

    private void Init() {
        button1 = findViewById(R.id.loss);
        button2 = findViewById(R.id.fit);
        button3 = findViewById(R.id.muscle);
        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
    }
}