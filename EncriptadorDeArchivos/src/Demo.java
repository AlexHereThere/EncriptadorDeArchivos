/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karoe
 */
public class Demo {
    public static void main(String[] args)
    {
        Encriptador enc = new Encriptador();
        int error = enc.encriptar("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\Trabajos Uni\\Semestre 5\\hola.txt");
        System.out.println("Error: "+error);
    }
}
