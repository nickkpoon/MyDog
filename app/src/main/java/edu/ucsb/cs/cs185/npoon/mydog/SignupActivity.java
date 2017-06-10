package edu.ucsb.cs.cs185.npoon.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    EditText et_ver_password;
    EditText et_security_question;
    EditText et_security_answer;
    Button btn_cancel;
    Button btn_create;

    ArrayList<EditText> fields = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_username = (EditText) findViewById(R.id.et_signup_username);
        et_password = (EditText) findViewById(R.id.et_signup_password);
        et_ver_password = (EditText) findViewById(R.id.et_signup_ver_password);
        et_security_question = (EditText) findViewById(R.id.et_security_question);
        et_security_answer = (EditText) findViewById(R.id.et_security_answer);
        btn_cancel = (Button) findViewById(R.id.btn_signup_cancel);
        btn_create = (Button) findViewById(R.id.btn_signup_create);

        fields.add(et_username);
        fields.add(et_password);
        fields.add(et_ver_password);
        fields.add(et_security_question);
        fields.add(et_security_answer);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean allFilled = true;

                //Check if all fields filled out
                for(EditText field : fields){
                    if(field.getText().toString().trim() == ""){
                        allFilled = false;
                    }
                }

                if(allFilled){
                    String username = et_username.getText().toString();
                    String password = et_password.getText().toString();
                    String ver_password = et_ver_password.getText().toString();
                    String security_question = et_security_question.getText().toString();
                    String security_answer = et_security_answer.getText().toString();
                    if(password.equals(ver_password)){
                        //Add account to database
                        BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                        backgroundTask.execute("sign_up", username, password, security_question, security_answer);

                        //Clear fields
                        for(EditText field : fields){
                            field.setText("");
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill out entire form", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
