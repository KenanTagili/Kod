package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText username, password;
    TextView info;
    String entered_Password, entered_Username;
    String stored_Name, stored_Surname, stored_Username, stored_Password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        info = findViewById(R.id.info);

        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
    }

    public void forgotClick(View v) {
            Intent intent = new Intent(Login.this, ForgotPassword.class);
            finish();
            startActivity(intent);
    }

    public void enterClick(View v) {
        entered_Username = username.getText().toString();
        entered_Password = password.getText().toString();

        stored_Name = sharedPreferences.getString("stored_Name", "");
        stored_Surname = sharedPreferences.getString("stored_Surname", "");
        stored_Username = sharedPreferences.getString("stored_Username", "");
        stored_Password = sharedPreferences.getString("stored_Password", "");

        if (entered_Username.equals(stored_Username)) {
            if (entered_Password.equals(stored_Password)) {
                Intent intent = new Intent(Login.this, Account.class);
                finish();
                startActivity(intent);
            } else
                info.setText(R.string.wrong_password);
        } else
            info.setText(R.string.wrong_username);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(Login.this, MainActivity.class);
        finish();
        startActivity(backIntent);
    }
}