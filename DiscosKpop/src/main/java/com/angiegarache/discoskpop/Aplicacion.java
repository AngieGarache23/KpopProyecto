/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angiegarache.discoskpop;

/**
 *
 * @author Angie Garache
 */
import com.angiegarache.utilidades.Layout;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    private Scanner _EntradaTeclado;
    private ArrayList _MiKpop;
    public Aplicacion(Scanner EntradaTeclado) {
        this._EntradaTeclado = EntradaTeclado;
        this._MiKpop = new ArrayList<KpopItem>();  
    }
    
    public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
          case "M":
                this.mostrarRegistros();
                break;
            case "I":
                System.out.println("Ingresar Compra");
                this.ingresarNuevoRegistro();
                break;
            case "A":
                this.actualizarCompra();
                System.out.println("Actualizar Compra");
                break;
            case "E": 
                this.eliminarCompra();
                System.out.println("Eliminar Compra");
                break;
            case "S":
                System.out.println("Usted ha salido del sistema Gracias por usar la App---Bendiciones!");
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
    }
    
    private void ingresarNuevoRegistro(){
        Layout.printHeader("Nuevo Registro de Curso");
        KpopItem nuevoKpopItem =  new KpopItem();
        nuevoKpopItem.setNombrealbum(Layout.obtenerValorParaCampo("Nombre del album", this._EntradaTeclado));
        nuevoKpopItem.setnumeroalbum(Layout.obtenerValorParaCampo("Numero de album", "xx", this._EntradaTeclado));
        nuevoKpopItem.setPrecio(Layout.obtenerValorParaCampo("Precio de album", "Precio en lempiras", this._EntradaTeclado));
        int anio = Integer.parseInt(Layout.obtenerValorParaCampo("Año de creacion yyyy", "2020", this._EntradaTeclado));
        int mes = Integer.parseInt(Layout.obtenerValorParaCampo("Mes de creacion 1-12", "1", this._EntradaTeclado));
        int dia = Integer.parseInt(Layout.obtenerValorParaCampo("Día de creacion 1-31", "1", this._EntradaTeclado));
        this._MiKpop.add(nuevoKpopItem);
        
        Layout.printSeparator();
        System.out.println(this._MiKpop.size());
    }

    private void mostrarRegistros(){
        Layout.printSeparator();
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Nombre del curso");
        columnas.add("Cedula");
        columnas.add("Precio L.");
        columnas.add("Duracion (meses)");
        columnas.add("Fecha de creacion");
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(7);
        anchos.add(20);
        anchos.add(13);
        anchos.add(20);
        anchos.add(14);
        anchos.add(14);
        
        
        // |1234567890|123456789012345|
        try {
            //Imprimir encabezado
            Layout.imprimirEnColumna(columnas, anchos, "||");
            Layout.printSeparator();
            for(int i = 0; i< this._MiKpop.size(); i++){
                columnas = ((KpopItem) this._MiKpop.get(i)).obtenerCampos();
                Layout.imprimirEnColumna(columnas, anchos, "||");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
    
    private void actualizarRegistro(){
        Layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        KpopItem selectCurso = null;
        for( int i=0; i < this._MiKpop.size(); i++){
            if( selectedId == ((KpopItem)this._MiKpop.get(i)).getId()) {
                selectKpop = (KpopItem)this._MiKpop.get(i);
                break;
            }
        }
        if (selectKpop == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectKpop.setNombre(Layout.obtenerValorParaCampo("Nombre del album", selectKpop.getNombrealbum(), this._EntradaTeclado));
            selectKpop.setnumeroalbum(Layout.obtenerValorParaCampo("Numero de album", selectKpop.getnumeroalbum(), this._EntradaTeclado));
            selectKpop.setPrecio(Layout.obtenerValorParaCampo("Precio del Album", selectKpop.getPrecio(), this._EntradaTeclado));
            int anio = Integer.parseInt(Layout.obtenerValorParaCampo("Año de Creacion yyyy", "2020", this._EntradaTeclado));
            int mes = Integer.parseInt(Layout.obtenerValorParaCampo("Mes de Creacion 1-12", "1", this._EntradaTeclado));
            int dia = Integer.parseInt(Layout.obtenerValorParaCampo("Día de Creacion 1-31", "1", this._EntradaTeclado));
            Layout.printSeparator();
            System.out.println("Registro Actualizado Satisfactoriamente!!!");
        }
        
    }
    
    private void eliminarRegistro(){
        Layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo de compra", "0", this._EntradaTeclado));
        int encontradoEnIndice = -1;
        for( int i=0; i < this._MiKpop.size(); i++){
            if( selectedId == ((KpopItem)this._MiKpop.get(i)).getId()) {
                encontradoEnIndice = i;
                break;
            }
        }
        if (encontradoEnIndice>=0){
            Layout.printSeparator();
            String confirmado = Layout.obtenerValorParaCampo("¿Desea Eliminar este Registro? S - N", "N", this._EntradaTeclado);
            if (confirmado.toUpperCase().equals("S")){
                this._MiKpop.remove(encontradoEnIndice);
                Layout.printSeparator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
    
}
