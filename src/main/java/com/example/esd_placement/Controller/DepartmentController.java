package com.example.esd_placement.Controller;

import com.example.esd_placement.Bean.Department;
import com.example.esd_placement.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.esd_placement.DAO.DepartmentDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/department")
public class DepartmentController {
    DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(Department department) {

        if(departmentDAO.addDepartment(department))
            return Response.status(200).entity("Sucessfully added Department").build();

        else
            return Response.status(400).entity("Failure while adding Department").build();
    }
}
