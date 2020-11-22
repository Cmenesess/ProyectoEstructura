
package Persona;

public class Paciente extends Persona{
    String nombre, apellido, genero, edad;
    Sintoma sintoma;
    
    public Paciente(String nombre, String apellido, String genero, String edad,Sintoma sintoma){
        super(nombre, apellido);
        this.sintoma = sintoma;
        this.genero = genero;
        this.edad = edad;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
    
}
