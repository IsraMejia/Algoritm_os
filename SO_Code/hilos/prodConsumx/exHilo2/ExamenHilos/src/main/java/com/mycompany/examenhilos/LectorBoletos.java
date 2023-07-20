/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenhilos;

/**
 *
 * @author ASUS
 */
class LectorBoletos extends Thread {
    private int lugar; // El lugar al que pertenece el lector (0 para Jardín Botánico, 1 para Pabellón de la Biodiversidad)
    private int[][] matrizAfluencia; // La matriz de afluencia
    int entradas;
    int torniquete;
    String place;
    private Modificador mensaje;

    public LectorBoletos(int lugar, int[][] matrizAfluencia, Modificador m, int t, String p) {
        this.lugar = lugar;
        this.matrizAfluencia = matrizAfluencia;
        mensaje = m;
        torniquete = t;
        place = p;
    }

    public void run() {
        for (int dia = 0; dia < matrizAfluencia[lugar].length; dia++) {
            entradas=0;
            for (int hora = 0; hora < 8; hora++) {
                // Simulación de registro de visitantes
                int numeroAleatorio = (int) (Math.random() * 100) + 1;

                if (numeroAleatorio <= 70) {
                    int visitantesRegistrados = (int) (Math.random() * 20) + 1;

                    synchronized (matrizAfluencia) {
                        //System.out.println("Lugar: "+lugar+" Dia: "+dia+" cuenta: "+visitantesRegistrados);
                        //matrizAfluencia[lugar][dia] += visitantesRegistrados;
                        entradas += visitantesRegistrados;
                    }
                }

                try {
                    Thread.sleep(10); // Espera de 1 segundo (simulando una hora)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String day = null;
            switch(dia){
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
            System.out.println("\nEn el "+place+" \tEl torniquete: "+torniquete+" registro: "+entradas+ " \ten el dia: "+day);
            mensaje.Almacenar(entradas, dia);
            /*try {
                    Thread.sleep(160); // Espera de 1 segundo (simulando una hora)
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }*/
            
            
        }
        
    }
}

