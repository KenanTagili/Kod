package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void loginClick(View v){
            Intent intent1 = new Intent(MainActivity.this, Login.class);
            finish();
            startActivity(intent1);
        }
        public void registerClick(View v){
            Intent intent2 = new Intent(MainActivity.this,Register.class);
            finish();
            startActivity(intent2);
        }
}