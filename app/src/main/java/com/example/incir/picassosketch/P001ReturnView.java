package com.example.incir.picassosketch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;



public class P001ReturnView extends View {
    Context context;
    public P001ReturnView(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        Rect rectTopLeft=new Rect(0,0,canvas.getWidth()/2,canvas.getHeight()/2);
        Rect rectTopRight=new Rect(canvas.getWidth()/2,0,canvas.getWidth(),canvas.getHeight()/2);

        Rect rectBottomLeft=new Rect(0,canvas.getHeight()/2,canvas.getWidth()/2,canvas.getHeight());
        Rect rectBottomRight=new Rect(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight());

        Paint paint =new Paint();
        paint.setColor(Color.RED);

        Paint paint2 =new Paint();
        paint2.setColor(Color.GREEN);

        Paint paint3 =new Paint();
        paint3.setColor(Color.BLUE);

        Paint paint4 =new Paint();
        paint4.setColor(Color.GRAY);

        canvas.drawRect(rectTopLeft, paint);
        canvas.drawRect(rectTopRight, paint2);
        canvas.drawRect(rectBottomLeft, paint3);
        canvas.drawRect(rectBottomRight, paint4);


        Picasso.Builder builder=new Picasso.Builder(getContext());
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                e.printStackTrace();
                Toast.makeText(context,"failed",Toast.LENGTH_LONG).show();
            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/1/Deneme/")
                .resize(200, 100)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {

                        BitmapDrawable bitmapDrawable=new BitmapDrawable(context.getResources(),bitmap);
                        Bitmap RealBitmap=bitmapDrawable.getBitmap();
                        canvas.drawBitmap(RealBitmap,0,0,null);

                        Toast.makeText(context, "onBitmapLoaded", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onBitmapFailed(Drawable drawable) {
                        Rect rectTopLeft = new Rect(0, 0, canvas.getWidth() / 2, canvas.getHeight() / 2);
                        Paint paint = new Paint();
                        paint.setColor(Color.RED);
                        canvas.drawRect(rectTopLeft, paint);
                        Toast.makeText(context, "onBitmapFailed", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPrepareLoad(Drawable drawable) {
                        Rect rectTopLeft = new Rect(0, 0, canvas.getWidth() / 2, canvas.getHeight() / 2);
                        Paint paint = new Paint();
                        paint.setColor(Color.GRAY);
                        canvas.drawRect(rectTopLeft, paint);

                        Toast.makeText(context, "onPrepareLoad", Toast.LENGTH_LONG).show();
                    }
                });


        //canvas.drawBitmap();
    }
}







