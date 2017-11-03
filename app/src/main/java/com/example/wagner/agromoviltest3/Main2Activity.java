package com.example.wagner.agromoviltest3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class Main2Activity extends AppCompatActivity {

    DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        picker=findViewById(R.id.datePicker2);

        final Button button = findViewById(R.id.button_cal_next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, available_transporters.class));
            }
        });
    }

    // returns an int corresponding to the date the user picks
    public int getCurrentDate(){
        int date = picker.getDayOfMonth();
        return date;
    }
}