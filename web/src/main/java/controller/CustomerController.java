package controller;

import persistence.model.Customer;
import persistence.service.CustomerDataService;
import rest.CustomerTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by patel_000 on 7/19/2017.
 */
public class CustomerController
{
    @Inject
    CustomerDataService cds;

    public List<Customer> getAllCustomers()
    {
        return cds.getAllCustomers();
    }

    public void addNewCustomer(CustomerTO customerTO)
    {
        Customer cus = new Customer();
        cus.setAge(customerTO.age);
        cus.setFirstName(customerTO.firstName);
        cus.setLastName(customerTO.lastName);
        cus.setBillingAddress(customerTO.billingAddress);
        cus.setMailingAddress(customerTO.mailingAddress);
        cus.setEmailAddress(customerTO.emailAddress);
        cus.setPhoneNumber(customerTO.phoneNumber);
        cus.setCreatedByUid(customerTO.createdByUid);
        cus.setModifiedByUid(customerTO.modifiedByUid);

        cds.persistCustomer(cus);
    }

    public void editCustomer(CustomerTO customerTO)

    {
        Customer cus = cds.selectCustomerById(customerTO.id);
        cus.setAge(customerTO.age);
        cus.setFirstName(customerTO.firstName);
        cus.setLastName(customerTO.lastName);
        cus.setBillingAddress(customerTO.billingAddress);
        cus.setMailingAddress(customerTO.mailingAddress);
        cus.setEmailAddress(customerTO.emailAddress);
        cus.setPhoneNumber(customerTO.phoneNumber);
        cus.setCreatedByUid(customerTO.createdByUid);
        cus.setModifiedByUid(customerTO.modifiedByUid);
        cds.updateCustomer(cus);
    }

    public void deleteCustomer(Long customerId)
    {
        cds.deleteCustomer(customerId);
    }

    public Customer getCustomerById(Long customerId)
    {
        return cds.selectCustomerById(customerId);
    }

    public Customer getCustomerByLastName(String customerLastName)
    {
        return cds.selectCustomerByLastName(customerLastName);
    }

    public Customer getCustomerByFirstName (String customerFirstName)
    {
        return cds.selectCustomerByFirstName(customerFirstName);
    }

    public List <Customer> getCustomerByLName(String customerLName) {return cds.getCustomerByLName;}
}
