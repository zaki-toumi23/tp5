package com.shaveshan.bibliothque;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class DBhelper extends SQLiteOpenHelper {
    // le nom de la table de base de données.
    public static final String BOOKS_TABLE_NAME = "Books";
    private Books r;

    public DBhelper(Context context) {
        super(context, "bibliotheque", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        db.execSQL("create table Books " + "(id integer primary key, titre text,auteur text,motCles text , resume text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(db);
    }

    //Inserer un nouveau rendez-vous
    public boolean insertBooks(String ptitre, String pauteur, String pmotCles , String presume) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titre", ptitre);
        contentValues.put("auteur", pauteur);
        contentValues.put("motCles", pmotCles);
        contentValues.put("resume" , presume);
        db.insert("Books", null, contentValues);
        return true;
    }

    public Books RechercherBooksByTitre(String ptitre){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from Books where titre='"+ptitre+"'", null );
        res.moveToFirst();
        Books b = null;
// on parcours le résultat et on crée pour chaque ligne un objet Rdv
        if(res.isAfterLast() == false){
            r= new Books() ;// on crée un nouveau objet Books
            b.setId(res.getInt(0)); // on mis son ID
            b.setTitre(res.getString(1)); // on mis son Titre
            b.setAuteur(res.getString(2)); // on mis son Auteur
            b.setMotCles(res.getString(3)); // on mis ça MotCles
            b.setResume(res.getString(4)); // on mis ça Resume
            res.moveToNext();
        }
        return b;
    }

    //nombre de lignes se trouvant dans la table.
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, BOOKS_TABLE_NAME);
        return numRows;
    }



    //mettre à jour un Books.
    public boolean updateBooks (Integer id, String titre, String auteur, String motCles , String resume)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titre", titre);
        contentValues.put("auteur", auteur);
        contentValues.put("motCles", motCles);
        contentValues.put("resume", resume);
        db.update("Books", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }



    // supprimer un Books
    public Integer deleteContact (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Books","id = ? ",
                new String[] { Integer.toString(id) });
    }



    // Lister tous les Books
    public ArrayList<Books> ListerTousRDV()
    {
//on crée un liste vide
        ArrayList<Books> array_list = new ArrayList<Books>();
        SQLiteDatabase db = this.getReadableDatabase();
// on lance la requête
        Cursor res = db.rawQuery( "select * from Books", null );
        res.moveToFirst();
        Books b;
// on parcours le résultat et on crée pour chaque ligne un objet Books
        while(res.isAfterLast() == false){
            b= new Books() ;// on crée un nouveau objet Books

            b.setId(res.getInt(0)); // on mis son ID
            b.setTitre(res.getString(1)); // on mis son Titre
            b.setAuteur(res.getString(2)); // on mis son Auteur
            b.setMotCles(res.getString(3)); // on mis ça MoteCles
            b.setResume(res.getString(4)); // on mis ça MoteCles
            array_list.add(b);
            res.moveToNext();
        }
// on renvoi le résultat.
        return array_list;
    }
}

