
package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import br.edu.ifpb.bdnc.projeto.tcc.domain.enuns.Area;
import br.edu.ifpb.bdnc.projeto.tcc.service.impl.TCCServiceImpl;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.TccService;
import java.io.IOException;
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
public class CadastrarTCC implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
        TCC tcc = dadosDoTcc(request);
        TccService service = new TCCServiceImpl();
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        
        if(service.salvar(tcc)){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("tcc", tcc);
            String titulo = tcc.getTitulo();
            String[] nome2 = titulo.trim().split(" ");
            titulo = nome2[0];
            sessao.setAttribute("tcc", titulo);
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
    
    private TCC dadosDoTcc(HttpServletRequest request){
        TCC tcc = new TCC();
        
        if (request.getParameter("titulo") != null) {
            String titulo = request.getParameter("titulo");
            tcc.setTitulo(titulo);
        }
        
        if (request.getParameter("autor") != null) {
            String autor = request.getParameter("autor");
            tcc.setAutor(autor);
        }
        
        if (request.getParameter("orientador") != null) {
            String orientador = request.getParameter("orientador");
            tcc.setOrientador(orientador);
        }
        
        if (request.getParameter("area") != null) {
            String area = request.getParameter("area");
            tcc.setArea(Area.valueOf(area));
        }
        
        return tcc;
    }
    
    
}
