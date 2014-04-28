/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackages;

import MyPackages.Activity;
import MyPackages.Claim;
import MyPackages.Person;
import MyPackages.Policy;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class CustomerCrd {

    private Person per;
    private ArrayList<Activity> PerActivities;

    public CustomerCrd() {
    }

    public CustomerCrd(CustomerCrd cst_crd) { //copy constructor
        ArrayList<Activity> per_act = new ArrayList<Activity>();

        for (Activity item : cst_crd.getPerActivities()) {
            per_act.add(item);
        }

        this.per = cst_crd.getPer();

        this.PerActivities = per_act;

        //this.PerActivities=cst_crd.getPerActivities();
    }

    public CustomerCrd(Person per, ArrayList<Activity> PerActivities) {
        this.per = per;
        this.PerActivities = PerActivities;
    }

    public CustomerCrd(Person per) { //dagan
        this.per = per;
        this.PerActivities = new ArrayList<Activity>();
    }

    /**
     * @return the per
     */
    public Person getPer() {
        return per;
    }

    /**
     * @return the PerActivities
     */
    public ArrayList<Activity> getPerActivities() {
        return PerActivities;
    }

    /**
     * @param per the per to set
     */
    public void setPer(Person per) {
        this.per = per;
    }

    /**
     * @param PerActivities the PerActivities to set
     */
    public void setPerActivities(ArrayList<Activity> PerActivities) {

        this.PerActivities = PerActivities;
    }

    @Override //??????????????????????????????????????????????? 
    public String toString() {
        return (getPer().toString());
    }

    /**
     *
     * @param my_cst_crd
     * @return
     */
    @SuppressWarnings("empty-statement")
    public boolean valueEquals(CustomerCrd my_cst_crd) {

        if ((this.getPer().equals(my_cst_crd.getPer())) == false) {
            System.out.println("Persons are not equal!!!" + "\n");
            System.out.println(this.getPer().toString() + "\n");
            System.out.println(my_cst_crd.getPer().toString() + "\n");
        }

        if (ezer(my_cst_crd.getPerActivities()) == false) {
            System.out.println("Activities are not equal!!!" + "\n");
            System.out.println(this.getPerActivities().toString() + "\n");
            System.out.println(my_cst_crd.getPerActivities().toString() + "\n");
        }

        return (this.getPer().valueEquals(my_cst_crd.getPer())) && (ezer(my_cst_crd.getPerActivities()));

    }

    public boolean ezer(ArrayList<Activity> act) {
        for (Activity my_act : act) {
            if (my_act instanceof Policy) {
                Policy my_p = (Policy) my_act;
                for (Activity ac : this.getPerActivities()) {
                    if (ac instanceof Policy) {
                        Policy p = (Policy) ac;
                        if (my_p.valueEquals(p)) {
                            return true;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            } else if (my_act instanceof Claim) {
                Claim my_c = (Claim) my_act;
                for (Activity ac : this.getPerActivities()) {
                    if (ac instanceof Claim) {
                        Claim c = (Claim) ac;
                        if ((my_c.valueEquals(c))) {
                            return true;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
