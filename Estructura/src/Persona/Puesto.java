/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
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
    public boolean Activo(){
        return disponiblidad;
    }
    public void Disponibilidad(){
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
    
}
