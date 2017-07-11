package controller;

import persistence.model.BlogEntry;
import persistence.service.BlogEntryDataService;
import rest.BlogEntryTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kushan on 6/19/17.
 */
public class BlogEntryController {

    @Inject
    BlogEntryDataService beds;

    public List<BlogEntry> getAllEntries(){
        return beds.getAllEntries();
    }


    public void addNewBlogEntry(String description, String location) {
        BlogEntry entry = new BlogEntry();
        entry.setDescription(description);
        entry.setLocation(location);
        beds.persistBlogEntry(entry);
    }

    public void editBlogEntry(BlogEntryTO blogEntryTO){
        BlogEntry entry = beds.selectBlogEntry(blogEntryTO.id);
        entry.setLocation(blogEntryTO.location);
        entry.setDescription(blogEntryTO.description);
        entry.setBlogData(blogEntryTO.blogData);
        beds.updateBlogEntry(entry);
    }

    public BlogEntry getLatestEntry() {
        return beds.getLatestEntry();
    }

    public void deleteBlogEntry(Long blogEntryId) {
        beds.deleteBlogEntry(blogEntryId);
    }
}