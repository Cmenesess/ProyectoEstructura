package estructura;

import Persona.Medico;
import Persona.Paciente;
import Persona.Puesto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class EscrituraDeArchivos {


    public static void EscrituraMedicos(Medico m) {
        try ( FileWriter fw = new FileWriter("src/Archivos/Medicos.txt", true);  
            BufferedWriter bw = new BufferedWriter(fw)) 
        {
            String text = m.toString();
            bw.write(text);
            bw.newLine();
            } catch (IOException e) {
            System.out.println("No hay tal archivo!");
        }
    }
    public static void escrituraPacientes(Paciente p){
        try(FileWriter fw = new FileWriter("src/Archivos/Pacientes.txt", true);
        BufferedWriter bw = new BufferedWriter(fw))
        {
            String text = p.toString();
            bw.write(text);
            bw.newLine();
        }catch (IOException e) {
            System.out.println("No hay tal archivo!");
        }
    }
    public static void escrituraPuesto(LinkedList<Puesto> puestos){
        try(FileWriter fw = new FileWriter("src/Archivos/puestos.txt", false);
        BufferedWriter bw = new BufferedWriter(fw)){
            for(Puesto p: puestos){
                bw.write(p.toString());
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("No hay tal archivo!");
        }
    }
    public static void escrituraPuestosMed(Puesto p, Medico m){
        try(FileWriter fw = new FileWriter("src/Archivos/puestosconmedicos.txt", true);
        BufferedWriter bw = new BufferedWriter(fw))
        {
            String text = p.toString();
            String text2 = m.toString();
            bw.write(text +" "+ text2);
            bw.newLine();
        }catch (IOException e) {
            System.out.println("No hay tal archivo!");
        }
    }
}
