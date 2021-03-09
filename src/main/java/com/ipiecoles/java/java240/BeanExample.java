package com.ipiecoles.java.java240;

//Soit la classe suivante que l'on faire gérer par Spring
class BeanExemple{
    private String msg;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //    public void getNom(){return nom;}
//    public void setNom(String n){nom = n;}
    public BeanExemple(String m){msg=m;}
    public void init() {}
    public void cleanup() {}
}
