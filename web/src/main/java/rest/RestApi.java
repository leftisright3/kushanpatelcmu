package rest;

import controller.BlogEntryController;
import persistence.model.BlogEntry;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest")
public class RestApi {

    @Inject
    BlogEntryController controller;

    @GET
    @Path("/methodPath/{paramName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getData(@PathParam("paramName") String whatever,
                            @QueryParam("queryParam") String queryParam) {
        return whatever + " " + queryParam;
    }

    @GET
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BlogEntry> getAllBlogEntries(){
        return controller.getAllEntries();
    }

    @GET
    @Path("/entries/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public BlogEntry getLatestEntry()
    {
        return controller.getLatestEntry();
    }

    @DELETE
    @Path("/entries/{id}")
    public void deleteBlogEntry(@PathParam("id") Long blogEntryId)
    {
        controller.deleteBlogEntry(blogEntryId);
    }


    @POST
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    public void addNewBlogEntry(@QueryParam("description") String desc,
                                @QueryParam("location") String loc) {
        controller.addNewBlogEntry(desc, loc);
    } //end addNewBlogEntryMethod

    @PUT
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.WILDCARD)
    public void editBlogEntry(BlogEntryTO blogEntryTO)
    {
        controller.editBlogEntry(blogEntryTO);

    }//end editBlogEntry()

    @GET
    @Path("mymethod")
    @Produces(MediaType.APPLICATION_JSON)
    public BlogEntryTO getAmarData()
    {
       return controller.counterPractice();


    } //end getAmarData method


}