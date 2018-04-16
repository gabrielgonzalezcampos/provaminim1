package minim1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Pedido {
    private ArrayList<Producto> productos= new ArrayList<Producto>();
    private ArrayList<Integer> cantidad=new ArrayList<Integer>();
    private String nomUsuari;

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public Pedido(){}
    public Pedido(ArrayList<Producto> productos,ArrayList<Integer> cantidad,String nomUsuari){
        this.productos=productos;
        this.cantidad=cantidad;
        this.nomUsuari=nomUsuari;
    }

}
