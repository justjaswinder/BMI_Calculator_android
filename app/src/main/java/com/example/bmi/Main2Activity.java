package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    EditText et_ft,et_clc;
    RadioGroup rd_grp;
    Button btn_cnvrt,btn_clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et_ft = (EditText)findViewById(R.id.et_ft);
        et_clc  = (EditText)findViewById(R.id.et_clc);
        rd_grp  = findViewById(R.id.rd_grp);

        btn_cnvrt = (Button)findViewById(R.id.btn_cnvrt);


        btn_cnvrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(et_ft.getText().toString().equalsIgnoreCase("")){
//                    Toast.makeText(getApplicationContext(),"Enter Fahrenheit value",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(et_clc.getText().toString().equalsIgnoreCase("")){
//                    Toast.makeText(getApplicationContext(),"Enter Celsius value",Toast.LENGTH_SHORT).show();
//                    return;
//                }
                if(rd_grp.getCheckedRadioButtonId() == R.id.rd_f){
                    if(et_clc.getText().toString().equalsIgnoreCase("")){
                        Toast.makeText(getApplicationContext(),"Enter Celsius value",Toast.LENGTH_SHORT).show();
                        return;
                    }

                   // (1°F − 32) × 5/9
                    double res = ((Double.parseDouble(et_clc.getText().toString()) * 9/5) + (32));
                    et_ft.setText(res+"");


                }
               else if (rd_grp.getCheckedRadioButtonId() == R.id.rd_c){

                    if(et_ft.getText().toString().equalsIgnoreCase("")){
                        Toast.makeText(getApplicationContext(),"Enter Fahrenheit value",Toast.LENGTH_SHORT).show();
                        return;
                    }



                   // double res1 = ((Double.parseDouble(et_ft.getText().toString()) - 32) * (5/9));

                 //   double res1 = (- 31) * (5/9);
                  //  et_clc.setText(res1 +"");
                    DecimalFormat df = new DecimalFormat("#.###");
                    df.setRoundingMode(RoundingMode.CEILING);
                   // double cel = Double.valueOf(et_ft.getText().toString());

                  //  et_clc.setText("" + df.format((cel * 1.8) + 32));//setText("" +(cel * 1.8) + 32);

                    double feh = Double.parseDouble(et_ft.getText().toString());
                    feh = ((feh - 32) *  0.5556);
                    et_clc.setText(""+df.format(feh));

                }else{
                    Toast.makeText(getApplicationContext(),"Select Any radio button",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btn_clr= (Button)findViewById(R.id.btn_clr);


        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_ft.setText("");
                et_clc.setText("");
                rd_grp.clearCheck();

            }
        });
    }
}
