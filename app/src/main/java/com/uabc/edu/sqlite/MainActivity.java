package com.uabc.edu.sqlite;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter scAdapter;
    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.SUBJECT, DatabaseHelper.DESC };

   final int[] to = new int[] { R.id.id, R.id.country, R.id.desc };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action",
//                        Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        dbManager=new DBManager(this);
        dbManager.open();
        Cursor cursor=dbManager.fetch();
        listView=findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        scAdapter= new SimpleCursorAdapter(this,R.layout.renglon,cursor,
                from,to,0);
        scAdapter.notifyDataSetChanged();
        listView.setAdapter(scAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position,
                                    long id) {
                TextView idTV=view.findViewById(R.id.id);
                TextView titleTV=view.findViewById(R.id.country);
                TextView descTV=view.findViewById(R.id.desc);



            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
