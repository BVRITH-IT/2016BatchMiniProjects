package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class uaReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ua_report);
        getSupportActionBar().setTitle("URIC ACID REPORT");


        Intent intent=getIntent();
        String[] uaReports=intent.getStringArrayExtra("uaReports");

        TextView tv1=findViewById(R.id.nameView);
        tv1.setText(uaReports[0]);
        TextView tv2=findViewById(R.id.ageView);
        tv2.setText(uaReports[1]);
        TextView tv3=findViewById(R.id.genderView);
        tv3.setText(uaReports[2]);
        TextView tv4=findViewById(R.id.referView);
        tv4.setText(uaReports[3]);

        DateFormat df= new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dObj=new Date();
        String dateN=df.format(dObj);
        String[] dataAry=dateN.split(" ");
        TextView tv5=findViewById(R.id.dateView);
        tv5.setText(dataAry[0]);
        TextView tv6=findViewById(R.id.timeView);
        tv6.setText(dataAry[1]);

        TextView t1=findViewById(R.id.uricAcidView);
        t1.setText(uaReports[4]);
    }
}
