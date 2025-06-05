/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.view;
import Main.controller.controllerParkir;
import Main.model;
import Main.model.modelParkir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author Lab Informatika
 */
public class viewParkir extends JFrame{
    private controllerParkir controller;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public void setController(controllerParkir controller){
        this.controller = controller;
    }
    public void showDataParkir(ArrayList<modelParkir.dataParkir> dataparkir){
        tableModel.setRowCount(0);
        for (modelParkir.dataParkir d : dataparkir){
            tableModel.addRow(new Object[]{
                d.id,
                d.nama,
                d.plat,
                d.merk,
                d.durasi,
                d.getTotalBayar()
            });
        }
    }
    
}
