package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import static android.widget.Toast.LENGTH_SHORT;

public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    public void reportGenerator(View view)
    {
        Spinner testSpin= findViewById(R.id.testSpinner);
        String test= testSpin.getSelectedItem().toString();
        getSupportActionBar().setTitle("ENTER YOU DETAILS");

        Spinner initialSpin=findViewById(R.id.initialsSpinner);
        String inName=initialSpin.getSelectedItem().toString();
        EditText et=findViewById(R.id.patientName);
        String fName=et.getText().toString();

        EditText ageEt=findViewById(R.id.age);
        String age=ageEt.getText().toString();
        Spinner ageSpin=findViewById(R.id.ageSpinner);
        String ageYM=ageSpin.getSelectedItem().toString();

        RadioGroup rg=findViewById(R.id.genderRadioGroup);
        RadioButton rb=findViewById(rg.getCheckedRadioButtonId());
        String gender=rb.getText().toString();

        EditText et1=findViewById(R.id.referrerName);
        String referrer=et1.getText().toString();

        String[] exArray=new String[]{inName+" "+fName,age+" "+ageYM,gender,referrer};

//        detailClass dc=new detailClass(initials+" "+pName,age+" "+yom,gender,referrer);

        switch (test)
        {
            case "THYROID PROFILE(T3,T4,TSH)":
                Intent thyroidIntent=new Intent(this,ThyroidActivity.class);
                thyroidIntent.putExtra("shortName",exArray);
                startActivity(thyroidIntent);
                break;
            case "LIVER FUNCTION TEST":
                Intent lftIntent=new Intent(this,lft.class);
                lftIntent.putExtra("lftName",exArray);
                startActivity(lftIntent);
                break;
            case "UREA":
                Intent ureaIntent=new Intent(this,ureaActivity.class);
                ureaIntent.putExtra("ureaName",exArray);
                startActivity(ureaIntent);
                break;
            case "COMPLETE BLOOD PICTURE(CBP)":
                Intent cbpIntent=new Intent(this,cbpActivity.class);
                cbpIntent.putExtra("cbpName",exArray);
                startActivity(cbpIntent);
                break;
            case "CALCIUM":
                Intent calIntent=new Intent(this,calciumActivity.class);
                calIntent.putExtra("calName",exArray);
                startActivity(calIntent);
                break;
            case "RANDOM BLOOD GLUCOSE(RBG)":
                Intent rbgIntent=new Intent(this,rbgActivity.class);
                rbgIntent.putExtra("rbgName",exArray);
                startActivity(rbgIntent);
                break;
            case "URIC ACID":
                Intent uaIntent=new Intent(this,uaActivity.class);
                uaIntent.putExtra("uriName",exArray);
                startActivity(uaIntent);
                break;
        }

    }


}
