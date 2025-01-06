package ch.zhaw.pm4;

import java.util.List;

import io.quarkus.panache.common.Sort;
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
    Template proposals;

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

    @GET
    @Path("/ui")
    @Blocking
    public TemplateInstance getProposals() {
        List<Proposal> allProposals = Proposal.listAll(Sort.by("title"));
        return proposals.data("proposals", allProposals);
    }
}
