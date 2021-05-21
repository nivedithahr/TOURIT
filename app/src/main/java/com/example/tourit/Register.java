package com.example.tourit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText fullName, emailId, newPassword, phoneNo;
    private Button registerBtn;
    private TextView gotoLogin;
    private ProgressBar registerProgressBar;

    FirebaseAuth userAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userAuth = FirebaseAuth.getInstance();

        fullName = findViewById(R.id.fullName);
        emailId = findViewById(R.id.resetEmail);
        newPassword = findViewById(R.id.password);
        phoneNo = findViewById(R.id.phoneNo);

        gotoLogin = findViewById(R.id.gotoLogin);

        registerBtn = findViewById(R.id.registerBtn);

        registerProgressBar = findViewById(R.id.registerProgressBar);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }

    private void register(){

        String name = fullName.getText().toString().trim();
        String email = emailId.getText().toString().trim();
        String password = newPassword.getText().toString().trim();
        String phone = phoneNo.getText().toString().trim();

        if(name.isEmpty()){
            fullName.setError("Please provide a Name");
            fullName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            emailId.setError("Please provide an Email");
            emailId.requestFocus();
            return;
        }
//
        if (password.isEmpty()){
            newPassword.setError("Please provide a Password");
            newPassword.requestFocus();
            return;
        }
        if (password.length() < 8){
            newPassword.setError("Minimum Password length should be 8 character");
            newPassword.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            phoneNo.setError("Please provide a Phone Number");
            phoneNo.requestFocus();
            return;
        }

        String Expn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        if (!email.matches(Expn)){
            emailId.setError("Provide a valid Email");
            emailId.requestFocus();
            return;
        }

        registerProgressBar.setVisibility(View.VISIBLE);
        userAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            UserObject userObject = new UserObject(name,email,phone);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(userObject).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this, "User has been successfully Registered", Toast.LENGTH_SHORT).show();
                                        registerProgressBar.setVisibility(View.GONE);
                                    }
                                    else {
                                        Toast.makeText(Register.this, "Registration Failed! Try again!!", Toast.LENGTH_SHORT).show();
                                        registerProgressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(Register.this, "Registration Failed! Try again!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}