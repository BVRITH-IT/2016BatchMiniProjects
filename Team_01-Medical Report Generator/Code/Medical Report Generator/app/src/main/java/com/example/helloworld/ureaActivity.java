package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class ureaActivity extends AppCompatActivity {

    String[] ureaReports=new String[50];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urea);
        getSupportActionBar().setTitle("UREA DETAILS");

        Intent intent =getIntent();
        String[] trial=intent.getStringArrayExtra("ureaName");
        ureaReports= Arrays.copyOf(trial,trial.length+2);


    }
    public void ureaReport(View view)
    {

        EditText e1=findViewById(R.id.bloodUrea);

        ureaReports[4]=e1.getText().toString();

        Intent intent=new Intent(this,ureaReportActivity.class);
        intent.putExtra("ureaReports",ureaReports);
        startActivity(intent);
    }
}
