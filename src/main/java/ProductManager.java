import java.util.ArrayList;
import java.util.Queue;

public interface ProductManager {
    public ArrayList ListadoOrdenado();
    public void HacerPedido(ArrayList<Productos> productos);
    public Pedido ServirPedido(Queue<Pedido> pedidos);

}
