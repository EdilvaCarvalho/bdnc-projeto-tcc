/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.service.interfaces;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface TccService {

    boolean salvar(TCC tcc);
    
    boolean salvarNeo4J(TCC tcc);
    
    int geradorId();

    public List<TCC> buscaPorAno(int ano);

    public List<TCC> buscaPorAutor(String autor);

    List<TCC> listar();

    public TCC buscaPorConteudo(String conteudo);

}
