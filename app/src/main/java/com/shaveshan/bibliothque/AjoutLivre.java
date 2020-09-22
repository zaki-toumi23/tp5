package com.shaveshan.bibliothque;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutLivre extends AppCompatActivity {
    private static DBhelper call ;
    public static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_livre);
    }
    @SuppressLint("WrongConstant")
    public void addBookToBdLite(View view) {
        EditText titre = findViewById(R.id.editTitre);
        String msg = null , titreBook = titre.getText().toString();
        if( titreBook.length() > 3 ){
            EditText auteur = findViewById(R.id.editAuteur);
            String auteurNom = auteur.getText().toString();
            if( auteurNom.length() > 3 ) {
                EditText motCle = findViewById(R.id.editMotCle);
                String motCleList = motCle.getText().toString();
                if(motCleList.indexOf(",")>1){
                    String[] result = motCleList.split(",");
                    if(result.length == 5){
                        EditText resume = findViewById(R.id.editResume);
                        String resumeBook = resume.getText().toString();
                        if(resumeBook.length() > 10 ){
                            //code Add Book
                            call = new DBhelper(getApplicationContext());
                            db = call.getWritableDatabase();
                            call.insertBooks(
                                    titre.getText().toString() ,
                                    auteur.getText().toString() ,
                                    motCle.getText().toString(),
                                    resume.getText().toString()
                            );
                            titre.setText(null);
                            auteur.setText(null);
                            motCle.setText(null);
                            resume.setText(null);
                            msg = "The book has been added";

                        }
                        else{
                            msg = "The operation failed, please write Book Abstract";
                        }
                    }
                    else{
                        msg = "The operation failed, please write Five Key Words split with \",\" ";
                    }
                }
                else{
                    msg = "The operation failed, please write Book Key Words";
                }
            }
            else{
                msg = "The operation failed, please write a Author Name ";
            }
        }
        else{
            msg = "The operation failed, please write Book Title";
        }
        Toast.makeText(getApplicationContext(),msg,1).show();
    }
}

