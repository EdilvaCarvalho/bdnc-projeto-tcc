/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.service.impl.TCCServiceImpl;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.TccService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseph
 */
public class BuscarTccAno implements Command{

    TccService service = new TCCServiceImpl();
    
   

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       
        
        int ano=Integer.parseInt(request.getParameter("pesquisa"));
        service.buscaPorAno(ano);
        
    
    }
    
}
