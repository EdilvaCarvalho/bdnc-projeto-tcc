
package br.edu.ifpb.bdnc.projeto.tcc.domain.enuns;

/**
 *
 * @author Edilva
 */
public enum Area {
    
    BANCOS_DE_DADOS("Bancos de Dados"), 
    ENGENHARIA_DE_SOFTWARE("Engenharia de Software"), 
    REDES("Redes"), 
    SEGURANÇA("Segurança"), 
    ARQUITETURA_DE_SISTEMAS("Arquitetura de Sistemas"), 
    HARDWARE("Hardware"), 
    DESENVOLVIMENTO_DE_SISTEMAS("Desenvolvimento de Sistemas");
    
    private final String descricao;
    
    Area(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    } 
}
