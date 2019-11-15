package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    EditText eView, pView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("LOGIN PAGE");


        eView = findViewById(R.id.userLview);
        pView = findViewById(R.id.passLView);

        firebaseAuth=FirebaseAuth.getInstance();

    }


    public void signUp(View view) {
        String userEmail = eView.getText().toString().trim();
        String userPaswd = pView.getText().toString().trim();
        if (userEmail.isEmpty()) {
            eView.setError("Please Provide Email First!");
            eView.requestFocus();
        } else if (userPaswd.isEmpty()) {
            pView.setError("Enter Password!");
            pView.requestFocus();
        } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
            Toast.makeText(MainActivity.this, "Fields Empty!!", Toast.LENGTH_SHORT).show();
        } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {

            firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                startActivity(new Intent(MainActivity.this,DetailActivity.class));

                            } else {

                                Toast.makeText(MainActivity.this,"Login Falied or user not Available",Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });

        } else {

            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


    public void register(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        mFirebaseAuth.addAuthStateListener(authStateListener);
    }
}



