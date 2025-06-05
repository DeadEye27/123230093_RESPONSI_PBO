/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Main.model.modelParkir;
import Main.view.viewParkir;
import Main.controller.controllerParkir;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()-> {
            modelParkir model = new modelParkir();
            viewParkir view = new viewParkir();
            new controllerParkir(model, view);
            view.setVisible(true);
        });
    }
    
}
