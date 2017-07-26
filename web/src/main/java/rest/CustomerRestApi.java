package rest;

import controller.CustomerController;
import persistence.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by patel_000 on 7/19/2017.
 */

@Path("/customer")
public class CustomerRestApi

{
    @Inject
    CustomerController customerController;

    @GET
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers()
    {
        return customerController.getAllCustomers();
    }

    @POST
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addNewCustomer(CustomerTO customerTO)
    {
        return customerController.addNewCustomer(customerTO);
    }

    @PUT
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer editCustomer(CustomerTO customerTO)
    {
        return customerController.editCustomer(customerTO);
    }

    @DELETE
    @Path("/customers/{id}")
    public void deleteCustomer(@PathParam("id") Long customerId)
    {
        customerController.deleteCustomer(customerId);
    }


    @GET
    @Path("/customers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") Long customerId)
    {
        return customerController.getCustomerById(customerId);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findCustomers(@QueryParam("searchstr") String searchStr)
    {
        if (searchStr != null && !searchStr.isEmpty())
        {
            return customerController.findCustomers(searchStr);
        }
        else
        {
            return null;
        }
    }

    @POST
    @Path("/supersearch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findCustomers(CustomerTO customerTO)
    {
        return customerController.findCustomers(customerTO);
    }
}
