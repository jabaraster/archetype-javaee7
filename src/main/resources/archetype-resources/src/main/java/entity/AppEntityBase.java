/**
 *
 */
package ${package}.entity;

import jabara.jpa.entity.EntityBase;
import jabara.jpa.entity.Id;
import net.arnx.jsonic.JSONHint;

/**
 * @param <E> -
 */
public abstract class AppEntityBase<E extends AppEntityBase<E>> extends EntityBase<E> {

    /**
     * @see jabara.jpa.entity.EntityBase#getId()
     */
    @Override
    @JSONHint(ignore = true)
    public Id<E> getId() {
        return super.getId();
    }

    /**
     * @return -
     */
    @JSONHint(name = "id")
    public Long getIdValue() {
        return this.id;
    }

    /**
     * @see jabara.jpa.entity.EntityBase#isPersisted()
     */
    @Override
    @JSONHint(ignore = true)
    public boolean isPersisted() {
        return super.isPersisted();
    }

}
