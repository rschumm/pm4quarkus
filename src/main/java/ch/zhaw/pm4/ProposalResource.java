package ch.zhaw.pm4;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.panache.common.Sort;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/proposal")
public class ProposalResource {

    @Inject
    @Location("proposals.html") 
    Template proposals;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Salut à la zhaw de la part de Quarkus dans le TGV!";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all proposals", description = "Returns a list of all proposals in the system")
    public List<Proposal> getAllProposals() {
        return Proposal.listAll(Sort.by("title"));
    }

    @GET
    @Path("/ui")
    @Blocking
    @Operation(summary = "Render proposals template", description = "Displays the proposals page with all proposals.")
    public TemplateInstance getProposals() {
        List<Proposal> allProposals = Proposal.listAll(Sort.by("title"));
        return proposals.data("proposals", allProposals);
    }
}
