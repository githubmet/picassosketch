package com.example.incir.picassosketch;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
//Picasso.Builder dan hareketle
public class P001Picasso extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001picasso);
        ImageView imageViewP001= (ImageView)findViewById(R.id.imageViewP001);

        Picasso.Builder builder=new Picasso.Builder(this);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                Toast.makeText(P001Picasso.this, "Failed dedik", Toast.LENGTH_SHORT).show();
            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/2/Deneme-Text/")
                        .resize(200, 100)
                        .placeholder(R.drawable.dag)
                        .into(imageViewP001, new Callback() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(P001Picasso.this, "onSuccess dedik", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError() {
                                Toast.makeText(P001Picasso.this, "onError dedik", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}





/*
// Picasso.with den hareketle
import com.squareup.picasso.Picasso;
public class P001Picasso extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001picasso);
        ImageView imageView= (ImageView)findViewById(R.id.imageViewP001);

        Picasso.with(this)
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .resize(200,300)
                .placeholder(R.drawable.dag)
                .rotate(270)
                .into(imageView);
    }
}
*/