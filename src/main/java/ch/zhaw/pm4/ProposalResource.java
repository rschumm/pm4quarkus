package ch.zhaw.pm4;

import java.util.List;

import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/proposal")
public class ProposalResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Salut à la zhaw de la part de Quarkus dans le TGV!";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proposal> getAllProposals() {
        return Proposal.listAll(Sort.by("title"));
    }
}
