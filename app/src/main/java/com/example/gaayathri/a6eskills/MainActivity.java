package com.example.gaayathri.a6eskills;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

    }


    private class LogoLauncher extends Thread{

        public void run(){
            try{
                sleep(1000);

                Intent homeintent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(homeintent);

                finish();


            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
