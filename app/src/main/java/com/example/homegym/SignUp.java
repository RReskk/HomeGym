package com.example.homegym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    TextView back;
    EditText login;
    EditText email;
    EditText pwd1;
    EditText pwd2;
    Button btn;
    DBHelper DB;

    String em_string;
    String l_string;
    String pwd_string1;
    String pwd_string2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        back = findViewById(R.id.back);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pwd1 = findViewById(R.id.password_1);
        pwd2 = findViewById(R.id.password_2);
        btn = findViewById(R.id.signup_button);
        DB = new DBHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l_string = login.getText().toString();
                em_string = email.getText().toString();
                pwd_string1 = pwd1.getText().toString();
                pwd_string2 = pwd2.getText().toString();

                Boolean check_result = Check();
                if (check_result == true) {
                    Boolean insert = DB.insertData(l_string, pwd_string2, em_string);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Регистрация выполнена", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Не удалось зарегистрировать", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private Boolean Check() {

        if (login.length() == 0 || pwd1.length() == 0 || pwd2.length() == 0 || email.length() == 0) {
            ShowDialog("Нужно заполнить все поля");
            return false;
        }
        else if (!pwd_string1.equals(pwd_string2)) {
            ShowDialog("Пароли должны совпадать");
            return false;
        }
        else if (EMAIL_ADDRESS_PATTERN.matcher(em_string).matches() == false) {
            ShowDialog("Введите почту правильно");
            return false;
        }
        else if (DB.checkLogin(l_string) == true) {
            ShowDialog("Пользователь уже существует");
            return false;
        }
        else {
            return true;
        }
    }

    private void ShowDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
}