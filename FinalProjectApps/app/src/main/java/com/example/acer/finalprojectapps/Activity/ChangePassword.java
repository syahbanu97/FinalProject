package com.example.acer.finalprojectapps.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.finalprojectapps.R;
import com.example.acer.finalprojectapps.Sqlite.SqliteHelper;

public class ChangePassword extends AppCompatActivity {

    EditText oldpassword;
    EditText newpassword;
    EditText confirmpassword;
    Button btnconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldpassword = (EditText)findViewById(R.id.old_password);
        newpassword = (EditText)findViewById(R.id.new_password);
        confirmpassword = (EditText)findViewById(R.id.confirm_newpassword);
        final SqliteHelper db = new SqliteHelper(this);
        btnconfirm = (Button)findViewById(R.id.btn_confirm);

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldpass = oldpassword.getText().toString();
                String newpass = newpassword.getText().toString();
                String confirmpass = confirmpassword.getText().toString();

                if (oldpass.equals("")||newpass.equals("")||confirmpass.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    if (newpass.equals(confirmpass)) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Not Recruiment", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
