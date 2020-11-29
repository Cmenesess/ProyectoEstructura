
package Persona;

import java.util.ArrayList;

public class roles {
    private ArrayList<Medico> doctores;
    private ArrayList<Paciente> pacientes;

    public roles() {
        ArrayList<Medico> doctores = new ArrayList<Medico>();
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    }

    public ArrayList<Medico> getDoctores() {
        return doctores;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setDoctores(ArrayList<Medico> doctores) {
        this.doctores = doctores;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
}
