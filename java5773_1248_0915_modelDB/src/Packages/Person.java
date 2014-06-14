/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dell
 */
// annotation - Person table
@Entity(name = "Person_Table")

// class with all details of the person
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String NamePerson;
    private Long PhonePerson;
    private String AddressPerson;

    // default ctor
    public Person() {
    }

    // Ctor
    public Person(String PerName, long PerId, long PerPhon, String PerAddress) {
        this.NamePerson = PerName;
        this.id = PerId;
        this.PhonePerson = PerPhon;
        this.AddressPerson = PerAddress;
    }

    // get person id
    public Long getId() {
        return id;
    }

    // set person id
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moshe.Person[ id=" + id + " ]";
    }

    /**
     * @return the NamePerson
     */
    // get name of the person
    public String getNamePerson() {
        return NamePerson;
    }

    /**
     * @param NamePerson the NamePerson to set
     */
    // set name of the person
    public void setNamePerson(String NamePerson) {
        this.NamePerson = NamePerson;
    }

    /**
     * @return the PhonePerson
     */
    // get phone number of the person
    public Long getPhonePerson() {
        return PhonePerson;
    }

    /**
     * @param PhonePerson the PhonePerson to set
     */
    // set phone number of the person
    public void setPhonePerson(Long PhonePerson) {
        this.PhonePerson = PhonePerson;
    }

    /**
     * @return the AddressPerson
     */
    // get adress of the person
    public String getAddressPerson() {
        return AddressPerson;
    }

    /**
     * @param AddressPerson the AddressPerson to set
     */
    // set adress of the person
    public void setAddressPerson(String AddressPerson) {
        this.AddressPerson = AddressPerson;
    }
}