package com.example.sss.mylistviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array_technology = getResources().getStringArray(R.array.array_technology);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_row, array_technology);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);



        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        //menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"Details");
        menu.add(0,v.getId(),1,"save");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Details")
        {
            Toast.makeText(getApplicationContext(),"Detail was pressed",Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle()=="save")
        {
            Toast.makeText(getApplicationContext(),"Save was pressed",Toast.LENGTH_LONG).show();
        }
        else
        {
           return false;
        }
        return true;

    }
}

