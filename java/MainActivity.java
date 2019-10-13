package com.example.emi_cal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1_prin,e2_roi,e3_time;
    TextView t_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           e1_prin = (EditText)findViewById(R.id.editText1);
           e2_roi = (EditText)findViewById(R.id.editText2);
           e3_time = (EditText)findViewById(R.id.editText3);
           t_display = (TextView)findViewById(R.id.textView);
           b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1_prin.getText().toString();
                String s2 = e2_roi.getText().toString();
                String s3 = e3_time.getText().toString();

                double p = Double.parseDouble(s1);
                double roi = Double.parseDouble(s2);
                double n = Double.parseDouble(s3);
                double  res = EmiCalculator(p,roi,n);
                String result = Double.toString(res);
                System.out.println("Calculated Emi is:");
                t_display.setText(String.valueOf(result));
            }
        });
    }
    public  double EmiCalculator(double p, double roi, double n)
    {
        double r=roi;
        r = roi/(12*100);
        double emi = (p*r*Math.pow((1+r),n)/(Math.pow((1+r),(n))-1));
        return emi;
    }
}
