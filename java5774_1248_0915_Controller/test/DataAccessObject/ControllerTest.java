/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Person;
import Packages.Policy;
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
public class ControllerTest {

    public ControllerTest() {
    }

    private static Controller sngltn = null;

    static {
        try {
            sngltn = Singelton.getMySingelton();
        } catch (Exception ex) {

        }
    }
    Person person = new Person("israel israeli", 123456789, 050111111, "tel-aviv");
    ArrayList<Activity> perActivities = new ArrayList<Activity>();
    CustomerCrd CstmrCrd = new CustomerCrd(person, perActivities);

    Date date1 = new Date();
    ArrayList<String> Mylist1 = new ArrayList<String>();
    Policy policy = new Policy(Policy.PlicyType.ThirdParty, Policy.InsrncCmpny.Migdal, (float) 100.0, "myRepresentative", date1, Mylist1 /*more detail*/);

    Date date2 = new Date();
    ArrayList<String> Mylist2 = new ArrayList<String>();
    ArrayList<String> Mylist3 = new ArrayList<String>();
    Claim claim = new Claim(Claim.ClaimStat.Treatment, Claim.EvntType.Personally, date1 /*EventTime*/, "hotel", Mylist3 /*recived documents*/, "myRepresentative", date2 /*OpeningDate*/, Mylist3 /*more detail*/);

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
     * Test of getActivityId method, of class Controller.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        sngltn.getActivityId()[0] = 1;
        long[] result = sngltn.getActivityId();
        assertTrue(result[0] == 1);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPolicyById method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPolicyById() throws Exception {
        System.out.println("GetPolicyById");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }
        if (policy.getId() == null) {
            sngltn.AddNewPolicy(policy, person);
        }
        Long id = policy.getId();
        Policy result = sngltn.GetPolicyById(id);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertEquals(policy, result);
    }

    /**
     * Test of method of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetClaimById() throws Exception {
        System.out.println("GetClaimById");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }
        if (claim.getId() == null) {
            sngltn.AddNewClaim(claim, person);
        }
        Long id = claim.getId();
        Claim result = sngltn.GetClaimById(id);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertEquals(claim, result);
    }

    /**
     * Test of AddNewCustomerCrd method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewCustomerCrd() throws Exception {
        System.out.println("AddNewCustomerCrd");
        if (sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.DeleteCustomerCrd(CstmrCrd);
        }
        boolean stat = sngltn.AddNewCustomerCrd(CstmrCrd);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of AddNewPolicy method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewPolicy() throws Exception {
        System.out.println("AddNewPolicy");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (policy.getId() != null) {
            sngltn.DeletePolicy(policy, person);
        }
        Long result = sngltn.AddNewPolicy(policy, person);
        boolean stat = (sngltn.GetPolicyById(result)!= null);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of AddNewClaim method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewClaim() throws Exception {
        System.out.println("AddNewClaim");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        Long result = sngltn.AddNewClaim(claim, person);
        boolean stat2 = (sngltn.GetClaimById(result) != null);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of DeleteCustomerCrd method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteCustomerCrd() throws Exception {
        System.out.println("DeleteCustomerCrd");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        sngltn.DeleteCustomerCrd(CstmrCrd);
        boolean stat = !(sngltn.GetAllCustemers().contains(CstmrCrd));
        assertTrue(stat);
    }

    /**
     * Test of DeletePolicy method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletePolicy() throws Exception {
        System.out.println("DeletePolicy");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }
        if (policy.getId() == null) {
            sngltn.AddNewPolicy(policy, person);
        }

        boolean stat = sngltn.DeletePolicy(policy, person);

        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of DeleteClaim method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteClaim() throws Exception {
        System.out.println("DeleteClaim");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }
        if (claim.getId() == null) {
            sngltn.AddNewClaim(claim, person);
        }

        boolean stat = sngltn.DeleteClaim(claim, person);

        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of UpdatePerson method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdatePerson() throws Exception {
        System.out.println("UpdatePerson");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        Person updatePerson = person;
        updatePerson.setNamePerson("Bob");
        sngltn.UpdatePerson(updatePerson);

        boolean stat = "Bob".equals(sngltn.GetMyPersonCstmrCrd(CstmrCrd.getId()).getPerson().getNamePerson());
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of UpdateActivity method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateActivity() throws Exception {
        System.out.println("UpdateActivity");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, CstmrCrd.getPerson());
        }
        sngltn.AddNewClaim(claim, person);
        Claim updateClaim = claim;
        updateClaim.setEventPlace("street");
        sngltn.UpdateActivity(updateClaim);
        boolean stat = "street".equals(sngltn.GetClaimById(claim.getId()).getEventPlace());
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of UpdateCustomerCrd method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateCustomerCrd() throws Exception {
        System.out.println("UpdateCustomerCrd");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        CustomerCrd updateCstmrCrd = CstmrCrd;
        updateCstmrCrd.getPerson().setNamePerson("Bob");
        sngltn.UpdateCustomerCrd(updateCstmrCrd);

        boolean stat = "Bob".equals(sngltn.GetMyPersonCstmrCrd(CstmrCrd.getId()).getPerson().getNamePerson());
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of UpdatePolicy method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdatePolicy() throws Exception {
        System.out.println("UpdatePolicy");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (policy.getId() != null) {
            sngltn.DeleteClaim(claim, CstmrCrd.getPerson());
        }
        sngltn.AddNewPolicy(policy, person);
        Policy updatePolicy = policy;
        updatePolicy.setRepresentativeName("Bob");
        sngltn.UpdatePolicy(policy, person);
        boolean stat = "Bob".equals(sngltn.GetPolicyById(policy.getId()).getRepresentativeName());
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of UpdateClaim method, of class Controller.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateClaim() throws Exception {
        System.out.println("UpdateClaim");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, CstmrCrd.getPerson());
        }
        sngltn.AddNewClaim(claim, person);
        Claim updateClaim = claim;
        updateClaim.setEventPlace("street");
        sngltn.UpdateClaim(updateClaim, person);
        boolean stat = "street".equals(sngltn.GetClaimById(claim.getId()).getEventPlace());
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of GetAllOpenClaims method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOpenClaims() throws Exception {
        System.out.println("GetAllOpenClaims");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        sngltn.AddNewClaim(claim, person);
        boolean stat = (sngltn.GetAllOpenClaims().contains(claim));
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of GetAllCustemers method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllCustemers() throws Exception {
        System.out.println("GetAllCustemers");
        if (sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.DeleteCustomerCrd(CstmrCrd);
        }
        boolean stat = sngltn.AddNewCustomerCrd(CstmrCrd);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of GetAllPolicies method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllPolicies() throws Exception {
        System.out.println("GetAllPolicies");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (policy.getId() != null) {
            sngltn.DeletePolicy(policy, person);
        }
        Long result = sngltn.AddNewPolicy(policy, person);
        boolean stat = sngltn.GetPolicyById(result) != null;
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of GetPerPolicies method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPerPolicies() throws Exception {
        System.out.println("GetPerPolicies");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (policy.getId() != null) {
            sngltn.DeletePolicy(policy, person);
        }
        Long result = sngltn.AddNewPolicy(policy, person);
        boolean stat = sngltn.GetPerPolicies(CstmrCrd.getPerson()).contains(policy);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

    /**
     * Test of GetAllClaims method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllClaims() throws Exception {
        System.out.println("GetAllClaims");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        Long result = sngltn.AddNewClaim(claim, person);
        boolean stat2 = (sngltn.GetClaimById(result) != null);
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of GetPerClaims method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPerClaims() throws Exception {
        System.out.println("GetPerClaims");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        Long result = sngltn.AddNewClaim(claim, person);
        boolean stat2 = (sngltn.GetPerClaims(CstmrCrd.getPerson()).contains(claim));
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of GetMyEventClaims method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMyEventClaims() throws Exception {
        System.out.println("GetMyEventClaims");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        Long result = sngltn.AddNewClaim(claim, person);
        boolean stat2 = (sngltn.GetMyEventClaims(claim.getEventType(), person).contains(claim));
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of GetMyStatusClaims method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMyStatusClaims() throws Exception {
        System.out.println("GetMyStatusClaims");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (claim.getId() != null) {
            sngltn.DeleteClaim(claim, person);
        }
        Long result = sngltn.AddNewClaim(claim, person);
        boolean stat2 = (sngltn.GetMyStatusClaims(claim.getInsuranceClaimStatus(), person).contains(claim));
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of GetMyTypePolicies method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMyTypePolicies() throws Exception {
        System.out.println("GetMyTypePolicies");
        if (!sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.AddNewCustomerCrd(CstmrCrd);
        }

        if (policy.getId() != null) {
            sngltn.DeletePolicy(policy, person);
        }
        Long result = sngltn.AddNewPolicy(policy, person);
        boolean stat2 = (sngltn.GetMyTypePolicies(policy.getPolicyType(), person).contains(policy));
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat2);
    }

    /**
     * Test of GetMyPersonCstmrCrd method, of class Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMyPersonCstmrCrd() throws Exception {
        System.out.println("GetMyPersonCstmrCrd");
        if (sngltn.GetAllCustemers().contains(CstmrCrd)) {
            sngltn.DeleteCustomerCrd(CstmrCrd);
        }
        sngltn.AddNewCustomerCrd(CstmrCrd);
        boolean stat = sngltn.GetMyPersonCstmrCrd(CstmrCrd.getId()).getPerson()==person;
        sngltn.DeleteCustomerCrd(CstmrCrd);
        assertTrue(stat);
    }

}
