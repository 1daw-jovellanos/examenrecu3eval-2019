
package recut8;


public class Decorativo implements IAlquilable {
    private double precioMes;
    private double descuento;

    @Override
    public double getPrecioMes() {
        return precioMes;
    }
    
    

    public Decorativo(double precioMes, double descuento) {
        this.precioMes = precioMes;
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
    
    
}
