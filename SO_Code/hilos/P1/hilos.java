package p1_saludo_so;
import java.time.LocalTime;

public static void main (String args[]) {
    
    System.out.println(Thread.currentThread().getName() + "\t Inicia ejecucion: "+ LocalTime.now());

    Saludo hilo1 = new Saludo(); 
    Saludo hilo2 = new Saludo();

    hilo1.start(); 
    hilo1.start();

    System.out.println("Termina Ejecucion"+ LocalTime.now());
}