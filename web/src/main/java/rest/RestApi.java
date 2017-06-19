package rest;

import controller.BlogEntryController;
import persistence.model.BlogEntry;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
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

    @POST
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    public void addNewBlogEntry(@QueryParam("description") String description,
                                @QueryParam("location") String location) {
        controller.addNewBlogEntry(description, location);
    }
}