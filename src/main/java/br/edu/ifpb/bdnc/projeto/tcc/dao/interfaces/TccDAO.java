
package br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface TccDAO {
    
    boolean salvar(TCC tcc);
    boolean remover(int id);
    boolean atualizar(TCC tcc);
    TCC getUsuario(int id);
    List<TCC> listar();
}
