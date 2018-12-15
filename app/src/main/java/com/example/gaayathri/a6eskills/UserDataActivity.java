package com.example.gaayathri.a6eskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        Button btn = findViewById(R.id.btnUpdate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeintent = new Intent(UserDataActivity.this, NavigationActivity.class);
                startActivity(homeintent);
            }
        });
    }
}
