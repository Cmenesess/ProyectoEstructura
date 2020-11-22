/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persona.*;
import estructura.LecturaDeArchivos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class Operatividad {
    public static Operatividad operatividad=new Operatividad();
    public LinkedList<Medico> doctores=new LinkedList<Medico>();
    public PriorityQueue<Paciente> Pacientes=new PriorityQueue<Paciente>();
    public LinkedList<Puesto> puestos=new LinkedList<Puesto>();
    public int turno;
    private Operatividad(){
        this.Pacientes = LecturaDeArchivos.LecturaPaciente();
        puestos=LecturaDeArchivos.LecturaPuestos();
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
    public List<Puesto> puestosDisponible(){
        List<Puesto> disponibles=new ArrayList<>();
        for(Puesto p: puestos)
            if(p.Activo()) disponibles.add(p);
        return disponibles;
    }
    public LinkedList<Medico> MedicosDisponibles(){
        LinkedList<Medico> disponibles=new LinkedList<>();
        for(Medico p: doctores){
             if(p.disponibilidad) disponibles.add(p);
        }
        return disponibles;
    }
    
    
}
