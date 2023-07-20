/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenhilos;

/**
 *
 * @author carlo
 */
public class Modificador {
	private int [] numMsj;
	private String textoMensaje;
        private int i;
        private int [] dia = new int[8];
	private boolean disponible = false; 
        private float change;

  public Modificador(int []array){
  
    numMsj = array;
    //i=-1;
    for(int j=0; j<7; j++){
        dia[j]=0;
    }
    i=0;
	}

  
	public synchronized void Almacenar(int nmsj, int index) {
		while(i ==numMsj.length) {
		    //el �ltimo mensaje no ha sido mostrado
		    try {
                        System.out.println("Bloqueado, esperando hilo");

		  	wait(); //se pone a dormir y cede el monitor
		   } catch (InterruptedException e) {} 
		}
                
		numMsj[index] += nmsj;
    //System.out.println("Productor: "+ nombre+" almacena el mensaje "+nmsj);
		//colocar el c�digo correpondiente para buscar el mensaje 
                //print();
                //System.out.println("Dia: "+(indice+1)+ "esperando hilo");
		//en una tabla de mensajes  
		textoMensaje = "mensaje ";
		disponible = true;
                
                dia[index]++;
		notifyAll();
	}	
	public synchronized String Obtener (String place) {
		String mensaje;
                
		while (dia[i]!=2 || i>=7) {
		    //no hay mensaje
		    try {
		  	wait(); //se pone a dormir y cede el monitor
		    } catch (InterruptedException e) {} 
		}
    
		disponible = false;
		notifyAll();
                String day = null;
                switch(i){
                    case 0: 
                        day= "Lunes";
                        break;
                    case 1: 
                        day= "Martes";
                        break;
                    case 2: 
                        day= "Miércoles";
                        break;
                    case 3: 
                        day= "Jueves";
                        break;
                    case 4: 
                        day= "Viernes";
                        break;
                        
                    case 5: 
                        day= "Sabado";
                        break;
                        
                    case 6: 
                        day= "Domingo";
                        break;
                        
                }
		mensaje = "\n\nLugar: "+place+"    Día: "+day+"   Número de visitantes: "+numMsj[i];
                //indice--;
                
                i++;
                
		return (mensaje);
	}
}