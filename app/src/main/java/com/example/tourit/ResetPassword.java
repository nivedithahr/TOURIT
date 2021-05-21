package com.example.tourit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    FirebaseAuth userAuth;

    private EditText resetEmail;
    private Button reset;
    private ProgressBar resetProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        userAuth = FirebaseAuth.getInstance();

        resetEmail = findViewById(R.id.resetEmail);
        reset = findViewById(R.id.resetBtn);
        resetProgressBar = findViewById(R.id.resetProgressBar);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPass();
            }
        });

    }

    private void resetPass(){
        String resEmail = resetEmail.getText().toString().trim();

        if(resEmail.isEmpty()){
            resetEmail.setError("Please provide an Email");
            resetEmail.requestFocus();
            return;
        }

        String Expn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        if (!resEmail.matches(Expn)){
            resetEmail.setError("Provide a valid Email");
            resetEmail.requestFocus();
            return;
        }

        resetProgressBar.setVisibility(View.VISIBLE);

        userAuth.sendPasswordResetEmail(resEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if ((task.isSuccessful())){
                    Toast.makeText(ResetPassword.this, "Reset Password link has been sent to your Email", Toast.LENGTH_SHORT).show();
                    resetProgressBar.setVisibility(View.GONE);
                }
                else {
                    Toast.makeText(ResetPassword.this, "Error!! Try again!", Toast.LENGTH_SHORT).show();
                    resetProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}