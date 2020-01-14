package com.uabc.edu.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyCountryActivity extends AppCompatActivity
        implements View.OnClickListener {
    private DBManager dbManager;private Long _id;private EditText titleText,descText;
    private Button btnUpdate,btnDelete;
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
        titleText=findViewById(R.id.subject_edittext);
        descText=findViewById(R.id.description_edittext);
        btnUpdate=findViewById(R.id.btn_update);
        btnDelete=findViewById(R.id.btn_delete);

        titleText.setText(country);
        descText.setText(desc);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:
                dbManager.update(
                        _id,
                        titleText.getText().toString(),
                        descText.getText().toString());
                returnHome();
                break;
            case R.id.btn_delete:
                dbManager.delete(_id);
                returnHome();
                break;
        }
    }
    public void returnHome(){
        Intent home=new Intent(this,MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}
