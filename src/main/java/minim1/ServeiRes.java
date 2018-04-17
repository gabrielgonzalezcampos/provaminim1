package minim1;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.LinkedList;

@Path("/service")
public class ServeiRes {
    @GET
    @Path("/ordenPrecio")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList ListadoOrdenadoPrecio(){
        return ProductManagerImpl.getInstance().ListadoOrdenadoPrecio();
    }
    @POST
    @Path("/hacerPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public int HacerPedido(ArrayList<Integer> productos, ArrayList<Integer> cantidad, String nomUsuari){
        ArrayList<Producto> prod=new ArrayList<>();
        if (ProductManagerImpl.getInstance().getUsuariobyName(nomUsuari)==null)
            return -1;
        for(int i=0;i<productos.size();i++){
            prod.add(ProductManagerImpl.getInstance().getProducts().get(productos.get(i)));
        }
        boolean res=ProductManagerImpl.getInstance().HacerPedido(prod,cantidad,nomUsuari);
        if (res=true)
            return 1;
        else return -2;
    }

    @GET
    @Path("/servirPedido")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido ServirPedido(){
        return ProductManagerImpl.getInstance().ServirPedido();
    }

    @GET
    @Path("/ordenVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList ListadoOrdenadoVentas(){
        return ProductManagerImpl.getInstance().ListadoOrdenadoVentas();
    }

    @POST
    @Path("/registre")
    @Produces(MediaType.APPLICATION_JSON)
    public int registre( String nom){
        ProductManagerImpl.getInstance().registre(nom);
        return 1;
    }

    @POST
    @Path("/addproduct")
    @Produces(MediaType.APPLICATION_JSON)
    public int addProduct(Producto p){
        ProductManagerImpl.getInstance().addProduct(p);
        return 1;
    }

}
