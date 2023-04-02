package com.application.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.application.converter.unit.LengthUnit;
import com.application.converter.unit.TemperatureUnit;
import com.application.converter.unit.WeightUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    // UI elements
    private TextView title;
    private EditText inputUnit, outputUnit;
    private Spinner fromUnit, toUnit, mainUnit;
    private Button submitBtn, clearBtn;
    private String[] mainUnitList = new String[]{"Length", "Weight", "Temperature"};
    private String[] lengthUnitList = new String[]{"Mile", "Yard", "Foot", "Inch"};
    private String[] weightUnitList = new String[]{"Pound", "Ounce", "Gram", "Kilogram"};
    private String[] temperatureUnitList = new String[]{"Fahrenheit", "Celsius", "Kelvin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        title = (TextView) findViewById(R.id.title);
        inputUnit = (EditText) findViewById(R.id.inputUnit);
        outputUnit = (EditText) findViewById(R.id.resultUnit);
        fromUnit = (Spinner) findViewById(R.id.fromUnit);
        toUnit = (Spinner) findViewById(R.id.toUnit);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        clearBtn = (Button) findViewById(R.id.exitBtn);
        mainUnit = (Spinner) findViewById(R.id.unitList);

        // Set up outputUnit to be uneditable
        outputUnit.setEnabled(false);


        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mainUnitList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainUnit.setAdapter(adapter);


        mainUnit.setOnItemSelectedListener(this);
        String selection = "Length";
        int spinnerPosition = adapter.getPosition(selection);
        mainUnit.setSelection(spinnerPosition);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        if (item.equals("Length")) {
            setSpinner(fromUnit, toUnit, lengthUnitList);
        } else if (item.equals("Weight")) {
            setSpinner(fromUnit, toUnit, weightUnitList);
        } else if (item.equals("Temperature")) {
            setSpinner(fromUnit, toUnit, temperatureUnitList);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void setSpinner(Spinner spinner, Spinner subSpin, String[] array) {
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        subSpin.setAdapter(adapter);
    }


    public void submit(View view) {
        String input = inputUnit.getText().toString();
        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();

       if (input.equals("")) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        } else if (from.equals(to))
       {
           Toast.makeText(this, "From source and to destination are same", Toast.LENGTH_SHORT).show();
       }
       else {
            double value = Double.parseDouble(input);
            double result = 0;

            TemperatureUnit temp = new TemperatureUnit();
            LengthUnit length = new LengthUnit();
            WeightUnit weight = new WeightUnit();

            if (from.equals("Fahrenheit") && to.equals("Celsius")) {
                result = temp.fahrenheitToCelsius(value);
            } else if (from.equals("Fahrenheit") && to.equals("Kelvin")) {
                result = temp.fahrenheitToKelvin(value);
            } else if (from.equals("Celsius") && to.equals("Fahrenheit")) {
                result = temp.celsiusToFahrenheit(value);
            } else if (from.equals("Celsius") && to.equals("Kelvin")) {
                result = temp.celsiusToKelvin(value);
            } else if (from.equals("Kelvin") && to.equals("Fahrenheit")) {
                result = temp.kelvinToFahrenheit(value);
            } else if (from.equals("Kelvin") && to.equals("Celsius")) {
                result = temp.kelvinToCelsius(value);
            } else if (from.equals("Mile") && to.equals("Yard")) {
                result = length.mileToYard(value);
            } else if (from.equals("Mile") && to.equals("Foot")) {
                result = length.mileToFoot(value);
            } else if (from.equals("Mile") && to.equals("Inch")) {
                result = length.mileToInch(value);
            } else if (from.equals("Yard") && to.equals("Mile")) {
                result = length.yardToMile(value);
            } else if (from.equals("Yard") && to.equals("Foot")) {
                result = length.yardToFoot(value);
            } else if (from.equals("Yard") && to.equals("Inch")) {
                result = length.yardToInch(value);
            } else if (from.equals("Foot") && to.equals("Mile")) {
                result = length.footToMile(value);
            } else if (from.equals("Foot") && to.equals("Yard")) {
                result = length.footToYard(value);
            } else if (from.equals("Foot") && to.equals("Inch")) {
                result = length.footToInch(value);
            } else if (from.equals("Inch") && to.equals("Mile")) {
                result = length.inchToMile(value);
            } else if (from.equals("Inch") && to.equals("Yard")) {
                result = length.inchToYard(value);
            } else if (from.equals("Inch") && to.equals("Foot")) {
                result = length.inchToFoot(value);
            } else if (from.equals("Pound") && to.equals("Ounce")) {
                result = weight.poundToOunce(value);
            } else if (from.equals("Pound") && to.equals("Gram")) {
                result = weight.poundToGram(value);
            } else if (from.equals("Pound") && to.equals("Kilogram")) {
                result = weight.poundToKilogram(value);
            } else if (from.equals("Ounce") && to.equals("Pound")) {
                result = weight.ounceToPound(value);
            } else if (from.equals("Ounce") && to.equals("Gram")) {
                result = weight.ounceToGram(value);
            } else if (from.equals("Ounce") && to.equals("Kilogram")) {
                result = weight.ounceToKilogram(value);
            } else if (from.equals("Gram") && to.equals("Pound")) {
                result = weight.gramToPound(value);
            } else if (from.equals("Gram") && to.equals("Ounce")) {
                result = weight.gramToOunce(value);
            } else if (from.equals("Gram") && to.equals("Kilogram")) {
                result = weight.gramToKilogram(value);
            } else if (from.equals("Kilogram") && to.equals("Pound")) {
                result = weight.kilogramToPound(value);
            } else if (from.equals("Kilogram") && to.equals("Ounce")) {
                result = weight.kilogramToOunce(value);
            } else if (from.equals("Kilogram") && to.equals("Gram")) {
                result = weight.kilogramToGram(value);
            } else {
                result = value;
            }

            outputUnit.setText(String.valueOf(result));
        }

    }

    // This method is called when the user clicks the exit button
    public void exit(View view) {
        finish();
        System.exit(0);
    }

}