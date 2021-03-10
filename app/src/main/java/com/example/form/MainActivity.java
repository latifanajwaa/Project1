package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.form.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText etTipeK, etBrand, etName, etLicense, etTSpeed, etGCapacity, etWheel, etTipe, etESystem;
    Button btSavetype, btSubmit, btTest;
    ActivityMainBinding mb;
    String name, email, pass, brand;
    String licenseE = "[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+";
    TextView vehicle, list;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mb.getRoot();
        setContentView(view);

        etTipeK = findViewById(R.id.etTipeK);
        etBrand = findViewById(R.id.etBrand);
        etName = findViewById(R.id.etName);
        etLicense = findViewById(R.id.etLicense);
        etTSpeed = findViewById(R.id.etTSpeed);
        etGCapacity = findViewById(R.id.etGCapacity);
        etWheel = findViewById(R.id.etWheel);
        etTipe = findViewById(R.id.etTipe);
        etESystem = findViewById(R.id.etESystem);
        btSavetype = findViewById(R.id.btSavetype);
        btSubmit = findViewById(R.id.btSubmit);
        btTest = findViewById(R.id.btTest);

        vehicle = (TextView)findViewById(R.id.Vehicle);
        list = (TextView)findViewById(R.id.list);

        String tipeK = etTipeK.getText().toString();
        if (tipeK.equals("Mobil") || tipeK.equals("Motor")) {
            Toast.makeText(MainActivity.this, "enter Tipe Kendaraan", Toast.LENGTH_LONG).show();
            return;
        }

        String brand = etBrand.getText().toString();
        if (brand.length() < 5){
            Toast.makeText(MainActivity.this, "enter Brand", Toast.LENGTH_LONG).show();
            return;
        }
        String name = etName.getText().toString();
        if (name.length() < 5){
            Toast.makeText(MainActivity.this, "enter Name", Toast.LENGTH_LONG).show();
            return;
        }
        String license = etLicense.getText().toString();
        if (license.matches("[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+")){
            Toast.makeText(MainActivity.this, "input License", Toast.LENGTH_LONG).show();
            return;
        }
        String topSpeed = etTSpeed.getText().toString();
        if (topSpeed.matches("[100-250]")){
            Toast.makeText(MainActivity.this, "input Top Speed", Toast.LENGTH_LONG).show();
            return;
        }
        String gasCap = etGCapacity.getText().toString();
        if (gasCap.matches("[30-60]")){
            Toast.makeText(MainActivity.this, "input gas capacity", Toast.LENGTH_LONG).show();
            return;
        }
        String wheel = etWheel.getText().toString();
        if (wheel.matches("[2-3]")){
            Toast.makeText(MainActivity.this, "input Wheel", Toast.LENGTH_LONG).show();
            return;
        }
        String tipe = etTipe.getText().toString();
        if (tipe.equals("SUV") || tipe.equals("Minivan") || tipe.equals("Supercar")) {
            Toast.makeText(MainActivity.this, "enter Tipe ", Toast.LENGTH_LONG).show();
            return;
        }
            String esystem = etESystem.getText().toString();
            if (esystem.matches("[1]+")) {
                Toast.makeText(MainActivity.this, "enter ES amount ", Toast.LENGTH_LONG).show();
                return;
            }

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    vehicle.setText(etTipeK.getText().toString() + etName.getText().toString());

                }
            });

            btTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   list.setText("Brand : " + etBrand.getText().toString() +"Name : " + etName.getText().toString()
                   + "License Plate : " + etLicense.getText().toString() + "Type : " + etTipe.getText().toString()
                   + "Gas capacity : " + etGCapacity.getText().toString() +  "Top Speed : " + topSpeed.getBytes().toString()
                   + "Wheel(s) : " + etWheel.getText().toString() + "Entertainment System : " + etESystem.getText().toString()
                   );
                }
            });









        }
    }
