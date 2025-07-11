package inventarioproductos;

public abstract class Producto implements Mostrable {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract String tipo();
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
}