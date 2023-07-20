/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenhilos;

/**
 *
 * @author ASUS
 */
public class ExamenHilos {

   public static void main(String[] args) {
        int numLugares = 2; // Número de lugares (Jardín Botánico y Pabellón de la Biodiversidad)
        int numDias = 7; // Número de días de la semana

        int[][] matrizAfluencia = new int[numLugares][numDias];

        // Crear y ejecutar hilos lectores
        for (int lugar = 0; lugar < numLugares; lugar++) {
            for (int i = 0; i < 2; i++) {
                LectorBoletos lector = new LectorBoletos(lugar, matrizAfluencia);
                lector.start();
            }
        }

        // Esperar a que los hilos terminen
        try {
            Thread.sleep(8 * 1000); // Esperar 8 horas (simulando el horario de servicio)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir total registrado por día
        for (int dia = 0; dia < numDias; dia++) {
            int totalDia = 0;
            for (int lugar = 0; lugar < numLugares; lugar++) {
                totalDia += matrizAfluencia[lugar][dia];
            }
            System.out.println("Total registrado en el día " + (dia + 1) + ": " + totalDia);
        }

        // Imprimir total registrado por semana en cada lugar
        for (int lugar = 0; lugar < numLugares; lugar++) {
            int totalSemana = 0;
            for (int dia = 0; dia < numDias; dia++) {
                totalSemana += matrizAfluencia[lugar][dia];
            }
            System.out.println("Total registrado en la semana en el lugar " + lugar + ": " + totalSemana);
        }
    }
}
