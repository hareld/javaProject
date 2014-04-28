/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPackages;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Policy extends Activity {
    
    /**
     */
   
    public enum PlicyType {CompulsoryInsurance , ThirdParty , Comprehensive ,

                            PersonalAccident , InsuranceExecutives , WorkAccidents , 

                            LifeInsurance , HealthInsurance
                           }; 
    
    public enum InsrncCmpny {Migdal , Shomera , Feinx ,

                             Ayalon , Tzion , Harel , Achara};                        
    
    
    private PlicyType PolicyType;    

    private InsrncCmpny InsuranceCompany;

    //private Date PolicyRenovationDate;  dagan
            
    private float PolicyRate;
    
    private long PolicyId; //dagan

    public Policy() {
    }
    
                    //dagan                                                                 //dagan
    public Policy(long [] PlicyId,PlicyType PolicyType, InsrncCmpny InsuranceCompany,/* Date PolicyRenovationDate,*/ float PolicyRate, String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {
        super(RepresentativeName, OpeningDate, MoreDetails);
        
        this.PolicyId = GiveMeActivityID(PlicyId); //dagan
        this.PolicyType = PolicyType;
        this.InsuranceCompany = InsuranceCompany;
        /*this.PolicyRenovationDate = PolicyRenovationDate;*/ //dagan
        this.PolicyRate = PolicyRate;
    }
        public Policy(Policy p) {
        super(p.getRepresentativeName(),p.getOpeningDate(),p.getMoreDetails());
        this.PolicyId = p.getPolicyId(); //dagan
        this.PolicyType =p.getPolicyType();
        this.InsuranceCompany = p.getInsuranceCompany();
        /*this.PolicyRenovationDate = p.getPolicyRenovationDate();*/ //dagan
        this.PolicyRate = p.getPolicyRate();
    }
    /**
     * @return the PolicyType
     */
    public PlicyType getPolicyType() {
        return PolicyType;
    }

    /**
     * @return the InsuranceCompany
     */
    public InsrncCmpny getInsuranceCompany() {
        return InsuranceCompany;
    }

    
    /**
     * @return the PolicyRenovationDate
     */
 /*   public Date getPolicyRenovationDate() { //dagan
        return PolicyRenovationDate;
    }
*/
    /**
     * @return the PolicyRate
     */
    public float getPolicyRate() {
        return PolicyRate;
    }
    
     public long getPolicyId() { // dagan
        return PolicyId;
    }

    /**
     * @param PolicyType the PolicyType to set
     */
    public void setPolicyType(PlicyType PolicyType) {
        this.PolicyType = PolicyType;
    }

    /**
     * @param InsuranceCompany the InsuranceCompany to set
     */
    public void setInsuranceCompany(InsrncCmpny InsuranceCompany) {
        this.InsuranceCompany = InsuranceCompany;
    }

    /**
     * @param PolicyRenovationDate the PolicyRenovationDate to set
     */
    /*public void setPolicyRenovationDate(Date PolicyRenovationDate) { //dagan
        this.PolicyRenovationDate = PolicyRenovationDate;
    }*/

    /**
     * @param PolicyRate the PolicyRate to set
     */
    public void setPolicyRate(float PolicyRate) {
        this.PolicyRate = PolicyRate;
    }
    
   @Override //dagan
    public long GiveMeActivityID(long []id) {
        long Plcy_ID= id[0]++;
        return Plcy_ID;
    }
    

    @Override
    public String toString(){
        
        return(super.toString()+"\n"+PolicyType+"\n"+InsuranceCompany+"\n"+/*PolicyRenovationDate+*/"\n"+PolicyRate); //dagan
    }
    
    public boolean valueEquals(Policy my_pl) {
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Policy:");
        if (getRepresentativeName().equals(my_pl.getRepresentativeName())==false)
        {
         System.out.println("   RepresentativeName: False"+"\n"+ "       this.RepresentativeName:"+"\n+               " + getRepresentativeName() + "     my_pl.RepresentativeName:"+"\n+               " + my_pl.getRepresentativeName());
        }
        
        if (getOpeningDate().toString().equals(my_pl.getOpeningDate().toString())==false)
        {
         System.out.println("   OpeningDate(): False"+"\n"+ "       this.OpeningDate():"+"\n+               " + getOpeningDate().toString() + "     my_pl.OpeningDate():"+"\n+               " + my_pl.getOpeningDate().toString());
        }
        
        if (getMoreDetails().equals(my_pl.getMoreDetails())==false)
        {
         System.out.println("   MoreDetails(): False"+"\n"+ "       this.MoreDetails():"+"\n+               " + getMoreDetails() + "     my_pl.MoreDetails():"+"\n+               " + my_pl.getMoreDetails());
        }
         
        if (getInsuranceCompany().toString().equals(my_pl.getInsuranceCompany().toString())==false)
        {
         System.out.println("   InsuranceCompany(): False"+"\n"+ "       this.InsuranceCompany():"+"\n+               " + getInsuranceCompany().toString() + "     my_pl.InsuranceCompany():"+"\n+               " + my_pl.getInsuranceCompany().toString());
        }
        
         if (getPolicyType().toString().equals(my_pl.getPolicyType().toString())==false)
        {
         System.out.println("   PolicyType(): False"+"\n"+ "       this.PolicyType():"+"\n+               " + getPolicyType().toString() + "     my_pl.PolicyType():"+"\n+               " + my_pl.getPolicyType().toString());
        }
         
      /*  if (getPolicyRenovationDate().toString().equals(my_pl.getPolicyRenovationDate().toString())==false)
        {
         System.out.println("   PolicyRenovationDate(): False"+"\n"+ "       this.PolicyRenovationDate():"+"\n+               " + getPolicyRenovationDate().toString() + "     my_pl.PolicyRenovationDate():"+"\n+               " + my_pl.getPolicyRenovationDate().toString());
        }  
      */   
        if (getPolicyRate()!=(my_pl.getPolicyRate()))
        {
         System.out.println("   PolicyRate(): False"+"\n"+ "       this.PolicyRate():"+"\n+               " + getPolicyRate() + "     my_pl.PolicyRate():"+"\n+               " + my_pl.getPolicyRate());
        }
        /*
        System.out.println("    RepresentativeName: "+getRepresentativeName().equals(my_pl.getRepresentativeName())+"\n");
        System.out.println("    OpeningDate: "+getOpeningDate().toString().equals(my_pl.getOpeningDate().toString())+"\n");
        System.out.println("    MoreDetails: "+(this.getMoreDetails().equals(my_pl.getMoreDetails()))+"\n");
        System.out.println("    InsuranceCompany: "+(this.InsuranceCompany.toString().equals(my_pl.getInsuranceCompany().toString()))+"\n");
        System.out.println("    PolicyType: "+(this.PolicyType.toString().equals(my_pl.getPolicyType().toString()))+"\n");
     //   System.out.println("    PolicyRenovationDate: "+(this.PolicyRenovationDate.toString().equals(my_pl.getPolicyRenovationDate().toString()))+"\n"); //dagan
        System.out.println("    PolicyRate: "+(this.PolicyRate==(my_pl.getPolicyRate()))+"\n");
        System.out.println("~~~~~~~~~~~~~");
        */
      return  (this.getRepresentativeName().equals(my_pl.getRepresentativeName()))&&
              (this.getOpeningDate().toString().equals(my_pl.getOpeningDate().toString()))&&
              (this.getMoreDetails().equals(my_pl.getMoreDetails()))&&
              (this.PolicyType.toString().equals(my_pl.getPolicyType().toString()))&&
              (this.InsuranceCompany.toString().equals(my_pl.getInsuranceCompany().toString()))&&
            //  (this.PolicyRenovationDate.toString().equals(my_pl.getPolicyRenovationDate().toString()))&& //dagan
              (this.PolicyRate == my_pl.getPolicyRate()); 
    }
}

