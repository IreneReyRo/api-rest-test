package com.example.demo.controllers;

import com.example.demo.models.Bootcamper;
import com.example.demo.services.BootcamperService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcamperController {
   private BootcamperService bootcamperService;

   public BootcamperController(BootcamperService bootcamperService){
       this.bootcamperService = bootcamperService;
   }

   @GET
   @Path("bootcampers")
   @Produces("application/json")
   public List<Bootcamper> listaTodos(){
       return bootcamperService.getAll();
   }

    @GET
    @Path("bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listaUno(@PathParam("nombre") String nombre){
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(Bootcamper bootcamper){
        bootcamperService.add(bootcamper);
        return Response.created(URI.create("/bootcampers/" + bootcamper.getNombre())).build();
    }

    @PUT
    @Path("bootcampers/{nombre}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response actualizarBootcamper(@PathParam("nombre") String nombre, Bootcamper bootcamper){
        Bootcamper bootcamperUpdated = bootcamperService.put(nombre, bootcamper);
        return Response.ok(bootcamperUpdated).build();
    }

    @DELETE
    @Path("bootcampers/{nombre}")
    @Produces("application/json")
    public Response borrarUno(@PathParam("nombre") String nombre){
        bootcamperService.delete(nombre);
        return Response.ok().build();
    }
}
