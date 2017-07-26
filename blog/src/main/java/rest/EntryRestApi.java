package rest;

import controller.EntryController;
import persistence.model.Entry;
import persistence.model.EntrySection;
import rest.transfer.EntrySectionTO;
import rest.transfer.EntryTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entry")
public class EntryRestApi {

    @Inject
    EntryController controller;

    @GET
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entry> getAllBlogEntries() {
        return controller.getAllEntries();
    }

    @GET
    @Path("/entry")
    @Produces(MediaType.APPLICATION_JSON)
    public Entry getLatestEntry(@QueryParam("id") Long id) {
        return controller.findById(id);
    }

    @POST
    @Path("/entries")
    @Produces(MediaType.APPLICATION_JSON)
    public Entry addNewEntry(EntryTO entryTO) {
        return controller.addNewEntry(entryTO);
    }

    @POST
    @Path("/sections")
    @Produces(MediaType.APPLICATION_JSON)
    public EntrySection addNewEntrySection(EntrySectionTO entrySectionTO) {
        return controller.addNewEntrySection(entrySectionTO);
    }

}