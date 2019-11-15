package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rbgReportActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbg_report);
        getSupportActionBar().setTitle("RANDOM BLOOD GLUCOSE REPORT");


        Intent intent=getIntent();
        String[] rbgReports=intent.getStringArrayExtra("rbgReports");

        TextView tv1=findViewById(R.id.nameView);
        tv1.setText(rbgReports[0]);
        TextView tv2=findViewById(R.id.ageView);
        tv2.setText(rbgReports[1]);
        TextView tv3=findViewById(R.id.genderView);
        tv3.setText(rbgReports[2]);
        TextView tv4=findViewById(R.id.referView);
        tv4.setText(rbgReports[3]);

        DateFormat df= new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dObj=new Date();
        String dateN=df.format(dObj);
        String[] dataAry=dateN.split(" ");
        TextView tv5=findViewById(R.id.dateView);
        tv5.setText(dataAry[0]);
        TextView tv6=findViewById(R.id.timeView);
        tv6.setText(dataAry[1]);

        TextView t1=findViewById(R.id.bloodView);
        t1.setText(rbgReports[4]);

    }
}
