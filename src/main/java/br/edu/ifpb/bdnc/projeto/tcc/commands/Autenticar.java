package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import br.edu.ifpb.bdnc.projeto.tcc.domain.enuns.Area;
import br.edu.ifpb.bdnc.projeto.tcc.service.impl.UsuarioServiceImpl;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.UsuarioService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edilva
 */
public class Autenticar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = service.autenticar(email, senha);

        if (usuario == null) {
            try {
                request.getRequestDispatcher("erroLogin.html").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            sessao.setAttribute("areas", Area.values());
            String nome = usuario.getNome();
            String[] nome2 = nome.trim().split(" ");
            nome = nome2[0];
            sessao.setAttribute("nome", nome);
            try {
                request.getRequestDispatcher("paginaDoUsuario.jsp").forward(request, response);
            } catch (IOException | ServletException ex) {
                Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
