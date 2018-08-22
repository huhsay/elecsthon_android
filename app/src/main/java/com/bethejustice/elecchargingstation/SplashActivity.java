package com.bethejustice.elecchargingstation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    /**
     * 첫 방문을 확인하여 first 변수에 넣는다.
     * 처음방문하면 InitActivity로 화면전환한다.
     */

    private boolean first = true;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(first){
                    Intent intent = new Intent(getApplicationContext(), InitActivity.class);
                    startActivity(intent);

                    finish();

                }else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            }
        }, 1000);
    }
}
