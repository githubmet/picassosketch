package com.example.incir.picassosketch;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class P003PicassoTransform extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003picassotransform);

        ImageView imageViewP003=(ImageView)findViewById(R.id.imageViewP003);

        Picasso.with(this)
                .load("http://lorempixel.com/400/200/sports/1/Dummy-Text/")
                .transform(new P002Transform())
                .into(imageViewP003);

    }
}
