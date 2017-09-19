/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.operations;

import static com.ansa.connection.Database.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.ansa.jsf.TesisBean;

/**
 *
 * @author AnsaKhitara
 */
public class TesisOperation {

    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    /* Method To Fetch The Tesis Records From Database */
    public static ArrayList<TesisBean> getTesisListFromDB() {
        ArrayList<TesisBean> tesisList = new ArrayList<TesisBean>();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from tesis");
//            resultSetObj = stmtObj.executeQuery("select id, judul, abstrak, penulis, penerbit, tahunTerbit, tipe from tesis INNER JOIN link_id, link");
            while (resultSetObj.next()) {
                TesisBean tObj = new TesisBean();
                tObj.setId(resultSetObj.getInt("id"));
                tObj.setJudul(resultSetObj.getString("judul"));
                tObj.setAbstrak(resultSetObj.getString("abstrak"));
                tObj.setPenulis(resultSetObj.getString("penulis"));
                tObj.setPenerbit(resultSetObj.getString("penerbit"));
                tObj.setTahunTerbit(resultSetObj.getString("tahunTerbit"));
                tObj.setTipe(resultSetObj.getString("tipe"));
                tesisList.add(tObj);
            }
            System.out.println("Total Records Fetched: " + tesisList.size());
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tesisList;
    }

    /* Method Used To Save New Tesis Record In Database */
    public static String saveTesisDetailsInDB(TesisBean newTesisObj) {
        int saveResult = 0;
        String navigationResult = "";
        try {
            pstmt = getConnection().prepareStatement("insert into tesis (judul, abstrak, penulis, penerbit, tahunTerbit, tipe) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newTesisObj.getJudul());
            pstmt.setString(2, newTesisObj.getAbstrak());
            pstmt.setString(3, newTesisObj.getPenulis());
            pstmt.setString(4, newTesisObj.getPenerbit());
            pstmt.setString(5, newTesisObj.getTahunTerbit());
            pstmt.setString(6, newTesisObj.getTipe());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (saveResult != 0) {
            navigationResult = "/Home_Tesis.xhtml?faces-redirect=true";
        } else {
            navigationResult = "/operation/tesis/createTesis.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    /* Method Used To Edit Student Record In Database */
    public static String editTesisRecordInDB(int Id) {
        TesisBean editRecord = null;
        System.out.println("editTesisRecordInDB() : Tesis Id: " + Id);

        /* Setting The Particular Student Details In Session */
        Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from tesis where id = " + Id);
            if (resultSetObj != null) {
                resultSetObj.next();
                editRecord = new TesisBean();
                editRecord.setId(resultSetObj.getInt("id"));
                editRecord.setJudul(resultSetObj.getString("judul"));
                editRecord.setAbstrak(resultSetObj.getString("abstrak"));
                editRecord.setPenulis(resultSetObj.getString("penulis"));
                editRecord.setPenerbit(resultSetObj.getString("penerbit"));
                editRecord.setTahunTerbit(resultSetObj.getString("tahunTerbit"));
                editRecord.setTipe(resultSetObj.getString("tipe"));
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/operation/tesis/editTesis.xhtml?faces-redirect=true";
    }

    /* Method Used To Update Tesis Record In Database */
    public static String updateTesisDetailsInDB(TesisBean updateTesisObj) {
        try {
            pstmt = getConnection().prepareStatement("update tesis set judul=?, abstrak=?, penulis=?, penerbit=?, tahunTerbit=?, tipe=? where id=?");
            pstmt.setString(1, updateTesisObj.getJudul());
            pstmt.setString(2, updateTesisObj.getAbstrak());
            pstmt.setString(3, updateTesisObj.getPenulis());
            pstmt.setString(4, updateTesisObj.getPenerbit());
            pstmt.setString(5, updateTesisObj.getTahunTerbit());
            pstmt.setString(6, updateTesisObj.getTipe());
            pstmt.setInt(7, updateTesisObj.getId());
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/Home_Tesis.xhtml?faces-redirect=true";
    }

    /* Method Used To Delete Tesis Record From Database */
    public static String deleteTesisRecordInDB(int Id) {
        System.out.println("deleteTesisRecordInDB() : Id: " + Id);
        try {
            pstmt = getConnection().prepareStatement("delete from tesis where id = " + Id);
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/Home_Tesis.xhtml?faces-redirect=true";
    }
}
