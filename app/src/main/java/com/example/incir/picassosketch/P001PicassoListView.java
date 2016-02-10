package com.example.incir.picassosketch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.picassosketch.adapter.P001ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P001PicassoListView extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001picassolistview);

        ListView listViewP001=(ListView)findViewById(R.id.listViewP001);

        String[] calismalar=getResources().getStringArray(R.array.calismalar);//dikkat bunu gondererek daha basit yapabilirsin
        List<String> stringList=new ArrayList(Arrays.asList(calismalar));

        ArrayAdapter arrayAdapter=new P001ArrayAdapter(this,R.layout.p001customrow,stringList);
        listViewP001.setAdapter(arrayAdapter);

        listViewP001.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,P002CreateBitmap.class);
        intent.putExtra("position",String.valueOf(position));
        startActivity(intent);
    }
}
