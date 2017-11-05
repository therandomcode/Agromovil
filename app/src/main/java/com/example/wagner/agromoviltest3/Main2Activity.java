package com.example.wagner.agromoviltest3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;

public class Main2Activity extends AppCompatActivity {

    DatePicker picker;
    CheckBox amCheckbox;
    CheckBox pmCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        picker=findViewById(R.id.datePicker2);
        amCheckbox=findViewById(R.id.amCheckBox);
        pmCheckbox=findViewById(R.id.pmCheckBox);

        final Button button = findViewById(R.id.button_cal_next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Main2Activity.this, available_transporters.class);
                Bundle myBundle = new Bundle();

                //Add whatever needs to be read from this screen to the bundle
                myBundle.putInt("myDate", getCurrentDate());
                myBundle.putBoolean("myAM", amCheckbox.isChecked());
                myBundle.putBoolean("myPM", pmCheckbox.isChecked());

                myIntent.putExtras(myBundle);
                startActivity(myIntent);
            }
        });
    }

    // returns an int corresponding to the date the user picks
    public int getCurrentDate(){
        int date = picker.getDayOfMonth();
        return date;
    }

}