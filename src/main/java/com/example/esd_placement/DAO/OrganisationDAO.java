package com.example.esd_placement.DAO;

import com.example.esd_placement.Bean.Organisation;
import com.example.esd_placement.Bean.Placement;

import java.util.List;

public interface OrganisationDAO {
    boolean addOrganisation(Organisation Orgobj);
    Organisation getOrgByID(int id);

    List<Organisation> getOrganisationList();
}
