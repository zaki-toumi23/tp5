package com.shaveshan.bibliothque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText titre , author , keyWord , resume;
    AlertDialog.Builder builder;
    Books book;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        book = getIntent().getExtras().getParcelable("thisBook");

        titre = findViewById(R.id.titreD);
        titre.setText(book.getTitre());
        titre.setInputType(titre.AUTOFILL_TYPE_NONE);

        author = findViewById(R.id.editA);
        author.setText(book.getAutear());
        author.setInputType(author.AUTOFILL_TYPE_NONE);

        keyWord = findViewById(R.id.editKey);
        keyWord.setText(book.getMotCles());
        keyWord.setInputType(keyWord.AUTOFILL_TYPE_NONE);

        resume = findViewById(R.id.editAbs);
        resume.setText(book.getResume());
        resume.setInputType(resume.AUTOFILL_TYPE_NONE);
    }
}
