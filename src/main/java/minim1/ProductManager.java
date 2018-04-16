package minim1;

import java.util.ArrayList;
import java.util.Queue;

public interface ProductManager {
    public ArrayList ListadoOrdenadoPrecio();
    public boolean HacerPedido(ArrayList<Producto> productos, ArrayList<Integer> cantidad,String nomUsuari);
    public Pedido ServirPedido();
    public ArrayList ListadoOrdenadoVentas();

}
