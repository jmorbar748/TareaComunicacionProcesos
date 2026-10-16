package org.iesalandalus.tema1.ejercicio2;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class Lector {

    public static void main(String[] args) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "org.iesalandalus.tema1.ejercicio2.Escritor");

            Process p = pb.start();


            System.out.println("Introduce un número entero: ");
            int number = Entrada.entero();

            //Obtenemos el OutputStream del hijo para mandarle datos al hijo
            OutputStream os = p.getOutputStream();
            PrintStream ps = new PrintStream(os);

            //Le mandamos al hijo el número inicial
            ps.println(number);
            ps.flush();

            //Obtenemos el inputStream del hijo para leer los resultados generados por el proceso hijo
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


            //Tratamiento de errores
            InputStream ir = p.getErrorStream();
            InputStreamReader irr = new InputStreamReader(ir);
            BufferedReader brr = new BufferedReader(irr);

            String linerr;

            while ((linerr = brr.readLine()) != null) {
                System.out.println("ERROR DE PROCESO HIJO: " + linerr);
            }

            //Cerramos los buffereds.
            br.close();
            brr.close();
            //Cerramos el PrintStream
            ps.close();
        } catch (IOException e) {
            System.out.println("ERROR: Error de I/O");
            e.printStackTrace();
        }
    }
}
