/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackages;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author dell
 */
public abstract class Activity {
  
    private String RepresentativeName;
    private Date OpeningDate;
    private ArrayList<String> MoreDetails;

    public abstract long GiveMeActivityID(long []id); //dagan
    public Activity() {
    }

    public Activity(String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {
        this.RepresentativeName = RepresentativeName;
        this.OpeningDate = OpeningDate;
        this.MoreDetails = MoreDetails;
    }
    
    
    /**
     * @return the RepresentativeName
     */
    public String getRepresentativeName() {
        return RepresentativeName;
    }

    /**
     * @return the OpeningDate
     */
    public Date getOpeningDate() {
        return OpeningDate;
    }

    /**
     * @return the MoreDetails
     */
    public ArrayList<String> getMoreDetails() {
        return MoreDetails;
    }

    /**
     * @param RepresentativeName the RepresentativeName to set
     */
    public void setRepresentativeName(String RepresentativeName) {
        this.RepresentativeName = RepresentativeName;
    }

    /**
     * @param OpeningDate the OpeningDate to set
     */
    public void setOpeningDate(Date OpeningDate) {
        this.OpeningDate = OpeningDate;
    }

    /**
     * @param MoreDetails the MoreDetails to set
     */
    public void setMoreDetails(ArrayList<String> MoreDetails) {
        this.MoreDetails = MoreDetails;
    }
    
    @Override //??????????????????????????????????????????????? 
    public String toString() { 
        String str=new String();
        for(String s : MoreDetails)
        {
            str+=s;
        }
        return (RepresentativeName + "\n" +OpeningDate + "\n" + str) ;
    }
}
