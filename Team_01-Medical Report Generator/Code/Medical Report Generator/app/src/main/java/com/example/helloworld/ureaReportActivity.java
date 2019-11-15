package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ureaReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urea_report);
        getSupportActionBar().setTitle("UREA REPORT");


        Intent intent=getIntent();
        String[] ureaReports=intent.getStringArrayExtra("ureaReports");

        TextView tv1=findViewById(R.id.nameView);
        tv1.setText(ureaReports[0]);
        TextView tv2=findViewById(R.id.ageView);
        tv2.setText(ureaReports[1]);
        TextView tv3=findViewById(R.id.genderView);
        tv3.setText(ureaReports[2]);
        TextView tv4=findViewById(R.id.referView);
        tv4.setText(ureaReports[3]);

        DateFormat df= new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dObj=new Date();
        String dateN=df.format(dObj);
        String[] dataAry=dateN.split(" ");
        TextView tv5=findViewById(R.id.dateView);
        tv5.setText(dataAry[0]);
        TextView tv6=findViewById(R.id.timeView);
        tv6.setText(dataAry[1]);

        TextView t1=findViewById(R.id.bloodUreaView);
        t1.setText(ureaReports[4]);
    }
}
