package edu.ucsb.cs.cs185.npoon.mydog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    TextView tv_create_acc;
    TextView tv_forgot_pass;
    TextView tv_continue;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        et_username = (EditText) findViewById(R.id.et_login_username);
        et_password = (EditText) findViewById(R.id.et_login_password);
        tv_continue = (TextView) findViewById(R.id.tv_continue);
        tv_create_acc = (TextView) findViewById(R.id.tv_create_acc);
        tv_forgot_pass = (TextView) findViewById(R.id.tv_forgot_pass);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_username.getText().toString().trim() != "" && et_password.getText().toString().trim() != ""){
                    String username = et_username.getText().toString();
                    String password = et_password.getText().toString();
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                    backgroundTask.execute("login", username, password);
                }
            }
        });

        tv_create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        tv_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecoverPasswordActivity.class);
                startActivity(intent);
            }
        });

        tv_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
