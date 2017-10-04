
package br.edu.ifpb.bdnc.projeto.tcc.service.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.impl.UsuaioDaoImpl;
import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.UsuarioService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioDAO dao;

    public UsuarioServiceImpl() {
        dao = new UsuaioDaoImpl();
    }

    @Override
    public boolean salvar(Usuario usuario) {
        return dao.salvar(usuario);
    }

    @Override
    public boolean remover(int id) {
        return dao.remover(id);
    }

    @Override
    public boolean editar(Usuario usuario) {
        return dao.atualizar(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return dao.listar();
    }

    @Override
    public Usuario getUsuario(int id) {
        return dao.getUsuario(id);
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return dao.autenticar(email, senha);
    }
    
}
