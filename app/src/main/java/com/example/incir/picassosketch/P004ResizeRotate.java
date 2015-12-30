package com.example.incir.picassosketch;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

public class P004ResizeRotate extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004resizerotate);

        final ImageView imageViewP004=(ImageView)findViewById(R.id.imageViewP004);
        Picasso.Builder builder=new Picasso.Builder(this);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {

            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/1/Rotate-120-Degrees/")
                .resize(800, 400)
                .rotate(120, 0, 0)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap bitmap) {

                        return bitmap; //I can not handle it.
                    }

                    @Override
                    public String key() {
                        return "balvbal";
                    }
                })
                .into(imageViewP004);

    }
}












