package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hello1 extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello1);
        button1 = findViewById(R.id.loss);
        button2 = findViewById(R.id.fit);
        button3 = findViewById(R.id.muscle);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button1, button2, button3);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button2, button1, button3);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button3, button2, button1);
            }
        });
    }

    private void ColorChange(Button button_g, Button button_w_1, Button button_w_2) {
        button_g.setBackgroundResource(R.drawable.custom_golden_element);
        button_w_1.setBackgroundResource(R.drawable.custom_element);
        button_w_2.setBackgroundResource(R.drawable.custom_element);
    }
}