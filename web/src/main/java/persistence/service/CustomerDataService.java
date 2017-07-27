package persistence.service;

import persistence.model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        cq.select(customerEntity).orderBy(cb.desc(customerEntity.get("id")));
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

    public Customer selectCustomerById(Long id)
    {
        return em.find(Customer.class, id);
    }



    public List<Customer> selectCustomersByMultipleQueries(Customer customer)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();
        if (customer.getId() != null)
            predicates.add(cb.equal(customerEntity.get("id"), customer.getId()));

        if (customer.getFirstName() != null)
        {
            predicates.add(cb.equal(customerEntity.get("firstName"), customer.getFirstName()));
        }
        if (customer.getLastName() != null)
        {
            predicates.add(cb.equal(customerEntity.get("lastName"), customer.getLastName()));
        }

        cq.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(cq).getResultList();
    }
}
