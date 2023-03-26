package com.example.esd_placement.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.type.TrueFalseConverter;

import java.util.List;

@Entity
@Table(name = "Organisation")

public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organisation_id;

    @Column(nullable = false,unique = true)
    private String name;
    @Column
    private String address;

//    @OneToMany
//    private List<Placement> placements;

    @OneToMany(mappedBy="organisation",fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Placement> placements;


    public Integer getOrganisation_id() {
        return organisation_id;
    }

    public void setOrganisation_id(Integer organisation_id) {
        this.organisation_id = organisation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organisation(String name, String address) {
        //this.organisation_id = organisation_id;
        this.name = name;
        this.address = address;
    }

    public Organisation(){

    }

    @Override
    public String toString() {
        return "Organisation{" +
                "organisation_id=" + organisation_id +
                ", name=" + name + '\'' +
                ", Address=" + address + '\'' +
                '}';
    }

}
