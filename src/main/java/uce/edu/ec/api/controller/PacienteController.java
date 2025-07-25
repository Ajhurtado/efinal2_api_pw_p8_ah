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
import uce.edu.ec.api.service.IPacienteService;
import uce.edu.ec.api.service.mapper.PacienteMapper;
import uce.edu.ec.api.service.to.PacienteTo;

@Path("/pacientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteController {
    
    @Inject
    private IPacienteService iPacienteService;
    @GET
    @Path("/{id}")
    public Response consultarPorId(@PathParam("id") Integer id) {
        PacienteTo paciente = PacienteMapper.toTo(this.iPacienteService.buscarPorId(id));
        return Response.status(228).entity(paciente).build();

    }

    @GET
    @Path("")
    public Response consultarTodos(@QueryParam("genero") String genero){
        List<PacienteTo> pacientes = this.iPacienteService.buscarTodos()
        .stream()
        .map(PacienteMapper::toTo)
        .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(pacientes).build();

    }

    @POST
    @Path("")
    public Response guardar(@RequestBody PacienteTo pacienteTo){
        this.iPacienteService.guardar(PacienteMapper.toEntity(pacienteTo));
        return Response.status(Response.Status.CREATED).entity(pacienteTo).build();
    }
}
