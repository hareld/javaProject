/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author dell
 */
// annotation - Policy table
@Entity(name = "Policy_Table")

// policy class - implementation of activity abstract class
public class Policy extends Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum PlicyType { CompulsoryInsurance, ThirdParty, Comprehensive,
                            PersonalAccident, InsuranceExecutives, WorkAccidents,
                            LifeInsurance, HealthInsurance
    }

    public enum InsrncCmpny { Migdal, Shomera, Feinx,
                               Ayalon, Tzion, Harel, Achara
    }

    private float PolicyRate;

    // annotation - enum format match to DB
    @Enumerated(EnumType.STRING)
    private Policy.PlicyType PolicyType;

    // annotation - enum format match to DB
    @Enumerated(EnumType.STRING)
    private Policy.InsrncCmpny InsuranceCompany;

    // default Ctor
    public Policy() {
    }

    // Ctor
    public Policy(Policy.PlicyType PolicyType, Policy.InsrncCmpny InsuranceCompany, float PolicyRate, String RepresentativeName, Date OpeningDate, ArrayList<String> MoreDetails) {
        super(RepresentativeName, OpeningDate, MoreDetails);
        this.PolicyType = PolicyType;
        this.InsuranceCompany = InsuranceCompany;
        this.PolicyRate = PolicyRate;
    }

    // copy Ctor
    public Policy(Policy p) {
        super(p.getRepresentativeName(), p.getOpeningDate(), p.getMoreDetails());
        this.PolicyType = p.getPolicyType();
        this.InsuranceCompany = p.getInsuranceCompany();
        this.PolicyRate = p.getPolicyRate();
    }

    /**
     * @return the PolicyRate
     */
    // get the rate of policy
    public float getPolicyRate() {
        return PolicyRate;
    }

    /**
     * @param PolicyRate the PolicyRate to set
     */
    // set the rate of the policy
    public void setPolicyRate(float PolicyRate) {
        this.PolicyRate = PolicyRate;
    }

    /**
     * @return the PolicyType
     */
    // get type of the policy
    public Policy.PlicyType getPolicyType() {
        return PolicyType;
    }

    /**
     * @param PolicyType the PolicyType to set
     */
    // set type of the policy
    public void setPolicyType(Policy.PlicyType PolicyType) {
        this.PolicyType = PolicyType;
    }

    /**
     * @return the InsuranceCompany
     */
    // get the insurance company
    public Policy.InsrncCmpny getInsuranceCompany() {
        return InsuranceCompany;
    }

    /**
     * @param InsuranceCompany the InsuranceCompany to set
     */
    // set the insurance company
    public void setInsuranceCompany(Policy.InsrncCmpny InsuranceCompany) {
        this.InsuranceCompany = InsuranceCompany;
    }
    
    // get list of more required details
    public List<String> getMoreDetailsValues() {
        return super.getMoreDetailsValues();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Policy)) {
            return false;
        }
        Policy other = (Policy) object;
        return (getId() != null || other.getId() == null) && (getId() == null || this.getId().equals(other.getId()));
    }

    @Override
    public String toString() {
        return "moshe.Policy[ id=" + getId() + " ]";
    }

    // return fake activity id (only for new policy before the save)
    public long GiveMeActivityID(long[] id) {
        long next_ID = id[0]++;
        return next_ID;
    }
}