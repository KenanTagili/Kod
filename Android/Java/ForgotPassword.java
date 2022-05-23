package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    TextView  info;
    EditText new_Password_1, new_Password_2;
    SwitchCompat visibility_switch;
    String entered_new_Password_1, entered_new_Password_2;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

        new_Password_1 = findViewById(R.id.new_password_1);
        new_Password_2 = findViewById(R.id.new_password_2);
        visibility_switch = findViewById(R.id.switch1);
        info = findViewById(R.id.Info);

        visibilitySwitch();
    }

    private void visibilitySwitch() {

        visibility_switch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                new_Password_1.setInputType(InputType.TYPE_CLASS_TEXT);
                new_Password_2.setVisibility(View.GONE);
            }
            else {
                new_Password_1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                new_Password_2.setVisibility(View.VISIBLE);
            }
        });
    }

    public void changeClick(View v) {
        entered_new_Password_1 = new_Password_1.getText().toString();
        entered_new_Password_2 = new_Password_2.getText().toString();

        if (entered_new_Password_1.equals(entered_new_Password_2) || visibility_switch.isChecked()) {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("stored_Password", entered_new_Password_1);
            editor.apply();

            Intent intent = new Intent(ForgotPassword.this, Login.class);
            finish();
            startActivity(intent);
        } else {
            info.setText(R.string.not_same);
        }
    }
    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(ForgotPassword.this, Login.class);
        finish();
        startActivity(backIntent);
    }
}