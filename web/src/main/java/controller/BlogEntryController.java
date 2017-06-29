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

    public void editBlogEntryLocation(Long id, String location){
        BlogEntry entry = blogEntryDataService.selectBlogEntry(id);
        entry.setLocation(location);
        blogEntryDataService.updateBlogEntry(entry);
    }//end EditLocation method

}
