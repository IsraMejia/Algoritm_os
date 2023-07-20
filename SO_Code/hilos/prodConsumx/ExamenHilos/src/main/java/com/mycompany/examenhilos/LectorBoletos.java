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

    public LectorBoletos(int lugar, int[][] matrizAfluencia) {
        this.lugar = lugar;
        this.matrizAfluencia = matrizAfluencia;
    }

    public void run() {
        for (int dia = 0; dia < matrizAfluencia[lugar].length; dia++) {
            for (int hora = 0; hora < 8; hora++) {
                // Simulación de registro de visitantes
                int numeroAleatorio = (int) (Math.random() * 100) + 1;

                if (numeroAleatorio <= 70) {
                    int visitantesRegistrados = (int) (Math.random() * 20) + 1;

                    synchronized (matrizAfluencia) {
                        matrizAfluencia[lugar][dia] += visitantesRegistrados * 2;
                    }
                }

                try {
                    Thread.sleep(10); // Espera de 1 segundo (simulando una hora)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

