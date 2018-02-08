package com.example.joe.second_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joe on 1/30/2018.
 */


/// left on trying to write to file.
public class Burger extends Activity implements View.OnClickListener {


    int burgerCounter = 0,chickenCounter = 0,friesCounter = 0, counter = 0;
    int valAddBurger,valAddChicken,valAddFries;
    int valSubBurger,valSubChicken,valSubFries;
    String emptyString = "", myfile = "output_file";
    double totalCost, burgerPrice =1.99, chickenPrice =1.5, friesPrice = 0.99;
    Button burgerTotal,chickenTotal,friesTotal, sendEmail;
    EditText inputAddBurger,inputAddChicken,inputAddFries;
    EditText inputSubBurger,inputSubChicken,inputSubFries;
    EditText inputForFile;
    TextView bDisplay,cDisplay, fDisplay, result;
    private Context context;
    //File file = new File(context.getFilesDir(),myfile);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burger);
        burgerTotal = (Button) findViewById(R.id.burger);
        burgerTotal.setOnClickListener(this);
        chickenTotal = (Button) findViewById(R.id.chicken);
        chickenTotal.setOnClickListener(this);
        friesTotal = (Button) findViewById(R.id.fries);
        friesTotal.setOnClickListener(this);
        final Button send = (Button) this.findViewById(R.id.output);
    }
    //burger total
    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.burger:
        burgerCounter = 0;
        //counter++;
        //counter = counter > 99 ? counter: 0;

        inputAddBurger =(EditText) findViewById(R.id.addBurger);
        inputSubBurger =(EditText) findViewById(R.id.subBurger);
        bDisplay = (TextView) findViewById(R.id.burgerDisplay);
        result = (TextView) findViewById(R.id.addResult);




                try {
                    inputAddBurger.setInputType(InputType.TYPE_CLASS_NUMBER);
                    inputSubBurger.setInputType(InputType.TYPE_CLASS_NUMBER);
                    valAddBurger = Integer.parseInt(inputAddBurger.getText().toString());
                    valSubBurger = Integer.parseInt(inputSubBurger.getText().toString());
                    burgerCounter = valAddBurger - valSubBurger;


                    totalCost = totalCost + (burgerCounter * burgerPrice);
                    if (totalCost > 0) {
                        result.setText("Your total is " + totalCost);
                    }
                    else
                    {
                        totalCost = 0;
                        result.setText("Your total is " + totalCost);

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                }


        break;


            case R.id.chicken:
        //chicken total
        //chickenCounter = 0;
        //counter++;
        //counter = counter > 99 ? counter: 0;

        inputAddChicken =(EditText) findViewById(R.id.addChicken);
        inputSubChicken =(EditText) findViewById(R.id.subChicken);
        cDisplay = (TextView) findViewById(R.id.chickenDisplay);
        //result = (TextView) findViewById(R.id.addResult);


                try {
                    inputAddChicken.setInputType(InputType.TYPE_CLASS_NUMBER);
                    inputSubChicken.setInputType(InputType.TYPE_CLASS_NUMBER);
                    valAddChicken = Integer.parseInt(inputAddChicken.getText().toString());
                    valSubChicken = Integer.parseInt(inputSubChicken.getText().toString());
                    chickenCounter = chickenCounter + valAddChicken - valSubChicken;

                    chickenCounter = chickenCounter > 0 ? chickenCounter:0;
                    totalCost = (chickenCounter * chickenPrice) + (burgerCounter* burgerPrice) + (friesCounter*friesPrice);
                    result.setText("Your total is " + totalCost);

                } catch (Exception e) {
                    e.printStackTrace();
                }


        break;



            case R.id.fries:
        //fries total
        //friesCounter = 0;
        //counter++;
        //counter = counter > 99 ? counter: 0;

        inputAddFries =(EditText) findViewById(R.id.addFries);
        inputSubFries =(EditText) findViewById(R.id.subFries);
        fDisplay = (TextView) findViewById(R.id.friesDisplay);
        //result = (TextView) findViewById(R.id.addResult);


                try {
                    inputAddFries.setInputType(InputType.TYPE_CLASS_NUMBER);
                    inputSubFries.setInputType(InputType.TYPE_CLASS_NUMBER);
                    valAddFries = Integer.parseInt(inputAddFries.getText().toString());
                    valSubFries = Integer.parseInt(inputSubFries.getText().toString());
                    friesCounter = valAddFries - valSubFries;


                    if (friesCounter > 0) {
                        totalCost = (chickenCounter * chickenPrice) + (burgerCounter* burgerPrice) + (friesCounter*friesPrice);
                        result.setText("Your total is " + totalCost);
                    }
                    else
                    {
                        friesCounter = 0;
                        totalCost = (chickenCounter * chickenPrice) + (burgerCounter* burgerPrice) + (friesCounter*friesPrice);
                        result.setText("Your total is " + totalCost);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            case R.id.output:
                counter++;
                counter = counter > 99 ? counter: 1;
                //inputForFile = (EditText) findViewById(R.id.output_name);
                //FileOutputStream outputStream;
                Log.i("Send email", "");

                /*String[] TO = {"someone@gmail.com"};
                String[] CC = {"xyz@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here"); */
                Log.i("SendMailActivity", "Send Button Clicked.");

                String fromEmail = "joeamp7@gmail.com";
                String fromPassword = "";
                String toEmails = "joeampuero@gmail.com";
                List toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                Log.i("SendMailActivity", "To List: " + toEmailList);
                String emailSubject = "Test";
                String emailBody = "Test";
                new SendMailTask(Burger.this).execute(fromEmail,
                        fromPassword, toEmailList, emailSubject, emailBody);

                try { //code in here may have problems keeps crashing.
                    /*
                    String customer_name = inputForFile.getText().toString();
                    String customer_order = "Order #" + counter + "/nTotal: " + totalCost;
                    outputStream = openFileOutput(myfile, Context.MODE_PRIVATE);
                    outputStream.write(customer_order.getBytes());
                    outputStream.write(customer_name.getBytes());
                    outputStream.close(); */

                }catch (Exception e){
                    e.printStackTrace();
                }



            break;
        default:
            break;
    }




}
}
