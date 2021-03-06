package edu.ucsb.cs.cs185.npoon.mydog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    TextView tv_create_acc;
    TextView tv_forgot_pass;
    Button btn_login;
    ImageView logo;

    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '*'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        et_username = (EditText) findViewById(R.id.et_login_username);
        et_password = (EditText) findViewById(R.id.et_login_password);
        tv_create_acc = (TextView) findViewById(R.id.tv_create_acc);
        tv_forgot_pass = (TextView) findViewById(R.id.tv_forgot_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
        logo = (ImageView) findViewById(R.id.login_logo);

        et_username.setSingleLine(false);
        et_username.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_username.setTextColor(getResources().getColor(R.color.primary_text));


        et_password.setSingleLine(false);
        et_password.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_password.setTextColor(getResources().getColor(R.color.primary_text));
        et_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());



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
                Intent intent = new Intent(LoginActivity.this, CreateAccActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });

        tv_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecoverActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });



    }

}
