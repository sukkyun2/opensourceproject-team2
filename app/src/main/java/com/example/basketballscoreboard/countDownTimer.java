package com.example.basketballscoreboard;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class countDownTimer extends AppCompatActivity {
        TextView textView ;

        Button start, pause, reset, lap ;

    long MillisecondTime, TimeBuff, UpdateTime = 0L ;
    long StartTime= 0L;  //시작시간

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;
    ListView listView ;

    int millis=3000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdowntimer);

        textView = (TextView)findViewById(R.id.textView1);
        start = (Button)findViewById(R.id.button);
        pause = (Button)findViewById(R.id.button2);
        reset = (Button)findViewById(R.id.button3);

        handler = new Handler() ;



        final CountDownTimer countDownTimer = new CountDownTimer(millis, 10) {
            public void onTick(long millisUntilFinished) {

                Seconds = (int) (millisUntilFinished / 1000);

                Minutes = Seconds / 60;

                Seconds = Seconds % 60;

                MilliSeconds = (int) (millisUntilFinished % 100);

                textView.setText("" + Minutes + ":"
                        + String.format("%02d", Seconds) + ":"
                        + String.format("%02d", MilliSeconds));
            }

            public void onFinish() {

                this.cancel();
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TimeBuff += MillisecondTime;

                countDownTimer.cancel();

                reset.setEnabled(true);

            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Seconds = (int) (millis / 1000);

                Minutes = Seconds / 60;

                Seconds = Seconds % 60;

                MilliSeconds = (int) (millis % 100);

                textView.setText("" + Minutes + ":"
                        + String.format("%02d", Seconds) + ":"
                        + String.format("%02d", MilliSeconds));

                //매개변수로 받고 텍스트 수정해야됨 이부분

            }
        });



    }
/*
    public Runnable runnable = new Runnable() {

        public void run() {

            //MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            MillisecondTime = StartTime - SystemClock.uptimeMillis();

            //UpdateTime = TimeBuff + MillisecondTime;
            UpdateTime =  MillisecondTime;



            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
    */
}

