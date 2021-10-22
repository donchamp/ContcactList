package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set2);
        initListButton();
        initMapButton();
        initSetButton();
        initSettings();
        initRadioGroupSortBy();
        initRadioGroupSortOrder();

    }

    private void initSetButton() {
        Button SetButton = findViewById(R.id.buttonSettings);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this, SetActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    private void initMapButton() {
        Button MapButton = findViewById(R.id.buttonMap);
        MapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this, MapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initListButton() {
        Button listButton = findViewById(R.id.buttonList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this, MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    private void initRadioGroupSortBy(){//saving information when selecting something
        RadioGroup rg = findViewById(R.id.radioGroupSortBy);
        RadioButton rbName = findViewById(R.id.radioName);
        RadioButton rbCity = findViewById(R.id.radioCity);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbName.isChecked()){
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield","name");
                    editor.apply();
                }else if (rbCity.isChecked()){
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield","city");
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield","birthday");
                    editor.apply();
                }
            }
        });
    }
    private void initRadioGroupSortOrder(){
        RadioGroup rgo = findViewById(R.id.radioGroupSortOrder);
        RadioButton rbAscending = findViewById(R.id.radioAscending);
        rgo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbAscending.isChecked()){
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortorder","Ascending");
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortorder","Descending");
                    editor.apply();
                }
            }
        });
    }

    private void initSettings() {
        //allows us to save data to phone below
        SharedPreferences sharedPref = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
        String sortBy = sharedPref.getString("sortfield", "name");
        String sortOrder = sharedPref.getString("sortorder", "ascending");//defaulting it to ascending
        RadioButton rbName = findViewById(R.id.radioName);
        RadioButton rbBirthday = findViewById(R.id.radioBirthday);
        RadioButton rbCity = findViewById(R.id.radioCity);
        if (sortBy.equals("name")) {
            rbName.setChecked(true);
        } else if (sortBy.equals("city")) {
            rbCity.setChecked(true);
        } else {
            rbBirthday.setChecked(true);
        }


    RadioButton rbAscending = findViewById(R.id.radioAscending);
    RadioButton rbDescending = findViewById(R.id.radioDescending);
    if(sortOrder.equals("ascending"))

    {
        rbAscending.setChecked(true);

    }else{
        rbDescending.setChecked(true);
    }
}}