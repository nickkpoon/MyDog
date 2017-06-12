package edu.ucsb.cs.cs185.npoon.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recoverUsername = "";
        questionVisible = false;
        securityQuestion = "";
        securityAnswer = "";
        passwordVisible = false;
        recoveredPassword = "";
    }

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

        if(questionVisible && !passwordVisible){
            et_username.setText(recoverUsername);
            tv_security_question.setVisibility(View.VISIBLE);
            et_security_answer.setVisibility(View.VISIBLE);
            String wholeQuestion = "Your security question:\n" + securityQuestion;
            tv_security_question.setText(wholeQuestion);
        } else if (questionVisible && passwordVisible){
            et_username.setText(recoverUsername);
            tv_security_question.setVisibility(View.VISIBLE);
            et_security_answer.setVisibility(View.VISIBLE);
            String wholeQuestion = "Your security question:\n" + securityQuestion;
            tv_security_question.setText(wholeQuestion);
            tv_password_pre.setVisibility(View.VISIBLE);
            tv_password.setText(recoveredPassword);
            tv_password.setVisibility(View.VISIBLE);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_username.getText().toString().trim().equals("")) {
                    String username = et_username.getText().toString();
                    if (!questionVisible && !passwordVisible && !recoverUsername.equals(username)) {
                        BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                        backgroundTask.execute("check_user_exists", username);
                        recoverUsername = username;
                    } else if (questionVisible && !passwordVisible) {
                        if(!et_security_answer.getText().toString().trim().equals("")){
                            if(et_security_answer.getText().toString().equals(securityAnswer)){
                                passwordVisible = true;
                                recreate();
                            } else {
                                Toast.makeText(getApplicationContext(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RecoverActivity.this, "Enter an answer", Toast.LENGTH_SHORT).show();
                        }
                    } else if (questionVisible && passwordVisible) {
                        Toast.makeText(RecoverActivity.this, "You already got your password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter your username", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
