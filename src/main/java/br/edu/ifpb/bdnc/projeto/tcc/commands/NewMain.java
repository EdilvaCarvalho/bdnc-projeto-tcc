/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.dao.impl.TccDaoImpl;
import br.edu.ifpb.bdnc.projeto.tcc.dao.impl.UsuaioDaoImpl;
import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import br.edu.ifpb.bdnc.projeto.tcc.domain.enuns.Area;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;

/**
 *
 * @author Edilva
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static List<String> palavrasChave = new ArrayList<>();;
    
    public static void main(String[] args) {
//        Usuario usuario = new Usuario("Edilva", LocalDate.now(), "edilva.com", "123");
//        UsuarioDAO dao = new UsuaioDaoImpl();
//        dao.salvar(usuario);
        palavrasChave.add("oficina");
        palavrasChave.add("motor");
        TCC tcc= new TCC("oficinatico", "joseph","Paulo",palavrasChave ,"kkjkjkjikjkj",
                2017,Area.BANCOS_DE_DADOS , "jlklklklklk");
        TccDaoImpl mongo = new TccDaoImpl();
        mongo.salvar(tcc);
    }

}
