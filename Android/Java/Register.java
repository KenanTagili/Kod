package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name, surname, username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
    }

    public void createClick(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", (dialog, which) -> {
            saveValuesToShared();
            Intent intent = new Intent(Register.this, Login.class);
            finish();
            startActivity(intent);
            Toast.makeText(Register.this, "Created", Toast.LENGTH_LONG).show();
        });
        alert.setNegativeButton("No", (dialog, which) -> {
        });
        alert.show();
    }

    void saveValuesToShared() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("stored_Name",name.getText().toString());
        editor.putString("stored_Surname",surname.getText().toString());
        editor.putString("stored_Username",username.getText().toString());
        editor.putString("stored_Password",password.getText().toString());
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(Register.this, MainActivity.class);
        finish();
        startActivity(backIntent);
    }
}
