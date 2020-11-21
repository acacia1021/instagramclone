package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);

       if (ParseUser.getCurrentUser() != null){
           goMainActivity();
       }

        setContentView(R.layout.activity_login);


        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);



        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
                public void onClick(View v){
            Log.i(TAG, "onClick login button");
            final String username = etUsername.getText().toString();
            final String password = etPassword.getText().toString();
            loginUser(username, password);
        }
    });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });


    }


private void loginUser(String username, String password){
    Log.i(TAG, "attempting to login user" + username);
    //TODO: navigate to the main activity if the user has signed in properly
    ParseUser.logInInBackground(username, password, new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if(e == null){
                Log.d("LoginActivity", "Login successful");
                final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Log.e("LoginActivity", "Login failure");
                Toast.makeText(LoginActivity.super.getBaseContext(), "Username or password incorrect", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
