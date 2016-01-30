package com.example.incir.picassosketch;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P001PicassoListView extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001picassolistview);

        ListView listViewP009=(ListView)findViewById(R.id.listViewP001Menu);
        String calismalar[]=getResources().getStringArray(R.array.calismalar);

        ListAdapter listAdapter=new P001ArrayAdapter(this,calismalar);
        listViewP009.setAdapter(listAdapter);

        listViewP009.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,P002CreateBitmap.class);
        intent.putExtra("position",String.valueOf(position));
        startActivity(intent);
    }
}
