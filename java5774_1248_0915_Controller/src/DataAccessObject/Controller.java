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
import Interface.IBackend;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author dell
 */
// the controller from the MVC - impe implement the interface
public class Controller implements IBackend {

    private final long[] nextID = {1};
    
    // create the manager of entities
    public EntityManagerFactory emf = null;
    
    // manage the entities
    public EntityManager em = null;
    
    // persistence the entities
    private final String PERSISTENCE_UNIT_NAME = "java5773_1248_0915_modelDBPU";

    // default Ctor
    public Controller() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    // add a new customer card
    @Override
    public boolean AddNewCustomerCrd(CustomerCrd c) {
        try {
            em.getTransaction().begin();
            em.persist(c.getPerson());
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.clear();
            return false;
        }
    }

    // get new activity id
    public long[] getActivityId() {
        return nextID;
    }

    // add a new claim for customer
    @Override
    public Long AddNewClaim(Claim Claim, Person person) {
        CustomerCrd cu;
        if ((cu = em.find(CustomerCrd.class, person.getId())) != null) {
            try {
                cu.getActivities().add(Claim);
                em.getTransaction().begin();
                em.persist(Claim);
                Claim c=em.merge(Claim);
                em.getTransaction().commit();
                return c.getId();

            } catch (Exception e) {
                System.out.println("err in someFunction" + e.getMessage());
                em.clear();
            }
        } else {
            AddNewCustomerCrd(cu);
            AddNewClaim(Claim, person);
        }
        return null;
    }

    // get policity activity by id
    @Override
    public Policy GetPolicyById(long polcyId) throws Exception {
        return em.find(Policy.class, polcyId);
    }

    // get claim activity by id
    @Override
    public Claim GetClaimById(long claimId) throws Exception {
        return em.find(Claim.class, claimId);
    }

    // add a new policy
    @Override
    public Long AddNewPolicy(Policy policy, Person person) throws Exception {
        try {
            CustomerCrd cu;
            if ((cu = em.find(CustomerCrd.class, person.getId())) != null) {
                try {
                    cu.getActivities().add(policy);
                    em.getTransaction().begin();
                    em.persist(policy);
                    Policy p=em.merge(policy);
                    em.getTransaction().commit();
                    return p.getId();

                } catch (Exception e) {
                    System.out.println("err in someFunction" + e.getMessage());
                    em.clear();
                }
            } else {
                AddNewCustomerCrd(cu);
                AddNewPolicy(policy, person);
            }

        } catch (Exception e) {
            em.clear();
        }
        return null;
    }

