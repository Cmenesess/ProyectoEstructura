/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import Collecciones.ArrayList;
import Collecciones.List;
import Persona.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class LecturaDeArchivos {
    public String cadena;
    public String ruta;
    public LecturaDeArchivos(String ruta){
        this.ruta=ruta;
    }
    public List<Sintoma> LecturaSintomas(){
        List<Sintoma> lista_sintomas=new ArrayList<>();
        FileReader f = null;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            while((cadena=b.readLine())!=null){
                String[] cadenas=cadena.split("|");
                Sintoma sintoma= new Sintoma(cadenas[0],Integer.parseInt(cadenas[1]));
                lista_sintomas.addLast(sintoma);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sintomas;
    }
    
    
    public List<? extends Persona> LecturaPersonas(){
        List<Persona> lista_Persona=new ArrayList<>();
        FileReader f = null;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            while((cadena=b.readLine())!=null){
                String[] cadenas=cadena.split("|");
                Persona persona= CortarCadena(cadenas);
                lista_Persona.addLast(persona);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_Persona;
    }
    public Persona CortarCadena(String[] array){
        if(array.length>3)return new Paciente(array[0],array[1],array[2],array[3],new Sintoma(array[4],Integer.parseInt(array[5])));
        return new Medico(array[0],array[1],Especialidad.valueOf(array[2]));
        
    }
    
}
