package com.example.simplesignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerCalculator extends AppCompatActivity {

    TextView reval;
    EditText v1,v2;
    Spinner spp;
    Button btres;
    int num1,num2;
    float res_val;
    ArrayAdapter<String > adapter;
    String rec="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_calculator);
        spp=(Spinner)findViewById(R.id.sp);
        btres=(Button)findViewById(R.id.btnres);
        v1=findViewById(R.id.val1);
        v2=findViewById(R.id.val2);
        reval=findViewById(R.id.ress);

        adapter=new ArrayAdapter<String>(SpinnerCalculator.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spp.setAdapter(adapter);
        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                       rec="ADD";

                        break;
                    case 1:
                        rec="SUBTRACT";
                        break;
                    case 2:
                        rec="MULTIPLY";
                        break;
                    case 3:
                        rec="DIVIDE";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SpinnerCalculator.this,"Nothing Selected",Toast.LENGTH_SHORT).show();

            }
        });
        btres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float value1=Float.parseFloat(v1.getText().toString());
                float value2=Float.parseFloat(v2.getText().toString());

                if(rec.equals("ADD")){
                    Add a=new Add();
                    float x= a.add(value1,value2);
                    reval.setText(String.valueOf(x));


                }
                if(rec.equals("SUBTRACT")){
                    Sub a=new Sub();
                    float x= a.sub(value1,value2);
                    reval.setText(String.valueOf(x));


                }
                if(rec.equals("MULTIPLY")){
                    Mul a=new Mul();
                    float x= a.mul(value1,value2);
                    reval.setText(String.valueOf(x));


                }
                if(rec.equals("DIVIDE")){
                    Div a=new Div();
                    Rem r=new Rem();
                    float x= a.div(value1,value2);
                    float y=r.rem(value1,value2);
                    reval.setText(String.valueOf(x)+" ,R: "+String.valueOf(y));


                }






            }
        });

    }
}