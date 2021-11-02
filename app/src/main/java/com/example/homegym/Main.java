package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {

    TextView digital_clock;
    Typeface tf;

    int mCurrentPeriod = 0;
    private Boolean isStarted = false;
    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.gradient);

        digital_clock = (TextView) findViewById(R.id.textView14);
        //tf = Typeface.createFromAsset(getAssets(), "@font/nd_astroneer.ttf");
        //digital_clock.setTypeface(tf);
    }

    public void onStartButtonClick(View v) {
        if (isStarted == false) {
            isStarted = true;
            myTimer = new Timer();
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    TimerMethod();
                }
            }, 0, 1000);
        }
    };


    public void onResetButtonClick(View v) {
        mCurrentPeriod = 0;
        if (myTimer != null)
            myTimer.cancel();
        digital_clock.setText("00:00");
        isStarted = false;
    };

    private void TimerMethod() {
        this.runOnUiThread(Timer_Tick);
    }

    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            mCurrentPeriod++;
            String temp = (new SimpleDateFormat("mm:ss")).format(new Date(
                    mCurrentPeriod * 1000));
            digital_clock.setText(temp);
        }
    };
}