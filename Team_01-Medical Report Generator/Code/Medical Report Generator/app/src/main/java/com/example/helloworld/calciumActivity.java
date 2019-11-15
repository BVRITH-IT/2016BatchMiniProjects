package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

public class calciumActivity extends AppCompatActivity {

    EditText e1;
    String[] calReports=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcium);
        getSupportActionBar().setTitle("CALCIUM REPORT DETAILS");

        Intent intent =getIntent();
        String[] trial=intent.getStringArrayExtra("calName");
        calReports= Arrays.copyOf(trial,trial.length+4);


    }

    public void calReport(View view)
    {

        e1=findViewById(R.id.serumCalc);

        calReports[4]=e1.getText().toString().trim();

        Intent intent=new Intent(this,calciumReportActivity.class);
        intent.putExtra("calReports",calReports);
        startActivity(intent);
    }
}
