package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Ubigeo;

@Stateless
public class UbigeoFacade extends AbstractFacade<Ubigeo> {

    @PersistenceContext(unitName = "dbiDocVGUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbigeoFacade() {
        super(Ubigeo.class);
    }
    
}
