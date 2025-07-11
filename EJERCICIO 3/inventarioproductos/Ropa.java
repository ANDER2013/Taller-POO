package inventarioproductos;

public class Ropa extends Producto {

    public Ropa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String tipo() {
        return "Ropa";
    }

    @Override
    public String mostrarPrecio() {
        return "Precio sin impuestos: $" + precio;
    }
}
