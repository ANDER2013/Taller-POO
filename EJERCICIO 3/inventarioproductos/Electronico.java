package inventarioproductos;

public class Electronico extends Producto {

    public Electronico(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String tipo() {
        return "Electrónico";
    }

    @Override
    public String mostrarPrecio() {
        return "Precio final (con IVA 12%): $" + (precio * 1.12);
    }
}
