
package Persona;

public class Paciente extends Persona{
    String nombre, apellido, genero;
    int edad;
    Sintoma sintoma;
    int Turno;
    
    public Paciente(String nombre, String apellido, String genero, int edad,Sintoma sintoma){
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

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int Turno) {
        this.Turno = Turno;
    }

    @Override
    public String toString() {
        return Turno + "";
    }
    
}
