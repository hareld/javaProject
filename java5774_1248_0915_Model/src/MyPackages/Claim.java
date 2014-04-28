/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackages;

import java.lang.ref.Reference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.DocumentEvent.EventType;

/**
 *
 * @author dell
 */
    public class Claim extends Activity{

    /**
     * @return the ClaimId
     */
 
    /**
     * @return the InsuranceClaimStatus
     */
        public enum EvntType {Vehicle , Work , Personally, Health};    
        public enum ClaimStat {Treatment ,Confirmed , Deferred , SeeInMoreDetails};
        public enum Documents {IDPhoto ,DriverLicense , VehicleLicense , 
                                ReferenceAppraisers , ConsentForm , GeneralReference ,
                                MedicalReview , ReferenceFromEmployer
                                };
        
        private long ClaimId; //dagan
        private ClaimStat InsuranceClaimStatus;     
        private EvntType EventType;
        private Date EventTime; //dagan
        /*private Date EventHour;*/ //dagan
        private String EventPlace; 
        private ArrayList<Documents> DocumentsRequired;
        private ArrayList<String> DocumentsReceived; //dagan

        public Claim() {
        }
                    //dagan                                                             //dagan           //dagan                                    //dagan                                    //dagan
    public Claim(long [] ClimyId,ClaimStat InsuranceClaimStatus, EvntType EventType, /*Date EventDate,*/ Date EventTime, String EventPlace, /*ArrayList<Documents> DocumentsRequired,*/ ArrayList<String> DocumentsReceived, String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {   
        super(RepresentativeName, OpeningDate, MoreDetails);
        this.ClaimId=GiveMeActivityID(ClimyId); //dagan
        this.InsuranceClaimStatus = InsuranceClaimStatus;
        this.EventType = EventType;
        /*this.EventHour=EventHour;*/ //dagan
        this.EventTime = EventTime; //dagan
        this.EventPlace = EventPlace;
        this.DocumentsRequired = SetReqDucmntsListByEvent(EventType); //dagan
        this.DocumentsReceived = DocumentsReceived;
    }

    public Claim(Claim c){
        super(c.getRepresentativeName(), c.getOpeningDate(), c.getMoreDetails());
        
        ArrayList<String> doc_rec=new ArrayList<String>();//dagan
        for (String item: c.getDocumentsReceived()) //dagan
            doc_rec.add(item.toString());//dagan
        
        ArrayList<Documents> doc_req=new ArrayList<Documents>();
        for (Documents item: c.getDocumentsRequired())
            doc_req.add(item);
                    
        this.InsuranceClaimStatus =c.getInsuranceClaimStatus();
        this.ClaimId=c.getClaimId(); //dagan
        this.EventType = c.getEventType();
        this.EventTime = c.getEventTime();//dagan
        //this.EventHour = c.getEventHour();//dagan
        this.EventPlace = c.getEventPlace();
        this.DocumentsRequired = doc_req;
        this.DocumentsReceived = doc_rec;
    }
        
        public ClaimStat getInsuranceClaimStatus() {
            return InsuranceClaimStatus;
        }

        public long getClaimId() { //dagan
            return ClaimId;
        }

        /**
         * @return the EventType
         */
        public EvntType getEventType() {
            return EventType;
        }

        /**
         * @return the EventDate
         */
        public Date getEventTime() { //dagan
            return EventTime;
        }

        /**
         * @return the EventHour
         */
       /* public Date getEventHour() { //dagan
            return EventHour;
        }*/

        /**
         * @return the EventPlace
         */
        public String getEventPlace() {
            return EventPlace;
        }

        /**
         * @return the DocumentsRequired
         */
        public ArrayList<Documents> getDocumentsRequired() {
            return DocumentsRequired;
        }

        /**
         * @return the DocumentsReceived
         */
        public ArrayList<String> getDocumentsReceived() { //dagan
            return DocumentsReceived;
        }

        /**
         * @param InsuranceClaimStatus the InsuranceClaimStatus to set
         */
        public void setInsuranceClaimStatus(ClaimStat InsuranceClaimStatus) {
            this.InsuranceClaimStatus = InsuranceClaimStatus;
        }

        /**
         * @param EventType the EventType to set
         */
        public void setEventType(EvntType EventType) {
            this.EventType = EventType;
        }

        /**
         * @param EventDate the EventDate to set
         */
        public void setEventTime(Date EventTime) { //dagan
            this.EventTime =EventTime;
        }

        /**
         * @param EventHour the EventHour to set //dagan
         */
        /*public void setEventHour(Date EventHour) {
            this.EventHour = EventHour;
        }*/

        /**
         * @param EventPlace the EventPlace to set
         */
        public void setEventPlace(String EventPlace) {
            this.EventPlace = EventPlace;
        }

        /**
         * @param DocumentsRequired the DocumentsRequired to set
         */
        public void setDocumentsRequired(ArrayList<Documents> DocumentsRequired) {
            this.DocumentsRequired = DocumentsRequired;
        }

        /**
         * @param DocumentsReceived the DocumentsReceived to set
         */                                        //dagan
        public void setDocumentsReceived(ArrayList<String> DocumentsReceived) {
            this.DocumentsReceived = DocumentsReceived;
        }
        
        
    @Override //dagan
    public long GiveMeActivityID(long []id) {
        long Claim_ID= id[0]++;
        return Claim_ID;
    }

    private ArrayList<Documents> SetReqDucmntsListByEvent(EvntType myevent) //dagan
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
            
     @Override //??????????????????????????????????????????????? 
    public String toString() { 
        String str1=new String();
        for(Documents doc : DocumentsRequired)
        {
            str1+=doc+"\n";
        }
        
         String str2=new String();
        for(String doc : DocumentsReceived) //dagan
        {
            str2+=doc+"\n";
        }
                                                                                            
        return (super.toString()+InsuranceClaimStatus+"\n"+EventType+"\n"+EventTime //dagan
                +"\n"+/*EventHour+*/"\n"+EventPlace+"\n"+str1+"\n"+str2); //dagan
    }
    
    
    public boolean valueEquals(Claim my_cl) {
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Claim:");
        System.out.println("    RepresentativeName: "+getRepresentativeName().equals(my_cl.getRepresentativeName())+"\n");
        System.out.println("    OpeningDate: "+getOpeningDate().toString().equals(my_cl.getOpeningDate().toString())+"\n");
        System.out.println("    MoreDetails: "+(this.getMoreDetails().equals(my_cl.getMoreDetails()))+"\n");
        System.out.println("    InsuranceClaimStatus: "+(this.InsuranceClaimStatus.toString().equals(my_cl.getInsuranceClaimStatus().toString()))+"\n");
        System.out.println("    EventType: "+(this.EventType.toString().equals(my_cl.getEventType().toString()))+"\n");
        System.out.println("    EventTime: "+(this.EventTime.toString().equals(my_cl.getEventTime().toString()))+"\n"); //dagan
        //System.out.println("    EventHour: "+(this.EventHour.toString().equals(my_cl.getEventHour().toString()))+"\n"); //dagan
        System.out.println("    EventPlace: "+(this.EventPlace.toString().equals(my_cl.getEventPlace().toString()))+"\n");
        System.out.println("    DocumentsReceived: "+(this.DocumentsReceived.equals(my_cl.getDocumentsReceived()))+"\n");
        System.out.println("    DocumentsRequired: "+(this.DocumentsRequired.equals(my_cl.getDocumentsRequired()))+"\n");
        System.out.println("~~~~~~~~~~~~~");
        return
                (this.getRepresentativeName().equals(my_cl.getRepresentativeName()))&&
              (this.getOpeningDate().toString().equals(my_cl.getOpeningDate().toString()))&&
              (this.getMoreDetails().equals(my_cl.getMoreDetails()))&&
                (this.InsuranceClaimStatus.toString().equals(my_cl.getInsuranceClaimStatus().toString())) &&
                (this.EventType.toString().equals(my_cl.getEventType().toString())) &&
                (this.EventTime.toString().equals(my_cl.getEventTime().toString()))&& //dagan
                /*(this.EventHour.toString().equals(my_cl.getEventHour().toString()))&&*/ //dagan
                (this.EventPlace.toString().equals(my_cl.getEventPlace().toString()))&&
                (this.DocumentsReceived.equals(my_cl.getDocumentsReceived()))&&
                (this.DocumentsRequired.equals(my_cl.getDocumentsRequired()));   
    }

        
}
