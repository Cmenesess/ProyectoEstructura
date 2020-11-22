/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import Collecciones.CircularDoublyLinkedList;
import Collecciones.CircularSimplyLinkedList;
import Collecciones.List;
import Persona.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class LecturaDeArchivos {

    public static ArrayList<Sintoma> LecturaSintomas(){
        ArrayList<Sintoma> lista_sintomas=new ArrayList<>();
        FileReader f = null;
        try {
            f = new FileReader("src/Archivos/sintoma.txt");
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while((cadena=b.readLine())!=null){
                String[] cadenas=cadena.split("/");
                Sintoma sintoma= new Sintoma(cadenas[0],Integer.parseInt(cadenas[1]));
                lista_sintomas.add(sintoma);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sintomas;
    }
    
    
    public static PriorityQueue<Paciente> LecturaPaciente(){
        PriorityQueue<Paciente> Pacien=new PriorityQueue<>((Paciente p1, Paciente p2)-> p1.getSintoma().getPrioridad()-p2.getSintoma().getPrioridad());
        FileReader f = null;
        try {
            f = new FileReader("src/Archivos/personas.txt");
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while((cadena=b.readLine())!=null){
                String[] cadenas=cadena.split("/");
                Paciente p=new Paciente(cadenas[0],cadenas[1],cadenas[2],cadenas[3],new Sintoma(cadenas[4],Integer.parseInt(cadenas[5])));
                Pacien.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return Pacien;
    }
    public static LinkedList<Puesto> LecturaPuestos(){
        LinkedList<Puesto> puestos=new  LinkedList<>();
        FileReader f = null;
        try {
            f = new FileReader("src/Archivos/puestos.txt");
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while((cadena=b.readLine())!=null){
                String[] cadenas=cadena.split("/");
                Puesto P= new Puesto(Integer.parseInt(cadenas[0]));
                puestos.add(P);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puestos;
    }
    public static CircularDoublyLinkedList<String> leerArchivoVideos(){
        CircularDoublyLinkedList<String> video=new CircularDoublyLinkedList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader("src/Archivos/videos.txt"))){
            String linea;
            while((linea=bf.readLine())!=null){
                video.addLast(linea);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return video;
    }
    
}
