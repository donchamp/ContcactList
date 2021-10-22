package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToggleButton();
        setForEditing(false);
        initListButton();
        initMapButton();
        initSetButton();
        initChangeDateButton();
    }
    private void initSetButton(){
        Button SetButton = findViewById(R.id.buttonSettings);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    private void initMapButton(){
            Button MapButton = findViewById(R.id.buttonMap);
            MapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
    }

    private void initListButton(){
        Button listButton = findViewById(R.id.buttonList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        }
    private void initToggleButton(){
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setForEditing(toggleButton.isChecked());
            }
        });
    }

    private void initChangeDateButton(){
        Button changeDateButton = findViewById(R.id.buttonChange);
        changeDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
            }
        });
    }

    private void setForEditing(boolean enabled){
        EditText editContact = findViewById(R.id.editContact);
        EditText editAddress = findViewById(R.id.editAddress);
        EditText editCity = findViewById(R.id.editCity);
        EditText editState = findViewById(R.id.editState);
        EditText editZipCode = findViewById(R.id.editZipCode);
        EditText editHomePhone = findViewById(R.id.editHomePhone);
        EditText editCellPhone = findViewById(R.id.editCellPhone);
        EditText editEmailAddress = findViewById(R.id.editEmailAddress);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonChange = findViewById(R.id.buttonChange);

        editContact.setEnabled(enabled);
        editAddress.setEnabled(enabled);
        editCity.setEnabled(enabled);
        editState.setEnabled(enabled);
        editZipCode.setEnabled(enabled);
        editHomePhone.setEnabled(enabled);
        editCellPhone.setEnabled(enabled);
        editEmailAddress.setEnabled(enabled);
        buttonSave.setEnabled(enabled);
        buttonChange.setEnabled(enabled);
    }


    public void didFinishDatePickerDialog(Calendar selectedDate) {
    TextView textBirthday = findViewById(R.id.textBirthday);
    textBirthday.setText(DateFormat.format("MM/dd/yyyy", selectedDate));
    }
}