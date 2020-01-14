package com.uabc.edu.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ModifyCountryActivity extends AppCompatActivity {
    private DBManager dbManager;
    private Long _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_country);
        dbManager=new DBManager(this);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String country=intent.getStringExtra("country");
        String desc= intent.getStringExtra("desc");
        _id=Long.parseLong(id);

    }
}
