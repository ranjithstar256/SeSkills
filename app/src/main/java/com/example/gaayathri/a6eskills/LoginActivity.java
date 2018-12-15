package com.example.gaayathri.a6eskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginbtn = findViewById(R.id.btnLogin);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeintent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homeintent);

            }
        });
    }
}
