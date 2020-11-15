
package Persona;

public class Medico extends Persona{
    String nombre, apellido;
    Especialidad especialidad;
    
    public Medico( String nombre, String apellido,Especialidad especialidad){
        super(nombre, apellido);
        this.especialidad = especialidad;
    }
    
    
}
