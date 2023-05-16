package p1_saludo_so;

import java.time.LocalTime;

public class Saludo extends Thread{

    public Saludo(){
        System.out.println(getName() + "Se ha creado un hilo nuevo: " + LocalTime.now());
    }

    public void run (){
        System.out.println(getName() +" Hola Mundo " + LocalTime.now());
        System.out.println("Soy el hilo: "+ getName()+ LocalTime.now());
        System.out.println("Termine "+ getName() + "\t Tiempo" + LocalTime.now( ));

        System.out.println("");
    }
}