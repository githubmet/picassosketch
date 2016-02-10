package com.example.incir.picassosketch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;

public class P002CreateBitmap extends Activity implements View.OnClickListener{
    ImageView imageViewZeroP002;
    ImageView imageView2P002;
    String positionVeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002createbitmap);
        Button buttonP002= (Button)findViewById(R.id.buttonP002);
        Button button2P002= (Button)findViewById(R.id.button2P002);
        Button button3P002= (Button)findViewById(R.id.button3P002);

        buttonP002.setOnClickListener(this);
        button2P002.setOnClickListener(this);
        button3P002.setOnClickListener(this);

        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            positionVeri= bundle.getString("position");
        }
        else{
            positionVeri="2";
        }
        getImageFromUrl();
    }

    private void getImageFromUrl() {
        imageViewZeroP002=(ImageView)findViewById(R.id.imageViewZeroP002);
        Picasso.with(this)
                .load("http://lorempixel.com/400/200/sports/"+positionVeri+"/Dummy-Text/")
                .resize(400, 200)
                .into(imageViewZeroP002);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonP002:
                ImageView imageViewP002= (ImageView)findViewById(R.id.imageViewP002);
                Drawable drawable=imageViewZeroP002.getDrawable();
                Bitmap bitmapReal= ((BitmapDrawable)drawable).getBitmap();

                imageViewP002.setImageBitmap(createBitmapGost(bitmapReal));
                
                break;
            case R.id.button2P002:
                imageView2P002= (ImageView)findViewById(R.id.imageView2P002);
                Picasso.with(this)
                        .load("http://lorempixel.com/400/200/sports/"+positionVeri+"/Dummy-Text/")
                        .transform(new P002Transform())
                        .into(imageView2P002);

                break;
            case R.id.button3P002:
                ImageView imageView3P002= (ImageView)findViewById(R.id.imageView3P002);
                Drawable drawable2=imageView2P002.getDrawable();
                Bitmap bitmapReal2= ((BitmapDrawable)drawable2).getBitmap();

                imageView3P002.setImageBitmap(createBitmapGost(bitmapReal2));
                break;
        }
    }

    private Bitmap createBitmapGost(Bitmap bitmapReal) {
        Bitmap bitmapSkeleton= Bitmap.createBitmap(bitmapReal.getWidth(), bitmapReal.getHeight(), bitmapReal.getConfig());
        int R,G,B;
        int x=bitmapReal.getWidth();
        int y=bitmapReal.getHeight();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                int tinyPixel= bitmapReal.getPixel(i,j);
                R= 255- Color.red(tinyPixel);
                G=255-Color.green(tinyPixel);
                B=255-Color.blue(tinyPixel);

                bitmapSkeleton.setPixel(i,j,Color.rgb(R,G,B));
            }
        }
        return bitmapSkeleton;
    }
}
















