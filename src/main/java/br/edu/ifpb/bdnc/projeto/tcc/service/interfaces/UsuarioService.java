
package br.edu.ifpb.bdnc.projeto.tcc.service.interfaces;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface UsuarioService {
    
    boolean salvar(Usuario usuario);
    boolean remover(int id);
    boolean editar(Usuario usuario);
    List<Usuario> listar();
    Usuario getUsuario(int id);
    Usuario autenticar(String email, String senha);
}
