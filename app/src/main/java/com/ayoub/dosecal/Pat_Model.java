package com.ayoub.dosecal;

public class Pat_Model {
    String id,nom,prenom,age,poids,sexe;
    public Pat_Model(String id, String nom, String prenom, String age, String poids, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.poids = poids;
        this.sexe = sexe;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


}
