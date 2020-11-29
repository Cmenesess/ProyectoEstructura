
package GUI;

import Persona.*;
import estructura.LecturaDeArchivos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Operatividad {
    private static Operatividad operatividad=null;
    private LinkedList<Medico> doctores=new LinkedList<Medico>();
    private PriorityQueue<Paciente> Pacientes=new PriorityQueue<Paciente>();
    private LinkedList<Puesto> puestos=new LinkedList<Puesto>();
    private int turno;
    private Operatividad(){
        this.Pacientes = LecturaDeArchivos.LecturaPaciente();
        puestos=LecturaDeArchivos.LecturaPuestos();
        TurnosIniciales();
        doctores = LecturaDeArchivos.LecturaMedicos();
        puestos.addAll(LecturaDeArchivos.LecturaPuestosConMedicos());
    }

    public LinkedList<Medico> getDoctores() {
        return doctores;
    }

    public PriorityQueue<Paciente> getPacientes() {
        return Pacientes;
    }

    public int getTurno() {
        return turno;
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
             puesto.NoDisponible();
        }
        gui.actualizarTableView();
    }
    private void TurnosIniciales(){
        List<Paciente> tmp = new LinkedList<>(); 
        while(!Pacientes.isEmpty()){
            Paciente p = Pacientes.poll();
            p.setTurno(turno++);
            tmp.add(p);
        }
        Pacientes.addAll(tmp);
    }
    public int generadorTurnos(){
        int turno_actual=turno;
        ++turno;
        return turno_actual;
    }
    
    public void eliminarPuesto(Puesto p){
        puestos.remove(p);
    }

    public Puesto puestoDisponible(){
        for(Puesto pu: puestos){
            if(pu.Actividad() && pu.Asignacion()) return pu;
        }
        return null;
    }
    public LinkedList<Puesto> puestosSinAsignar(){
        LinkedList<Puesto> disponibles=new LinkedList<>();
        for(Puesto p: puestos){
            System.out.println(p);
            if(!p.Asignacion()) disponibles.add(p);
        }
        System.out.println(disponibles);
        return disponibles;
    }
    
    public LinkedList<Medico> MedicosSinAsignar(){
        LinkedList<Medico> disponibles=new LinkedList<>();
        for(Medico p: doctores){
             if(!p.Estado()) disponibles.add(p);
        }
        return disponibles;
    }

    public LinkedList<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(LinkedList<Puesto> puestos) {
        this.puestos = puestos;
    }
     public List<Puesto> puestosOcupados(){
        List<Puesto> disponibles=new ArrayList<>();
        for(Puesto p: puestos)
            if(!p.Actividad()) disponibles.add(p);
        return disponibles;
    }
    
    public boolean generarPuesto(Puesto p){
        if(!Pacientes.isEmpty()){
            p.setPaciente(Pacientes.poll());
            p.NoDisponible();
        }else{
            p.Disponible();
            p.SinPaciente();
        }
        gui.actualizarTableView();
        return true;
    }

    
}
