package Todo;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACR
 */
public class Encriptador {
    FileWriter writer;
    BufferedReader reader;
    String csv = "src\\resources\\ArchivosEncriptados.csv";
    static{
    System.loadLibrary("EncAsm");
    }
    public native char encriptarROT47(char textChar);
    public native char generarChar(int num);
    public native int compararCadenas(String cadena1,String cadena2);
  
   
    public boolean encriptarROT47Archivo(String direccion_y_nombre) 
    {
        String nuevoTexto="";
        try {
            reader = new BufferedReader(new FileReader(direccion_y_nombre));
            String line = reader.readLine();
            while(line!=null)
            {
                for(char c :line.toCharArray())
                {
                    nuevoTexto+=encriptarROT47(c); 
                }
                nuevoTexto+="\n";
                line = reader.readLine();
            }    
            writer = new FileWriter(direccion_y_nombre);
            writer.write(nuevoTexto);
            writer.close();
         return true;
        } catch (IOException ex) {
            return false;
        }
    } 
    
    public String generarContrasena(int longitud)
    {
        Random rmd = new Random();
        String pass="";
        for(int i=0;i<longitud;i++)
        {
        char c = generarChar(rmd.nextInt(10));      
        pass+=c;  
        }
        
        return pass;
    }
    
    public int encriptarArchivo(String direccion_y_nombre,String contrasena) throws IOException
    {
        if(buscarArchivoEnCsv(direccion_y_nombre)!=null)return 0;//ya se encripto?
        if(encriptarROT47Archivo(direccion_y_nombre)==false)return 1;//si se encontro?
        else
        {
        writer = new FileWriter(csv,true);//agregar a lista
        writer.write("\n"+direccion_y_nombre+","+contrasena);
        writer.close();
        return 2; //se logro encriptar
        }
       
    }
    
    public String[] buscarArchivoEnCsv(String direccion_y_nombre) throws FileNotFoundException, IOException
    {
        reader = new BufferedReader(new FileReader(csv));
        String line = reader.readLine();
        while(line!=null)
        {
            String[] lines = line.split(",");//obtener nombre cadena
            if(compararCadenas(direccion_y_nombre,lines[0])==1)return lines;//lo encontro
            line = reader.readLine();
        }
        return null;//no lo encontro
    }
    
    public int desencriptarArchivo(String direccion_y_nombre,String contrasena) throws IOException
    {
        String[] lines = buscarArchivoEnCsv(direccion_y_nombre);
        if(lines==null)return 0;//se encripto?
        if(compararCadenas(contrasena,lines[1])==0)return 1; //contrasena esta bien?
        if(encriptarROT47Archivo(direccion_y_nombre)==false)return 2;//por alguna razon no se pudo encriptar
        borrarArchivoEnCsv(direccion_y_nombre);//borrar de lista
      return 3;  //se logro desencriptar
    }
            
   public void borrarArchivoEnCsv(String direccion_y_nombre) throws IOException
   {
        String nuevoTexto="";
        reader = new BufferedReader(new FileReader(csv));
        String line = reader.readLine();
        while(line!=null)
        {
            String[] lines = line.split(",");//obtener nombre cadena
            if(compararCadenas(direccion_y_nombre,lines[0])==0)nuevoTexto+=line;
            line = reader.readLine();
        }
        writer = new FileWriter(csv);
        writer.write(nuevoTexto);
        writer.close();
   }
}
