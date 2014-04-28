/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import MyPackages.Claim;
import MyPackages.Person;
import MyPackages.Claim.ClaimStat;
import MyPackages.Claim.EvntType;
import MyPackages.Policy;
import MyPackages.Policy.PlicyType;
import MyPackages.CustomerCrd;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public interface IBackend {

    boolean AddNewCustomerCrd(CustomerCrd c) throws Exception; //dagan
    boolean AddNewPolicy(Policy po,Person per) throws Exception; //dagan

    
    /**
     *
     * @param cl
     * @param per
     * @throws Exception
     */
    void AddNewClaim(Claim cl,Person per) throws Exception;
    void DeleteCustomerCrd(CustomerCrd c) throws Exception;
    boolean DeletePolicy(Policy po,Person per) throws Exception;
    boolean DeleteClaim(Claim cl,Person per) throws Exception;
    void UpdateCustomerCrd(CustomerCrd c) throws Exception;
    void UpdatePolicy(Policy po,Person per) throws Exception;
    void UpdateClaim(Claim cl,Person per) throws Exception;
    ArrayList<Claim> GetAllOpenClaims() throws Exception;
    ArrayList<CustomerCrd> GetAllCustemers() throws Exception;
    ArrayList<Policy> GetAllPolicies() throws Exception;
    ArrayList<Policy> GetPerPolicies(Person per) throws Exception;
    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<Claim> GetAllClaims() throws Exception;
    ArrayList<Claim> GetPerClaims(Person per) throws Exception;
    ArrayList<Claim> GetMyEventClaims(EvntType et,Person per) throws Exception;
    ArrayList<Claim> GetMyStatusClaims(ClaimStat cs,Person per) throws Exception;
    ArrayList<Policy> GetMyTypePolicies(PlicyType cs,Person per) throws Exception;
    
    CustomerCrd GetMyPersonCstmrCrd(long perId) throws Exception; //dagan
    Policy GetPolicyById(long polcyId) throws Exception; //dagan
    Claim GetClaimById(long claimId) throws Exception; //dagan
}
