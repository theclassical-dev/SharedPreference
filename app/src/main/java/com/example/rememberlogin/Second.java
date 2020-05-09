package com.example.rememberlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {


    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        logout = findViewById(R.id.Logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sf = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor edit =  sf.edit();
                edit.putString("remember","false");
                edit.commit();

                finish();
            }
        });
    }
}
