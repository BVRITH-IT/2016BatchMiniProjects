package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ThyroidActivity extends AppCompatActivity {

    String[] thyArray=new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thyroid);
        getSupportActionBar().setTitle("THYRIOD DETAILS");


        Intent intent=getIntent();
        String[] exArray=intent.getStringArrayExtra("shortName");
        thyArray= Arrays.copyOf(exArray,exArray.length+4);

    }
    public void reportGenerator(View view)
    {
        EditText e1=findViewById(R.id.t3id);
        String t3=e1.getText().toString();
        EditText e2=findViewById(R.id.t4id);
        String t4=e2.getText().toString();
        EditText e3=findViewById(R.id.totalTsh);
        String totalTsh=e3.getText().toString();
        thyArray[4]=t3;
        thyArray[5]=t4;
        thyArray[6]=totalTsh;

        Intent reportIntent=new Intent(this,thyroidReportActivity.class);
        reportIntent.putExtra("thyroidDetails",thyArray);
        startActivity(reportIntent);
    }
}
