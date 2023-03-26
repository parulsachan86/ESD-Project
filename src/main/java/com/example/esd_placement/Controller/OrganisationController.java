package com.example.esd_placement.Controller;

import com.example.esd_placement.Bean.Organisation;
import com.example.esd_placement.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.esd_placement.DAO.OrganisationDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/organisation")
public class OrganisationController {
    OrganisationDAO orgDAO = new OrganisationDAOImpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_organisation(Organisation org){
//            System.out.printf(String.valueOf(plac));
        if(orgDAO.addOrganisation(org)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding organisation").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_departments(){
        List<Organisation> depts = orgDAO.getOrganisationList();
        System.out.printf("Hello world");
        return Response.status(200).entity(depts).build();
    }
}
