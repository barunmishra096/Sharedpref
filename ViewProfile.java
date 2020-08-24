package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);


        TextView mUsername = findViewById(R.id.home_tv_login_email);
        TextView mPassword = findViewById(R.id.home_tv_login_password);

        Button mButtonLogout = findViewById(R.id.button_logout);
        Button mButtonEditData = findViewById(R.id.button_editdata);


        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SHARED",MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = prefs.edit();

        final String username = prefs.getString("USERNAME","");
        final String password = prefs.getString("PASSWORD","");

        mUsername.setText(username);
        mPassword.setText(password);



        mButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor1.putString("USERNAME","");
                editor1.putString("PASSWORD","");
                editor1.putBoolean("ISREMEMBERME",false);

                editor1.apply();

                startActivity(new Intent(ViewProfile.this,LoginActivity.class));
                finish();

            }
        });

       mButtonEditData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

                   editor1.putString("USERNAME",username);
                   editor1.putString("PASSWORD",password);
                   editor1.putBoolean("ISREMEMBERME",false);

                   editor1.apply();

                   startActivity(new Intent(ViewProfile.this, EditProfile.class));
                   onStop();

           }
       });








    }
}
