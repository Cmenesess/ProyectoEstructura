
package Persona;

public class Medico extends Persona{
    public String nombre, apellido, especialidad;
    public boolean sin_asignacion;
    public boolean disponibilidad;
    
    public Medico( String nombre, String apellido,String especialidad){
        super(nombre, apellido);
        this.especialidad = especialidad;
        disponibilidad=true;
    }
    public boolean Estado(){
        return sin_asignacion;
    }
    public void EstadoAsignado(){
        sin_asignacion=true;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void NoDisponible() {
        disponibilidad=false;
    }
    
    
}
