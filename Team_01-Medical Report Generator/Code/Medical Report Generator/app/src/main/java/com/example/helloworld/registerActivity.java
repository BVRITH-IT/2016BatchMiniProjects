package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerActivity extends AppCompatActivity {

    EditText eView,pView;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("REGISTRATION PAGE");

        databaseReference= FirebaseDatabase.getInstance().getReference("medicalReports");
        firebaseAuth=FirebaseAuth.getInstance();
        }
    public void registered(View view)
    {
        eView=findViewById(R.id.eMail);
        pView=findViewById(R.id.pass);

        final String eMail=eView.getText().toString();
        final String pass=pView.getText().toString();

        if(eMail.isEmpty())
        {
            eView.setError("Please Enter Email");
            eView.requestFocus();
        }
        else if(pass.isEmpty())
        {
            pView.setError("Please Enter Password");
            pView.requestFocus();
        }
        else if(eMail.isEmpty() && pass.isEmpty())
        {
            Toast.makeText(this,"Fields Are Empty!!",Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.createUserWithEmailAndPassword(eMail, pass)
                .addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            student information= new student(eMail,pass);

                            FirebaseDatabase.getInstance().getReference("medicalReports")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(registerActivity.this,"Registration Complete!!;)",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(registerActivity.this,MainActivity.class));
                                }
                            });
                        } else {


                        }

                        // ...
                    }
                });
    }

    }