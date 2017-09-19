/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ansa.jsf;

import db.operations.LinkOperation;
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
public class LinkBean {

    private int link_id;
    private String link;

    public ArrayList<LinkBean> linkListFromDB;

    public int getLink_id() {
        return link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<LinkBean> getLinkListFromDB() {
        return linkListFromDB;
    }

    public void setLinkListFromDB(ArrayList<LinkBean> linkListFromDB) {
        this.linkListFromDB = linkListFromDB;
    }

    
    
    /* Method Will Avoid Multiple Calls To DB For Fetching The Students Records. If This Is Not Used & Data Is Fetched From Getter Method, JSF DataTable Will Make Multiple Calls To DB*/
    @PostConstruct
    public void init() {
        linkListFromDB = LinkOperation.getLinkListFromDB();
    }

    /* Method Used To Fetch All Records From The Database */
    public ArrayList<LinkBean> linkList() {
        return linkListFromDB;
    }

    /* Method Used To Save New Student Record */
    public String saveLinkDetails(LinkBean newLinkObj) {
        return LinkOperation.saveLinkDetailsInDB(newLinkObj);
    }

    /* Method Used To Edit Student Record */
    public String editLinkRecord(int Id) {
        return LinkOperation.editLinkRecordInDB(Id);
    }

    /* Method Used To Update Student Record */
    public String updateLinkDetails(LinkBean updateLinkObj) {
        return LinkOperation.updateLinkDetailsInDB(updateLinkObj);
    }

    /* Method Used To Delete Student Record */
    public String deleteLinkRecord(int Id) {
        return LinkOperation.deleteLinkRecordInDB(Id);
    }
}
