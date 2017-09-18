package br.edu.ifpb.bdnc.projeto.tcc.dao.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class UsuaioDaoImpl implements UsuarioDAO {

    @Inject
    private EntityManager manager;

    public UsuaioDaoImpl() {
    }

    @Override
    public boolean salvar(Usuario usuario) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public boolean remover(int id) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            Usuario usuario = manager.find(Usuario.class, id);
            manager.remove(usuario);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            manager.merge(usuario);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public Usuario getUsuario(int id) {
        return manager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios;
        Query query = manager.createQuery("SELECT u FROM Usuario u");
        usuarios = query.getResultList();
        return usuarios;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        Usuario usuario = (Usuario) query.getSingleResult();
        return usuario;
    }

}
