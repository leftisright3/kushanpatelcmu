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

    public void editBlogEntry(BlogEntryTO blogEntryTO){
        BlogEntry entry = blogEntryDataService.selectBlogEntry(blogEntryTO.id);
        entry.setLocation(blogEntryTO.location);
        entry.setDescription(blogEntryTO.description);
        entry.setBlogData(blogEntryTO.blogData);
        blogEntryDataService.updateBlogEntry(entry);
    }

    public BlogEntry getLatestEntry() {
        return blogEntryDataService.getLatestEntry();
    }


}