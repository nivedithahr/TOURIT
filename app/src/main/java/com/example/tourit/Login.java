package com.example.tourit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth userAuth;

    private EditText userEmailId, userPassword;
    private TextView forgetPassword, registerHere;
    private Button loginBtn;
    private ProgressBar loginProgressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        userAuth = FirebaseAuth.getInstance();

        userEmailId = findViewById(R.id.resetEmail);
        userPassword = findViewById(R.id.password);

        forgetPassword = findViewById(R.id.forgetPassword);
        registerHere = findViewById(R.id.registerHere);

        loginBtn = findViewById(R.id.resetBtn);

        loginProgressBar = findViewById(R.id.resetProgressBar);

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ResetPassword.class));
            }
        });
    }

    private void userLogin(){
        String userEmail = userEmailId.getText().toString().trim();
        String userPass = userPassword.getText().toString().trim();

        if (userEmail.isEmpty()){
            userEmailId.setError("Please provide an Email");
            userEmailId.requestFocus();
            return;
        }
        String Expn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        if (!userEmail.matches(Expn)){
            userEmailId.setError("Provide a valid Email");
            userEmailId.requestFocus();
            return;
        }

        if (userPass.length() < 8){
            userPassword.setError("Minimum Password length should be 8 character");
            userPassword.requestFocus();
            return;
        }

        loginProgressBar.setVisibility(View.VISIBLE);

        userAuth.signInWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    if (firebaseUser.isEmailVerified()){
                        startActivity(new Intent(Login.this,MainActivity.class));
                    }
                    else {
                        firebaseUser.sendEmailVerification();
                        Toast.makeText(Login.this, "Email is not verified! Check your mail for verification link and Try again", Toast.LENGTH_SHORT).show();
                        loginProgressBar.setVisibility(View.GONE);
                    }
                }
                else {
                    Toast.makeText(Login.this, "Login Failed! Try again!!", Toast.LENGTH_SHORT).show();
                    loginProgressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}