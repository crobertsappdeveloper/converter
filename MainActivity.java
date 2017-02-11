package com.example.android.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float calculation;
    double finalCalculation;
    double rounded;
    String finalOutput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayCalculation(View view) {
        displayMessage(createCalculation());

    }

    private String createCalculation() {
        /* Returns the value of the checkbox from the ID from activity main. With the radio button being cast using (RadioButton) */
       RadioButton milesBox = (RadioButton) findViewById(R.id.miles);
       RadioButton kilometresBox = (RadioButton) findViewById(R.id.kilometres);
       RadioButton metresBox = (RadioButton) findViewById(R.id.metres);
       RadioButton footBox = (RadioButton) findViewById(R.id.foot);
        RadioButton centimetresBox = (RadioButton) findViewById(R.id.centimetres);
        RadioButton inchesBox = (RadioButton) findViewById(R.id.inches);
        RadioButton kilogramsBox = (RadioButton) findViewById(R.id.kilograms);
        RadioButton poundsBox = (RadioButton) findViewById(R.id.pounds);

        /* Stores whether the Radio button has been ticked or not in a boolean true/false variable with only two possible values */
        boolean milesChecked = milesBox.isChecked();
        boolean kilometresChecked = kilometresBox.isChecked();
        boolean metresChecked = metresBox.isChecked();
        boolean footChecked = footBox.isChecked();
        boolean centimetresChecked = centimetresBox.isChecked();
        boolean inchesChecked = inchesBox.isChecked();
        boolean kilogramsChecked = kilogramsBox.isChecked();
        boolean poundsChecked = poundsBox.isChecked();

        /* Gets the content of the text box and converts it from a string to a float */
        EditText convert = (EditText) findViewById(R.id.numeric);
        String conversion = convert.getText().toString();
        calculation = Float.parseFloat(conversion);
        if (milesChecked) {
            /* makes the calculation then rounds the figure to two decimal places after that it is converted back into a string so it can be displayed using return */
            finalCalculation = calculation * 1.6;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Kilometres";
            return finalOutput;
        }

        if (kilometresChecked) {
            finalCalculation = calculation / 1.6;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Miles";
            return finalOutput;
        }
        if (metresChecked) {
            finalCalculation = calculation * 3.28084;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Foot";
            return finalOutput;
        }

        if (footChecked) {
            finalCalculation = calculation / 3.28084;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Metres";
            return finalOutput;
        }
        if (centimetresChecked) {
            finalCalculation = calculation * 2.54;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Inches";
            return finalOutput;
        }

        if (inchesChecked) {
            finalCalculation = calculation / 2.54;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Centimetres";
            return finalOutput;
        }
        if (kilogramsChecked) {
            finalCalculation = calculation * 2.2;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Pounds";
            return finalOutput;
        }

        if (poundsChecked) {
            finalCalculation = calculation / 2.2;
            rounded = (double) Math.round(finalCalculation * 100) / 100;
            finalOutput = String.valueOf(rounded);
            finalOutput = finalOutput + " Kilograms";
            return finalOutput;
        }

        return finalOutput;
    }

    private void displayMessage(String message) {
        TextView calculationTextView = (TextView) findViewById(R.id.calculation_display);
        calculationTextView.setText(message);
    }

    public void ResetValues(View view) {
        /* Clears the text box */
        EditText emptyText = (EditText) findViewById(R.id.numeric);
        emptyText.setText("0");

        /* Clears the value calculation field */
        finalOutput = "";
        displayMessage(finalOutput);
    }
}
