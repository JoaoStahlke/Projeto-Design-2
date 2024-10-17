package Adapter;

import Classes.Paciente;
import Controller.PacienteController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pacientes")
public class PacienteRestAdapter {

    private PacienteController pacienteController;

    public PacienteRestAdapter() {
        this.pacienteController = new PacienteController();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionarPaciente(Paciente paciente) {
        try {
            pacienteController.adicionarPaciente(paciente);
            return Response.status(Response.Status.CREATED).entity(paciente).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPacientes() {
        try {
            List<Paciente> pacientes = pacienteController.listarPacientes();
            return Response.ok(pacientes).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarPaciente(@PathParam("id") int id, Paciente paciente) {
        try {
            paciente.setId(id);
            pacienteController.atualizarPaciente(paciente);
            return Response.ok(paciente).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPaciente(@PathParam("id") int id) {
        try {
            pacienteController.deletarPaciente(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
