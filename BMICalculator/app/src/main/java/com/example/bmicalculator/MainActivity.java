package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText height, weight;
    private ImageView imageView1, imageView2, imageView3,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onBtnCLick(View view) {
        height=findViewById(R.id.htEdText);
        weight=findViewById(R.id.wtEdText);
        result=findViewById(R.id.txtResult);
        imageView1=findViewById(R.id.image1);
        imageView2=findViewById(R.id.image2);
        imageView3=findViewById(R.id.image3);


        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }



    private void displayBMI(float bmi) {
        String bmiLabel = "";
        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "very_severely_underweight";
            image=imageView2;
            imageView2.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "severely_underweight";
            image=imageView2;
            imageView2.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "underweight";
            image=imageView2;
            imageView2.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "normal";
            image=imageView1;
            imageView1.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "overweight";
            image=imageView3;
            imageView3.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "obese_class_i";
            image=imageView3;
            imageView3.setVisibility(View.VISIBLE);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "obese_class_ii";
            image=imageView3;
            imageView3.setVisibility(View.VISIBLE);
        } else {
            bmiLabel = "obese_class_iii";
            image=imageView3;
            imageView3.setVisibility(View.VISIBLE);
        }
        bmiLabel=bmi+"\n"+bmiLabel;
        result.setText(bmiLabel);
        String finalMessage="Click on Image to maintain your BMI";

        if(image!=imageView1){
            Toast.makeText(this,finalMessage,Toast.LENGTH_LONG).show();
        }
        if(image==imageView1)
        {
            imageView2.setVisibility(View.GONE);
            imageView3.setVisibility(View.GONE);
        }
        if(image==imageView2)
        {
            imageView3.setVisibility(View.GONE);
            imageView1.setVisibility(View.GONE);
        }

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.healthline.com/nutrition/18-foods-to-gain-weight");
            }
        });
        if(image==imageView3)
        {
            imageView2.setVisibility(View.GONE);
            imageView1.setVisibility(View.GONE);
        }

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.healthline.com/nutrition/30-ways-to-lose-weight-naturally");
            }
        });

    }
    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}