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

    public List<Predicate> createPredicateList(Customer customer, boolean advancedSearch)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();
        List<Predicate> advancedSearchPredicates = new ArrayList<>();

        //ToDo find a way to get customerProperties from customerEntity

//        List<Property> customerProperties = customer.getProperties();
//
//        for (int i=0; i > customerProperties.length; i++)
//        {
//
//                if (advancedSearch) {
//                    predicates.add(cb.equal(customerEntity.get(customerProperties.get(i).getName()), customerProperties.get(i).getValue()));
//                } else if (customerProperties.get(i).getType() instanceof String) {
//                    predicates.add(cb.like(customerEntity.get(customerProperties.get(i).getName()), "%" + customerProperties.get(i).getValue() + "%"));
//                }
//        }

            if (customer.getId() != null)
            {
                advancedSearchPredicates.add(cb.equal(customerEntity.get("id"), customer.getId()));
            }
            if (customer.getFirstName() != null) {
                predicates.add(cb.like(customerEntity.get("firstName"), "%" + customer.getFirstName() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("firstName"), customer.getFirstName()));
            }
            if (customer.getLastName() != null) {
                predicates.add(cb.like(customerEntity.get("lastName"), "%" + customer.getLastName() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("lastName"), customer.getLastName()));
            }
            if (customer.getAge() != null) {
                advancedSearchPredicates.add(cb.equal(customerEntity.get("age"), customer.getAge()));
            }
            if (customer.getPhoneNumber() != null) {
                predicates.add(cb.like(customerEntity.get("phoneNumber"), "%" + customer.getPhoneNumber() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("phoneNumber"), customer.getPhoneNumber()));
            }
            if (customer.getEmailAddress() != null) {
                predicates.add(cb.like(customerEntity.get("emailAddress"), "%" + customer.getEmailAddress() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("emailAddress"), customer.getEmailAddress()));
            }
            if (customer.getMailingAddress() != null) {
                predicates.add(cb.equal(customerEntity.get("mailingAddress"), "%" + customer.getMailingAddress() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("mailingAddress"), customer.getMailingAddress()));
            }

            if (customer.getBillingAddress() != null) {
                predicates.add(cb.like(customerEntity.get("billingAddress"), "%" + customer.getBillingAddress() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("billingAddress"), customer.getBillingAddress()));
            }
            if (customer.getCreatedByUid() != null) {
                predicates.add(cb.like(customerEntity.get("createdByUid"), "%" + customer.getCreatedByUid() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("createdByUid"), customer.getCreatedByUid()));
            }
            if (customer.getModifiedByUid() != null) {
                predicates.add(cb.like(customerEntity.get("modifiedByUid"), "%" + customer.getModifiedByUid() + "%"));
                advancedSearchPredicates.add(cb.equal(customerEntity.get("modifiedByUid"), customer.getModifiedByUid()));
            }
        if(advancedSearch)
        {
            return advancedSearchPredicates;
        }
        else
        {
            return predicates;
        }
    }

    public List<Customer> advancedSearch(Customer customer)
    {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        List<Predicate> predicates = createPredicateList(customer, true);
        cq.where(predicates.toArray(new Predicate[]{}));
        cq.select(customerEntity).orderBy(cb.desc(customerEntity.get("id")));

        return em.createQuery(cq).getResultList();
    }

    public List<Customer> simpleSearch(Customer customer)
    {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerEntity = cq.from(Customer.class);
        List<Predicate> predicates = createPredicateList(customer, false);
        cq.where(cb.or(predicates.toArray(new Predicate[]{})));
        cq.select(customerEntity).orderBy(cb.desc(customerEntity.get("id")));
        return em.createQuery(cq).getResultList();
    }
}