    // delete a customer card (activities, customer card, person) 
    @Override
    public void DeleteCustomerCrd(CustomerCrd cstmrCrd) throws Exception {
        try {
            Person person = cstmrCrd.getPerson();

            for (int i = 0; i < cstmrCrd.getActivities().size(); i++) {
                if (cstmrCrd.getActivities().get(i) instanceof Policy) {
                    Policy policy = (Policy) cstmrCrd.getActivities().get(i);
                    DeletePolicy(policy, person);
                    i--;
                } else if (cstmrCrd.getActivities().get(i) instanceof Claim) {
                    Claim claim = (Claim) cstmrCrd.getActivities().get(i);
                    DeleteClaim(claim, person);
                    i--;
                }
            }

            Person p = em.find(Person.class, person.getId());
            CustomerCrd c = em.find(CustomerCrd.class, person.getId());
            em.getTransaction().begin();
            em.remove(c);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // delete a policy (more details, policy, activity)
    @Override
    public boolean DeletePolicy(Policy po, Person per) throws Exception {
        try {
            CustomerCrd c = em.find(CustomerCrd.class, per.getId());

            // delete MoreDetails
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Activity> criteriaQuery = criteriaBuilder.createQuery(Activity.class);
            criteriaQuery.from(Activity.class);
            Query query = em.createQuery(criteriaQuery);
            List<Activity> AllActivityList = query.getResultList();
            
            for (Activity act : AllActivityList) {
                if (act.getId() == po.getId()) {
                    List<String> listStirng = act.getMoreDetailsValues();
                    listStirng.clear();
                    em.getTransaction().begin();
                    for (String str : listStirng) {
                        em.merge(str);
                    }
                    em.getTransaction().commit();
                } else {

                }
            }

            // delete Policy
            em.getTransaction().begin();
            c.getActivities().remove(po);
            em.getTransaction().commit();

            Policy plcy = em.find(Policy.class, po.getId());
            em.remove(plcy);

            // delete po.getId() data from "Activity_Table"
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Activity_Table WHERE ID = po.getId() ");
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // delete a claim (more details, received documents list,  required documents list, claim, activity)
    @Override
    public boolean DeleteClaim(Claim cl, Person per) throws Exception {
        try {
            CustomerCrd c = em.find(CustomerCrd.class, per.getId());

            // delete MoreDetails
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Activity> criteriaQuery1 = criteriaBuilder.createQuery(Activity.class);
            criteriaQuery1.from(Activity.class);
            Query query = em.createQuery(criteriaQuery1);
            List<Activity> AllActivityList = query.getResultList();
            
            for (Activity act : AllActivityList) {
                if (act.getId() == cl.getId()) {
                    List<String> listStirng = act.getMoreDetailsValues();
                    listStirng.clear();
                    em.getTransaction().begin();
                    for (String str : listStirng) {
                        em.merge(str);
                    }
                    em.getTransaction().commit();
                } else {
                }
            }

            // delete DocumentsReceived
            for (Activity act : AllActivityList) {
                if (act instanceof Claim && act.getId() == cl.getId()) {
                    Claim claim = (Claim) act;
                    List<String> listStirng = claim.getDocumentsReceivedValues();
                    listStirng.clear();
                    em.getTransaction().begin();
                    for (String str : listStirng) {
                        em.merge(str);
                    }
                    em.getTransaction().commit();
                } else {
                }
            }

            // delete DocumentsRequired
            for (Activity act : AllActivityList) {
                if (act instanceof Claim && act.getId() == cl.getId()) {
                    Claim claim = (Claim) act;
                    List<Claim.Documents> listEnumDocuments = claim.getDocumentsRequiredValues();
                    listEnumDocuments.clear();
                    em.getTransaction().begin();
                    for (Claim.Documents ducom : listEnumDocuments) {
                        em.merge(ducom);
                    }
                    em.getTransaction().commit();

                } else {
                }
            }

            // delete Claim 
            em.getTransaction().begin();
            c.getActivities().remove(cl);
            em.getTransaction().commit();

            Claim claim = em.find(Claim.class, cl.getId());
            em.remove(claim);

            // delete cl.getId() data from "Activity_Table"
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Activity_Table WHERE ID = cl.getId() ");
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // update a person
    @Override
    public void UpdatePerson(Person per) throws Exception {
        try {
            Person person = em.find(Person.class, per.getId());
            em.getTransaction().begin();
            person.setNamePerson(per.getNamePerson());
            person.setAddressPerson(per.getAddressPerson());
            person.setPhonePerson(per.getPhonePerson());
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    // update an activity
    @Override
    public void UpdateActivity(Activity activity) throws Exception {
        if (activity instanceof Policy) {
            Policy plcy = (Policy) activity;
            UpdatePolicy(plcy, null);

        } else if (activity instanceof Claim) {
            Claim claim = (Claim) activity;
            UpdateClaim(claim, null);
        }

    }

    // update a customer card
    @Override
    public void UpdateCustomerCrd(CustomerCrd c) throws Exception {
        List<Policy> AllPolicies = em.createQuery("from Policy_Table").getResultList();
        List<Claim> AllClaims = em.createQuery("from Claim_Table").getResultList();

        CustomerCrd cus = em.find(CustomerCrd.class, c.getId());
        Person person = em.find(Person.class, c.getId());
        if (cus != null) //update person
        {
            UpdatePerson(person);
        }

        for (Activity act : c.getActivities()) //update or add activity
        {
            if (act instanceof Policy) //Policy
            {
                Policy pl = (Policy) act;
                if (AllPolicies.contains(pl)) //alreadt exsit (just update)
                {
                    UpdateActivity(act);
                } else //should add 
                {
                    AddNewPolicy(pl, person);
                }
            } else if (act instanceof Claim) //Claim
            {
                Claim cl = (Claim) act;
                if (AllClaims.contains(cl)) //alreadt exsit (just update)
                {
                    UpdateActivity(act);
                } else //should add 
                {
                    AddNewClaim(cl, person);
                }
            }

            // remove of policies
            if (AllPolicies.size() > 0) {
                for (Policy plcy : AllPolicies) {
                    if (!(c.getActivities().contains(plcy))) {
                        DeletePolicy(plcy, person);
                    } else {
                    }
                }
            }
            
            // remove of claims
            if (AllClaims.size() > 0) {
                for (Claim clim : AllClaims) {
                    if (!(c.getActivities().contains(clim))) {
                        DeleteClaim(clim, person);
                    } else {
                    }
                }
            }
        }
    }

    // update a policy
    @Override
    public void UpdatePolicy(Policy policy, Person per) throws Exception {
        try {
            Policy p = em.find(Policy.class, policy.getId());
            em.getTransaction().begin();
            p.setRepresentativeName(policy.getRepresentativeName());
            p.setMoreDetails(policy.getMoreDetailsValues());
            p.setInsuranceCompany(policy.getInsuranceCompany());
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // update a claim
    @Override
    public void UpdateClaim(Claim claim, Person per) throws Exception {
        try {
            Claim c = em.find(Claim.class, claim.getId());

            //All EnumList as List<>
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Claim> criteriaQuery = criteriaBuilder.createQuery(Claim.class);
            criteriaQuery.from(Claim.class);
            Query query = em.createQuery(criteriaQuery);
            List<Claim> AllClaimList = query.getResultList();

            //get claim.DocumentsRequired as List<>
            List<Claim.Documents> DocumentsRequiredList = null;
            for (Claim cl : AllClaimList) {
                if (cl.getId() == claim.getId()) {
                    DocumentsRequiredList = cl.getDocumentsRequiredValues();
                } else {
                }
            }

            em.getTransaction().begin();
            c.setDocumentsReceived(claim.getDocumentsReceivedValues());
            c.setEventTime(claim.getEventTime()); 
            c.setEventPlace(claim.getEventPlace());
            c.setInsuranceClaimStatus(claim.getInsuranceClaimStatus());
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // get all the open claims in the system
    @Override
    public ArrayList<Claim> GetAllOpenClaims() throws Exception {
        List<Claim> claim_list = em.createQuery("from Claim_Table").getResultList();
        ArrayList<Claim> claim_open = new ArrayList<Claim>();
        for (Claim cl : claim_list) {
            if (cl.getInsuranceClaimStatus() == Claim.ClaimStat.Treatment || cl.getInsuranceClaimStatus() == Claim.ClaimStat.SeeInMoreDetails) {
                claim_open.add(cl);
            }
        }
        return claim_open;
    }

    // get all the customers in the system
    @Override
    public ArrayList<CustomerCrd> GetAllCustemers() throws Exception {
        List<CustomerCrd> customerCrd_list = em.createQuery("from CustomerCrd_Table").getResultList();
        ArrayList<CustomerCrd> cstmrCrds = new ArrayList<CustomerCrd>();
        for (CustomerCrd cstmrCrd : customerCrd_list) {
            cstmrCrds.add(cstmrCrd);
        }
        return cstmrCrds;
    }

    // get the all policies in the system
    @Override
    public ArrayList<Policy> GetAllPolicies() throws Exception {
        List<Policy> Policies_list = em.createQuery("from Policy_Table").getResultList();
        ArrayList<Policy> Policies = new ArrayList<Policy>();
        for (Policy p : Policies_list) {
            Policies.add(p);
        }
        return Policies;
    }

    // get all policies for a person
    @Override
    public ArrayList<Policy> GetPerPolicies(Person per) throws Exception {
        ArrayList<Policy> Policies = new ArrayList<Policy>();
        CustomerCrd cstmrCrd = em.find(CustomerCrd.class, per.getId());
        for (Activity act : cstmrCrd.getActivities()) {
            if (act instanceof Policy) {
                Policies.add((Policy) act);
            }
        }
        return Policies;
    }

    // get all the claims in the system
    @Override
    public ArrayList<Claim> GetAllClaims() throws Exception {
        List<Claim> claim_list = em.createQuery("from Claim_Table").getResultList();
        ArrayList<Claim> claims = new ArrayList<Claim>();
        for (Claim c : claim_list) {
            claims.add(c);
        }
        return claims;
    }

    // get all claims for person
    @Override
    public ArrayList<Claim> GetPerClaims(Person per) throws Exception {
        ArrayList<Claim> claim_list = new ArrayList<Claim>();
        CustomerCrd cstmrCrd = em.find(CustomerCrd.class, per.getId());
        for (Activity act : cstmrCrd.getActivities()) {
            if (act instanceof Claim) {
                claim_list.add((Claim) act);
            }
        }
        return claim_list;
    }

    // get claims of person that match to specific event
    @Override
    public ArrayList<Claim> GetMyEventClaims(Claim.EvntType et, Person per) throws Exception {
        ArrayList<Claim> claim_list = new ArrayList<Claim>();
        CustomerCrd cstmrCrd = em.find(CustomerCrd.class, per.getId());
        for (Activity act : cstmrCrd.getActivities()) {
            if (act instanceof Claim) {
                Claim cl = (Claim) act;
                if (cl.getEventType() == et) {
                    claim_list.add((Claim) act);
                } else {
                }
            }
        }
        return claim_list;
    }

    // get claims of person that match to specific status
    @Override
    public ArrayList<Claim> GetMyStatusClaims(Claim.ClaimStat cs, Person per) throws Exception {
        ArrayList<Claim> claim_list = new ArrayList<Claim>();
        CustomerCrd cstmrCrd = em.find(CustomerCrd.class, per.getId());
        for (Activity act : cstmrCrd.getActivities()) {
            if (act instanceof Claim) {
                Claim cl = (Claim) act;
                if (cl.getInsuranceClaimStatus() == cs) {
                    claim_list.add((Claim) act);
                } else {
                }
            }
        }
        return claim_list;
    }

    // get policies of person that match to specific type
    @Override
    public ArrayList<Policy> GetMyTypePolicies(Policy.PlicyType cs, Person per) throws Exception {
        ArrayList<Policy> policy_list = new ArrayList<Policy>();
        CustomerCrd cstmrCrd = em.find(CustomerCrd.class, per.getId());
        for (Activity act : cstmrCrd.getActivities()) {
            if (act instanceof Policy) {
                Policy pl = (Policy) act;
                if (pl.getPolicyType() == cs) {
                    policy_list.add((Policy) act);
                } else {
                }
            }
        }
        return policy_list;
    }

    // get customer card by person id
    @Override
    public CustomerCrd GetMyPersonCstmrCrd(long perId) throws Exception {
        return em.find(CustomerCrd.class, perId);
    }   
}