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
    public void addNewCustomer(CustomerTO customerTO)
    {
        customerController.addNewCustomer(customerTO);
    }

    @PUT
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public void editCustomer(CustomerTO customerTO)
    {
        customerController.editCustomer(customerTO);
    }

    @DELETE
    @Path("/customers/{id}")
    public void deleteCustomer(@PathParam("id") Long customerId)
    {
        customerController.deleteCustomer(customerId);
    }

}
