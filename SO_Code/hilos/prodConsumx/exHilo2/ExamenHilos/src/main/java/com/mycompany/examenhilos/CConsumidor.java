/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenhilos;

/**
 *
 * @author carlo
 */
class CConsumidor extends Thread {
	private Modificador mensaje;   //�ltimo mensaje generado
	String place;
	public CConsumidor (Modificador c, String p) {
		mensaje = c;
                place = p;
	}
	
	public void run() {
	  String Msj;	//mensaje a mostrar
		
	  while (true) {
	     Msj = mensaje.Obtener(place); //obtener el �ltimo mensaje
             System.out.println(Msj);
	     //System.out.println("Consumidor "+ getName() + ":  obtuvo " + Msj + "\n");
	  }
	}
}
