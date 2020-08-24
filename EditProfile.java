package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    private EditText mGetEmail1;
    private EditText mGetPassword1;
    private CheckBox mRememberMe1;
    private Button mlogagain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);


        mGetEmail1 = findViewById(R.id.email_enter_again_edit);
        mGetPassword1 = findViewById(R.id.pass_enter_again_edit);
        mRememberMe1 = findViewById(R.id.check_remember_2);
        mlogagain = findViewById(R.id.button_login_2);



        SharedPreferences prefs = getApplicationContext().getSharedPreferences("SHARED",MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = prefs.edit();



        String usernamefromview = prefs.getString("USERNAME","");
        String passwordfromview = prefs.getString("PASSWORD","");

        mGetEmail1.setText(usernamefromview);
        mGetPassword1.setText(passwordfromview);

       //Button section
      mlogagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String username = mGetEmail1.getText().toString();
                String password = mGetPassword1.getText().toString();

                boolean isrememberme2 = mRememberMe1.isChecked();

                if (isrememberme2){
                    editor2.putString("USERNAME",username);
                    editor2.putString("PASSWORD",password);

                    editor2.putBoolean("ISREMEMBERME",isrememberme2);
                    editor2.apply();
                }
                movetohome();

            }
        });


    }

    private void movetohome(){
        startActivity(new Intent(EditProfile.this,ViewProfile.class));
        finish();
    }
}
