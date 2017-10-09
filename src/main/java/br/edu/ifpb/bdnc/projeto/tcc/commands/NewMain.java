/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.dao.impl.UsuaioDaoImpl;
import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import java.time.LocalDate;

/**
 *
 * @author Edilva
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Edilva", LocalDate.now(), "edilva.com", "123");
        UsuarioDAO dao = new UsuaioDaoImpl();
        dao.salvar(usuario);
    }
    
}