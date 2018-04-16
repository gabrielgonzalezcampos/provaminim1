package minim1;

import java.util.ArrayList;

public class Producto {
    private String nom;
    private int preu;
    private int ventas;

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPreu(int preu) {
        this.preu = preu;
    }
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getPreu() {
        return preu;
    }
    public int getVentas() {
        return ventas;
    }
    public String getNom() {
        return nom;
    }

    public Producto(){
    }
    public Producto(String nom,int preu,int ventas){
        this.nom=nom;
        this.preu=preu;
        this.ventas=ventas;
    }
}