
package br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface TccDAO {
    
    boolean salvar(TCC tcc);
    TCC buscaPorAno(int ano);
    TCC buscaPorAutor(String autor);
    TCC buscaPorConteudo(String conteudo);
    List<TCC> listar();
}
