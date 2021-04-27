package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

    }

    public void save(View view) {

    }
}