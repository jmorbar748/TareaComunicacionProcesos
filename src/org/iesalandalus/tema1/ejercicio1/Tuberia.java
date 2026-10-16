package org.iesalandalus.tema1.ejercicio1;

import java.io.*;

public class Tuberia {

    public static void main(String[] args){

        try {

            // Creamos el proceso1, se indican los comandos
            ProcessBuilder pb1 = new ProcessBuilder("CMD", "/C", "DIR");
            Process proceso1 = pb1.start();

            ProcessBuilder pb2 = new ProcessBuilder("CMD", "/C", "FIND", ".txt");
            Process proceso2 = pb2.start();

            // Leemos la salida de P1
            BufferedReader br1 = new BufferedReader(
                    new InputStreamReader(proceso1.getInputStream()));

            // Preparamos la escritura en la entrada de P2
            BufferedWriter bw2 = new BufferedWriter(
                    new OutputStreamWriter(proceso2.getOutputStream()));

            String linea;
            while ((linea = br1.readLine()) != null) {
                bw2.write(linea);  //en vez de println, escribimos en P2
                bw2.newLine();     //salto de linea
            }
            //  Cerramos los flujos
            bw2.flush();
            bw2.close();
            br1.close();

            // Leemos la salida de P2 y la mostramos por pantalla
            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(proceso2.getInputStream()));


            String lineaFinal;
            while ((lineaFinal = br2.readLine()) != null) {
                System.out.println(lineaFinal);
            }
            //Cerramos los flujos
            br2.close();

            System.out.println("Finalizada la ejecución");

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }

    }

}
