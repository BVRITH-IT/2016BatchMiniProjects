package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class cbpActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    String[] cbpReports=new String[50];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbp);
        getSupportActionBar().setTitle("COMPLETE BLOOD PICTURE");

        Intent intent=getIntent();
        String[] trialArray=intent.getStringArrayExtra("cbpName");
        cbpReports= Arrays.copyOf(trialArray,trialArray.length+6);


    }
    public void cbpReport(View view)
    {
        e1=findViewById(R.id.hemoView);
        e2=findViewById(R.id.pvcView);
        e3=findViewById(R.id.rbcCount);
        e4=findViewById(R.id.totalPlatelet);
        e5=findViewById(R.id.totalWbc);

        cbpReports[4]=e1.getText().toString().trim();
        cbpReports[5]=e2.getText().toString().trim();
        cbpReports[6]=e3.getText().toString().trim();
        cbpReports[7]=e4.getText().toString().trim();
        cbpReports[8]=e5.getText().toString().trim();
        Intent intent=new Intent(this,cbpReportActivity.class);
        intent.putExtra("cbpReports",cbpReports);
        startActivity(intent);
    }
}
