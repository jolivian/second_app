package com.example.joe.second_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Joe on 1/30/2018.
 */

public class Burger extends Activity{


    int counter;
    Button add, sub;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burger);
        counter = 0;
        add = (Button) findViewById(R.id.bTot);
        sub = (Button) findViewById(R.id.bBack);
        display = (TextView) findViewById(R.id.tvDisplay);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                display.setText("Your total is " + counter);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                display.setText("Your total is " + counter);
            }
        });
    }
}
