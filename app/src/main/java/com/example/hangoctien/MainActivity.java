package com.example.hangoctien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hangoctien.database.AppDatabase;
import com.example.hangoctien.database.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edName,edEmail,edReview;
    Spinner spinner;
    Button btFeedback;
    String status = "Gripe";
    AppDatabase db;
    CheckBox ck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initView();
    }
    private void initView() {
        ck = findViewById(R.id.ck);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edReview = findViewById(R.id.edReview);
        btFeedback = findViewById(R.id.btFeedback);
        btFeedback.setOnClickListener(this);

        String[] listStatus = {"Gripe", "Nice", "Bad"};
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listStatus);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {
        if(edName.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui long nhap ten",Toast.LENGTH_LONG).show();
            return;
        }
        if(edEmail.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui long nhap Email",Toast.LENGTH_LONG).show();
            return;
        }
        if(edReview.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui long nhap Review",Toast.LENGTH_LONG).show();
            return;
        }


        User user = new User();
        user.setName(edName.getText().toString());
        user.setEmail(edEmail.getText().toString());
        user.setReview(edReview.getText().toString());
        user.setListStatus(spinner.getSelectedItem().toString());
        long id = db.userDao().insertUser(user);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }

    }









    }
