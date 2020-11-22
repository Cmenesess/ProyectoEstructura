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
import java.util.PriorityQueue;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class Operatividad {
    public ArrayList<Medico> doctores;
    public PriorityQueue<Paciente> Pacientes;
    public LinkedList<Puesto> puestos;
    public Operatividad(){
        this.Pacientes = LecturaDeArchivos.LecturaPaciente();
        //this.pacientes = new PriorityQueue<>((Paciente p1, Paciente p2)-> p1.getSintoma().getPrioridad()-p2.getSintoma().getPrioridad());
        this.puestos = new LinkedList<>();
        puestos=LecturaDeArchivos.LecturaPuestos();
    }
}
