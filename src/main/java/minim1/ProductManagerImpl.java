package minim1;

import java.util.ArrayList;
import java.util.Queue;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class ProductManagerImpl implements ProductManager {
    private static ProductManagerImpl ourInstance;
    private Queue<Pedido> pedidos;
    private ArrayList<Producto> products;
    private ArrayList<String> Usuario;
    final static Logger log = Logger.getLogger(ProductManagerImpl.class);

    public ArrayList<Producto> getProducts() {
        return products;
    }
    public Queue<Pedido> getPedidos() {
        return pedidos;
    }
    public ArrayList<String> getUsuario() {
        return Usuario;
    }
    public String getUsuariobyName(String nom) {
        int i=0;
        boolean encontrado=false;
        while ((i==Usuario.size())||(encontrado))
        {
            if (Usuario.get(i)==nom){
                encontrado=true;
            }
            else i++;
        }
        return Usuario.get(i);
    }

    public void setPedidos(Queue<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setProducts(ArrayList<Producto> products) {
        this.products = products;
    }
    public void setUsuario(ArrayList<String> usuario) {
        Usuario = usuario;
    }
    public void registre(String nom){
        this.Usuario.add(nom);
    }
    public void addProduct(Producto p){
        products.add(p);
    }

    public static ProductManagerImpl getInstance(){
        if (ourInstance==null)
            ourInstance=new ProductManagerImpl();
        return ourInstance;
    }
    private ProductManagerImpl() {}

    public ArrayList ListadoOrdenadoPrecio() {
        org.apache.log4j.BasicConfigurator.configure();
        ArrayList<Producto> productos=products;

        Producto p=new Producto();
        float preu;
        int pos=0;
        log.info("Productos: "+productos.size()+"productos");


        for(int i=0;i<productos.size();i++) {
            preu= productos.get(i).getPreu();
            for(int j=1;(i+j)<productos.size();j++){
                if (productos.get(i+j).getPreu()<preu) {
                    preu = productos.get(i+j).getPreu();
                    pos = i+j;
                }
            }
            p=productos.get(i);
            productos.set(i,productos.get(pos));
            productos.set(pos,p);


        }
        log.info("Productos ordenados: "+productos.size()+"productos");
        return productos;
    }


    public boolean HacerPedido(ArrayList<Producto> productos, ArrayList<Integer> cantidad, String nomUsuari) {
        org.apache.log4j.BasicConfigurator.configure();
        log.info("Pedidos: "+pedidos.size()+" Productos: "+productos.size()+" productos Tamaño cantidades: "+ cantidad.size());
        if (productos.size()!=cantidad.size()){
            log.error("Error en los datos");
            return false;
        }
        Pedido p =new Pedido(productos,cantidad,nomUsuari);
        pedidos.add(p);
        log.info("Pedidos: "+pedidos.size()+" Pedido: Productos: "+productos.size()+" productos Tamaño cantidades: "+ cantidad.size());
        return true;
    }

    public Pedido ServirPedido() {
        org.apache.log4j.BasicConfigurator.configure();
        log.info("Pedidos: "+pedidos.size());
        Pedido p;
        p=pedidos.poll();
        for (int i=0;i<p.getProductos().size();i++) {
            p.getProductos().get(i).setVentas(p.getProductos().get(i).getVentas()+p.getCantidad().get(i));
        }
        log.info("Pedidos: "+pedidos.size());
        return p;
    }

    public ArrayList ListadoOrdenadoVentas() {
        org.apache.log4j.BasicConfigurator.configure();
        ArrayList<Producto> productos=products;
        if (productos.size()==0)
        {
            log.error("Lista de productos vacia");
            return null;
        }

        Producto p=new Producto();
        int ventas;
        int pos=0;
        log.info("Productos: "+productos.size()+"productos");


        for(int i=0;i<productos.size();i++) {
            ventas= productos.get(i).getVentas();
            for(int j=1;(i+j)<productos.size();j++){
                if (productos.get(i+j).getVentas()>ventas) {
                    ventas = productos.get(i+j).getVentas();
                    pos = i+j;
                }
            }
            p=productos.get(i);
            productos.set(i,productos.get(pos));
            productos.set(pos,p);


        }
        log.info("Productos ordenados: "+productos.size()+"productos");
        return productos;
    }
}
