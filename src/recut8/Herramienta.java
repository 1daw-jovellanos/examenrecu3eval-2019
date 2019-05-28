
package recut8;


public class Herramienta implements IAlquilable {
    private double precioMes;
    private double peso;

    @Override
    public double getPrecioMes() {
        return precioMes;
    }

    public double getPeso() {
        return peso;
    }
    
    public Herramienta(double precioMes, double peso) {
        this.precioMes = precioMes;
        this.peso = peso;
    }

    
}
