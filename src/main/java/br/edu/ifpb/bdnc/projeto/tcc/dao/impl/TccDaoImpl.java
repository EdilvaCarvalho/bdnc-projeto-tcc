
package br.edu.ifpb.bdnc.projeto.tcc.dao.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.TccDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Edilva
 */
public class TccDaoImpl implements TccDAO{

    @Override
    public boolean salvar(TCC tcc) {
        com.mongodb.MongoClient client= new com.mongodb.MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("tcc");
        MongoCollection<Document> colecao= database.getCollection("tcc");
        colecao.insertOne(tcc.toDocument());
        
        Block<Document> printBlock = (final Document document)->{
            TCC tcc1= new TCC().fromDocument(document);
            System.out.println(tcc1);
        };
        
        colecao.find(new Document("id",0))
                .forEach(printBlock);
        client.close();
        return true;
    }

    @Override
    public TCC buscaPorAno(int ano) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TCC buscaPorAutor(String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TCC buscaPorConteudo(String conteudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TCC> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
