
package Persona;

public class Medico extends Persona{
    String nombre, apellido, especialidad;
    
    public Medico( String nombre, String apellido,String especialidad){
        super(nombre, apellido);
        this.especialidad = especialidad;
    }
    
    
}
