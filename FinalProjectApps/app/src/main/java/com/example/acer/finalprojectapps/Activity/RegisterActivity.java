package com.example.acer.finalprojectapps.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.finalprojectapps.R;
import com.example.acer.finalprojectapps.Sqlite.SqliteHelper;

public class RegisterActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirm;

    //Declaration TextInputLayout
    /*TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    TextInputLayout textInputLayoutConfirm;*/

    //Declaration Button
    Button buttonRegister;
    Button buttonBackLogin;

    SqliteHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new SqliteHelper(this);
        editTextEmail = (EditText) findViewById(R.id.registrasi_email);
        editTextPassword = (EditText) findViewById(R.id.registrasi_password);
        editTextConfirm = (EditText) findViewById(R.id.registrasi_confirm);
        buttonBackLogin = (Button) findViewById(R.id.btn_backToLogin);
        buttonRegister = (Button) findViewById(R.id.btn_register);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirm = editTextConfirm.getText().toString();

                if (email.equals("") || password.equals("") || confirm.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(confirm)) {
                        Boolean chkemail = db.chkemail(email);
                        if (chkemail == true) {
                            Boolean insert = db.insertuser(email, password);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password don't the match", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        buttonBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}