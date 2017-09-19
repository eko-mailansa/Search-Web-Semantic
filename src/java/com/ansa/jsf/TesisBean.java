/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ansa.jsf;

import db.operations.TesisOperation;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AnsaKhitara
 */
@ManagedBean
@RequestScoped
public class TesisBean {

    private int id;
    private String judul, abstrak, penulis, penerbit, tahunTerbit, tipe;

    public ArrayList<TesisBean> tesisListFromDB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /* Method Will Avoid Multiple Calls To DB For Fetching The Students Records. If This Is Not Used & Data Is Fetched From Getter Method, JSF DataTable Will Make Multiple Calls To DB*/
    @PostConstruct
    public void init() {
        tesisListFromDB = TesisOperation.getTesisListFromDB();
    }

    /* Method Used To Fetch All Records From The Database */
    public ArrayList<TesisBean> tesisList() {
        return tesisListFromDB;
    }

    /* Method Used To Save New Student Record */
    public String saveTesisDetails(TesisBean newTesisObj) {
        return TesisOperation.saveTesisDetailsInDB(newTesisObj);
    }

    /* Method Used To Edit Student Record */
    public String editTesisRecord(int Id) {
        return TesisOperation.editTesisRecordInDB(Id);
    }

    /* Method Used To Update Student Record */
    public String updateTesisDetails(TesisBean updateTesisObj) {
        return TesisOperation.updateTesisDetailsInDB(updateTesisObj);
    }

    /* Method Used To Delete Student Record */
    public String deleteTesisRecord(int Id) {
        return TesisOperation.deleteTesisRecordInDB(Id);
    }
}
