package com.shaveshan.bibliothque;

import android.os.Parcel;
import android.os.Parcelable;

class Books implements Parcelable {
    private String titre , autear , motCles , resume;
    int id ;


    public Books(){ }

    public Books(String titre , String autear , String motCles , String resume ){
        setTitre(titre);
        setAuteur(autear);
        setMotCles(motCles);
        setResume(resume);
    }

    public Books(int id ,String titre , String autear , String motCles , String resume){
        setTitre(titre);
        setAuteur(autear);
        setMotCles(motCles);
        setResume(resume);
        setId(id);
    }

    public static final Creator<Books> CREATOR = new Creator<Books>() {
        @Override
        public Books createFromParcel(Parcel in) {
            return new Books(in);
        }

        @Override
        public Books[] newArray(int size) {
            return new Books[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String autear) {
        this.autear = autear;
    }

    public void setMotCles(String motCles) {
        this.motCles = motCles;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }




    public int getId(){
        return this.id;
    }
    public String getTitre(){
        return this.titre;
    }
    public String getAutear(){
        return this.autear;
    }
    public String getMotCles(){
        return this.motCles;
    }
    public String getResume(){
        return this.resume;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(titre);
        dest.writeString(autear);
        dest.writeString(motCles);
        dest.writeString(resume);
    }

    public Books(Parcel in) {
        this.id = in.readInt();
        this.titre = in.readString();
        this.autear = in.readString();
        this.motCles = in.readString();
        this.resume = in.readString();
    }
}


