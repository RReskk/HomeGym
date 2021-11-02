package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class LaunchScreen extends AppCompatActivity {
    Intent intent;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref = getSharedPreferences("Values", MODE_PRIVATE);

        Launch();
    }

    private void Launch() {
        String isDone = pref.getString("isDone", "");

        if (isDone.equals("Done")) {
            intent = new Intent(LaunchScreen.this, SignIn.class);
        }
        else {
            intent = new Intent(LaunchScreen.this, Hello1.class);
        }
        startActivity(intent);
        finish();
    }

}