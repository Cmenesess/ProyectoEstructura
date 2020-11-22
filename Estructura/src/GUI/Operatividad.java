
package GUI;

import Persona.*;
import estructura.LecturaDeArchivos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Operatividad {
    public static Operatividad operatividad=new Operatividad();
    public ArrayList<Medico> doctores;
    public PriorityQueue<Paciente> Pacientes;
    public LinkedList<Puesto> puestos;
    public int turno;
    private Operatividad(){
        this.Pacientes = LecturaDeArchivos.LecturaPaciente();
        puestos=LecturaDeArchivos.LecturaPuestos();
    }

    public static Operatividad getOperatividad() {
        return operatividad;
    }

    public static void setOperatividad(Operatividad operatividad) {
        Operatividad.operatividad = operatividad;
    }

    public ArrayList<Medico> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Medico> doctores) {
        this.doctores = doctores;
    }

    public PriorityQueue<Paciente> getPacientes() {
        return Pacientes;
    }

    public void setPacientes(PriorityQueue<Paciente> Pacientes) {
        this.Pacientes = Pacientes;
    }

    public LinkedList<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(LinkedList<Puesto> puestos) {
        this.puestos = puestos;
    }
    public void agregarCola(Paciente p){
        Pacientes.offer(p);
        p.setTurno(generadorTurnos());
        
    }
    public int generadorTurnos(){
        int turno_actual=turno;
        ++turno;
        return turno_actual;
    }
}
