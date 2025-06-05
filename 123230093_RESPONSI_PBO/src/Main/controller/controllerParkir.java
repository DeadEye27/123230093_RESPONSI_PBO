/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;
import Main.model;
import Main.model.modelParkir;
import Main.view.viewParkir;
import java.util.ArrayList;

/**
 *
 * @author Lab Informatika
 */
public class controllerParkir {
    private modelParkir model;
    private viewParkir view;
    
    public controllerParkir(modelParkir model, viewParkir view){
        this.model = model;
        this.view = view;
        view.setController(this);
        loadDataParkirList();
    }
    public void loadDataParkirList(){
        ArrayList<modelParkir.dataParkir> dataParkirs = model.getAlldataParkir();
        view.showDataParkir(dataParkirs);
    }
    
    public void addDataParkir(String nama, String plat, String merk, int durasi){
        if (model.addDataParkir(nama, plat, merk, durasi)){
            view.showMessage("Data Parkir berhasil ditambahkan");
            loadDataParkirList();
        }else {
            view.showMessage("Gagal Menambahkan Data Parkir");
        }
    }
    
    public void deleteDataParkir(int id){
        if (model.deleteDataParkir(id)){
            view.showMessage("Data Parkir Berhasil Dihapus");
        } else {
            view.showMessage("Gagal Menghapus Data Parkir");
        }
    }
    
    public void updateDataParkir(int id, String nama, String plat, String merk, int durasi){
        if (model.updateDataParkir(id, nama, plat, merk, durasi)){
            view.showMessage("Data Parkir Berhasil diperbarui");
        } else {
            view.showMessage("Gagal Mempebarui Data Parkir");
        }
    }
    
    
    
}
