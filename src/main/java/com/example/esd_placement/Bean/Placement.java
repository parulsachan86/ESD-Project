package com.example.esd_placement.Bean;

import com.example.esd_placement.DAO.DAOImplementation.OrganisationDAOImpl;
import jakarta.persistence.*;

@Entity
@Table(name = "Placement")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PlacId;

    @Column(nullable = false)
    private String profile;

    @Column
    private String specialization ;
    @Column
    private String domain;

    @Column
    private Integer intake;

    @Column
    private Float min_grade;

    @ManyToOne
    @JoinColumn(name="organisation_id")
    private Organisation organisation;

    public Integer getPlacId() {
        return PlacId;
    }

    public void setPlacId(Integer placId) {
        PlacId = placId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getIntake() {
        return intake;
    }

    public void setIntake(Integer intake) {
        this.intake = intake;
    }

    public Float getMin_grade() {
        return min_grade;
    }

    public void setMin_grade(Float min_grade) {
        this.min_grade = min_grade;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Placement() {
    }

    public Placement(Integer placId, String profile, String specialization, String domain, Integer intake, Float min_grade, Organisation organisation) {
        PlacId = placId;
        this.profile = profile;
        this.specialization = specialization;
        this.domain = domain;
        this.intake = intake;
        this.min_grade = min_grade;
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "PlacId=" + PlacId +
                ", profile='" + profile + '\'' +
                ", specialization='" + specialization + '\'' +
                ", domain='" + domain + '\'' +
                ", intake=" + intake +
                ", min_grade=" + min_grade +
                '}';
    }
}