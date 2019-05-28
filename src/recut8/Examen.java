
package recut8;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


public class Examen  {
        double precioJarron;
        double descuentoJarron;
        double precioMartillo;
        double pesoMartillo;
        double precioMaceta;
        double descuentoMaceta;
    public static String listarTodo (List<IAlquilable> miLista) {
        String resultado = "";
        for (IAlquilable objeto : miLista) {   //Bucle for each
            if (objeto instanceof Martillo) {
                resultado += String.format("Martillo %.1f peso:%.1f%n", objeto.getPrecioMes(),
                       ((Martillo) objeto).getPeso());
            } else if (objeto instanceof Jarron) {
                 resultado += String.format("Jarron %.1f descuento:%.1f%n", objeto.getPrecioMes(),
                       ((Jarron) objeto).getDescuento());
            } else {
                  resultado += String.format("Maceta %.1f descuento:%.1f%n", objeto.getPrecioMes(),
                       ((Maceta) objeto).getDescuento());               
            } 
        }
        return resultado;
    }

    public boolean hayProductoDeMasDe10000 (List<IAlquilable> miLista) {
//        for (IAlquilable objeto : miLista) {
//            if (objeto.getPrecioMes() > 10000) {              
//                return true;
//            }
//        }
//        return false;

        boolean encontrado = false;
        Iterator<IAlquilable> iter = miLista.iterator();
        while (!encontrado && iter.hasNext()) {
            IAlquilable objeto = iter.next();
            if (objeto.getPrecioMes() > 10000) {
                encontrado = true;
            }
        }
        return encontrado;
     }
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        List<IAlquilable> listaPrueba = new ArrayList<>();
        listaPrueba.add(new Maceta(12.5, 10));
        listaPrueba.add(new Jarron(15.4, 2));
        listaPrueba.add(new Jarron(13.1, 15));
        String r = listarTodo(listaPrueba);
        System.out.println(r);
    }
}
