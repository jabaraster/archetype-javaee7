/**
 *
 */
package ${package}.web.api;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import jabara.general.NotFound;
import jabara.jpa.entity.Id;
import ${package}.entity.EEmployee;
import ${package}.service.EmployeeService;

/**
 *
 */
@Path("employee")
@Dependent
public class EmployeeResource {

    private static final String PARAM_ID = "id"; //$NON-NLS-1$

    @Inject
    EmployeeService employeeService;

    /**
     * @return -
     */
    @Path("/")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<EEmployee> getAll() {
        return this.employeeService.getAll();
    }

    /**
     * @param pId -
     * @return -
     */
    @Path("/{" + PARAM_ID + "}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public EEmployee getById(@PathParam(PARAM_ID) final long pId) {
        try {
            return this.employeeService.getById(new Id<EEmployee>(pId));
        } catch (@SuppressWarnings("unused") final NotFound e) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }
}
