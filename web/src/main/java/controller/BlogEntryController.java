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
        blogEntryDataService.createBlogEntry(entry);
    }

}
