package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class calciumReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcium_report);
        getSupportActionBar().setTitle("CALCIUM REPORT");

        Intent intent=getIntent();
        String[] trialArray=intent.getStringArrayExtra("calReports");

        TextView tv1=findViewById(R.id.nameView);
        tv1.setText(trialArray[0]);
        TextView tv2=findViewById(R.id.ageView);
        tv2.setText(trialArray[1]);
        TextView tv3=findViewById(R.id.genderView);
        tv3.setText(trialArray[2]);
        TextView tv4=findViewById(R.id.referView);
        tv4.setText(trialArray[3]);

        DateFormat df= new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dObj=new Date();
        String dateN=df.format(dObj);
        String[] dataAry=dateN.split(" ");
        TextView tv5=findViewById(R.id.dateView);
        tv5.setText(dataAry[0]);
        TextView tv6=findViewById(R.id.timeView);
        tv6.setText(dataAry[1]);

        TextView serum=findViewById(R.id.serumView);
        serum.setText(trialArray[4]);
    }
}
