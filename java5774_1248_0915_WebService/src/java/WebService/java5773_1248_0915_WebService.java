/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;



import DAOAdapters.Java_5774_1248_0915_BackedDAOAdapters;
import DAOAdapters.Singelton;
import Interface.IBackend;
import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Person;
import Packages.Policy;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author dell
 */
@WebService(serviceName = "java5773_1248_0915_WebServiceAdapter")
public class java5773_1248_0915_WebService implements IBackend {

    private static Java_5774_1248_0915_BackedDAOAdapters sngltn = null;

    static {
        try {
            sngltn = Singelton.getMySingelton();
        } catch (Exception ex) {
            Logger.getLogger(java5773_1248_0915_WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static final Logger log = Logger.getLogger(java5773_1248_0915_WebService.class.getCanonicalName());

    /**
     * This is a sample web service operation //
     * @param c
     * @return 
     * @throws java.lang.Exception
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    
    // add a new customer card
    @Override
    @WebMethod
    public boolean AddNewCustomerCrd(@WebParam CustomerCrd c) throws Exception {
        try {
            sngltn.AddNewCustomerCrd(c);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in AddNewCustomerCrd", e);
            throw new Exception("Server Error");
        }
        return true;
    }

    // add a new policy
    @Override
    @WebMethod
    public Long AddNewPolicy(@WebParam Policy po,@WebParam Person per) throws Exception {
        try {
            return sngltn.AddNewPolicy(po, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in AddNewPolicy", e);
            throw new Exception("Server Error");
        }
    }

    // add a new policy
    @Override
    @WebMethod
    public Long AddNewClaim(@WebParam Claim cl,@WebParam Person per) throws Exception {
        try {
            return sngltn.AddNewClaim(cl, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in AddNewClaim", e);
            throw new Exception("Server Error");
        }
    }

    // delete a customer card
    @Override
    @WebMethod
    public void DeleteCustomerCrd(@WebParam CustomerCrd c) throws Exception {
        try {
            sngltn.DeleteCustomerCrd(c);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in DeleteCustomerCrd", e);
            throw new Exception("Server Error");
        }
    }
    
    // delete a policy
    @Override
    @WebMethod
    public boolean DeletePolicy(@WebParam Policy po,@WebParam Person per) throws Exception {
        try {
            sngltn.DeletePolicy(po, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in DeletePolicy", e);
            throw new Exception("Server Error");
        }
        return true;
    }

    // delete a claim
    @Override
    @WebMethod
    public boolean DeleteClaim(@WebParam Claim cl,@WebParam Person per) throws Exception {
        try {
            sngltn.DeleteClaim(cl, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in DeleteClaim", e);
            throw new Exception("Server Error");
        }
        return true;
    }

    // update a person
    @Override
    @WebMethod
    public void UpdatePerson(@WebParam Person per) throws Exception {
        try {
            sngltn.UpdatePerson(per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in UpdatePerson", e);
            throw new Exception("Server Error");
        }
    }
    
    // update an activity
    @Override
    @WebMethod
    public void UpdateActivity(@WebParam Activity activity) throws Exception {
        try {
            sngltn.UpdateActivity(activity);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in UpdateActivity", e);
            throw new Exception("Server Error");
        }
    }

    
    // update a customer card
    @Override
    @WebMethod
    public void UpdateCustomerCrd(@WebParam CustomerCrd c) throws Exception {
        try {
            sngltn.UpdateCustomerCrd(c);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in UpdateCustomerCrd", e);
            throw new Exception("Server Error");
        }
    }

    // update a policy
    @Override
    @WebMethod
    public void UpdatePolicy(@WebParam Policy po,@WebParam Person per) throws Exception {
        try {
            sngltn.UpdatePolicy(po, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in UpdatePolicy", e);
            throw new Exception("Server Error");
        }
    }

    // update a claim
    @Override
    @WebMethod
    public void UpdateClaim(@WebParam Claim cl,@WebParam Person per) throws Exception {
        try {
            sngltn.UpdateClaim(cl, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in UpdateClaim", e);
            throw new Exception("Server Error");
        }
    }

    // return list with all open claims in the system
    @Override
    @WebMethod
    public ArrayList<Claim> GetAllOpenClaims() throws Exception {

        ArrayList<Claim> claim_open = new ArrayList<Claim>();
        try {
            claim_open = sngltn.GetAllOpenClaims();
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetAllOpenClaims", e);
            throw new Exception("Server Error");
        }
        return claim_open;
    }

    // return list with all exist customers in the system
    @Override
    @WebMethod
    public ArrayList<CustomerCrd> GetAllCustemers() throws Exception {

        ArrayList<CustomerCrd> AllCustemersList = new ArrayList<CustomerCrd>();
        try {
            AllCustemersList = sngltn.GetAllCustemers();
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetAllCustemers", e);
            throw new Exception("Server Error");
        }
        return AllCustemersList;
    }

    // return list with policies in the system
    @Override
    @WebMethod
    public ArrayList<Policy> GetAllPolicies() throws Exception {
        ArrayList<Policy> AllPolicyList = new ArrayList<Policy>();
        try {
            AllPolicyList = sngltn.GetAllPolicies();
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetAllPolicies", e);
            throw new Exception("Server Error");
        }
        return AllPolicyList;
    }

    // return list with policies for a person
    @Override
    @WebMethod
    public ArrayList<Policy> GetPerPolicies(@WebParam Person per) throws Exception {
        ArrayList<Policy> PerPoliciesList = new ArrayList<Policy>();
        try {
            PerPoliciesList = sngltn.GetPerPolicies(per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetPerPolicies", e);
            throw new Exception("Server Error");
        }
        return PerPoliciesList;
    }

    // return a list with all claim in the system
    @Override
    @WebMethod
    public ArrayList<Claim> GetAllClaims() throws Exception {
        ArrayList<Claim> AllClaimList = new ArrayList<Claim>();
        try {
            AllClaimList = sngltn.GetAllClaims();
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetAllClaims", e);
            throw new Exception("Server Error");
        }
        return AllClaimList;
    }

    // return list with claims for a person
    @Override
    @WebMethod
    public ArrayList<Claim> GetPerClaims(@WebParam Person per) throws Exception {
        ArrayList<Claim> PerClaimsList = new ArrayList<Claim>();
        try {
            PerClaimsList = sngltn.GetPerClaims(per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetPerClaims", e);
            throw new Exception("Server Error");
        }
        return PerClaimsList;
    }

    // return list with claims of person that match to specific event
    @Override
    @WebMethod
    public ArrayList<Claim> GetMyEventClaims(@WebParam Claim.EvntType et,@WebParam Person per) throws Exception {
        ArrayList<Claim> MyEventClaimsList = new ArrayList<Claim>();
        try {
            MyEventClaimsList = sngltn.GetMyEventClaims(et, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetMyEventClaims", e);
            throw new Exception("Server Error");
        }
        return MyEventClaimsList;
    }

    // return list of claims of person that match to specific status
    @Override
    @WebMethod
    public ArrayList<Claim> GetMyStatusClaims(@WebParam Claim.ClaimStat cs,@WebParam Person per) throws Exception {
        ArrayList<Claim> MyStatusClaimsList = new ArrayList<Claim>();
        try {
            MyStatusClaimsList = sngltn.GetMyStatusClaims(cs, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetMyStatusClaims", e);
            throw new Exception("Server Error");
        }
        return MyStatusClaimsList;
    }

    // return list of policies of person that match to specific type
    @Override
    @WebMethod
    public ArrayList<Policy> GetMyTypePolicies(@WebParam Policy.PlicyType cs,@WebParam Person per) throws Exception {
        ArrayList<Policy> MyTypePoliciesList = new ArrayList<Policy>();
        try {
            MyTypePoliciesList = sngltn.GetMyTypePolicies(cs, per);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetMyTypePolicies", e);
            throw new Exception("Server Error");
        }
        return MyTypePoliciesList;
    }

    // return customer card by person id
    @Override
    @WebMethod
    public CustomerCrd GetMyPersonCstmrCrd(@WebParam long perId) throws Exception {
        CustomerCrd MyPersonCstmrCrd = new CustomerCrd();
        try {
            MyPersonCstmrCrd = sngltn.GetMyPersonCstmrCrd(perId);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetMyPersonCstmrCrd", e);
            throw new Exception("Server Error");
        }
        return MyPersonCstmrCrd;
    }

    // return policity activity by id
    @Override
    @WebMethod
    public Policy GetPolicyById(@WebParam long polcyId) throws Exception {
        Policy PolicyById = new Policy();
        try {
            PolicyById = sngltn.GetPolicyById(polcyId);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetPolicyById", e);
            throw new Exception("Server Error");
        }
        return PolicyById;
    }

    // return claim activity by id
    @Override
    @WebMethod
    public Claim GetClaimById(@WebParam long claimId) throws Exception {
        Claim ClaimById = new Claim();
        try {
            ClaimById = sngltn.GetClaimById(claimId);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An error in GetClaimById", e);
            throw new Exception("Server Error");
        }
        return ClaimById;
    }
}
