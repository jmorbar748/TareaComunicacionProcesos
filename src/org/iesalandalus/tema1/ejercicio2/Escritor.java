package org.iesalandalus.tema1.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Escritor {

public static void main(String[] args){

    try
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(isr);

        String line;

        line=bf.readLine();
        int number=Integer.parseInt(line);

        for(int i = number + 1;i <= number + 10;i++)
        {
            System.out.println(i);
        }
        bf.close();
    }
    catch(IOException e)
    {
        System.out.println("ERROR: Error de I/O");
        e.printStackTrace();
    }

}

}
