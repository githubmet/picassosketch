package com.example.incir.picassosketch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
public class P000MenuArrayAdapter extends ArrayAdapter<String> {


    public P000MenuArrayAdapter(Context context, String[] resource) {
        super(context,R.layout.p000menucustomrow,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View viewElde= layoutInflater.inflate(R.layout.p000menucustomrow, parent, false);

        TextView textViewP009= (TextView)viewElde.findViewById(R.id.textViewDynamicP000Menu);
        ImageView imageViewP009= (ImageView)viewElde.findViewById(R.id.imageViewDynamicP000Menu);

        String calismalar= getItem(position);  //dikkat getItem() metodu ne buyuk bir nimet GOR
        textViewP009.setText(calismalar);

        Picasso.Builder builder=new Picasso.Builder(getContext());
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                e.printStackTrace();
            }
        }).build()
                .load("http://lorempixel.com/400/200/sports/"+position+"/"+calismalar+"/")
                .resize(200,100)
                .placeholder(R.drawable.bulleticon)
                .into(imageViewP009);

        return viewElde;
    }
}









