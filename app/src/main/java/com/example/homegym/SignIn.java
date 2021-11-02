package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class SignIn extends AppCompatActivity {
    EditText loginText;
    EditText pwdText;
    Button signIn;
    TextView signUp;
    TextView skip;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        Init();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean check_result = Check();
                if (check_result == true) {
                    Toast.makeText(getApplicationContext(), "Успешный вход", Toast.LENGTH_SHORT).show();
                    GoTo(Main.class, true);
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoTo(SignUp.class, false);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoTo(Main.class, true);
            }
        });
    }

    private Boolean Check() {
        String login = loginText.getText().toString();
        String pwd = pwdText.getText().toString();

        if (loginText.length() == 0 || pwdText.length() == 0) {
            ShowDialog("Нужно заполнить все поля");
            return false;
        }
        else {
            try {
                if (DB.checkUserPassword(login, pwd) == true) {
                    return true;
                }
                else {
                    ShowDialog("Неверный логин или пароль");
                    return false;
                }
            }
            catch (Exception e) {
                ShowDialog("Проблемы с базой данных");
                return false;
            }
        }
    }

    private void GoTo(Class nextActivity, Boolean isFinish){
        Intent intent = new Intent(SignIn.this, nextActivity);
        startActivity(intent);
        if (isFinish == true){
            finish();
        }
    }

    private void ShowDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void Init() {
        loginText = findViewById(R.id.editText1);
        pwdText = findViewById(R.id.editText2);
        signIn = findViewById(R.id.button);
        signUp = findViewById(R.id.signUp);
        skip = findViewById(R.id.skip);
        DB = new DBHelper(this);
    }

}