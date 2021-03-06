package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ass2.model.CVinfo;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtHobbies;
    private EditText edtPhone;
    private EditText edtEmail;
    private Spinner spGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtHobbies = findViewById(R.id.edtHobbies);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        spGender= findViewById(R.id.spGender);
        spinner();
    }
    public void spinner(){
        String data []={"Male","Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, data);
        spGender.setAdapter(adapter);

    }

    public void next(View view) {
        String name=edtName.getText().toString();
        String hobbies=edtHobbies.getText().toString();
        String phone=edtPhone.getText().toString();
        String email=edtEmail.getText().toString();
        String gender=spGender.getSelectedItem().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("Name",name);
        intent.putExtra("Hobbies",hobbies);
        intent.putExtra("Phonenum",phone);
        intent.putExtra("Email",email);
        intent.putExtra("Gender",gender);
        startActivity(intent);
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CVinfo cv = gson.fromJson(str, CVinfo.class);
            if (str.trim().length() != 0) {
                edtName.setText(cv.getName());
                edtHobbies.setText(cv.getHobbies());
                edtPhone.setText(cv.getPhone());
                edtEmail.setText(cv.getEmail());

            }
        } catch (Exception e) {
            System.out.println();
        }

    }

    public void save(View view) {


    }
}
