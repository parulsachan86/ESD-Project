package com.example.esd_placement.Controller;

import com.example.esd_placement.Bean.Employee;
import com.example.esd_placement.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd_placement.DAO.EmployeeDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/employee")
public class EmployeeController {
    EmployeeDAO empDAO = new EmployeeDAOImpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_employee(Employee empl){
//            System.out.printf(String.valueOf(plac));
        if(empDAO.addEmployee(empl)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding employee").build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee employee1 = empDAO.login(employee);
        if(employee1 == null)
            return Response.status(402).build();
        else
            return  Response.ok().entity(employee1).build();
    }
}


