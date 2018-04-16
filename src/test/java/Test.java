import minim1.Pedido;
import minim1.ProductManagerImpl;
import minim1.Producto;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test {
    private ProductManagerImpl productManager;

    @Before
    public void setUp()throws java.io.IOException{
        productManager=ProductManagerImpl.getInstance();
        ArrayList<Producto> p=new ArrayList<Producto>();
        Producto p1=new Producto(1,"poma",2,0);
        Producto p2=new Producto(2,"pera", (float) 1.34,0);
        Producto p3=new Producto(3,"platan",1,0);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        productManager.setProducts(p);
    }

    @org.junit.Test
    public void testRealizarPedido(){
        String usuario="Gabri";
        ArrayList<Producto> p =new ArrayList<>();
        Producto p1=new Producto(1,"poma",2,0);
        Producto p3=new Producto(3,"platan",1,0);
        p.add(p1);
        p.add(p3);
        ArrayList<Integer> c =new ArrayList<>();
        c.add(3);

        Assert.assertEquals(false, productManager.HacerPedido(p,c,usuario));
        c.add(7);
        Assert.assertEquals(true,productManager.HacerPedido(p,c,usuario));

    }
    @org.junit.Test
    public void testServirPedido(){
        String usuario="Gabri";
        ArrayList<Producto> p =new ArrayList<>();
        Producto p1=new Producto(1,"poma",2,0);
        Producto p3=new Producto(3,"platan",1,0);
        p.add(p1);
        p.add(p3);
        ArrayList<Integer> c =new ArrayList<>();
        c.add(3);
        c.add(7);
        Pedido ped=new Pedido(p,c,usuario);
        Assert.assertEquals(ped, productManager.ServirPedido());
    }
    @org.junit.After
    public void tearDown(){
    }

}
