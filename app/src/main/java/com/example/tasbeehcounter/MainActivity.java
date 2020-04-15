package com.example.tasbeehcounter;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreference;
    String MyPREFERENCES = "MyPrefs" ;
    private String value = "valueKey";
    private int defaultTasbeehValue = 0;
    TextView mTextViewDisplay;
    FloatingActionButton mButtonCounter;
    FloatingActionButton mButtonRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewDisplay = findViewById(R.id.txt_display);
        sharedPreference = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        mButtonCounter = findViewById(R.id.btn_counter);
        mButtonRest = findViewById(R.id.btn_reset);
        //
        final SharedPreferences.Editor editor = sharedPreference.edit();
        int initialLastValue = sharedPreference.getInt(value, defaultTasbeehValue);
        mTextViewDisplay.setText(String.valueOf(initialLastValue));

        mButtonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringValue = mTextViewDisplay.getText().toString();
                int originalValue = Integer.parseInt(stringValue);
                int newValue = originalValue + 1;
                String displayValue = Integer.toString(newValue);
                mTextViewDisplay.setText(displayValue);


                editor.putInt(value,newValue);
                editor.apply();
            }
        });
        mButtonRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reset = "0";
                mTextViewDisplay.setText(reset);
                editor.putInt(value, defaultTasbeehValue);
                editor.apply();

            }
        });
    }
}
