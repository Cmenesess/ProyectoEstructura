
package Persona;

public class Paciente extends Persona{
    String nombre, apellido, genero, edad;
    Sintoma sintoma;
    
    public Paciente(Sintoma sintoma, String nombre, String apellido, String genero, String edad){
        super(nombre, apellido);
        this.sintoma = sintoma;
        this.genero = genero;
        this.edad = edad;
    }
    
}
