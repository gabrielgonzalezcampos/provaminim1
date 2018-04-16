package minim1;

import java.util.ArrayList;

public class Producto {
    private String nom;
    private float preu;
    private int ventas;
    private int id;

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPreu(int preu) {
        this.preu = preu;
    }
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    public void setId(int id) {
        this.id = id;
    }

    public float getPreu() {
        return preu;
    }
    public int getVentas() {
        return ventas;
    }
    public String getNom() {
        return nom;
    }
    public int getId() {
        return id;
    }

    public Producto(){
    }
    public Producto(int id,String nom,float preu,int ventas){
        this.nom=nom;
        this.preu=preu;
        this.ventas=ventas;
        this.id=id;
    }
}