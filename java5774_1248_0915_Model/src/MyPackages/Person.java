/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackages;

/**
 *
 * @author dell
 */
public class Person {
    
private String PerName;
private long PerId;
private long PerPhon;
private String PerAddress;

    public Person() {
    }

    public Person(String PerName, long PerId, long PerPhon, String PerAddress) {
        this.PerName = PerName;
        this.PerId = PerId;
        this.PerPhon = PerPhon;
        this.PerAddress = PerAddress;
    }

    /**
     * @return the PerName
     */
    public String getPerName() {
        return PerName;
    }

    /**
     * @return the PerId
     */
    public long getPerId() {
        return PerId;
    }

    /**
     * @return the PerPhon
     */
    public long getPerPhon() {
        return PerPhon;
    }

    /**
     * @return the PerAddress
     */
    public String getPerAddress() {
        return PerAddress;
    }

    /**
     * @param PerName the PerName to set
     */
    public void setPerName(String PerName) {
        this.PerName = PerName;
    }

    /**
     * @param PerId the PerId to set
     */
    public void setPerId(long PerId) {
        this.PerId = PerId;
    }

    /**
     * @param PerPhon the PerPhon to set
     */
    public void setPerPhon(long PerPhon) {
        this.PerPhon = PerPhon;
    }

    /**
     * @param PerAddress the PerAddress to set
     */
    public void setPerAddress(String PerAddress) {
        this.PerAddress = PerAddress;
    }
    
    @Override //??????????????????????????????????????????????? 
    public String toString() { 
        return (PerName+"\n"+PerId+"\n"+PerPhon+"\n"+PerAddress); 
    } 

    public boolean valueEquals(Person per) {
    return (this.PerName == null ? per.getPerName() == null : this.PerName.equals(per.getPerName())) && (this.PerId == per.getPerId()) && (this.PerPhon == per.getPerPhon()) && (this.PerAddress == null ? per.getPerAddress() == null : this.PerAddress.equals(per.getPerAddress()));
    }
    

}
