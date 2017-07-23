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
    public List<Customer> getAllCustomers() {
        return customerController.getAllCustomers();
    }

    @POST
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public void addNewCustomer(CustomerTO customerTO) {
        customerController.addNewCustomer(customerTO);
    }

    @PUT
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public void editCustomer(CustomerTO customerTO) {
        customerController.editCustomer(customerTO);
    }

    @DELETE
    @Path("/customers/{id}")
    public void deleteCustomer(@PathParam("id") Long customerId) {
        customerController.deleteCustomer(customerId);
    }


    @GET
    @Path("/customers/{LName}")
    public List<Customer> getCustomersByLName(@PathParam("LName") String customerLName){
        return customerController.getCustomerByLName(customerLName);
    }

    @GET
    @Path("/customers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") Long customerId) {
        return customerController.getCustomerById(customerId);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findCustomer(@QueryParam("firstname") String customerFirstName, @QueryParam("lastname") String customerLastName, @QueryParam("id") Long customerId)
    {
        if (customerId != null)
        {
            return customerController.getCustomerById(customerId);
        }
        else if (customerLastName != null && !customerLastName.isEmpty())
        {
            return customerController.getCustomerByLastName(customerLastName);
        }
        else if (customerFirstName !=null && !customerFirstName.isEmpty())
        {
            return customerController.getCustomerByFirstName(customerFirstName);
        }
        else
        {
            return null;
        }

    }

}



