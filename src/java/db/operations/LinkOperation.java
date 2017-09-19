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

import com.ansa.jsf.LinkBean;

/**
 *
 * @author AnsaKhitara
 */
public class LinkOperation {

    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    /* Method To Fetch The Link Records From Database */
    public static ArrayList<LinkBean> getLinkListFromDB() {
        ArrayList<LinkBean> linkList = new ArrayList<LinkBean>();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from link");
            while (resultSetObj.next()) {
                LinkBean tObj = new LinkBean();
                tObj.setLink_id(resultSetObj.getInt("link_id"));
                tObj.setLink(resultSetObj.getString("link"));
                linkList.add(tObj);
            }
            System.out.println("Total Records Fetched: " + linkList.size());
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return linkList;
    }

    /* Method Used To Save New Link Record In Database */
    public static String saveLinkDetailsInDB(LinkBean newLinkObj) {
        int saveResult = 0;
        String navigationResult = "";
        try {
            pstmt = getConnection().prepareStatement("insert into link (link) values (?)");
            pstmt.setString(1, newLinkObj.getLink());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (saveResult != 0) {
            navigationResult = "/Home_Link.xhtml?faces-redirect=true";
        } else {
            navigationResult = "/operation/link/createLink.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    /* Method Used To Edit Student Record In Database */
    public static String editLinkRecordInDB(int Id) {
        LinkBean editRecord = null;
        System.out.println("editLinkRecordInDB() : Link Id: " + Id);

        /* Setting The Particular Student Details In Session */
        Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from link where link_id = " + Id);
            if (resultSetObj != null) {
                resultSetObj.next();
                editRecord = new LinkBean();
                editRecord.setLink_id(resultSetObj.getInt("link_id"));
                editRecord.setLink(resultSetObj.getString("link"));
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/operation/link/editLink.xhtml?faces-redirect=true";
    }

    /* Method Used To Update Link Record In Database */
    public static String updateLinkDetailsInDB(LinkBean updateLinkObj) {
        try {
            pstmt = getConnection().prepareStatement("update link set link=? where link_id=?");
            pstmt.setString(1, updateLinkObj.getLink());
            pstmt.setInt(2, updateLinkObj.getLink_id());
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/Home_Link.xhtml?faces-redirect=true";
    }

    /* Method Used To Delete Link Record From Database */
    public static String deleteLinkRecordInDB(int Id) {
        System.out.println("deleteLinkRecordInDB() : Id: " + Id);
        try {
            pstmt = getConnection().prepareStatement("delete from link where link_id = " + Id);
            pstmt.executeUpdate();
            connObj.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/Home_Link.xhtml?faces-redirect=true";
    }
}
