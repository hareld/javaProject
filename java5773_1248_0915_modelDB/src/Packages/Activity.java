/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/** 
 * @author dell
 */
// annotation - use for the webService entity generator
@XmlSeeAlso({
    Policy.class,
    Claim.class
})

// annotation - Activity class for the WebService
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Activity")

// annotation - Activity table
@Entity(name = "Activity_Table")
@Inheritance(strategy = InheritanceType.JOINED)

// class of the posible activity (policy or claim) - cannot be implemented
public abstract  class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    // annotation - record identifer of the activity 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String RepresentativeName;

    // annotation - date format match to DB
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date OpeningDate;

    // annotation - list format match to DB
    //@OneToMany
    @ElementCollection
    @CollectionTable(name = "MoreDetails_Table")
    private List<String> MoreDetails;

    // default Ctor
    public Activity() {
    }

    // Ctor
    public Activity(String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {
        this.RepresentativeName = RepresentativeName;
        this.OpeningDate = OpeningDate;
        this.MoreDetails = MoreDetails;
    }

    // get the activity id
    public Long getId() {
        return id;
    }

    // set the activity id
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the RepresentativeName
     */
    // get the name of representative
    public String getRepresentativeName() {
        return RepresentativeName;
    }

    /**
     * @param RepresentativeName the RepresentativeName to set
     */
    // set the name of representative
    public void setRepresentativeName(String RepresentativeName) {
        this.RepresentativeName = RepresentativeName;
    }

    /**
     * @return the OpeningDate
     */
    // get the open date
    public Date getOpeningDate() {
        return OpeningDate;
    }

    /**
     * @param OpeningDate the OpeningDate to set
     */
    // set the open date
    public void setOpeningDate(Date OpeningDate) {
        this.OpeningDate = OpeningDate;
    }

    /**
     * @param MoreDetails the MoreDetails to set
     */
    // set the list of other required details
    public void setMoreDetails(List<String> MoreDetails) {
        this.MoreDetails = MoreDetails;
    }

    /**
     * @return the MoreDetails
     */
    // get the list of other required details
    public ArrayList<String> getMoreDetails() {
        return (ArrayList<String>) MoreDetails;
    }

    // converting more details ArrayList to List
    public List<String> getMoreDetailsValues() {
        return MoreDetails;
    }

    // get the size of other required details list
    public int getMoreDetailsSize() {
        return MoreDetails.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moshe.Activity[ id=" + id + " ]";
    }
}