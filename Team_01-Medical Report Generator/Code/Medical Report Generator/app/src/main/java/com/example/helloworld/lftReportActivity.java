package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class lftReportActivity extends AppCompatActivity {

    String[] trialArray=new String[50];
    TextView e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lft_report);
        getSupportActionBar().setTitle("LIVER FUNCTION TEST REPORT");


        Intent intent =getIntent();
        String[] trial=intent.getStringArrayExtra("lftReports");
        trialArray= Arrays.copyOf(trial,trial.length+20);


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

        e1=findViewById(R.id.blabla1);
        e2=findViewById(R.id.blabla2);
        e3=findViewById(R.id.blabla3);
        e4=findViewById(R.id.blabla4);
        e5=findViewById(R.id.blabla5);
        e6=findViewById(R.id.blabla6);
        e7=findViewById(R.id.blabla7);
        e8=findViewById(R.id.blabla8);
        e9=findViewById(R.id.blabla9);
        e10=findViewById(R.id.blabla10);
//
        e1.setText(trialArray[4]);
        e2.setText(trialArray[5]);
        e3.setText(trialArray[6]);
        e4.setText(trialArray[7]);
        e5.setText(trialArray[8]);
        e6.setText(trialArray[9]);
        e7.setText(trialArray[10]);
        e8.setText(trialArray[11]);
        e9.setText(trialArray[12]);
        e10.setText(trialArray[13]);

//        e2.setText("Ritesh ramchandnai");
//        e3.setText("Ritesh ramchandnai");
//        e4.setText("Ritesh ramchandnai");
//        e5.setText("Ritesh ramchandnai");
//        e6.setText("Ritesh ramchandnai");
//        e7.setText("Ritesh ramchandnai");
//        e8.setText("Ritesh ramchandnai");
//        e9.setText("Ritesh ramchandnai");
//        e10.setText("Ritesh ramchandnai");
    }
}
