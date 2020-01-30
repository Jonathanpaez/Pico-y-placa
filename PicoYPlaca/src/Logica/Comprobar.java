/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author Jonathan
 */
public class Comprobar {
    
    //inicializacion de datos
    public String placa = "";
    public String fecha = "";
    public String hora = "";
    public int ultimo_digito = 0;
    public String dia = "";
    HashMap<Integer, String> reglas = new HashMap<Integer, String>();

    public void ingresar_Reglas(){
        
        reglas.put(1, "LUNES");
        reglas.put(2, "LUNES");
        reglas.put(3, "MARTES");
        reglas.put(4, "MARTES");
        reglas.put(5, "MIERCOLES");
        reglas.put(6, "MIERCOLES");
        reglas.put(7, "JUEVES");
        reglas.put(8, "JUEVES");
        reglas.put(1, "VIERNES");
        reglas.put(1, "VIERNES");
    }
    
    //generar getters an setters
    public int getUltimo_digito() {
        return ultimo_digito;
    }

    public void setUltimo_digito(int ultimo_digito) {
        this.ultimo_digito = ultimo_digito;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    //ingreso de datos
    public void ingresar_Datos(String placa, String fecha, String hora){
        
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public void ultimo_Digito(){
        
        int placa_numerica = 0;
        String[] partes_placa = this.placa.split("-");
        placa_numerica = Integer.parseInt(partes_placa[1]);
        this.ultimo_digito = placa_numerica%10;      
        
    }
    
    //referencia a https://es.stackoverflow.com/questions/62067/dia-de-la-semana-a-partir-de-fecha-en-formato-int
    public static String dia_Semana(int mes, int dias, int año) {
         String dia="";
         int numD;
         Calendar c = Calendar.getInstance(Locale.US);
         c.set(año,mes-1,dias);
         numD=c.get(Calendar.DAY_OF_WEEK);
        if(numD == Calendar.SUNDAY)
            dia="DOMINGO";
        else if(numD == Calendar.MONDAY)
            dia="LUNES";
        else if(numD == Calendar.TUESDAY)
            dia="MARTES";
        else if(numD == Calendar.WEDNESDAY)
            dia="MIERCOLES";
        else if(numD == Calendar.THURSDAY)
            dia="JUEVES";
        else if(numD == Calendar.FRIDAY)
            dia="VIERNES";
        else if(numD == Calendar.SATURDAY)
            dia="SABADO";
         return dia;
    }
    
    public int comprobacion_Hora(){
        
        int tiempo = 0;
        String[] hora_minutos = this.hora.split(":");
        tiempo = (Integer.parseInt(hora_minutos[0])*100) + Integer.parseInt(hora_minutos[1]);
        
        return tiempo;
    }
    
    public void comprobar_Fecha(){
        String[] fecha = this.fecha.split("/");
        this.dia = this.dia_Semana(Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                Integer.parseInt(fecha[2]));
        
    }
    
    public void resultado(){
        
        this.ultimo_Digito();
        this.ingresar_Reglas();
        this.comprobar_Fecha();
        
        if(this.dia.equals(this.reglas.get(this.ultimo_digito))){
            if((this.comprobacion_Hora()>=700) && (this.comprobacion_Hora()<=930)){
                System.out.println("Su auto no esta autorizado a circular en dia " 
                        + this.dia + " en la hora " + this.hora );          
            }
            else if((this.comprobacion_Hora()>=1600) && (this.comprobacion_Hora()<=1930)){
                System.out.println("Su auto no esta autorizado a circular en dia " 
                        + this.dia + " en la hora " + this.hora );
            }else{
                System.out.println("Su auto esta autorizado a circular en dia " 
                        + this.dia + " en el horario de " + this.hora );
            }
            
        }else{
            System.err.println("Su automovil puede circular sin ninguna restriccion el dia " + this.dia);
        }
    }
}
    
    
    
    
   
