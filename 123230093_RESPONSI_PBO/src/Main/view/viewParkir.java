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
    private JTextField fieldNama;
    private JTextField fieldPlat;
    private JTextField fieldMerk;
    private JTextField fieldDurasi;
    
    private JButton addButton, deleButton, updaButton, editButton, cleaButton;
    private int currentEditingid = -1;
    
    public viewDataparkir(){
        setTitle("Aplikasi Manajemen Data Parkir");
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel 
        
        
        
        
        tableModel = new DefaultTableModel(new Object[]{
           "ID", "Nama", "Plat", "Merk", "Durasi", "Total Bayar" 
        }, 0);
        
        table = new JTable(tableModel);
        
    
    
    
        public void setController(controllerParkir controller){
            this.controller = controller;
        }
        public void showDataParkir(ArrayList<modelParkir.dataParkir> dataparkirs){
            tableModel.setRowCount(0);
            for (modelParkir.dataParkir d : dataparkirs){
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
        public void showMessage(String message){
            JOptionPane.showMessageDialog(this, message);
        }
    } 
}
