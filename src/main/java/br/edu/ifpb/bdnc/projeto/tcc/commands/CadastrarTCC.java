package br.edu.ifpb.bdnc.projeto.tcc.commands;

import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import br.edu.ifpb.bdnc.projeto.tcc.domain.enuns.Area;
import br.edu.ifpb.bdnc.projeto.tcc.service.impl.TCCServiceImpl;
import br.edu.ifpb.bdnc.projeto.tcc.service.interfaces.TccService;
import br.edu.ifpb.bdnc.projeto.tcc.util.LeitorPdf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author Edilva
 */
public class CadastrarTCC implements Command {

    TccService service = new TCCServiceImpl();
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            TCC tcc = dadosDoTcc(request);
            String url = request.getHeader("referer");
            request.setAttribute("pagina", url);

            if (service.salvar(tcc) && service.salvarNeo4J(tcc)) {
                try {
                    request.getRequestDispatcher("paginaDoUsuario.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarTCC.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    request.getRequestDispatcher("erroCadastro.html").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CadastrarTCC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarTCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TCC dadosDoTcc(HttpServletRequest request) throws IOException, ServletException {
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
        if (request.getParameter("resumo") != null) {
            String resumo = request.getParameter("resumo");
            tcc.setResumo(resumo);
        }

        if (request.getParameter("pdf") != null) {
            try {
                String texto = request.getParameter("pdf");
                LeitorPdf leitor = new LeitorPdf(texto);
                tcc.setPdfTcc(leitor.getText());
            } catch (SAXException | TikaException ex) {
                Logger.getLogger(CadastrarTCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("ano") != null) {
            int ano = Integer.parseInt(request.getParameter("ano"));
            tcc.setAno(ano);
        }
        if (request.getParameter("palavraChave") != null) {
            String[] palavrasChave = request.getParameterValues("palavraChave");
            List<String> lista = new ArrayList<>();
            lista.addAll(Arrays.asList(palavrasChave));
            tcc.setPalavrasChave(lista);
        }
        
       tcc.setId(service.geradorId()+1);
        return tcc;
    }

}
