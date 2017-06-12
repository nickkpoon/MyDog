package edu.ucsb.cs.cs185.npoon.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecoverActivity extends AppCompatActivity {

    EditText et_username;
    TextView tv_security_question;
    EditText et_security_answer;
    TextView tv_password_pre;
    TextView tv_password;
    Button btn_submit;

    static String recoverUsername = "";
    static Boolean questionVisible = false;
    static String securityQuestion = "";
    static String securityAnswer = "";
    static Boolean passwordVisible = false;
    static String recoveredPassword = "";

    Boolean usernameEnter = false;
    Boolean passwordObtained = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover);

        et_username = (EditText) findViewById(R.id.et_rec_username);
        tv_security_question = (TextView) findViewById(R.id.tv_rec_question);
        et_security_answer = (EditText) findViewById(R.id.et_rec_answer);
        tv_password_pre = (TextView) findViewById(R.id.tv_rec_password_pre);
        tv_password = (TextView) findViewById(R.id.tv_rec_password);
        btn_submit = (Button) findViewById(R.id.btn_rec_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEnter == false){
                    usernameEnter = true;
                    tv_security_question.setVisibility(View.VISIBLE);
                    et_security_answer.setVisibility(View.VISIBLE);
                    et_security_answer.requestFocus();
                } else {
                    passwordObtained = true;
                    tv_password_pre.setVisibility(View.VISIBLE);
                    tv_password.setVisibility(View.VISIBLE);
                    tv_password.setText("password");
                }
            }
        });


    }

}
