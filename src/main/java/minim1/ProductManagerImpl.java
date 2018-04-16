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
    final static Logger log = Logger.getLogger(ProductManagerImpl.class);


    public static ProductManagerImpl getInstance(){
        if (ourInstance==null)
            ourInstance=new ProductManagerImpl();
        return ourInstance;
    }
    private ProductManagerImpl() {}

    @GET
    @Path("/ordenPrecio")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList ListadoOrdenadoPrecio() {
        org.apache.log4j.BasicConfigurator.configure();
        ArrayList<Producto> productos=products;

        Producto p=new Producto();
        int preu;
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

    @POST
    @Path("/hacerPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public void HacerPedido(ArrayList<Producto> productos, ArrayList<Integer> cantidad, String nomUsuari) {
        org.apache.log4j.BasicConfigurator.configure();
        log.info("Pedidos: "+pedidos.size()+" Productos: "+productos.size()+" productos Tamaño cantidades: "+ cantidad.size());
        if (productos.size()!=cantidad.size()){
            log.error("Error en los datos");
            return;
        }
        Pedido p =new Pedido(productos,cantidad,nomUsuari);
        pedidos.add(p);
        log.info("Pedidos: "+pedidos.size()+" Pedido: Productos: "+productos.size()+" productos Tamaño cantidades: "+ cantidad.size());
    }

    @GET
    @Path("/servirPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido ServirPedido() {
        org.apache.log4j.BasicConfigurator.configure();
        log.info("Pedidos: "+pedidos.size());
        Pedido p;
        p=pedidos.poll();
        log.info("Pedidos: "+pedidos.size());
        return p;
    }

    @GET
    @Path("/ordenVentas")
    @Produces(MediaType.APPLICATION_JSON)
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
