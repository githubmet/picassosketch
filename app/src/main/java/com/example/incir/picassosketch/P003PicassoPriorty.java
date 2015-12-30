package com.example.incir.picassosketch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class P003PicassoPriorty extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003picassopriorty);

        ImageView imageViewP002=(ImageView)findViewById(R.id.imageViewP003);
        ImageView imageView2P002=(ImageView)findViewById(R.id.imageView2P003);

        Picasso.with(this)
                .load("http://lorempixel.com/400/200/sports/1/Dummy-Text/")
                .priority(Picasso.Priority.LOW)
                .into(imageViewP002);
        Picasso.with(this)
                .load("http://lorempixel.com/400/200/sports/8/Dummy-Text/")
                .priority(Picasso.Priority.HIGH)
                .into(imageView2P002);
    }
}
