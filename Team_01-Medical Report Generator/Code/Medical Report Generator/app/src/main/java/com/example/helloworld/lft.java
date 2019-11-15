package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class lft extends AppCompatActivity {

    String[] lftReports=new String[50];
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lft);
        getSupportActionBar().setTitle("LIVER FUNCTION TEST DETAILS");


        Intent intent =getIntent();
        String[] trial=intent.getStringArrayExtra("lftName");
        lftReports= Arrays.copyOf(trial,trial.length+20);



//        lftReports[4]=e1.getText().toString().trim();


    }
    public void lftReport(View view)
        {

            e1=findViewById(R.id.h1);
            e2=findViewById(R.id.h2);
            e3=findViewById(R.id.h3);
            e4=findViewById(R.id.h4);
            e5=findViewById(R.id.h5);
            e6=findViewById(R.id.h6);
            e7=findViewById(R.id.h7);
            e8=findViewById(R.id.h8);
            e9=findViewById(R.id.h9);
            e10=findViewById(R.id.h10);

            lftReports[4]=e1.getText().toString().trim();
            lftReports[5]=e2.getText().toString().trim();
            lftReports[6]=e3.getText().toString().trim();
            lftReports[7]=e4.getText().toString().trim();
            lftReports[8]=e5.getText().toString().trim();
            lftReports[9]=e6.getText().toString().trim();
            lftReports[10]=e7.getText().toString().trim();
            lftReports[11]=e8.getText().toString().trim();
            lftReports[12]=e9.getText().toString().trim();
            lftReports[13]=e10.getText().toString().trim();

            Intent intent=new Intent(this,lftReportActivity.class);
            intent.putExtra("lftReports",lftReports);
            startActivity(intent);
        }
}


//    }
//    public void lftReport(View view)
//    {
//        Intent intent =new Intent(this,lftReportActivity.class);
//        intent.putExtra("lftReports",lftReports);
//        startActivity(intent);
//    }

