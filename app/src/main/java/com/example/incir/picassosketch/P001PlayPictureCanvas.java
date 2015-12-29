package com.example.incir.picassosketch;


import android.app.Activity;
import android.os.Bundle;

public class P001PlayPictureCanvas extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        P001ReturnView p001ReturnView=new P001ReturnView(this);
        setContentView(p001ReturnView);
    }
}
