package br.edu.ifpb.bdnc.projeto.tcc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
public class ProdutorEntityManager {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bdnc-projeto-tcc-PU");

    public static EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }
    
    public void finaliza(EntityManager manager) {
        if(manager != null && manager.isOpen()){
            manager.close();
        }
   }
}
