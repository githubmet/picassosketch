package com.example.incir.picassosketch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P000MenuToActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String Activities[]= getResources().getStringArray(R.array.ActivityNames);
        ListAdapter listAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Activities);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {
             Class className= Class.forName("com.example.incir.picassosketch."+l.getItemAtPosition(position));
            Intent intent=new Intent(P000MenuToActivity.this,className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
