
package Persona;

public class Puesto {
    private Paciente paciente;
    private Medico MedicoTurnoo;
    private int numero;
    private boolean disponiblidad;
    public Puesto(int numero) {
        this.numero = numero;
        this.disponiblidad = true;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public boolean Actividad(){
        return disponiblidad;
    }
    public void SinPaciente(){
        paciente=null;
    }
    public void Disponible(){
         disponiblidad=true;
    }
    public void NoDisponible(){
        disponiblidad=false;
    }
    public Medico getMedicoTurnoo() {
        return MedicoTurnoo;
    }

    public void setMedicoTurnoo(Medico MedicoTurnoo) {
        this.MedicoTurnoo = MedicoTurnoo;
    }
    public boolean Asignacion(){
        if(MedicoTurnoo==null){
            return false;
        }
       return true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero + "";
    }
    
    
}
