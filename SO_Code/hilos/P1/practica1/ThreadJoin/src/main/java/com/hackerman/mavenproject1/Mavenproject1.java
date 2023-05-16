/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hackerman.mavenproject1;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IsraCode
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "\t Inicia ejecucion: "+ LocalTime.now());

        Saludo hilo1 = new Saludo(); 
        hilo1.setName("HiloA");
        hilo1.setPriority(Thread.MIN_PRIORITY);


        Saludo hilo2 = new Saludo("HiloB");
        hilo1.setPriority(Thread.MAX_PRIORITY);
        
        hilo1.start(); 
        hilo2.start();
 
        Saludo hilo3 = new Saludo("HiloC");
        
        /**Se ponen los Try en bloques diferentes ya que si estuvieran en el mismo y sucede error en un hilo
         * En ese momento deja de ejecutarse esa porcion del try , lanzando el error y no leyendo las deams lineas de codigo
         */
        try { 
            hilo1.join();
            System.out.println("join Hilo1");
        } catch (InterruptedException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try { 
            hilo2.join();
            System.out.println("join Hilo2");
        } catch (InterruptedException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hilo3.start();
        try { 
            hilo3.join(); //Ahora el main no puede morir hasta que termine el hilo3
        } catch (InterruptedException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\n\n\t\tTermina Ejecucion"+ LocalTime.now());

        //GeneraInfoA();
    }

    /*private static GenerarInfoMain(){
        System.out.println("\n\tEstado de los hilos:" );
        System.out.println("main: hilo1 "+ getState(hilo1));
        System.out.println("main: hilo2 "+ getState(hilo2)); 
        System.out.println("main hilos activos : "+ Thread.activeCount() );
    }
    */
}
