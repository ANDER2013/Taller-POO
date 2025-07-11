public class Gerente extends EmpleadoBase{
    public Gerente(String nombre){
        super(nombre);
    }
    public double calcularSalario(int horas){
        return horas  * 25.0;
    }
    
    public String Rol(){
        return "Gerente";
    }
}
