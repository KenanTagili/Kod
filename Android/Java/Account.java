package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {
     TextView name;
     String storedName,storedSurname;
     SharedPreferences sharedPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name = findViewById(R.id.userInfo);
        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        storedName = sharedPreferences.getString("stored_Name","");
        storedSurname = sharedPreferences.getString("stored_Surname","");

        name.setText(storedName + " " + storedSurname);
    }
    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(Account.this, Login.class);
        finish();
        startActivity(backIntent);
    }
}