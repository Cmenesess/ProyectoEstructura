
package Persona;

public class Medico extends Persona{
    private String especialidad;
    private boolean asignacion;
    private boolean disponibilidad;
    
    public Medico( String nombre, String apellido,String especialidad){
        super(nombre, apellido);
        this.especialidad = especialidad;
        disponibilidad=true;
        asignacion=false;
    }
    public boolean Estado(){
        return asignacion;
    }
    public void EstadoAsignado(){
        asignacion=true;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void NoDisponible() {
        disponibilidad=false;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public boolean isAsignacion() {
        return asignacion;
    }
    
    
}
