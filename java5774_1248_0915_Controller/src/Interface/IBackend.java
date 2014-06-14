/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;
import java.util.ArrayList;
import Packages.Activity;
import Packages.Claim;
import Packages.Claim.ClaimStat;
import Packages.Claim.EvntType;
import Packages.CustomerCrd;
import Packages.Person;
import Packages.Policy;
import Packages.Policy.PlicyType;


/**
 * @author dell
 */

// interface
public interface IBackend {

    Long AddNewPolicy(Policy po,Person per) throws Exception;
    Long AddNewClaim(Claim cl,Person per) throws Exception;

    boolean AddNewCustomerCrd(CustomerCrd c) throws Exception;
    boolean DeletePolicy(Policy po,Person per) throws Exception;
    boolean DeleteClaim(Claim cl,Person per) throws Exception;
    
    void DeleteCustomerCrd(CustomerCrd c) throws Exception;
    void UpdatePerson(Person per) throws Exception;
    void UpdateActivity(Activity activity) throws Exception;
    void UpdateCustomerCrd(CustomerCrd c) throws Exception;
    void UpdatePolicy(Policy po,Person per) throws Exception;
    void UpdateClaim(Claim cl,Person per) throws Exception;
    
    ArrayList<Claim> GetAllOpenClaims() throws Exception;
    ArrayList<CustomerCrd> GetAllCustemers() throws Exception;
    ArrayList<Policy> GetAllPolicies() throws Exception;
    ArrayList<Policy> GetPerPolicies(Person per) throws Exception;
    ArrayList<Claim> GetAllClaims() throws Exception;
    ArrayList<Claim> GetPerClaims(Person per) throws Exception;
    ArrayList<Claim> GetMyEventClaims(EvntType et,Person per) throws Exception;
    ArrayList<Claim> GetMyStatusClaims(ClaimStat cs,Person per) throws Exception;
    ArrayList<Policy> GetMyTypePolicies(PlicyType cs,Person per) throws Exception;
    
    CustomerCrd GetMyPersonCstmrCrd(long perId) throws Exception;
    Policy GetPolicyById(long polcyId) throws Exception;
    Claim GetClaimById(long claimId) throws Exception;
}