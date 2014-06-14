/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Packages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author dell
 */
// annotation - CustomerCrd table
@Entity(name = "CustomerCrd_Table")

// class of the customer card
public class CustomerCrd implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @OneToOne
    private Person person;
    
    @OneToMany
    private List<Activity> activities;

    // default Ctor
    public CustomerCrd() {
    }

    // Ctor
    public CustomerCrd(Person person, List<Activity> activities) {
        this.id=person.getId();
        this.activities = new ArrayList<Activity>();
        this.person = person;
        this.activities = activities;
    }
    
    // get customer id
    public Long getId() {
        return id;
    }

    // set customer id
    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof CustomerCrd)) {
            return false;
        }
        CustomerCrd other = (CustomerCrd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moshe.CustomerCrd[ id=" + id + " ]";
    }

    /**
     * @return the person
     */
    // get the person data (object)
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    // get the person data (object)
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the activities
     */
    // get the list of the activities
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    // set the list of the activities
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }   
}