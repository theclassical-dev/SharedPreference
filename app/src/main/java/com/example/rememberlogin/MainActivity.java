package com.example.rememberlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    CheckBox remember;
    Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        remember = findViewById(R.id.RememberMe);
        login = findViewById(R.id.Login);

        SharedPreferences sf = getSharedPreferences("checkbox",MODE_PRIVATE);
        String check = sf.getString("remember","");

        if(check.equals("true")){
            Intent intent = new Intent(this,Second.class);
            startActivity(intent);
        }else if(check.equals("false")){
            Toast.makeText(this,"Please Sign In",Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                startActivity(intent);
            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()){
                    SharedPreferences sf = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor edit =  sf.edit();
                    edit.putString("remember","true");
                    edit.commit();
                    Toast.makeText(MainActivity.this,"checked",Toast.LENGTH_SHORT).show();

                }else if (!compoundButton.isChecked()){
                    SharedPreferences sf = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor edit =  sf.edit();
                    edit.putString("remember","false");
                    edit.commit();
                    Toast.makeText(MainActivity.this,"Unchecked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
