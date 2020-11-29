
package Persona;

public class Paciente extends Persona{
    private String genero;
    private int edad;
    private Sintoma sintoma;
    private int Turno;
    
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
	public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return Turno + "";
    }
    
}
