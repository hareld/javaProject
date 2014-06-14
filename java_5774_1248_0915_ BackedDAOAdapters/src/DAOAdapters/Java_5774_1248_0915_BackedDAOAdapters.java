/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdapters;

import Interface.IBackend;
import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Person;
import Packages.Policy;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import webservice.Exception_Exception;

/**
 *
 * @author dell
 */
public class Java_5774_1248_0915_BackedDAOAdapters implements IBackend {

    webservice.Person ConvertPerson(Packages.Person p) {
        webservice.Person ws_person = new webservice.Person();
        ws_person.setId(p.getId());
        ws_person.setAddressPerson(p.getAddressPerson());
        ws_person.setNamePerson(p.getNamePerson());
        ws_person.setPhonePerson(p.getPhonePerson());
        return ws_person;
    }

    Packages.Person ConvertPerson(webservice.Person ws_p) {
        Packages.Person p = new Packages.Person();
        p.setId(ws_p.getId());
        p.setAddressPerson(ws_p.getAddressPerson());
        p.setNamePerson(ws_p.getNamePerson());
        p.setPhonePerson(ws_p.getPhonePerson());
        return p;
    }

    webservice.Activity ConvertActivity(Packages.Activity a) {
        if (a instanceof Packages.Policy) {
            Packages.Policy plcy = (Packages.Policy) a;
            webservice.Policy ws_p = ConvertPolicy(plcy);
        } else if (a instanceof Packages.Claim) {
            Packages.Claim clim = (Packages.Claim) a;
            webservice.Claim ws_c = ConvertClaim(clim);
            return ws_c;
        }
        return null;

    }

    Packages.Activity ConvertActivity(webservice.Activity ws_a) {
        if (ws_a instanceof webservice.Policy) {
            webservice.Policy ws_p = (webservice.Policy) ws_a;
            Packages.Policy plcy = ConvertPolicy(ws_p);
            return plcy;

        } else if (ws_a instanceof webservice.Claim) {
            webservice.Claim ws_c = (webservice.Claim) ws_a;
            Packages.Claim clim = ConvertClaim(ws_c);
        }
        return null;
    }

    webservice.Policy ConvertPolicy(Packages.Policy p) {
        Packages.Policy plcy = (Packages.Policy) p;
        webservice.Policy ws_p = new webservice.Policy();

        GregorianCalendar openDate = new GregorianCalendar();
        openDate.setTime(p.getOpeningDate());
        XMLGregorianCalendarImpl openDateImpl = new XMLGregorianCalendarImpl(openDate);

        ws_p.setRepresentativeName(plcy.getRepresentativeName());
        ws_p.setOpeningDate(openDateImpl);
        ws_p.setId(plcy.getId());
        ws_p.setInsuranceCompany(webservice.InsrncCmpny.fromValue(plcy.getInsuranceCompany().name()));
        ws_p.setPolicyRate(plcy.getPolicyRate());
        ws_p.setPolicyType(webservice.PlicyType.fromValue(plcy.getPolicyType().name()));
        for (String detail : p.getMoreDetails()) {
            ws_p.getMoreDetails().add(detail);
        }
//            ws_p.setMoreDetailsSize(plcy.getMoreDetailsSize());??
//            ws_p.setMoreDetailsValues(ewew);??
        return ws_p;
    }

    webservice.Claim ConvertClaim(Packages.Claim c) {
        Packages.Claim clim = (Packages.Claim) c;
        webservice.Claim ws_c = new webservice.Claim();

        GregorianCalendar openDate = new GregorianCalendar();
        openDate.setTime(c.getOpeningDate());
        XMLGregorianCalendarImpl openDateImpl = new XMLGregorianCalendarImpl(openDate);

        GregorianCalendar eventTime = new GregorianCalendar();
        eventTime.setTime(c.getOpeningDate());
        XMLGregorianCalendarImpl eventTimeImpl = new XMLGregorianCalendarImpl(eventTime);

        ws_c.setId(clim.getId());
        ws_c.setInsuranceClaimStatus(webservice.ClaimStat.fromValue(clim.getInsuranceClaimStatus().name()));
        ws_c.setOpeningDate(openDateImpl);
        ws_c.setRepresentativeName(clim.getRepresentativeName());
        for (String detail : c.getMoreDetails()) {
            ws_c.getMoreDetails().add(detail);
        }
        ws_c.setEventPlace(clim.getEventPlace());
        ws_c.setEventTime(eventTimeImpl);
        ws_c.setEventType(webservice.EvntType.fromValue(clim.getEventType().name()));

        return ws_c;
    }

