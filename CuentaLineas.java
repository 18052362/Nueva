import java.io.*;
import java.util.*;
import javax.swing.*;

public class CuentaLineas
{
    static int lineasT;

    public static void main(String[] args) {
        lineasT = 0;
        File archivo = new File("C:\\Users\\Diana Torres\\Desktop\\prueba.txt");
        cuentaLineas(archivo);
    }
    
    public static void cuentaLineas(File archivo) {
        try {
                BufferedReader archivoL = new BufferedReader(new FileReader(archivo));
                String lineaL;
                while((lineaL = archivoL.readLine()) != null) {
                    lineasT= lineasT + 1;
                }
                JOptionPane.showMessageDialog(null, "Lineas totales: " + lineasT);
                archivoL.close();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
