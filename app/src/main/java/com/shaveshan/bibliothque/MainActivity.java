package com.shaveshan.bibliothque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addEven(View view) {
        Intent myIntent = new Intent(this ,AjoutLivre.class);
        startActivity( myIntent );
    }
    public void displaysBookList(View view) {
        Intent myIntent = new Intent(this ,Affiche.class);
        startActivity( myIntent );
    }
}
