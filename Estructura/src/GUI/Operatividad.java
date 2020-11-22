
package GUI;

import Persona.*;
import estructura.LecturaDeArchivos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Operatividad {
    private static Operatividad operatividad=null;
    public LinkedList<Medico> doctores=new LinkedList<Medico>();
    public PriorityQueue<Paciente> Pacientes=new PriorityQueue<Paciente>();
    public LinkedList<Puesto> puestos=new LinkedList<Puesto>();
    public int turno;
    private Operatividad(){
        this.Pacientes = LecturaDeArchivos.LecturaPaciente();
        puestos=LecturaDeArchivos.LecturaPuestos();
    }
    public static Operatividad getInstance() {
        if (null == operatividad)
            operatividad = new Operatividad();
        return operatividad;
    }
    public void agregarCola(Paciente p){
        Pacientes.offer(p);
        p.setTurno(generadorTurnos());
        Puesto puesto= puestoDisponible();
        if(puesto!=null){
            puesto.setPaciente(Pacientes.poll());
        }
    }
    public int generadorTurnos(){
        int turno_actual=turno;
        ++turno;
        return turno_actual;
    }
    public Puesto puestoDisponible(){
        for(Puesto pu: puestos){
            if(pu.Activo()) return pu;
        }
        return null;
    }
    public LinkedList<Puesto> puestosSinAsignar(){
        LinkedList<Puesto> disponibles=new LinkedList<>();
        for(Puesto p: puestos)
            if(!p.Asignacion()) disponibles.add(p);
        return disponibles;
    }
    public LinkedList<Medico> MedicosSinAsignar(){
        LinkedList<Medico> disponibles=new LinkedList<>();
        for(Medico p: doctores){
             if(!p.Estado()) disponibles.add(p);
        }
        return disponibles;
    }
    
    
}