    Packages.Policy ConvertPolicy(webservice.Policy ws_p) {
        Packages.Policy plcy = new Packages.Policy();

        plcy.setId(ws_p.getId());
        plcy.setInsuranceCompany(Packages.Policy.InsrncCmpny.valueOf(ws_p.getInsuranceCompany().name()));
        plcy.setMoreDetails(ws_p.getMoreDetails());
//          plcy.setMoreDetailsSize() =;??
//          plcy.setMoreDetailsValues() =;??
        plcy.setOpeningDate(ws_p.getOpeningDate().toGregorianCalendar().getTime());
        plcy.setPolicyRate(ws_p.getPolicyRate());
        plcy.setPolicyType(Packages.Policy.PlicyType.valueOf(ws_p.getPolicyType().name()));
        plcy.setRepresentativeName(ws_p.getRepresentativeName());
        return plcy;
    }

    Packages.Claim ConvertClaim(webservice.Claim ws_c) {
        Packages.Claim clim = new Packages.Claim();

        clim.setId(ws_c.getId());
        clim.setInsuranceClaimStatus(Packages.Claim.ClaimStat.valueOf(ws_c.getInsuranceClaimStatus().name()));
        clim.setMoreDetails(ws_c.getMoreDetails());
        //  clim.getMoreDetailsSize() =;??
        //  clim.getMoreDetailsValues() =;??
        clim.setOpeningDate(ws_c.getOpeningDate().toGregorianCalendar().getTime());
        clim.setRepresentativeName(ws_c.getRepresentativeName());
        for (String doc_rec : ws_c.getDocumentsReceived()) {
            clim.getDocumentsReceived().add(doc_rec);
        }
        //clim.getDocumentsReceivedValues() =;???
        for (webservice.Documents doc_req : ws_c.getDocumentsRequired()) {
            clim.getDocumentsRequired().add(Packages.Claim.Documents.valueOf(doc_req.name()));
        }
        //clim.getDocumentsRequiredValues() =;???
        clim.setEventPlace(ws_c.getEventPlace());
        clim.setEventTime(ws_c.getEventTime().toGregorianCalendar().getTime());
        clim.setEventType(Packages.Claim.EvntType.valueOf(ws_c.getEventType().name()));
        return clim;
    }

    webservice.CustomerCrd ConvertCustomerCrd(Packages.CustomerCrd c) {
        webservice.CustomerCrd ws_customerCrd = new webservice.CustomerCrd();
        ws_customerCrd.setId(c.getId());
        ws_customerCrd.setPerson(ConvertPerson(c.getPerson()));
        for (Packages.Activity act : c.getActivities()) {
            ws_customerCrd.getActivities().add(ConvertActivity(act));
        }
        return ws_customerCrd;
    }

    Packages.CustomerCrd ConvertCustomerCrd(webservice.CustomerCrd ws_c) {
        Packages.CustomerCrd customerCrd = new Packages.CustomerCrd();
        customerCrd.setId(ws_c.getId());
        customerCrd.setPerson(ConvertPerson(ws_c.getPerson()));
        for (webservice.Activity act : ws_c.getActivities()) {
            customerCrd.getActivities().add(ConvertActivity(act));
        }
        return customerCrd;
    }

