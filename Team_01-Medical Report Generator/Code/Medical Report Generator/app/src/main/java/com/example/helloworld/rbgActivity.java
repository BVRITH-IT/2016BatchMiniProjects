package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class rbgActivity extends AppCompatActivity {
    EditText e1;
    String[] rbgReports=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbg);
        getSupportActionBar().setTitle("RANDOM BLOOD GLUCOSE DETAILS");


        Intent intent =getIntent();
        String[] trial=intent.getStringArrayExtra("rbgName");
        rbgReports= Arrays.copyOf(trial,trial.length+2);



    }

    public void reportGenerator(View view)
    {

        e1=findViewById(R.id.bloodGlucose);

        rbgReports[4]=e1.getText().toString().trim();

        Intent intent=new Intent(this,rbgReportActivity.class);
        intent.putExtra("rbgReports",rbgReports);
        startActivity(intent);
    }
}
