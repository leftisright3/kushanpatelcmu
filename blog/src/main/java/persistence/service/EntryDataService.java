package persistence.service;

import persistence.model.Entry;
import persistence.model.EntrySection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.List;

/**
 * Created by kushan on 6/19/17.
 */
@Stateless
public class EntryDataService {

    @Inject
    private EntityManager em;

    public List<Entry> getAllEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entry> cq = cb.createQuery(Entry.class);
        Root<Entry> blogEntryEntity = cq.from(Entry.class);
        cq.select(blogEntryEntity).orderBy(cb.desc(blogEntryEntity.get("modifiedTime")));
        return em.createQuery(cq).getResultList();
    }

    public Entry getById(Long id){
        return em.find(Entry.class, id);
    }

    public Entry addNewEntry(Entry entry) {
        Calendar now = Calendar.getInstance();
        entry.setCreatedTime(now);
        entry.setModifiedTime(now);
        em.persist(entry);
        return entry;
    }

    public EntrySection addNewEntrySection(EntrySection entry) {
        Calendar now = Calendar.getInstance();
        entry.setCreatedTime(now);
        entry.setModifiedTime(now);
        em.persist(entry);
        return entry;
    }
}
