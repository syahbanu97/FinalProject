package com.example.acer.finalprojectapps;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nama;
    private String review;
    private int rating;

    public Note(String nama, String review, int rating) {
        this.nama = nama;
        this.review = review;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

}
