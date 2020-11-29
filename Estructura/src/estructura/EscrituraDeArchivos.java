package estructura;

import Persona.Medico;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class EscrituraDeArchivos {
    public static void EscrituraMedicos(LinkedList<Medico> m) {
        try ( FileWriter fw = new FileWriter("medicos.txt", true);  
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) 
        {
            for (Medico c: m){
               out.println(c.getNombre()+ "/" + c.getApellido() + "/" + c.getEspecialidad()); 
            }
            
        } catch (IOException e) {
            System.out.println("No hay tal archivo!");
        }
    }
}
