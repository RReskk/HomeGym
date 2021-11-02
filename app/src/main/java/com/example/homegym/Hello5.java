package com.example.homegym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hello5 extends AppCompatActivity {

    EditText heightText;
    EditText weightText;
    Button nextBtn;
    Boolean res = false;

    SharedPreferences pref;
    SharedPreferences.Editor edit;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello5);
        Init();
    }

    public void ButtonPressed(View view) {
        res = Check();
        if (res == true) {
            edit.putString("Height", heightText.getText().toString());
            edit.putString("Weight", weightText.getText().toString());
            edit.putString("isDone", "Done");
            edit.apply();
            Toast.makeText(getApplicationContext(), "Значения сохранены", Toast.LENGTH_SHORT).show();
            nextBtn.setBackgroundResource(R.drawable.custom_golden_element);
            startActivity(intent);
            finish();
        }
    }

    private Boolean Check() {
        String hStr = heightText.getText().toString();
        String wStr = weightText.getText().toString();

        if (!hStr.isEmpty() && !wStr.isEmpty()) {
            int height = Integer.parseInt(hStr);
            int weight = Integer.parseInt(wStr);

            if (height <= 100 || weight <= 40 || height >= 250 || weight >= 450) {
                ShowAlert("Введите корректные данные");
                return false;
            }
            else {
                return true;
            }
        } else {
            ShowAlert("Заполните все поля");
            return false;
        }
    }

    private  void ShowAlert(String text) {
        new AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage(text)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void Init() {
        heightText = findViewById(R.id.HeightText);
        weightText = findViewById(R.id.weightText);
        nextBtn = findViewById(R.id.nxtButton2);

        intent = new Intent(Hello5.this, SignIn.class);

        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
    }
}