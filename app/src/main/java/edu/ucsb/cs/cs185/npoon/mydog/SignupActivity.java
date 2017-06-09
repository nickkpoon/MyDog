package edu.ucsb.cs.cs185.npoon.mydog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    EditText et_ver_password;
    EditText et_email;
    Button btn_cancel;
    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_username = (EditText) findViewById(R.id.et_signup_username);
        et_password = (EditText) findViewById(R.id.et_signup_password);
        et_ver_password = (EditText) findViewById(R.id.et_signup_ver_password);
        et_email = (EditText) findViewById(R.id.et_signup_email);
        btn_cancel = (Button) findViewById(R.id.btn_signup_cancel);
        btn_create = (Button) findViewById(R.id.btn_signup_create);
    }
}
