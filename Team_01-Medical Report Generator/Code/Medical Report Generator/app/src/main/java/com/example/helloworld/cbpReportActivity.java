package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cbpReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbp_report);
        getSupportActionBar().setTitle("COMPLETE BLOOD PICTURE REPORT");

        Intent intent=getIntent();
        String[] thyReports=intent.getStringArrayExtra("cbpReports");
        TextView tv1=findViewById(R.id.nameView);
        tv1.setText(thyReports[0]);
        TextView tv2=findViewById(R.id.ageView);
        tv2.setText(thyReports[1]);
        TextView tv3=findViewById(R.id.genderView);
        tv3.setText(thyReports[2]);
        TextView tv4=findViewById(R.id.referView);
        tv4.setText(thyReports[3]);

        DateFormat df= new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dObj=new Date();
        String dateN=df.format(dObj);
        String[] dataAry=dateN.split(" ");
        TextView tv5=findViewById(R.id.dateView);
        tv5.setText(dataAry[0]);
        TextView tv6=findViewById(R.id.timeView);
        tv6.setText(dataAry[1]);

        TextView t1,t2,t3,t4,t5;
        t1=findViewById(R.id.hemoView);
        t2=findViewById(R.id.pcvView);
        t3=findViewById(R.id.totalRbc);
        t4=findViewById(R.id.plateletCount);
        t5=findViewById(R.id.wbcCount);

        t1.setText(thyReports[4]);
        t2.setText(thyReports[5]);
        t3.setText(thyReports[6]);
        t4.setText(thyReports[7]);
        t5.setText(thyReports[8]);
    }
}
