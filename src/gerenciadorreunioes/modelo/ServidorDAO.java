package gerenciadorreunioes.modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class ServidorDAO {
    
    public void cadastrar(Servidor ser) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(ser);
        s.getTransaction().commit();
    }

    public void alterar(Servidor ser) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(ser);
        s.getTransaction().commit();
    }

    public void deletar(String siape) {
        for (Servidor ser : getServidores()) {
            if (siape.equals(ser.getSiape())) {
                Servidor a = ser;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(a);
                s.getTransaction().commit();
            }
        }
    }

    public ArrayList<Servidor> getServidores() {
        String hql = "SELECT * FROM Servidor;";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<Servidor> getMembrosComuns() {
        String hql = "SELECT * FROM Servidor WHERE serDe = 0 AND serCoordenador = 0;";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<Servidor> getServidores(String siapeCoordenador) {
        String hql = "SELECT * FROM Servidor JOIN Servidor_Grupo JOIN Grupo WHERE serSiape = seg_serSiape AND seg_gruCodigo = gruCodigo AND gruSiapeCoordenador = " + siapeCoordenador + ";";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<Servidor> getCoordenadores() {
        String hql = "SELECT * FROM Servidor WHERE serCoordenador = 1;";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<Servidor> getServidoresDE() {
        String hql = "SELECT * FROM Servidor WHERE serDe = 1;";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<Servidor> getParticipantesDoGrupo(int gruCodigo) {
        String hql = "SELECT serSiape, serNome, serTelefone, serEmail, serSenha, serArea, serDe, serCoordenador, serResponsavelAta "
                + "FROM Servidor JOIN Servidor_Grupo JOIN Grupo "
                + "WHERE serSiape = seg_serSiape AND gruCodigo = seg_gruCodigo AND gruCodigo = ?;";
        ArrayList<Servidor> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<Servidor> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<Servidor>) listServidores;
        return arrayServidores;
    }
    
}