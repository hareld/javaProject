/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessObject;

import MyPackages.Activity;
import MyPackages.Claim;
import MyPackages.Person;
import MyPackages.Policy;
import MyPackages.CustomerCrd;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class IBackend_DAO_List_implTest {
    
    CustomerCrd cstmrcrd1;
    Person person1;
    Activity policy1;
    Activity claim1;
   
    
    CustomerCrd cstmrcrd2;
    Person person2;
    Activity policy2;
        Claim claim2;
            ArrayList<String> receivedDucemnts;
    
    CustomerCrd cstmrcrd3;
    Policy policy3;
    Claim claim3;

    
    Claim claim4;
    
    Date Datechange; // for line 176
    
    public IBackend_DAO_List_implTest() throws ParseException, Exception {
            person1 = new Person("harel", Long.valueOf(300680915), Long.valueOf(523231816) , "kedumim");
            person2 = new Person("ariel", Long.valueOf(26591248) ,Long.valueOf(547822613), "hadar ganim");
          //----
            DateFormat dmyFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
            long []policyID={1};
            long []claimID={1};
            
            Date policyUpdateDate1= new Date();
            policyUpdateDate1=dmyFormat.parse("23/04/2014 23:00:00");
            
            Datechange=policyUpdateDate1; // for line 176
            
            Date policyOpenDate1= new Date();
            policyOpenDate1=dmyFormat.parse("22/04/2014 22:00:00 ");
            
            ArrayList<String> moreDetailsPolicy1 = new ArrayList<String>();
            moreDetailsPolicy1.add("super policy");
            
            policy1= new Policy(policyID,Policy.PlicyType.CompulsoryInsurance, Policy.InsrncCmpny.Ayalon, /*policy1_UpdatDate*/ 120 , "seffi rolnik", policyOpenDate1, moreDetailsPolicy1);
          //-------------------
            
            Date cliamEventDate1=new Date();
            cliamEventDate1=dmyFormat.parse("15/02/1987 15:30:00");
            
            ArrayList<String> receivedDocuments = new ArrayList<String>();
            receivedDocuments.add("IDPhoto");
            receivedDocuments.add("ConsentForm");
                    
            Date claimOpenDate1= new Date();
            
            ArrayList<String> moreDetailsClaim1 = new ArrayList<String>();
            moreDetailsClaim1.add("Favorite client");
            
            claim1= new Claim(claimID,Claim.ClaimStat.Treatment, Claim.EvntType.Health , cliamEventDate1 , "jerusalem", receivedDocuments ,"Israel Israely" ,claimOpenDate1, moreDetailsClaim1);
            //----------------  
            
            ArrayList<Activity> activity1= new ArrayList<Activity>();
            activity1.add(policy1);
            activity1.add(claim1);
            
            //---------------- 
            cstmrcrd1 = new CustomerCrd(person1,activity1);
            
            //---------------- 
            //---------------- 
            
            claim4=new Claim((Claim)claim1);
            claim4.setEventPlace("kfar saba");
            claim4.setInsuranceClaimStatus(Claim.ClaimStat.Confirmed);
            
            ArrayList<Activity>  activity2= new ArrayList<Activity>();
            activity2.add(claim4);
            activity2.add(claim1);
            cstmrcrd3=new CustomerCrd(person2,activity2);
            
            //-----------
            //-----------
            IBackend_DAO_List_impl sngltn = null;
            sngltn=Singelton.getMySingelton();
            sngltn.AddNewCustomerCrd(cstmrcrd1);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

        /**
     * Test of GetAllOpenClaims method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOpenClaims() throws Exception {
 //       System.out.println("GetAllOpenClaims");
        //Claim.ClaimStat et = Claim.ClaimStat.Treatment;
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();

        ArrayList<Claim> expResult = new ArrayList<Claim>();
        expResult.add((Claim) claim1);
        
        ArrayList<Claim> result = sngltn.GetAllOpenClaims();
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Claim c1t=expResult.get(index);
            Claim c2t=result.get(index);
            if(!(c1t.valueEquals(c2t)))
            {
                check=false;
                break;
            }
        }
         assertTrue(check);
    }
    
    /**
     * Test of AddNewCustomerCrd method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewCustomerCrd() throws Exception {
    //    System.out.println("AddNewCustomerCrd");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.AddNewCustomerCrd(cstmrcrd1);
        assertTrue("", sngltn.GetAllCustemers().contains(cstmrcrd1));
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of DeleteCustomerCrd method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteCustomerCrd() throws Exception {
    //    System.out.println("DeleteCustomerCrd");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.DeleteCustomerCrd(cstmrcrd1);
        assertFalse("", sngltn.GetAllCustemers().contains(cstmrcrd1));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of UpdateCustomerCrd method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateCustomerCrd() throws Exception { //*************************
    //    System.out.println("UpdateCustomerCrd");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        cstmrcrd2=new CustomerCrd(cstmrcrd1);
        cstmrcrd2.setPer(person2);
        assertFalse(cstmrcrd2.valueEquals(cstmrcrd1));
    }

    /**
     * Test of AddNewPolicy method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewPolicy() throws Exception { 
  //    System.out.println("AddNewPolicy");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        //sngltn.AddNewCustomerCrd(cstmrcrd1);
        assertTrue("",sngltn.AddNewPolicy((Policy) policy2, person1) );
    }

      

    /**
     * Test of DeletePolicy method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletePolicy() throws Exception {
     //   System.out.println("DeletePolicy");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.DeletePolicy((Policy)policy1 , person1);
         assertFalse("", sngltn.GetAllPolicies().contains(policy1));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of UpdatePolicy method, of class IBackend_DAO_List_impl.
     */
    @Test
    public void testUpdatePolicy() throws Exception{ //**************************************
      //  System.out.println("UpdatePolicy");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        policy2=new Policy((Policy)policy1);
        policy2.setOpeningDate(Datechange);
        sngltn.UpdatePolicy((Policy)policy1 , person1);
        assertNotSame((Policy)policy1, (Policy)policy2);
       
    }

    /**
     * Test of AddNewClaim method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewClaim() throws Exception {
  //      System.out.println("AddNewClaim");   
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.AddNewClaim((Claim)claim1 , person1);
        assertTrue("", sngltn.GetAllClaims().contains((Claim)claim1));
    }
        

    /**
     * Test of DeleteClaim method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteClaim() throws Exception {
   //     System.out.println("DeleteClaim");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.DeleteClaim((Claim)claim1 , person1);
        assertFalse("", sngltn.GetAllClaims().contains(claim1));
    }

    /**
     * Test of UpdateClaim method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateClaim() throws Exception { //****************************************
     //   System.out.println("UpdateClaim");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        receivedDucemnts = new ArrayList<String>();
        receivedDucemnts.add("MedicalReview");
        claim2=new Claim((Claim)claim1);
        claim2.setDocumentsReceived(receivedDucemnts);
        sngltn.UpdateClaim(claim2, person1);
        assertNotSame(claim1, claim2);
    }

    /**
     * Test of GetMyEventClaims method, of class IBackend_DAO_List_impl.
     */
    @Test
    public void testGetMyEventClaims() throws Exception {
  //    System.out.println("GetMyEventClaims");
        Claim.EvntType eventType = Claim.EvntType.Vehicle;
        
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        
        claim3=new Claim((Claim)claim1);
        ArrayList<Claim> expResult = new ArrayList<Claim>();
        expResult.add(claim3);
        ArrayList<Claim> result = sngltn.GetMyEventClaims(eventType, person1);
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Claim c1t=expResult.get(index);
            Claim c2t=result.get(index);
            /*System.out.println("*************");
            System.out.println(c1t);
            System.out.println("~~~~~~~~~~");
            System.out.println(c2t);
            System.out.println("*************");*/
            assertTrue(c1t.valueEquals(c2t));
        }
    }

    /**
     * Test of GetMyStatusClaims method, of class IBackend_DAO_List_impl.
     */
 @Test
    public void testGetMyStatusClaims() throws Exception{
   //     System.out.println("GetMyStatusClaims");
        Claim.ClaimStat claimStat = Claim.ClaimStat.Treatment;
        
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        
        claim3=new Claim((Claim)claim1);
        ArrayList<Claim> expResult = new ArrayList<Claim>();
        expResult.add(claim3);
        ArrayList<Claim> result = sngltn.GetMyStatusClaims(claimStat, person1);
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Claim c1t=expResult.get(index);
            Claim c2t=result.get(index);
            if(!(c1t.valueEquals(c2t)))
            {
                check=false;
                break;
            }
                assertTrue("",check==true);
        }
    }

    /**
     * Test of GetMyTypePolicies method, of class IBackend_DAO_List_impl.
     */
    @Test
    public void testGetMyTypePolicies() throws Exception {
        Policy.PlicyType pt = Policy.PlicyType.CompulsoryInsurance;
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        policy3=new Policy((Policy)policy1);
        ArrayList<Policy> expResult = new ArrayList<Policy>();
        expResult.add(policy3);
        ArrayList<Policy> result = sngltn.GetMyTypePolicies(pt, person1);
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Policy p1t=expResult.get(index);
            Policy p2t=result.get(index);
            assertTrue(p1t.valueEquals(p2t));
        }
        
       
     }


    /**
     * Test of getCstmrCrdByPerId method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testgetCstmrCrdByPerId() throws Exception {
       // System.out.println("getCstmrCrdByPerId");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        sngltn.AddNewCustomerCrd(cstmrcrd1);
        
        CustomerCrd expResult = cstmrcrd1;
        CustomerCrd result = sngltn.getCstmrCrdByPerId(cstmrcrd1.getPer().getPerId());
        
        /*System.out.println("=========");
        System.out.println(result.toString());
        System.out.println("=========");
        System.out.println("++++++++++");
        System.out.println(expResult.toString());
        System.out.println("++++++++++");*/
        assertTrue(expResult.valueEquals(result));
    }

    /**
     * Test of GetAllCustemers method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllCustemers() throws Exception {
        System.out.println("GetAllCustemers");
        IBackend_DAO_List_impl instance = new IBackend_DAO_List_impl();
        ArrayList<CustomerCrd> expResult= new ArrayList<CustomerCrd> () ;
        expResult.add(cstmrcrd1);
         
        ArrayList<CustomerCrd> result = instance.GetAllCustemers();
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            CustomerCrd c1t=expResult.get(index);
            CustomerCrd c2t=result.get(index);
            if(!(c1t.valueEquals(c2t)))
            {
                check=false;
                break;
            }
        }
         assertTrue("",check);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllPolicies method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllPolicies() throws Exception {
       // System.out.println("GetAllPolicies");
        IBackend_DAO_List_impl instance = new IBackend_DAO_List_impl();
        
        ArrayList<Policy> expResult = new ArrayList<Policy>();
        expResult.add((Policy) policy1);
        
        ArrayList<Policy> result = instance.GetAllPolicies();
        
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Policy p1t=expResult.get(index);
            Policy p2t=result.get(index);
            if(!(p1t.valueEquals(p2t)))
            {
                check=false;
                break;
            }
        }
         assertTrue(check);
    }

    /**
     * Test of GetAllClaims method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllClaims() throws Exception {
        //System.out.println("GetAllClaims");
        IBackend_DAO_List_impl sngltn = null;
        sngltn=Singelton.getMySingelton();
        ArrayList<Claim> expResult = new ArrayList<>();
        
        expResult.add((Claim) claim1);
        
        ArrayList<Claim> result = sngltn.GetAllClaims();
        boolean check= true;
        if(result.size()!=expResult.size())
            check=false;
        else
            for(int index=0;index<result.size() || index<expResult.size();index++)
            {
                Claim c1t=expResult.get(index);
                Claim c2t=result.get(index);
                if(!(c1t.valueEquals(c2t)))
                {
                    check=false;
                    break;
                }
            }
         assertTrue(check);
    }

    /**
     * Test of GetPerPolicies method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPerPolicies() throws Exception {
        IBackend_DAO_List_impl instance = new IBackend_DAO_List_impl();
        
        ArrayList<Policy> expResult = new ArrayList<Policy>();
        expResult.add((Policy) policy1);
        
        ArrayList<Policy> result = instance.GetPerPolicies(person1);
        
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Policy p1t=expResult.get(index);
            Policy p2t=result.get(index);
            if(!(p1t.valueEquals(p2t)))
            {
                check=false;
                break;
            }
        }
         assertTrue("",check);
    }

    /**
     * Test of GetPerClaims method, of class IBackend_DAO_List_impl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPerClaims() throws Exception {
        IBackend_DAO_List_impl instance = new IBackend_DAO_List_impl();
        
        ArrayList<Claim> expResult = new ArrayList<Claim>();
        expResult.add((Claim) claim1);
        
        ArrayList<Claim> result = instance.GetPerClaims(person1);
        
        boolean check= true;
        for(int index=0;index<result.size() && index<expResult.size();index++)
        {
            Claim c1t=expResult.get(index);
            Claim c2t=result.get(index);
            if(!(c1t.valueEquals(c2t)))
            {
                check=false;
                break;
            }
        }
         assertTrue("",check);
    }
}