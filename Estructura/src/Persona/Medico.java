
package Persona;

public class Medico extends Persona{
    String nombre, apellido;
    Especialidad especialidad;
    
    public Medico(Especialidad especialidad, String nombre, String apellido){
        super(nombre, apellido);
        this.especialidad = especialidad;
    }
    
    
}
