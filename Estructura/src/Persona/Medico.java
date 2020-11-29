
package Persona;

public class Medico extends Persona{
    private String especialidad;
    private boolean asignacion;
    public Medico( String nombre, String apellido,String especialidad){
        super(nombre, apellido);
        this.especialidad = especialidad;
        asignacion=false;
    }
    public boolean Estado(){
        return asignacion;
    }
    public void setEstado(boolean estado){
        asignacion=estado;
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
}
