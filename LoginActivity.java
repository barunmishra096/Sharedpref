package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

      private EditText mGetEmail;
      private EditText mGetPassword;
      private CheckBox mRememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mGetEmail = findViewById(R.id.email_enter);
        mGetPassword = findViewById(R.id.pass_enter);
        mRememberMe = findViewById(R.id.check_remember);
        Button mButtonLogin = findViewById(R.id.button_login);

        //create the sharedpref file
        SharedPreferences pref = getApplicationContext().getSharedPreferences("SHARED",MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        // Button
       mButtonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String username = mGetEmail.getText().toString();
               String password = mGetPassword.getText().toString();

               boolean isRememberMe = mRememberMe.isChecked();

               if (isRememberMe)
               {
                   editor.putString("USERNAME", username);
                   editor.putString("PASSWORD", password);
                   editor.putBoolean("ISREMEMBERME",isRememberMe);


                   editor.apply();


               }

               moveToHomeScreen();
           }
       });

       boolean isAlreadyLoggedIn = pref.getBoolean("ISREMEMBERME", false);

        if(isAlreadyLoggedIn){
           moveToHomeScreen();
        }
    }

    private void moveToHomeScreen()
    {
        startActivity(new Intent(LoginActivity.this, ViewProfile.class));
        finish();

    }
}
