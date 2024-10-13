package com.example.startlist.Bean;

public class Gumbull {
    private int id;
    private static int comp;
    private String nom;
    private String photo;
    private float star;
    public Gumbull(){}
    public Gumbull(String nom,String photo,float star){
        this.id=++comp;
        this.nom=nom;
        this.photo=photo;
        this.star=star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
