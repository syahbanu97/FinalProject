package com.example.acer.finalprojectapps.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.acer.finalprojectapps.R;
import com.example.acer.finalprojectapps.Sqlite.SqliteHelper;

public class LoginActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration Button
    Button buttonLogin;
    Button buttonRegister;

    //Declaration SqliteHelper
    SqliteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.login_email);
        editTextPassword = (EditText) findViewById(R.id.login_password);
        buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonRegister = (Button) findViewById(R.id.btn_register);
        db = new SqliteHelper(this);

        //Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                Boolean chkemailpass = db.emailpassword(email, password);
                if (chkemailpass == true){
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password, check again!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Register
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}