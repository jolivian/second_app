package com.example.joe.second_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Joe on 1/30/2018.
 */

public class Chicken extends Activity{

    double counter;
    Button total, back;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken);
        counter = 0;
        total = (Button) findViewById(R.id.bTot);
        back = (Button) findViewById(R.id.bBack);
        display = (TextView) findViewById(R.id.tvDisplay);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter += 1.5 ;
                display.setText("Your total is " + counter);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                display.setText("Your total is " + counter);
            }
        });
    }
}
