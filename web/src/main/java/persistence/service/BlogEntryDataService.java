package persistence.service;

import persistence.model.BlogEntry;

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
public class BlogEntryDataService {
    @Inject
    private EntityManager em;

    public List<BlogEntry> getAllEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BlogEntry> cq = cb.createQuery(BlogEntry.class);
        Root<BlogEntry> blogEntryEntity = cq.from(BlogEntry.class);
        cq.select(blogEntryEntity).orderBy(cb.desc(blogEntryEntity.get("modifiedTime")));
        return em.createQuery(cq).getResultList();
    }

    public BlogEntry selectBlogEntry(Long id){
        return em.find(BlogEntry.class, id);
    }

    public BlogEntry persistBlogEntry(BlogEntry blogEntry) {
        Calendar now = Calendar.getInstance();
        blogEntry.setCreatedTime(now);
        blogEntry.setModifiedTime(now);
        blogEntry.setCreatedByUid("SYSTEM");
        blogEntry.setModifiedByUid("SYSTEM");
        em.persist(blogEntry);
        return blogEntry;
    }

    public BlogEntry updateBlogEntry(BlogEntry blogEntry) {
        Calendar now = Calendar.getInstance();
        blogEntry.setModifiedTime(now);
        blogEntry.setModifiedByUid("SYSTEM");
        em.merge(blogEntry);
        return blogEntry;
    }

    public void deleteBlogEntry(BlogEntry blogEntry){
        em.remove(blogEntry);
    }

    public BlogEntry getLatestEntry() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BlogEntry> cq = cb.createQuery(BlogEntry.class);
        Root<BlogEntry> blogEntryEntity = cq.from(BlogEntry.class);
        cq.select(blogEntryEntity).orderBy(cb.desc(blogEntryEntity.get("modifiedTime")));
        return em.createQuery(cq).setMaxResults(1).getSingleResult();
    }
}
