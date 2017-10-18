package br.edu.ifpb.bdnc.projeto.tcc.dao.impl;

import br.edu.ifpb.bdnc.projeto.tcc.dao.interfaces.TccDAO;
import br.edu.ifpb.bdnc.projeto.tcc.domain.entidades.TCC;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

/**
 *
 * @author Edilva
 */
public class TccDaoImpl implements TccDAO {

    private Session session;
    com.mongodb.MongoClient client = new com.mongodb.MongoClient("localhost", 27017);
    MongoDatabase database = client.getDatabase("tcc");
    MongoCollection<Document> colecao = database.getCollection("tcc");

    public TccDaoImpl() {
        session = conectarNeo4J();
    }

    @Override
    public boolean salvar(TCC tcc) {
        colecao.insertOne(tcc.toDocument());
        Block<Document> printBlock = (final Document document) -> {
            TCC tcc1 = new TCC().fromDocument(document);
            System.out.println(tcc1);
        };

        colecao.find(new Document("id", tcc.getId()))
                .forEach(printBlock);
        System.out.println(printBlock);
        client.close();
        return true;
    }

    public int geradorId() {
            int qnt = (int) colecao.count();
            return qnt;
    }

    @Override
    public List<TCC> buscaPorAno(int ano) {
         Block<Document> printBlock = (final Document document) -> {
            TCC tcc1 = new TCC().fromDocument(document);
            System.out.println(tcc1);
        };

        colecao.find(new Document("ano", ano))
                .forEach(printBlock);
        System.out.println(printBlock);
        client.close();
        return null;
    }

    @Override
    public List<TCC> buscaPorAutor(String autor) {
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

    public Session conectarNeo4J() {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "123"));
        return driver.session();
    }

    @Override
    public boolean salvarNeo4J(TCC tcc) {
        criarNo(tcc);
        criarRelacao(tcc);
        session.close();
        return true;
    }

    public void criarNo(TCC tcc) {
        if (!noTccExistente(tcc.getId())) {
            session.run("CREATE (:Tcc{id: $id})",
                    Values.parameters("id", tcc.getId()));
        }
        if (!noAreaExistente(tcc.getArea().toString())) {
            session.run("CREATE (:Area{area: $area})",
                    Values.parameters("area", tcc.getArea().toString()));
        }
        if (!noOrientadorExistente(tcc.getOrientador())) {
            session.run("CREATE (:Orientador{nome: $nome})",
                    Values.parameters("nome", tcc.getOrientador()));
        }
    }

    public boolean noTccExistente(int id) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (t:Tcc) "
                + "WHERE t.id = $id "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("id", id));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public boolean noAreaExistente(String area) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (a:Area) "
                + "WHERE a.area = $area "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("area", area));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public boolean noOrientadorExistente(String nome) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (o:Orientador) "
                + "WHERE o.nome = $nome "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("nome", nome));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public void sessionClose() {
        session.close();
    }

    public void criarRelacao(TCC tcc) {
        session.run("MATCH (t:Tcc{id:$id}), (a:Area{area:$area}), (o:Orientador{nome:$nome}) "
                + "CREATE (t)-[r:PERTENCE]->(a), (t)-[r1:ORIENTADOR]->(o)",
                Values.parameters("id", tcc.getId(), "area", tcc.getArea().toString(),
                        "nome", tcc.getOrientador()));
    }

}
