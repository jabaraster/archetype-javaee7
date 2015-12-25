/**
 *
 */
package ${package}.javaee.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import ${package}.Environment;

/**
 *
 */
@Dependent
class EntityManagerFactoryProducer {

    @PersistenceUnit(unitName = Environment.APPLICATION_NAME)
    @Produces
    EntityManagerFactory entityManagerFactory;
}
