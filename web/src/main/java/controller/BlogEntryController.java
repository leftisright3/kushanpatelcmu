package controller;

import persistence.model.BlogEntry;
import persistence.service.BlogEntryDataService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kushan on 6/19/17.
 */
public class BlogEntryController {

    @Inject
    BlogEntryDataService blogEntryDataService;

    public List<BlogEntry> getAllEntries(){
        return blogEntryDataService.getAllEntries();
    }

    public void addNewBlogEntry(String description, String location) {
        BlogEntry entry = new BlogEntry();
        entry.setDescription(description);
        entry.setLocation(location);
        blogEntryDataService.persistBlogEntry(entry);
    }

    
    public void editBlogEntry(Long id, String location, String description)
    {
        BlogEntry entry = blogEntryDataService.selectBlogEntry(id);
        entry.setLocation(location);
        entry.setDescription(description);
        blogEntryDataService.updateBlogEntry(entry);
    }//end EditLocation method

}
