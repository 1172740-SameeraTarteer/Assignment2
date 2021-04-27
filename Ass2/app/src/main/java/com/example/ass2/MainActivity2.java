package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ass2.model.CVinfo;
import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {

    private EditText edu;
    private EditText WorkExperience;
    private EditText Language;
    private EditText Skill;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edu = findViewById(R.id.edtEdu);
        WorkExperience = findViewById(R.id.edtExper);
        Language = findViewById(R.id.edtLang);
        Skill = findViewById(R.id.edtSkill);
        save = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String hobbies = intent.getStringExtra("hobbies");
        String email = intent.getStringExtra("Email");
        String phone = intent.getStringExtra("phone");
        String gender = intent.getStringExtra("gender");


        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CVinfo cv = gson.fromJson(str, CVinfo.class);
            if (str.trim().length() != 0) {
                edu.setText(cv.getEduction());
                WorkExperience.setText(cv.getWorkExperience());
                Language.setText(cv.getLanguage());
                Skill.setText(cv.getSkill());
            }

        } catch (Exception e) {
            System.out.println();
        }
        save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                CVinfo cv = new CVinfo(name,hobbies,email,phone,gender,edu.getText().toString(),WorkExperience.getText().toString(),Language.getText().toString(),Skill.getText().toString());

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