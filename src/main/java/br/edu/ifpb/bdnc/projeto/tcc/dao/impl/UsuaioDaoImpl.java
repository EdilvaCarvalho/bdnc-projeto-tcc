package br.edu.ifpb.bdnc.projeto.tcc.dao.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import br.edu.ifpb.bdnc.projeto.tcc.util.ProdutorEntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class UsuaioDaoImpl implements UsuarioDAO {

    private EntityManager manager;

    public UsuaioDaoImpl() {
        manager = ProdutorEntityManager.criaEntityManager();
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
        } finally{
            manager.close();
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
        } finally{
            manager.close();
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
        } finally{
            manager.close();
        }
        return retorno;
    }

    @Override
    public Usuario getUsuario(int id) {
        Usuario usuario = null;
        try {
            usuario = manager.find(Usuario.class, id);
        } catch (Exception e) {
            return usuario;
        } finally {
            manager.close();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = null;
        try {
            Query query = manager.createQuery("SELECT u FROM Usuario u");
            usuarios = query.getResultList();
        } catch (Exception e) {
            return usuarios;
        } finally{
            manager.close();
        }
        return usuarios;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Usuario usuario = null;
        try {
            Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            return usuario;
        } finally{
            manager.close();
        }
        return usuario;
    }

}
