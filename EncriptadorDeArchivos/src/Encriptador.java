/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karoe
 */
public class Encriptador {
    static{
    System.loadLibrary("encriptadoAsm");
    }
    public native int encriptar(String direccion_y_nombre);
    public native int desencriptar(String direccion_y_nombre);
    
}
