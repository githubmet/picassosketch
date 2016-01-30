package com.example.incir.picassosketch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
public class P001ArrayAdapter extends ArrayAdapter<String> {

    Context context;
    public P001ArrayAdapter(Context context, String[] resource) {
        super(context,R.layout.p001menucustomrow,resource);
        this.context=context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View viewElde= layoutInflater.inflate(R.layout.p001menucustomrow, parent, false);

        TextView textViewP009= (TextView)viewElde.findViewById(R.id.textViewDynamicP001Menu);
        final ImageView imageViewP009= (ImageView)viewElde.findViewById(R.id.imageViewDynamicP001Menu);

        final String calismalar= getItem(position);  //dikkat getItem() metodu ne buyuk bir nimet GOR
        textViewP009.setText(calismalar);


        //Uri uri =Uri.parse("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/");  //bu sekil ok.
        Picasso.Builder builder=new Picasso.Builder(getContext());
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                e.printStackTrace();
            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/" + position + "/" + calismalar + "/")  //uri)
                .error(R.drawable.header) // will be displayed if the image cannot be loaded
                .resize(200, 100)
                .placeholder(R.drawable.bulleticon)
                .into(imageViewP009);

        return viewElde;

    }
}

/*
.into(imageViewP009, new Callback()...

.fetch ... cache ile alakali

This method forces the image to be loaded from the network by skipping the caches.
.memoryPolicy(MemoryPolicy.NO_CACHE)
.networkPolicy(NetworkPolicy.NO_CACHE)

*/
