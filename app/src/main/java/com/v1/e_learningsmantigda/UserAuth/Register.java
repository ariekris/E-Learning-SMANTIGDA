package com.v1.e_learningsmantigda.UserAuth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.v1.e_learningsmantigda.MainActivity;
import com.v1.e_learningsmantigda.R;

/**
 * Created by Arie Krisnoanto on 12/15/2017.
 */

public class Register extends AppCompatActivity {

    private EditText firstname, lastname, induksiswa, email, password;
    private Button btn_register;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btn_register = findViewById(R.id.btn_register);
        firstname = findViewById(R.id.inputFirstname);
        lastname = findViewById(R.id.inputLastname);
        induksiswa = findViewById(R.id.inputInduksiswa);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputFirstname = firstname.getText().toString().trim();
                String inputLastname = lastname.getText().toString().trim();
                String inputIndukSiswa = induksiswa.getText().toString().trim();
                String inputEmail = email.getText().toString().trim();
                String inputPassword = password.getText().toString().trim();

                if (TextUtils.isEmpty(inputFirstname)) {
                    Toast.makeText(getApplicationContext(), "Masukkan nama depan Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputLastname)) {
                    Toast.makeText(getApplicationContext(), "Masukkan nama belakang Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputIndukSiswa)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Nomor Induk Siswa Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputEmail)) {
                    Toast.makeText(getApplicationContext(), "Masukkan alamat email Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputPassword)) {
                    Toast.makeText(getApplicationContext(), "Masukkan kata sandi Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Kata sandi terlalu pendek, masukkan minimal 6 karakter!", Toast.LENGTH_SHORT).show();
                    return;
                }


                //create user
                auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                //progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Register.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

    }

/*    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }*/
}
