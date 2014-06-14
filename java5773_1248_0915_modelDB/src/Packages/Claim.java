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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;

/**
 * @author dell
 */
// annotation - Claim table
@Entity(name = "Claim_Table")

// claim class - implementation of activity abstract class
public class Claim extends Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum EvntType  {Vehicle , Work , Personally, Health};  
    
    public enum ClaimStat {Treatment ,Confirmed , Deferred , SeeInMoreDetails};
    
    public enum Documents {IDPhoto ,DriverLicense , VehicleLicense , 
                           ReferenceAppraisers , ConsentForm , GeneralReference ,
                           MedicalReview , ReferenceFromEmployer
                          };
    
    // annotation - enum format match to DB
    @Enumerated(EnumType.STRING)
    private ClaimStat InsuranceClaimStatus;
    
    // annotation - enum format match to DB
    @Enumerated(EnumType.STRING)
    private EvntType EventType;
    
    // annotation - date format match to DB
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date EventTime;

    private String EventPlace;
    
    // annotations - list of enum format match to DB
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "DocumentsRequired_Table")
     private List<Documents> DocumentsRequired;
    
    // annotation - list format match to DB
    @ElementCollection
    @CollectionTable(name = "DocumentsReceived_Table")
    private List<String> DocumentsReceived;

    // default Ctor
    public Claim() {
    }
    
    // Ctor
    public Claim(ClaimStat InsuranceClaimStatus, EvntType EventType, Date EventTime, String EventPlace, ArrayList<String> DocumentsReceived, String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {   
        super(RepresentativeName, OpeningDate, MoreDetails);
        this.InsuranceClaimStatus = InsuranceClaimStatus;
        this.EventType = EventType;
        this.EventTime = EventTime;
        this.EventPlace = EventPlace;
        this.DocumentsRequired = SetReqDucmntsListByEvent(EventType);
        this.DocumentsReceived = DocumentsReceived;
    }

    // copy Ctor
    public Claim(Claim c){
        super(c.getRepresentativeName(), c.getOpeningDate(), c.getMoreDetails());
        
        ArrayList<String> doc_rec=new ArrayList<String>();
        for (String item: c.getDocumentsReceived())
            doc_rec.add(item.toString());
        
        ArrayList<Documents> doc_req=new ArrayList<Documents>();
        for (Documents item: c.getDocumentsRequired())
            doc_req.add(item);
                    
        this.InsuranceClaimStatus =c.getInsuranceClaimStatus();
        this.EventType = c.getEventType();
        this.EventTime = c.getEventTime();
        this.EventPlace = c.getEventPlace();
        this.DocumentsRequired = doc_req;
        this.DocumentsReceived = doc_rec;
    }

    // get claim id
    public Long getId() {
        return super.getId();
    }
    
    // set claim id
    public void setId(Long id) {
        super.setId(id);
    }

    /**
     * @return the InsuranceClaimStatus
     */
    // get the status of the insurance claim
    public ClaimStat getInsuranceClaimStatus() {
        return InsuranceClaimStatus;
    }

    /**
     * @param InsuranceClaimStatus the InsuranceClaimStatus to set
     */
    // get the status of the insurance claim
    public void setInsuranceClaimStatus(ClaimStat InsuranceClaimStatus) {
        this.InsuranceClaimStatus = InsuranceClaimStatus;
    }

    /**
     * @return the EventType
     */
    // get the event type
    public EvntType getEventType() {
        return EventType;
    }

    /**
     * @param EventType the EventType to set
     */
    // set the event type
    public void setEventType(EvntType EventType) {
        this.EventType = EventType;
    }

    /**
     * @return the EventTime
     */
    // get the event type
    public Date getEventTime() {
        return EventTime;
    }

    /**
     * @param EventTime the EventTime to set
     */
    // set the event type
    public void setEventTime(Date EventTime) {
        this.EventTime = EventTime;
    }

    /**
     * @return the EventPlace
     */
    // get the event place
    public String getEventPlace() {
        return EventPlace;
    }

    /**
     * @param EventPlace the EventPlace to set
     */
    // set the event place
    public void setEventPlace(String EventPlace) {
        this.EventPlace = EventPlace;
    }

    /**
     * @param DocumentsRequired the DocumentsRequired to set
     */
    // set the list of required documents
    public void setDocumentsRequired(ArrayList<Documents> DocumentsRequired) {
        this.setDocumentsRequired(DocumentsRequired);
    }

     /**
     * @return the DocumentsRequired
     */
    // get the list of required documents
    public ArrayList<Documents> getDocumentsRequired() {
        return (ArrayList<Documents>)DocumentsRequired;
    }
    
    // converting ArrayList to List
    public List<Documents> getDocumentsRequiredValues() {
        return DocumentsRequired;
    }

    /**
     * @param DocumentsRequired the DocumentsRequired to set
     */
    // set the list of required documents
    public void setDocumentsRequired(List<Documents> DocumentsRequired) {
        this.DocumentsRequired = DocumentsRequired;
    }

    /**
     * @return the DocumentsReceived
     */
    // get the array list of received documents
    public ArrayList<String> getDocumentsReceived() {
        return (ArrayList<String>)DocumentsReceived;
    }
    
    /**
     * @param DocumentsReceived the DocumentsReceived to set
     */
    // get the array list of received documents
    public void setDocumentsReceived(ArrayList<String> DocumentsReceived) {
        this.DocumentsReceived=DocumentsReceived;
    }
    
    // set the list of received documents
    public List<String> getDocumentsReceivedValues() {
        return DocumentsReceived;
    }

    /**
     * @param DocumentsReceived the DocumentsReceived to set
     */
    // set the list of received documents
    public void setDocumentsReceived(List<String> DocumentsReceived) {
        this.DocumentsReceived = DocumentsReceived;
    }
    
    // converting ArrayList to List
    public List<String> getMoreDetailsValues() {
        return super.getMoreDetailsValues();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) object;
        return (getId() != null || other.getId() == null) && (this.getId() == null || this.getId().equals(other.getId()));
    }

    @Override
    public String toString() {
        return "moshe.Claim[ id=" + getId() + " ]";
    }
    
    // return fake activity id (only for new claim before the save)
    public long GiveMeActivityID(long []id) {
        long next_ID = id[0]++;
        return next_ID;
    }
    
    // returnn list of required documents according the choosen events
    protected ArrayList<Documents> SetReqDucmntsListByEvent(EvntType myevent) //dagan
    {
        ArrayList<Documents> arr=new ArrayList<Documents>();
        if (myevent.equals(EvntType.Vehicle))
        {
            arr.add(Documents.IDPhoto);
            arr.add(Documents.VehicleLicense);
            arr.add(Documents.DriverLicense);
            arr.add(Documents.ReferenceAppraisers);
            arr.add(Documents.MedicalReview);
        }
        else if (myevent.equals(EvntType.Health))
        {
            arr.add(Documents.IDPhoto);
            arr.add(Documents.ConsentForm);
            arr.add(Documents.MedicalReview);
        }
        else if (myevent.equals(EvntType.Personally))
        {
            arr.add(Documents.IDPhoto);
            arr.add(Documents.ConsentForm);
            arr.add(Documents.MedicalReview);
            arr.add(Documents.GeneralReference);
        }
        else if (myevent.equals(EvntType.Work))
        {
            arr.add(Documents.IDPhoto);
            arr.add(Documents.ConsentForm);
            arr.add(Documents.MedicalReview);
            arr.add(Documents.GeneralReference);
            arr.add(Documents.ReferenceFromEmployer);
        }
        return arr;
    }
}