    //---------------------
    @Override
    public boolean AddNewCustomerCrd(Packages.CustomerCrd c) throws Exception {
        try {
            addNewCustomerCrd(ConvertCustomerCrd(c));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Long AddNewPolicy(Policy po, Person per) throws Exception {
        try {
            return addNewPolicy(ConvertPolicy(po), ConvertPerson(per));
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Long AddNewClaim(Claim cl, Person per) throws Exception {
        return addNewClaim(ConvertClaim(cl), ConvertPerson(per));
    }

    @Override
    public void DeleteCustomerCrd(CustomerCrd c) throws Exception {
        deleteCustomerCrd(ConvertCustomerCrd(c));
    }

    @Override
    public boolean DeletePolicy(Policy po, Person per) throws Exception {
        try {
            deletePolicy(ConvertPolicy(po), ConvertPerson(per));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean DeleteClaim(Claim cl, Person per) throws Exception {
        try {
            deleteClaim(ConvertClaim(cl), ConvertPerson(per));
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void UpdatePerson(Person per) throws Exception {
        updatePerson(ConvertPerson(per));
    }

    @Override
    public void UpdateActivity(Activity activity) throws Exception {
        updateActivity(ConvertActivity(activity));
    }

    @Override
    public void UpdateCustomerCrd(CustomerCrd c) throws Exception {
        updateCustomerCrd(ConvertCustomerCrd(c));
    }

    @Override
    public void UpdatePolicy(Policy po, Person per) throws Exception {
        updatePolicy(ConvertPolicy(po), ConvertPerson(per));
    }

    @Override
    public void UpdateClaim(Claim cl, Person per) throws Exception {
        updateClaim(ConvertClaim(cl), ConvertPerson(per));
    }

    @Override
    public ArrayList<Packages.Claim> GetAllOpenClaims() throws Exception {
        ArrayList<Packages.Claim> arrLis = new ArrayList<Packages.Claim>();
        for (webservice.Claim ws_clim : getAllOpenClaims()) {
            arrLis.add(ConvertClaim(ws_clim));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.CustomerCrd> GetAllCustemers() throws Exception {
        ArrayList<Packages.CustomerCrd> arrLis = new ArrayList<Packages.CustomerCrd>();
        for (webservice.CustomerCrd ws_cstmrCrd : getAllCustemers()) {
            arrLis.add(ConvertCustomerCrd(ws_cstmrCrd));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.Policy> GetAllPolicies() throws Exception {
        ArrayList<Packages.Policy> arrLis = new ArrayList<Packages.Policy>();
        for (webservice.Policy ws_plcy : getAllPolicies()) {
            arrLis.add(ConvertPolicy(ws_plcy));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.Policy> GetPerPolicies(Person per) throws Exception {
        ArrayList<Packages.Policy> arrLis = new ArrayList<Packages.Policy>();
        for (webservice.Policy ws_plcy : getPerPolicies(ConvertPerson(per))) {
            arrLis.add(ConvertPolicy(ws_plcy));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Claim> GetAllClaims() throws Exception {
        ArrayList<Packages.Claim> arrLis = new ArrayList<Packages.Claim>();
        for (webservice.Claim ws_clim : getAllClaims()) {
            arrLis.add(ConvertClaim(ws_clim));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.Claim> GetPerClaims(Person per) throws Exception {
        ArrayList<Packages.Claim> arrLis = new ArrayList<Packages.Claim>();
        for (webservice.Claim ws_clim : getPerClaims(ConvertPerson(per))) {
            arrLis.add(ConvertClaim(ws_clim));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.Claim> GetMyEventClaims(Claim.EvntType et, Person per) throws Exception {
        ArrayList<Packages.Claim> arrLis = new ArrayList<Packages.Claim>();
        for (webservice.Claim ws_clim : getMyEventClaims(webservice.EvntType.fromValue(et.name()), ConvertPerson(per))) {
            arrLis.add(ConvertClaim(ws_clim));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Claim> GetMyStatusClaims(Claim.ClaimStat cs, Person per) throws Exception {
        ArrayList<Packages.Claim> arrLis = new ArrayList<Packages.Claim>();
        for (webservice.Claim ws_clim : getMyStatusClaims(webservice.ClaimStat.fromValue(cs.name()), ConvertPerson(per))) {
            arrLis.add(ConvertClaim(ws_clim));
        }
        return arrLis;
    }

    @Override
    public ArrayList<Packages.Policy> GetMyTypePolicies(Policy.PlicyType cs, Person per) throws Exception {
        ArrayList<Packages.Policy> arrLis = new ArrayList<Packages.Policy>();
        for (webservice.Policy ws_plcy : getMyTypePolicies(webservice.PlicyType.fromValue(cs.name()), ConvertPerson(per))) {
            arrLis.add(ConvertPolicy(ws_plcy));
        }
        return arrLis;
    }

    @Override
    public CustomerCrd GetMyPersonCstmrCrd(long perId) throws Exception {
        Packages.CustomerCrd cstmrCrd = new Packages.CustomerCrd();
        cstmrCrd = ConvertCustomerCrd(getMyPersonCstmrCrd(perId));
        return cstmrCrd;
    }

    @Override
    public Policy GetPolicyById(long polcyId) throws Exception {
        Packages.Policy plcy = new Packages.Policy();
        plcy = ConvertPolicy(getPolicyById(polcyId));
        return plcy;
    }

    @Override
    public Claim GetClaimById(long claimId) throws Exception {
        Packages.Claim clim = new Packages.Claim();
        clim = ConvertClaim(getClaimById(claimId));
        return clim;
    }

    private static Long addNewClaim(webservice.Claim arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.addNewClaim(arg0, arg1);
    }

    private static boolean addNewCustomerCrd(webservice.CustomerCrd arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.addNewCustomerCrd(arg0);
    }

    private static Long addNewPolicy(webservice.Policy arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.addNewPolicy(arg0, arg1);
    }

    private static boolean deleteClaim(webservice.Claim arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.deleteClaim(arg0, arg1);
    }

    private static void deleteCustomerCrd(webservice.CustomerCrd arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.deleteCustomerCrd(arg0);
    }

    private static boolean deletePolicy(webservice.Policy arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.deletePolicy(arg0, arg1);
    }

    private static java.util.List<webservice.Claim> getAllClaims() throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getAllClaims();
    }

    private static java.util.List<webservice.CustomerCrd> getAllCustemers() throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getAllCustemers();
    }

    private static java.util.List<webservice.Claim> getAllOpenClaims() throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getAllOpenClaims();
    }

    private static java.util.List<webservice.Policy> getAllPolicies() throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getAllPolicies();
    }

    private static webservice.Claim getClaimById(long arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getClaimById(arg0);
    }

    private static java.util.List<webservice.Claim> getMyEventClaims(webservice.EvntType arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getMyEventClaims(arg0, arg1);
    }

    private static webservice.CustomerCrd getMyPersonCstmrCrd(long arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getMyPersonCstmrCrd(arg0);
    }

    private static java.util.List<webservice.Claim> getMyStatusClaims(webservice.ClaimStat arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getMyStatusClaims(arg0, arg1);
    }

    private static java.util.List<webservice.Policy> getMyTypePolicies(webservice.PlicyType arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getMyTypePolicies(arg0, arg1);
    }

    private static java.util.List<webservice.Claim> getPerClaims(webservice.Person arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getPerClaims(arg0);
    }

    private static java.util.List<webservice.Policy> getPerPolicies(webservice.Person arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getPerPolicies(arg0);
    }

    private static webservice.Policy getPolicyById(long arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        return port.getPolicyById(arg0);
    }

    private static void updateActivity(webservice.Activity arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.updateActivity(arg0);
    }

    private static void updateClaim(webservice.Claim arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.updateClaim(arg0, arg1);
    }

    private static void updateCustomerCrd(webservice.CustomerCrd arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.updateCustomerCrd(arg0);
    }

    private static void updatePerson(webservice.Person arg0) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.updatePerson(arg0);
    }

    private static void updatePolicy(webservice.Policy arg0, webservice.Person arg1) throws Exception_Exception {
        webservice.Java577312480915WebServiceAdapter_Service service = new webservice.Java577312480915WebServiceAdapter_Service();
        webservice.Java577312480915WebServiceAdapter port = service.getJava577312480915WebServiceAdapterPort();
        port.updatePolicy(arg0, arg1);
    }

}
