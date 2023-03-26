package com.example.esd_placement.Controller;

import com.example.esd_placement.Bean.Organisation;
import com.example.esd_placement.Bean.Placement;

import com.example.esd_placement.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.esd_placement.DAO.DAOImplementation.PlacementDAOImpl;
import com.example.esd_placement.DAO.PlacementDAO;

import com.example.esd_placement.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/placement")
public class PlacementController extends HelloApplication{
        PlacementDAO placDAO = new PlacementDAOImpl();
        @POST
        @Path("/add")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public Response add_placement(Placement plac){
//            System.out.printf(String.valueOf(plac));
//            PlacementDAOImpl placementDAO = new PlacementDAOImpl();
//            OrganisationDAOImpl organisationDAO = new OrganisationDAOImpl();
//            Organisation org = organisationDAO.getOrgByID(1);
//            Placement p1 = new Placement("Nvidia","dev","CSE",30,3.14,org);
////            placDAO.addPlacement(p1);
            if(placDAO.addPlacement(plac)){
                return Response.status(200).entity("Success").build();
            }

            return Response.status(400).entity("Failure while adding placement").build();
        }

}
