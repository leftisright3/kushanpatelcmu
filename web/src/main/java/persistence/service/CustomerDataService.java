package persistence.service;

import persistence.model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.List;


/**
 * Created by patel_000 on 7/19/2017.
 */
@Stateless
public class CustomerDataService
{
    @Inject
    private EntityManager em;

    public List<Customer> getCustomerByLName(String LName){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        cq.select(customerEntity).orderBy(cb.desc(customerEntity.get(LName)));
        return em.createQuery(cq).getResultList();
    }

    public List<Customer> getAllCustomers()
    {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        cq.select(customerEntity).orderBy(cb.desc(customerEntity.get("modifiedTime")));
        return em.createQuery(cq).getResultList();
    }

    public Customer persistCustomer(Customer customer)
    {
        Calendar now = Calendar.getInstance();
        customer.setCreatedTime(now);
        customer.setModifiedTime(now);
        em.persist(customer);
        return customer;
    }

    public Customer selectCustomerById(Long id)
    {
        return em.find(Customer.class, id);
    }

    public Customer updateCustomer(Customer customer)
    {
        Calendar now = Calendar.getInstance();
        customer.setModifiedTime(now);
        em.merge(customer);
        return customer;
    }

    public void deleteCustomer(Long idToDelete)
    {
        Customer entityToDelete = em.find(Customer.class, idToDelete);
        em.remove(entityToDelete);
    }

    public Customer selectCustomerByLastName(String customerLastName)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        Predicate condition = cb.equal(customerEntity.get("lastName"), customerLastName);

        cq.where(condition);
        return em.createQuery(cq).getSingleResult();

        //ToDo execute query to get customer by last name

    }

    public Customer selectCustomerByFirstName(String customerfirstName)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        Predicate condition = cb.equal(customerEntity.get("firstName"), customerfirstName);

        cq.where(condition);
        return em.createQuery(cq).getSingleResult();

        //ToDo execute query to get customer by last name

    }

    //
}
