/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuprincipal;

import java.util.Scanner;
import tienda.ControladorVistas;

/**
 *
 * @author utku36
 */
public class VistaMP implements ContratoVistaMP {
    private final ContratoPresentadorMP presentador;
    private final ControladorVistas controlador;
    
    public VistaMP (ControladorVistas controlador){
        this.controlador = controlador;
        this.presentador = new PresentadorMP(this);
        this.presentador.iniciar();  
    }
    
    @Override
    public void mostrarMenuPrincipal(){
        Scanner teclado = new Scanner(System.in);
        clearConsole();
        System.out.println("\t"+"¡Bienvenidos!"+"\n"+
                "Ingrese una de las siguientes opciones: "+"\n"+
                "1) Tomar pedido."+"\n"+
                "2) Cancelar pedido."+"\n"+
                "3) Facturar."+"\n"+
                "4) Estadisiticas."+"\n"+
                "5) Administrar."+"\n"+
                "6) Salir."+"\n");
        int opcion=teclado.nextInt();
        presentador.procesarOpcionIngresada(opcion);
    }
    
    @Override
    public void mostrarOPcionErronea(){
        this.clearConsole();
        System.out.println("La opcion ingresada no es correcta.");
        }
    
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
/*
    try {
      final String os = System.getProperty("os.name");
      if (os.contains("Windows")) {
          Runtime.getRuntime().exec("cls");
      } else {
          Runtime.getRuntime().exec("clear");
      }
    } catch (final Exception e) {
        System.out.println("something went wrong :(");
    }
*/
  }

    @Override
    public void irTomarPedido() {
        this.controlador.lanzarTomarPedido();
    }

    @Override
    public void mostrarSaludoDespedida() {
        System.out.println("Fin de operaciones. Buen dia!");
    }

    @Override
    public void irCancelarPedido() {
        this.controlador.lanzarCancelarPedido();
    }

    @Override
    public void irFacturar() {
        this.controlador.lanzarFacturacion();
    }

    @Override
    public void irEstadisticas() {
        this.controlador.lanzarEstadisticas();
    }

    @Override
    public void irAdministrar() {
        this.controlador.lanzarAdministrar();
    }
}
