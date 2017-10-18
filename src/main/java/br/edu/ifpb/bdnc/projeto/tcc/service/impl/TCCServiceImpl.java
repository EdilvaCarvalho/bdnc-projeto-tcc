/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.service.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.impl.TccDaoImpl;
import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.TccDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.TccService;
import java.util.List;

/**
 *
 * @author joseph
 */
public class TCCServiceImpl implements TccService{

    private TccDAO dao;
    
     public TCCServiceImpl() {
        dao = new TccDaoImpl();
    }
    
    @Override
    public boolean salvar(TCC tcc) {
        return dao.salvar(tcc);
    }

    @Override
    public List<TCC> listar() {
        return dao.listar();
    }

    @Override
    public List<TCC> buscaPorAno(int ano) {
        return dao.buscaPorAno(ano);
    }

    @Override
    public List<TCC> buscaPorAutor(String autor) {
        return dao.buscaPorAutor(autor);
    }

    @Override
    public TCC buscaPorConteudo(String conteudo) {
        return dao.buscaPorConteudo(conteudo);
    }

    @Override
    public boolean salvarNeo4J(TCC tcc) {
        return  dao.salvarNeo4J(tcc);
    }

    @Override
    public int geradorId() {
        return dao.geradorId();
    }

}
