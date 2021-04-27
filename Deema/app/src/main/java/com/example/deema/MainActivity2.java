package com.example.deema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.deema.model.CV;
import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {

    private EditText edu;
    private EditText wk;
    private EditText ski;
    private Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edu = findViewById(R.id.edtEdu);
        wk = findViewById(R.id.edtExperience);
        ski = findViewById(R.id.edtSkills);
        finish = findViewById(R.id.btnFinish);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String hobbies = intent.getStringExtra("hobbies");
        String email = intent.getStringExtra("Email");
        String address = intent.getStringExtra("address");
        String gender = intent.getStringExtra("gender");


        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV cv = gson.fromJson(str, CV.class);
            if (str.trim().length() != 0) {
                edu.setText(cv.getEducation());
                wk.setText(cv.getExperience());
                ski.setText(cv.getSkills());
            }

        } catch (Exception e) {
            System.out.println();
        }
        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                CV cv = new CV(name,hobbies,email,address,gender,edu.getText().toString(),wk.getText().toString(),ski.getText().toString());

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);
                SharedPreferences.Editor editor = prefs.edit();
                Gson gson = new Gson();
                String cvString = gson.toJson(cv);


                editor.putString("cv", cvString);


                editor.commit();

                Log.d("object", cvString);

            }
        });
    }
}