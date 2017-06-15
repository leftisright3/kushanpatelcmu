package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestApi {

    @GET
    @Path("/methodPath/{paramName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getData(@PathParam("paramName") String whatever,
                            @QueryParam("queryParam") String queryParam) {
        return whatever + " " + queryParam;
    }
}