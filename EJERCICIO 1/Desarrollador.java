public class Desarrollador extends EmpleadoBase{
    public Desarrollador(String nombre){
        super(nombre);
    }
    public double calcularSalario(int horas){
        return horas * 15.0;
    }
    public String Rol(){
        return "Desarrollador";
    }
    
}
