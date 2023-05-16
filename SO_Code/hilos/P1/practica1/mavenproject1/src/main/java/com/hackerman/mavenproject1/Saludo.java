/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackerman.mavenproject1;

import java.time.LocalTime;

public class Saludo extends Thread{

    public Saludo( ){ 
        System.out.println(getName() + "Se ha creado un hilo nuevo: " + LocalTime.now());
    }
    
    public Saludo( String nombre){
        setName(nombre);
        System.out.println(getName() + "Se ha creado un hilo nuevo: " + LocalTime.now());
    }

    /*
    private void GeneraInfoA() {
        System.out.println(getName() +" Hola Mundo " + LocalTime.now());
        System.out.println("Soy el hilo: "+ getName()+ LocalTime.now());
        System.out.println("Termine "+ getName() + "\t Tiempo" + LocalTime.now( ));
        
    }
    */

    private void GeneraInfoB(){
        System.out.println("\n\n\t"+ getName()+ " Hola Mundo "
            + "\n Mi nombre es : " + getName()
            + "\n ID: " + getId()
            + "\n Prioridad :" + getPriority()
            + "\n Estado: " + getState()
            + "\n Grupo: " + getThreadGroup()
            + "\n time: " + LocalTime.now()
        );
         
    }     

    public void run (){
        //GeneraInfoA();
        GeneraInfoB();
        
    }

    
}