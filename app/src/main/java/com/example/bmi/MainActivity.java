package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_feet,et_inch,et_pound;
    TextView tv_result;
    Button btn_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_feet = (EditText)findViewById(R.id.et_feet);
        et_inch  = (EditText)findViewById(R.id.et_inch);
        et_pound  = (EditText)findViewById(R.id.et_pound);
         tv_result = (TextView) findViewById(R.id.tv_result);
         btn_calc = (Button)findViewById(R.id.btn_calc);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }


    private void calculate() {

        double feet , inch ,weight , result, finalHeight;

        if(et_feet.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"Enter Feet value",Toast.LENGTH_SHORT).show();
            return;
        }
        if(et_inch.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"Enter Inch value",Toast.LENGTH_SHORT).show();
            return;
        }
        if(et_pound.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"Enter Pound value",Toast.LENGTH_SHORT).show();
            return;
        }
        feet = Double.parseDouble(et_feet.getText().toString());
        inch = Double.parseDouble(et_inch.getText().toString());
        weight = Double.parseDouble(et_pound.getText().toString());

        finalHeight = (feet * 12) + inch;
        result = (weight * 703) / (finalHeight * finalHeight);

        tv_result.setText(String.format("%,.2f", result));
    }
}
