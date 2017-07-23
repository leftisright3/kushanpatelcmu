package persistence.service;

import persistence.model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

    public List<Customer> getAllCustomers()
    {
        //ToDo execute query to get all customers
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
        //customer.setCreatedByUid("");
        //customer.setModifiedByUid("");
        em.persist(customer);
        return customer;
    }

    public Customer selectCustomer(Long id)
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

    //
}
