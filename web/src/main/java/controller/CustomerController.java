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

    public Customer setCustomerFromCustomerTO(CustomerTO customerTO, Customer cus)
    {
        cus.setAge(customerTO.age);
        cus.setFirstName(customerTO.firstName);
        cus.setLastName(customerTO.lastName);
        cus.setBillingAddress(customerTO.billingAddress);
        cus.setMailingAddress(customerTO.mailingAddress);
        cus.setEmailAddress(customerTO.emailAddress);
        cus.setPhoneNumber(customerTO.phoneNumber);
        cus.setCreatedByUid(customerTO.createdByUid);
        cus.setModifiedByUid(customerTO.modifiedByUid);
        return cus;
    }

    public List<Customer> getAllCustomers()
    {
        return cds.getAllCustomers();
    }

    public void deleteCustomer(Long customerId)
    {
        cds.deleteCustomer(customerId);
    }

    public Customer getCustomerById(Long customerId)
    {
        return cds.selectCustomerById(customerId);
    }

    public Customer addNewCustomer(CustomerTO customerTO)
    {
        Customer cus = new Customer();
        setCustomerFromCustomerTO(customerTO, cus);
        cds.persistCustomer(cus);
        return cus;
    }

    public Customer editCustomer(CustomerTO customerTO)
    {
        Customer cus = cds.selectCustomerById(customerTO.id);
        setCustomerFromCustomerTO(customerTO, cus);
        cds.updateCustomer(cus);
        return cus;
    }

    public List<Customer> findCustomers(CustomerTO customerTO)
    {
        Customer cus = new Customer();
        cus.setId(customerTO.id);
        setCustomerFromCustomerTO(customerTO, cus);
        return cds.advancedSearch(cus);
    }

    public List<Customer> findCustomers(String searchStr)
    {
        Customer cus = new Customer();
        cus.setFirstName(searchStr);
        cus.setLastName(searchStr);
        cus.setPhoneNumber(searchStr);
        cus.setEmailAddress(searchStr);
        cus.setMailingAddress(searchStr);
        cus.setBillingAddress(searchStr);
        cus.setModifiedByUid(searchStr);
        cus.setCreatedByUid(searchStr);
        return cds.simpleSearch(cus);
    }
}
