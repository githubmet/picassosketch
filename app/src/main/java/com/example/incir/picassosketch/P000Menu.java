package com.example.incir.picassosketch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P000Menu extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String ActivityNames[]= getResources().getStringArray(R.array.ActivityNames);  //.getStringArray yeni bir veri kaynagi
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);//,Activities); bunu buradan aliyoruz sonda ekliyoruz
        setListAdapter(arrayAdapter);
        arrayAdapter.addAll(ActivityNames);  //dikkat listAdapter in bu sekilde bir ozeligi yok
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {
             Class className= Class.forName("com.example.incir.picassosketch."+l.getItemAtPosition(position));
            Intent intent=new Intent(P000Menu.this,className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
/*
List<String> listActivityNames=new ArrayList();
listActivityNames.add(0,"P001");
listActivityNames.add(1,"P002");
listActivityNames.add(2,"P003");
listActivityNames.add(3,"P004");
*/
