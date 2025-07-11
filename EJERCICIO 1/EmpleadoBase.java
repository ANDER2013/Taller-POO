public abstract class EmpleadoBase implements Empleado {
    private String nombre;
    
    public EmpleadoBase(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
}
