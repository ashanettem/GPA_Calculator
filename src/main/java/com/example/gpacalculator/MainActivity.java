package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText eT3;
    EditText eT4;
    EditText eT5;
    EditText eT6;
    EditText eT7;

    TextView mTv;
    TextView mTv2;
    TextView mTv3;
    TextView mTv4;
    TextView mTv5;
    TextView mTv6;
    TextView mTv7;
    Button mButton;
    ConstraintLayout mCL;


    double grade1;
    double grade2;
    double grade3;
    double grade4;
    double grade5;

    double gpa;

    boolean buttonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT3 = (EditText)findViewById(R.id.editText3);
        eT4 = (EditText)findViewById(R.id.editText4);
        eT5 = (EditText)findViewById(R.id.editText5);
        eT6 = (EditText)findViewById(R.id.editText6);
        eT7 = (EditText)findViewById(R.id.editText7);
        mTv = (TextView)findViewById(R.id.textView);
        mTv2 = (TextView)findViewById(R.id.textView2);
        mTv3 = (TextView)findViewById(R.id.textView3);
        mTv4 = (TextView)findViewById(R.id.textView4);
        mTv5 = (TextView)findViewById(R.id.textView5);
        mTv6 = (TextView)findViewById(R.id.textView6);
        mTv7 = (TextView)findViewById(R.id.textView7);
        mButton = (Button)findViewById(R.id.button);
        mCL = (ConstraintLayout)findViewById(R.id.thisLayout);


    }

    public void calculateGPA(View view) {

        if(buttonPressed){
            clear(view);
            mButton.setText(getResources().getString(R.string.button_compute));
        }
        else {


            if(TextUtils.isEmpty(eT3.getText().toString())  || TextUtils.isEmpty(eT4.getText().toString())
                || TextUtils.isEmpty(eT5.getText().toString()) || TextUtils.isEmpty(eT6.getText().toString())
                    || TextUtils.isEmpty(eT7.getText().toString()))
                {

                Toast.makeText(MainActivity.this, "Fill in grades for all courses", Toast.LENGTH_SHORT).show();
                return;
            }

            buttonPressed = true;

            grade1 = Double.parseDouble(eT3.getText().toString());
            grade2 = Double.parseDouble(eT4.getText().toString());
            grade3 = Double.parseDouble(eT5.getText().toString());
            grade4 = Double.parseDouble(eT6.getText().toString());
            grade5 = Double.parseDouble(eT7.getText().toString());

            gpa = ((grade1 + grade2 + grade3 + grade4 + grade5) / 5);

            mTv7.setText(getResources().getString(R.string.gpa) + " " + Double.toString(gpa));

            mButton.setText(getResources().getString(R.string.button_clear));


            changeColor(gpa);
        }
    }

    public void clear(View view){
        eT3.getText().clear();
        eT4.getText().clear();
        eT5.getText().clear();
        eT6.getText().clear();
        eT7.getText().clear();

        mTv7.setText(getResources().getString(R.string.gpa));

        mCL.setBackgroundColor(getResources().getColor(R.color.blue));
        eT3.setTextColor(getResources().getColor(R.color.yellow));
        eT4.setTextColor(getResources().getColor(R.color.yellow));
        eT5.setTextColor(getResources().getColor(R.color.yellow));
        eT6.setTextColor(getResources().getColor(R.color.yellow));
        eT7.setTextColor(getResources().getColor(R.color.yellow));
        mTv.setTextColor(getResources().getColor(R.color.yellow));
        mTv2.setTextColor(getResources().getColor(R.color.yellow));
        mTv3.setTextColor(getResources().getColor(R.color.yellow));
        mTv4.setTextColor(getResources().getColor(R.color.yellow));
        mTv5.setTextColor(getResources().getColor(R.color.yellow));
        mTv6.setTextColor(getResources().getColor(R.color.yellow));
        mTv7.setTextColor(getResources().getColor(R.color.yellow));

        buttonPressed = false;
    }


    public void changeColor(double gpa){

        if(gpa <= 100 && gpa >= 80){
            mCL.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(gpa <= 79 && gpa >= 61 ){
            mCL.setBackgroundColor(getResources().getColor(R.color.yellow));
            eT3.setTextColor(getResources().getColor(R.color.black));
            eT4.setTextColor(getResources().getColor(R.color.black));
            eT5.setTextColor(getResources().getColor(R.color.black));
            eT6.setTextColor(getResources().getColor(R.color.black));
            eT7.setTextColor(getResources().getColor(R.color.black));
            mTv.setTextColor(getResources().getColor(R.color.black));
            mTv2.setTextColor(getResources().getColor(R.color.black));
            mTv3.setTextColor(getResources().getColor(R.color.black));
            mTv4.setTextColor(getResources().getColor(R.color.black));
            mTv5.setTextColor(getResources().getColor(R.color.black));
            mTv6.setTextColor(getResources().getColor(R.color.black));
            mTv7.setTextColor(getResources().getColor(R.color.black));

        }
        else if(gpa <= 60){
            mCL.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else{
            mCL.setBackgroundColor(getResources().getColor(R.color.blue));
        }

    }

}
