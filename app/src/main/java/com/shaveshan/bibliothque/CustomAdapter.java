package com.shaveshan.bibliothque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    ArrayList<Books> l ;
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, ArrayList<Books> l ) {
        this.l = l;
        inflter = inflter.from(applicationContext);
    }


    public int getCount() {
        return l.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return l.get(i).getId();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Books b = l.get(i);
        view = inflter.inflate(R.layout.view_row, null);
        TextView titre = view.findViewById(R.id.titre), auteur = view.findViewById(R.id.src);
        titre.setText( b.getTitre() );
        auteur.setText( b.getAutear() ) ;
        return view;
    }

}
