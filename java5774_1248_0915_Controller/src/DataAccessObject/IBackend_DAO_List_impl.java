/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessObject;

import MyPackages.Activity;
import java.util.ArrayList;
import MyPackages.Person;
import MyPackages.Claim;
import MyPackages.Claim.ClaimStat;
import static MyPackages.Claim.ClaimStat.Treatment;
import MyPackages.Claim.EvntType;
import MyPackages.Policy;
import MyPackages.Policy.PlicyType;
import Interface.IBackend;
import MyPackages.CustomerCrd;
//
/**
 *
 * @author dell
 */
public class IBackend_DAO_List_impl implements IBackend{
    private long []PolicyID={1}; //dagan
    private long []ClaimID={1}; //dagan
    
    private ArrayList<CustomerCrd> CustomerCrds;
    //*************************************************************************
    public IBackend_DAO_List_impl(){
        CustomerCrds = new ArrayList<CustomerCrd>();
    }
    
    /**
     *
     * @param cu
     * @return 
     */
    @Override //dagan
    public boolean AddNewCustomerCrd(CustomerCrd cu){ 
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(cu.getPer().getPerId())) == null)
        {
           CustomerCrds.add(cu);
           return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param c
     */
    @Override
    public void DeleteCustomerCrd(CustomerCrd c){
        
        for(CustomerCrd cu : CustomerCrds)
        {
            if(cu.getPer().getPerId() == c.getPer().getPerId())//dagan
            {
                CustomerCrds.remove(cu);
                break;
            }
        }
    }

    /**
     *
     * @param c
     */
    @Override
    public void UpdateCustomerCrd(CustomerCrd c){
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(c.getPer().getPerId())) != null)//dagan
        {
            for(CustomerCrd cu : CustomerCrds)
            {
                if(cus.getPer().getPerId() == cu.getPer().getPerId())
                {
                    cus.setPer(c.getPer());
                    cus.setPerActivities(c.getPerActivities());
                }
            }
        }
        else
        {}//  System.out.println("Not getCstmrCrdByPerId this customer\n");
    }
    
    /**
     *
     * @param po
     * @param per
     * @return 
     */
    @Override //dagan
    public boolean AddNewPolicy(Policy po,Person per)
    { 
        CustomerCrd cu;       
        if((cu=getCstmrCrdByPerId(per.getPerId())) != null)
        {
           cu.getPerActivities().add(po);
           return true;
        }
        else
        {
            AddNewCustomerCrd(cu);
            AddNewPolicy(po,per);
            return true;
        }
        
    }

    /**
     *
     * @param po
     * @param per
     */
    @Override
    public boolean DeletePolicy(Policy po, Person per){
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(per.getPerId())) != null)
        {
           for(Activity act : cus.getPerActivities())
           {
              if(act instanceof Policy)//dagan
              {  
                Policy policy=(Policy)act; //dagan
                if(po.getPolicyId() == policy.getPolicyId()) //dagan
                {
                    cus.getPerActivities().remove(po);
                    return true;
                }
              }
           }
           
        }
        else
        {return false;} // System.out.println("Not getCstmrCrdByPerId this customer\n");
        return false;
    }

    /**
     *
     * @param po
     * @param per
     */
    @Override // dagan (i changed this function)
    public void UpdatePolicy(Policy po, Person per){
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(per.getPerId())) != null)
        {
           for(Activity act : cus.getPerActivities())
           {
               if(act instanceof Policy) //dagan
               {
                   Policy pol=(Policy)act; 
                   if (pol.getPolicyId()==po.getPolicyId()) //dagan
                   { //dagan
                        pol.setInsuranceCompany(po.getInsuranceCompany());
                        pol.setMoreDetails(po.getMoreDetails());
                      //  pol.setOpeningDate(po.getOpeningDate()); //dagan
                     //   pol.setPolicyRenovationDate(po.getPolicyRenovationDate()); dagan
                      //  pol.setPolicyType(po.getPolicyType()); //dagan
                        pol.setRepresentativeName(po.getRepresentativeName());
                   } //dagan
               }
           }
        }
    }

    /**
     *
     * @param cl
     * @param per
     */
    @Override
    public void AddNewClaim(Claim cl,Person per){ 
        
        CustomerCrd cu;
        if((cu=getCstmrCrdByPerId(per.getPerId())) != null)
        {
           cu.getPerActivities().add(cl);
        }
        else
        {
            AddNewCustomerCrd(cu);
            AddNewClaim(cl,per);
        }
    }

    /**
     *
     * @param cl
     * @param per
     */
    @Override
    public boolean DeleteClaim(Claim cl, Person per){
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(per.getPerId())) != null)
        {
           for(Activity act : cus.getPerActivities())
           {
              if(act instanceof Claim)//dagan
              { 
                Claim claim=(Claim)act; //dagan
                if(cl.getClaimId() == claim.getClaimId()) //dagan
                {
                    cus.getPerActivities().remove(cl);
                    return true;
                }
              }
           }
        }
        else
        {return false;}// System.out.println("Not getCstmrCrdByPerId this customer\n"); 
        return false;
    }

    /**
     *
     * @param cl
     * @param per
     */
    @Override
    public void UpdateClaim(Claim cl, Person per){
        
        CustomerCrd cus;
        if((cus=getCstmrCrdByPerId(per.getPerId())) != null)
        {
            for(Activity act : cus.getPerActivities())
           {
               if (act instanceof Claim){ //dagan
                                            Claim claim=(Claim)act;
                                            if(cl.getClaimId() == claim.getClaimId())
                                            {
                                                Claim cla=(Claim)act;
                                                cla.setDocumentsReceived(cl.getDocumentsReceived());
                                                cla.setDocumentsRequired(cl.getDocumentsRequired());
                                                cla.setEventTime(cl.getEventTime());//dagan
                                                cla.setEventPlace(cl.getEventPlace());
                                                cla.setEventType(cl.getEventType());
                                                cla.setInsuranceClaimStatus(cl.getInsuranceClaimStatus());
                                            }
                                        }
           }
        }
    }
    
    /**
     *
     * @param et
     * @param per
     * @return
     */
    @Override
    public ArrayList<Claim> GetMyEventClaims(EvntType et,Person per){
      
        CustomerCrd cu;
        ArrayList<Claim> arr=new ArrayList<Claim>();
        if((cu=getCstmrCrdByPerId(per.getPerId())) != null)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Claim)
                {
                    Claim cl=(Claim)act;
                    
                    if(cl.getEventType() == et)
                    {
                        arr.add(cl);                        
                    }
                    
                }
            }

            return arr;
        }
        else
        {
         //   System.out.println("Not getCstmrCrdByPerId claim with status" + et.toString() + "\n");
            return null;
        }
    }
     
    /**
     *
     * @param cs
     * @param per
     * @return
     */
    @Override
    public ArrayList<Claim> GetMyStatusClaims(ClaimStat cs,Person per){
      
        CustomerCrd cu;
        ArrayList<Claim> arr=new ArrayList<Claim>();
        if((cu=getCstmrCrdByPerId(per.getPerId())) != null)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Claim)
                {
                    Claim cl=(Claim)act;
                    if(cl.getInsuranceClaimStatus() == cs)
                        arr.add(cl);
                }
            }
            return arr;
        }
        else
        {
            System.out.println("Not exist claim with status" + cs.toString() + "\n");
            return null;
        }
    }
    
    /**
     *
     * @param cs
     * @param per
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Policy> GetMyTypePolicies(PlicyType cs,Person per) throws Exception {
        
        CustomerCrd cu;
        ArrayList<Policy> arr=new ArrayList<Policy>();
        if((cu=getCstmrCrdByPerId(per.getPerId())) != null)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Policy)
                {
                    Policy po=(Policy)act;
                    if(po.getPolicyType() == cs)
                        arr.add(po);
                }
            }
            return arr;
        }
        else
        {
           // System.out.println("Not getCstmrCrdByPerId policy with type " + cs.toString() + "\n");
            return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Claim> GetAllOpenClaims(){
        
        ArrayList<Claim> arr = new ArrayList<Claim>();
        for(CustomerCrd cu : CustomerCrds)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Claim)
                {
                    Claim cl=(Claim)act;
                    if(cl.getInsuranceClaimStatus() == ClaimStat.Treatment || cl.getInsuranceClaimStatus() == ClaimStat.SeeInMoreDetails)
                        arr.add(cl);
                }
            }
        }
        return arr;
    }

    public CustomerCrd getCstmrCrdByPerId(long id) {
        
        for(CustomerCrd cus : CustomerCrds)
        {
            if(id == cus.getPer().getPerId())
                return cus;
        }
        return null;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<CustomerCrd> GetAllCustemers() throws Exception {
    return CustomerCrds;      
    }

    @Override
    public ArrayList<Policy> GetAllPolicies() throws Exception {
        ArrayList<Policy> arr = new ArrayList<Policy>();
        for(CustomerCrd cu : CustomerCrds)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Policy)
                {
                    Policy pl=(Policy)act;
                        arr.add(pl);
                }
            }
        }
        return arr;
    }

    @Override
    public ArrayList<Claim> GetAllClaims() throws Exception {
        ArrayList<Claim> arr = new ArrayList<Claim>();
        for(CustomerCrd cu : CustomerCrds)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Claim)
                {
                    Claim cl=(Claim)act;
                        arr.add(cl);
                }
            }
        }
        return arr;
    }

    @Override
    public ArrayList<Policy> GetPerPolicies(Person per) throws Exception {
        ArrayList<Policy> arr = new ArrayList<Policy>();
        for(CustomerCrd cu : CustomerCrds)
        {
            if(cu.getPer().getPerId()==per.getPerId())
            {
                for(Activity act : cu.getPerActivities())
                {
                    if(act instanceof Policy)
                    {
                        Policy pl=(Policy)act;
                            arr.add(pl);
                    }
                }
            }
        }
        return arr;
    }

    @Override
    public ArrayList<Claim> GetPerClaims(Person per) throws Exception {
        ArrayList<Claim> arr = new ArrayList<Claim>();
        for(CustomerCrd cu : CustomerCrds)
        {
            if(cu.getPer().getPerId()==per.getPerId())
            {
                for(Activity act : cu.getPerActivities())
                {
                    if(act instanceof Claim)
                    {
                        Claim cl=(Claim)act;
                            arr.add(cl);
                    }
                }
            }
        }
        return arr;
    }

    /**
     *
     * @param perId
     * @return
     * @throws Exception
     */
    @Override //dagan
    public CustomerCrd GetMyPersonCstmrCrd(long perId) throws Exception {
        return (getCstmrCrdByPerId(perId));
    }

    /**
     * @return the PolicyID
     */
    public long[] getPolicyID() { //dagan
        return PolicyID;
    }

    /**
     * @return the ClaimID
     */
    public long[] getClaimID() { //dagan
        return ClaimID;
    }

    @Override //dagan
    public Policy GetPolicyById(long polcyId) throws Exception {
        Policy policy = null;
        for(CustomerCrd cu : CustomerCrds)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Policy )
                {
                    Policy pl=(Policy)act;
                    if(pl.getPolicyId()==polcyId) return pl;
                }
            }
        }
        return null;
    }

    @Override //dagan
    public Claim GetClaimById(long claimId) throws Exception {
        Claim Claim = null;
        for(CustomerCrd cu : CustomerCrds)
        {
            for(Activity act : cu.getPerActivities())
            {
                if(act instanceof Claim )
                {
                    Claim cl=(Claim)act;
                    if(cl.getClaimId()==claimId) return cl;
                }
            }
        }
        return null;
    }

    


}
    