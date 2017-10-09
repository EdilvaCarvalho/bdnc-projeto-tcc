
package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.Usuario;
import br.edu.ifpb.bdnc.projeto.tcc.service.impl.UsuarioServiceImpl;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.UsuarioService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class CadastrarUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = dadosDoUsuario(request);
        UsuarioService service = new UsuarioServiceImpl();
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        
        if(service.salvar(usuario)){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            String nome = usuario.getNome();
            String[] nome2 = nome.trim().split(" ");
            nome = nome2[0];
            sessao.setAttribute("nome", nome);
            try {
                request.getRequestDispatcher("paginaDoUsuario.jsp").forward(request, response);
            } catch (IOException | ServletException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                request.getRequestDispatcher("erroCadastro.html").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Usuario dadosDoUsuario(HttpServletRequest request){
        Usuario usuario = new Usuario();
        
        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            usuario.setNome(nome);
        }
        
        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            usuario.setEmail(email);
        }
        
        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            usuario.setSenha(senha);
        }
        
        return usuario;
    }
    
}
