package model;

import java.sql.Connection;
import java.util.Objects;

public class utilisateur {
    long Nom;
    String Prenom;
    String Email;
    String Cin;
    int Tel;
    String Sexe;


    public long getId() {
        return 0;
    }

    public void setNom(long nom) {
    }

    public void setPrenom(String prenom) {
    }

    public void setEmail(String email) {
    }

    public void setCin(String cin) {
    }

    public void setTel(int tel) {
    }

    public void setSexe(String sexe) {
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                "Nom=" + Nom +
                ", Prenom='" + Prenom + '\'' +
                ", Email='" + Email + '\'' +
                ", Cin='" + Cin + '\'' +
                ", Tel=" + Tel +
                ", Sexe='" + Sexe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        utilisateur utilisateur  = (utilisateur) o;
        return Nom == utilisateur.Nom && Tel == utilisateur.Tel && Objects.equals(Prenom, utilisateur.Prenom) && Objects.equals(Email, utilisateur.Email) && Objects.equals(Cin, utilisateur.Cin) && Objects.equals(Sexe, utilisateur.Sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nom, Prenom, Email, Cin, Tel, Sexe);
    }


    public void setId(long aLong) {
    }

    public static long getNom() {
        return Nom;
    }

    public static String getPrenom() {
        return Prenom;
    }

    public static String getEmail() {
        return Email;
    }

    public static String getCin() {
        return Cin;
    }

    public static int getTel() {
        return Tel;
    }

    public static String getSexe() {
        return Sexe;
    }

    public void add(utilisateur utilisateur) {
    }
}


