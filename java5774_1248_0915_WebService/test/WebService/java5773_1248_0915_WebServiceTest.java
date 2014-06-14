/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService;

import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Person;
import Packages.Policy;
import java.util.ArrayList;
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
public class java5773_1248_0915_WebServiceTest {
    
    public java5773_1248_0915_WebServiceTest() {
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
     * Test of AddNewCustomerCrd method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testAddNewCustomerCrd() throws Exception {
        System.out.println("AddNewCustomerCrd");
        CustomerCrd c = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        boolean expResult = false;
        boolean result = instance.AddNewCustomerCrd(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddNewPolicy method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testAddNewPolicy() throws Exception {
        System.out.println("AddNewPolicy");
        Policy po = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        boolean expResult = false;
        Long result = instance.AddNewPolicy(po, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddNewClaim method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testAddNewClaim() throws Exception {
        System.out.println("AddNewClaim");
        Claim cl = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.AddNewClaim(cl, per);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteCustomerCrd method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testDeleteCustomerCrd() throws Exception {
        System.out.println("DeleteCustomerCrd");
        CustomerCrd c = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.DeleteCustomerCrd(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeletePolicy method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testDeletePolicy() throws Exception {
        System.out.println("DeletePolicy");
        Policy po = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        boolean expResult = false;
        boolean result = instance.DeletePolicy(po, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteClaim method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testDeleteClaim() throws Exception {
        System.out.println("DeleteClaim");
        Claim cl = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        boolean expResult = false;
        boolean result = instance.DeleteClaim(cl, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdatePerson method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testUpdatePerson() throws Exception {
        System.out.println("UpdatePerson");
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.UpdatePerson(per);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateActivity method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testUpdateActivity() throws Exception {
        System.out.println("UpdateActivity");
        Activity activity = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.UpdateActivity(activity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateCustomerCrd method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testUpdateCustomerCrd() throws Exception {
        System.out.println("UpdateCustomerCrd");
        CustomerCrd c = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.UpdateCustomerCrd(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdatePolicy method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testUpdatePolicy() throws Exception {
        System.out.println("UpdatePolicy");
        Policy po = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.UpdatePolicy(po, per);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateClaim method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testUpdateClaim() throws Exception {
        System.out.println("UpdateClaim");
        Claim cl = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        instance.UpdateClaim(cl, per);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllOpenClaims method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetAllOpenClaims() throws Exception {
        System.out.println("GetAllOpenClaims");
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Claim> expResult = null;
        ArrayList<Claim> result = instance.GetAllOpenClaims();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllCustemers method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetAllCustemers() throws Exception {
        System.out.println("GetAllCustemers");
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<CustomerCrd> expResult = null;
        ArrayList<CustomerCrd> result = instance.GetAllCustemers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllPolicies method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetAllPolicies() throws Exception {
        System.out.println("GetAllPolicies");
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Policy> expResult = null;
        ArrayList<Policy> result = instance.GetAllPolicies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPerPolicies method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetPerPolicies() throws Exception {
        System.out.println("GetPerPolicies");
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Policy> expResult = null;
        ArrayList<Policy> result = instance.GetPerPolicies(per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllClaims method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetAllClaims() throws Exception {
        System.out.println("GetAllClaims");
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Claim> expResult = null;
        ArrayList<Claim> result = instance.GetAllClaims();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPerClaims method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetPerClaims() throws Exception {
        System.out.println("GetPerClaims");
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Claim> expResult = null;
        ArrayList<Claim> result = instance.GetPerClaims(per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyEventClaims method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetMyEventClaims() throws Exception {
        System.out.println("GetMyEventClaims");
        Claim.EvntType et = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Claim> expResult = null;
        ArrayList<Claim> result = instance.GetMyEventClaims(et, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyStatusClaims method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetMyStatusClaims() throws Exception {
        System.out.println("GetMyStatusClaims");
        Claim.ClaimStat cs = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Claim> expResult = null;
        ArrayList<Claim> result = instance.GetMyStatusClaims(cs, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyTypePolicies method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetMyTypePolicies() throws Exception {
        System.out.println("GetMyTypePolicies");
        Policy.PlicyType cs = null;
        Person per = null;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        ArrayList<Policy> expResult = null;
        ArrayList<Policy> result = instance.GetMyTypePolicies(cs, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyPersonCstmrCrd method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetMyPersonCstmrCrd() throws Exception {
        System.out.println("GetMyPersonCstmrCrd");
        long perId = 0L;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        CustomerCrd expResult = null;
        CustomerCrd result = instance.GetMyPersonCstmrCrd(perId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPolicyById method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetPolicyById() throws Exception {
        System.out.println("GetPolicyById");
        long polcyId = 0L;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        Policy expResult = null;
        Policy result = instance.GetPolicyById(polcyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetClaimById method, of class java5773_1248_0915_WebService.
     */
    @Test
    public void testGetClaimById() throws Exception {
        System.out.println("GetClaimById");
        long claimId = 0L;
        java5773_1248_0915_WebService instance = new java5773_1248_0915_WebService();
        Claim expResult = null;
        Claim result = instance.GetClaimById(claimId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
