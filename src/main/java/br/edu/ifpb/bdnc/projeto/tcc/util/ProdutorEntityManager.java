package br.edu.ifpb.bdnc.projeto.tcc.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
public class ProdutorEntityManager {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bdnc-projeto-tcc-PU");

    @Produces
    @RequestScoped
    public EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }
    
    public void finaliza(@Disposes EntityManager manager) {
        if(manager != null && manager.isOpen()){
            manager.close();
        }
   }
}
