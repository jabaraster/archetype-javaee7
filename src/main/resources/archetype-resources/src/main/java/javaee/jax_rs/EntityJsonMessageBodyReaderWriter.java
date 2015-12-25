/**
 *
 */
package ${package}.javaee.jax_rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import jabara.jpa.entity.EntityBase;

/**
 *
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntityJsonMessageBodyReaderWriter extends JsonMessageBodyReaderWriterBase<EntityBase<?>> {
    // nodef
}
