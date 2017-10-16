
package br.edu.ifpb.bdnc.projeto.tcc.domain.entidades;

import br.edu.ifpb.bdnc.projeto.tcc.domain.enuns.Area;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.bson.Document;

/**
 *
 * @author Edilva
 */

public class TCC implements Serializable{
    
    private int id;
    private String titulo;
    private String autor;
    private String orientador;
    private List<String> palavrasChave;
    private String resumo;
    private int ano;
    private Area area;
    private String pdfTcc;

    public TCC() {
    }

    public TCC(String titulo, String autor, String orientador, List<String> palavrasChave, String resumo, int ano, Area area, String pdfTcc) {
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.ano = ano;
        this.area = area;
        this.pdfTcc = pdfTcc;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(List<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getPdfTcc() {
        return pdfTcc;
    }

    public void setPdfTcc(String pdfTcc) {
        this.pdfTcc = pdfTcc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.autor);
        hash = 17 * hash + Objects.hashCode(this.orientador);
        hash = 17 * hash + Objects.hashCode(this.palavrasChave);
        hash = 17 * hash + Objects.hashCode(this.resumo);
        hash = 17 * hash + this.ano;
        hash = 17 * hash + Objects.hashCode(this.area);
        hash = 17 * hash + Objects.hashCode(this.pdfTcc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TCC other = (TCC) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.orientador, other.orientador)) {
            return false;
        }
        if (!Objects.equals(this.resumo, other.resumo)) {
            return false;
        }
        if (!Objects.equals(this.pdfTcc, other.pdfTcc)) {
            return false;
        }
        if (!Objects.equals(this.palavrasChave, other.palavrasChave)) {
            return false;
        }
        if (this.area != other.area) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TCC{" + "titulo=" + titulo + ", autor=" + autor + ", orientador=" + orientador + ", palavrasChave=" + palavrasChave + ", resumo=" + resumo + ", ano=" + ano + ", area=" + area + ", pdfTcc=" + pdfTcc + '}';
    }
    
     public Document toDocument() {
        Document doc = new Document()
                .append("_id", id)
                .append("titulo", titulo)
                .append("autor", autor)
                .append("ano", ano)
                .append("area",area.toString())
                .append("orientador", orientador)
                .append("palavras-chave", palavrasChave.toString())
                .append("resumo", resumo)
                .append("pdf", pdfTcc);
        return doc;
    }
      public TCC fromDocument(Document doc) {
        id = doc.getInteger("_id");
        titulo= doc.getString("titulo");
        area= doc.get("area",Area.class);
        return this;
    }
}
