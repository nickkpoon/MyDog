package edu.ucsb.cs.cs185.npoon.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nickkpoon on 6/12/2017.
 */

public class CreateAccActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    EditText et_ver_password;
    EditText et_security_question;
    EditText et_security_answer;
    Button btn_signup;
    ImageView logo;

    ArrayList<EditText> fields = new ArrayList<>();

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
        setContentView(R.layout.activity_create);
        et_username = (EditText) findViewById(R.id.et_login_username);
        et_password = (EditText) findViewById(R.id.et_login_password);
        et_ver_password = (EditText) findViewById(R.id.et_verify_password);
        et_security_question = (EditText) findViewById(R.id.et_security_question);
        et_security_answer = (EditText) findViewById(R.id.et_security_answer);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        logo = (ImageView) findViewById(R.id.login_logo);

        et_username.setSingleLine(false);
        et_username.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_username.setTextColor(getResources().getColor(R.color.primary_text));


        et_password.setSingleLine(false);
        et_password.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_password.setTextColor(getResources().getColor(R.color.primary_text));
        et_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        et_ver_password.setSingleLine(false);
        et_ver_password.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_ver_password.setTextColor(getResources().getColor(R.color.primary_text));
        et_ver_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        et_security_question.setSingleLine(false);
        et_security_question.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_security_question.setTextColor(getResources().getColor(R.color.primary_text));

        et_security_answer.setSingleLine(false);
        et_security_answer.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        et_security_answer.setTextColor(getResources().getColor(R.color.primary_text));

        fields.add(et_username);
        fields.add(et_password);
        fields.add(et_ver_password);
        fields.add(et_security_question);
        fields.add(et_security_answer);



        btn_signup.setOnClickListener(new View.OnClickListener() {
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


    }

}
