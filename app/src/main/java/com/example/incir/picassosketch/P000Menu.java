package com.example.incir.picassosketch;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P000Menu extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p000menu);

        ListView listViewP009=(ListView)findViewById(R.id.listViewP000Menu);
        String calismalar[]=getResources().getStringArray(R.array.calismalar);

        ListAdapter listAdapter=new P000MenuArrayAdapter(this,calismalar);
        listViewP009.setAdapter(listAdapter);

        listViewP009.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(P000Menu.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this,P001PlayPictureCanvas.class);
        startActivity(intent);
    }
}
