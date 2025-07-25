package uce.edu.ec.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.IDoctorRepo;
import uce.edu.ec.api.service.IDoctorService;
import uce.edu.ec.api.service.mapper.DoctorMapper;
import uce.edu.ec.api.service.to.DoctorTo;

@Path("/doctores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorController {
    
    @Inject
    private IDoctorService iDoctorService;
    @GET
    @Path("/{id}")
    public Response consultarPorId(@PathParam("id") Integer id) {
        DoctorTo doctor = DoctorMapper.toTo(this.iDoctorService.buscarPorId(id));
        return Response.status(228).entity(doctor).build();

    }

    @GET
    @Path("")
    public Response consultarTodos(@QueryParam("genero") String genero){
        List<DoctorTo> doctores = this.iDoctorService.buscarTodos(genero)
        .stream()
        .map(DoctorMapper::toTo)
        .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(doctores).build();

    }

    @POST
    @Path("")
    public Response guardar(@RequestBody DoctorTo doctorTo){
        this.iDoctorService.guardar(DoctorMapper.toEntity(doctorTo));
        return Response.status(Response.Status.CREATED).entity(doctorTo).build();
    }
   
}



