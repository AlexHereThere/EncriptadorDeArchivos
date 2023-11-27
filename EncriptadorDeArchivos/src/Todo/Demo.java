package Todo;


import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACR
 */
public class Demo {
    public static void main(String[] args) throws IOException
    {
        Encriptador enc = new Encriptador();
        int f = enc.compararCadenas("g", "S");
        enc.encriptarROT47('2');
        char s = enc.generarChar(2);
        System.out.println(s);
        System.out.println(f);
    }
}
