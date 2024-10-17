package Adapter;

import Classes.Medico;
import Controller.MedicoController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/medicos")
public class MedicoRestAdapter {

    private MedicoController medicoController;

    public MedicoRestAdapter() {
        this.medicoController = new MedicoController();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionarMedico(Medico medico) {
        try {
            medicoController.adicionarMedico(medico);
            return Response.status(Response.Status.CREATED).entity(medico).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMedicos() {
        try {
            List<Medico> medicos = medicoController.listarMedicos();
            return Response.ok(medicos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarMedico(@PathParam("id") int id, Medico medico) {
        try {
            medico.setId(id);
            medicoController.atualizarMedico(medico);
            return Response.ok(medico).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarMedico(@PathParam("id") int id) {
        try {
            medicoController.deletarMedico(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
