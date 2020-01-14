package com.uabc.edu.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_con);
        dbManager=new DBManager(this);
        dbManager.open();
        subjectEditText=findViewById(R.id.subject_edittext);
        descEditText=findViewById(R.id.description_edittext);
        addTodoBtn=findViewById(R.id.add_record);
        addTodoBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_record:
                final String country=subjectEditText.getText().toString();
                final String desc= descEditText.getText().toString();
                dbManager.insert(country,desc);
                break;
        }
    }
    public void returnHome(){
        Intent home=new Intent(this,MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }

    @Override
    public void onBackPressed() {
        returnHome();
    }
}
