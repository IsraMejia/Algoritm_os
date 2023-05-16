/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hackerman.mavenproject1;

import java.time.LocalTime;

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
 

        GenerarInfoMain();

        System.out.println("\n\n\t\tTermina Ejecucion"+ LocalTime.now());

        //GeneraInfoA();
    }

    private static GenerarInfoMain() {
        System.out.println("\n\tEstado de los hilos:" );
        System.out.println("main: hilo1 "+ getState(hilo1));
        System.out.println("main: hilo2 "+ getState(hilo2)); 
        System.out.println("main hilos activos : "+ Thread.activeCount() );
    }
}
