/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Logica.Comprobar;
import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class Main {
    public static void main(String[] args) {
        
        //Inicializacion de variables
        Scanner reader = new Scanner(System.in);
        String placa = "";
        String fecha = "";
        String hora = "";
        String continuar = "S";
        Comprobar comprobar = new Comprobar();
        
        while (continuar.equals("S")){
            
            // Ingreso de datos
            System.out.println("Favor ingresar la placa del vehiculo (Ej: PWE-1100)");
            placa = reader.nextLine();

            System.out.println("Ingrese la fecha en la que desea circular (Ej: dd/mm/aa)");
            fecha = reader.nextLine();

            System.out.println("Ingrese la hora en la que desea conducir (Ej: 15:00)");
            hora = reader.nextLine();
            
            //Manejo de datos
            comprobar.ingresar_Datos(placa, fecha, hora);
            comprobar.resultado();
            
            //posibilidad de mas consultas
            System.out.println("Desea realizar otra consulta? S/N");
            continuar = reader.nextLine();
            
        }
    }
    
}
