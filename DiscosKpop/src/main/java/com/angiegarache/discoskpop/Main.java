/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angiegarache.discoskpop;
import com.angiegarache.utilidades.Layout;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Angie Garache
 */


public class Main {
    public static void main (String[] args) {
        //Layout.printSeparator();
        //System.out.println("Musica App V1.0");
        //Layout.printSeparator();
        Layout.printHeader("Compra de album Kpop");
        String OpcionMenu = "";
        
        Scanner entradaTeclado = new Scanner(System.in);
        
        Aplicacion cursoApp = new Aplicacion(entradaTeclado);
        
        while (!(OpcionMenu.toUpperCase().equals("S"))) {
            Layout.printMenu();
            OpcionMenu = entradaTeclado.nextLine();

            System.out.println("Texto ingresado es igual a " + OpcionMenu);
            // Verificar las Opciones
            cursoApp.activarEvento(OpcionMenu);
            
        }
     }
}
