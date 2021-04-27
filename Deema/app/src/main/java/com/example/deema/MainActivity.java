package com.example.deema;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.deema.model.CV;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtHobbies;
    private EditText edtAddress;
    private EditText edtEmail;
    private Spinner gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtHobbies = findViewById(R.id.edtHobbies);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);
        gender= findViewById(R.id.gender);
        spinner();
    }
    public void spinner(){
        String data []={"Male","Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, data);
        gender.setAdapter(adapter);

    }


    public void Continue(View view) {
        String name=edtName.getText().toString();
        String hobbies=edtHobbies.getText().toString();
        String address=edtAddress.getText().toString();
        String email=edtEmail.getText().toString();
        String genderS=gender.getSelectedItem().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("Name",name);
        intent.putExtra("Hobbies",hobbies);
        intent.putExtra("Address",address);
        intent.putExtra("Email",email);
        intent.putExtra("Gender",genderS);
        startActivity(intent);
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV cv = gson.fromJson(str, CV.class);
            if (str.trim().length() != 0) {
                edtName.setText(cv.getName());
                edtHobbies.setText(cv.getHobbies());
                edtAddress.setText(cv.getAddress());
                edtEmail.setText(cv.getEmail());

            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}