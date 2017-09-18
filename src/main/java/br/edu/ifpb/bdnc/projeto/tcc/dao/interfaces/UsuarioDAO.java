
package br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface UsuarioDAO {
    
    boolean salvar(Usuario usuario);
    boolean remover(int id);
    boolean atualizar(Usuario usuario);
    Usuario getUsuario(int id);
    List<Usuario> listar();
}
