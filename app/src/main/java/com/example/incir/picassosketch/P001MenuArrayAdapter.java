package com.example.incir.picassosketch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
public class P001MenuArrayAdapter extends ArrayAdapter<String> {


    public P001MenuArrayAdapter(Context context, String[] resource) {
        super(context,R.layout.p001menucustomrow,resource);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View viewElde= layoutInflater.inflate(R.layout.p001menucustomrow, parent, false);

        TextView textViewP009= (TextView)viewElde.findViewById(R.id.textViewDynamicP001Menu);
        final ImageView imageViewP009= (ImageView)viewElde.findViewById(R.id.imageViewDynamicP001Menu);

        final String calismalar= getItem(position);  //dikkat getItem() metodu ne buyuk bir nimet GOR
        textViewP009.setText(calismalar);

        Picasso.Builder builder=new Picasso.Builder(getContext());
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                e.printStackTrace();
            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/")
                .resize(200, 100)
                .placeholder(R.drawable.bulleticon)
                .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                .into(imageViewP009);

        return viewElde;

    }
}

/*
.into(imageViewP009, new Callback() {
@Override
public void onSuccess() {
        //Once the image is loaded, load the next image
        Picasso.with(getContext())
        .load("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/")
        .noPlaceholder()
        .into(imageViewP009);
        }

@Override
public void onError() {

        }
        });
*/

/*        This method forces the image to be loaded from the network by skipping the caches.
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
*/


/*

// BU kısım bize sadece resmin memory nin chache kismina alinmasini engeller. App yavaslar fakat memory free  !
.load("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/")
        .fetch(new Callback() {
@Override
public void onSuccess() {
        Picasso.with(getContext())
        .load("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/")
        .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
        .resize(200, 100)
        .into(imageViewP009);
        }

@Override
public void onError() {
        Toast.makeText(getContext(),"onError",Toast.LENGTH_SHORT).show();
        }
        });*/









