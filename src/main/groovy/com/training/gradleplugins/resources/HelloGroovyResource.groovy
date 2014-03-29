package com.training.gradleplugins.resources

import com.training.gradleplugins.core.Notificacion
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path("/hellogroovy")
@Produces(MediaType.APPLICATION_JSON)
class HelloGroovyResource {
    public static final String CLICHED_MESSAGE = "Hello!";

    @GET
    public String getHello() {
        return CLICHED_MESSAGE
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    static
////    public void post(MultivaluedMap<String, String> formParams) {
//    def create(@FormParam("text") Notification text) {
////    def create(@FormParam("text") Map<String> text) {
//        println text
//        StringBuilder stringBuilder = new StringBuilder()
//////        return CLICHED_MESSAGE +  text
////        stringBuilder.append(text)
//        return Response.ok(stringBuilder, MediaType.APPLICATION_JSON).build()
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    Notificacion testPost(Notificacion notification) {
        notification
    }
}