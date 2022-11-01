package com.example.classdb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignupActivity extends AppCompatActivity {
    TextView back;
    EditText name, id, pw, pw2, birth, phone;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        back = findViewById(R.id.backlog);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        name = findViewById(R.id.signName);
        id=findViewById(R.id.signID);
        pw=findViewById(R.id.signPW);
        pw2=findViewById(R.id.signPW2);
        birth=findViewById(R.id.signBirth);
        phone=findViewById(R.id.phoneNum);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        new Handler().postDelayed(new Runnable() {
            public void run() {
                phone.requestFocus();
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(phone, 0);
                phone.setSelection(phone.length());
            }
        }, 100);


        submit = findViewById(R.id.signupbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String user_id = id.getText().toString();
                String user_pw = pw.getText().toString();
                String user_pw2 = pw2.getText().toString();
                String user_birth = birth.getText().toString();
                String user_phone = phone.getText().toString();

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}