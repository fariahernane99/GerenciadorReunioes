/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author GAMBÁ
 */
public class GrupoDAO {

    public void cadastrar(Grupo alu) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(alu);
        s.getTransaction().commit();
    }

    public void alterar(Grupo alu) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(alu);
        s.getTransaction().commit();
    }

    public void deletar(int codigo) {
        for (Grupo gru : getGrupos()) {
            if (codigo == gru.getCodigo()) {
                Grupo a = gru;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(a);
                s.getTransaction().commit();
            }
        }
    }

    public ArrayList<Grupo> getGrupos() {
        String hql = "SELECT * FROM Grupo;";
        ArrayList<Grupo> arrayGrupos;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Grupo.class));//Sem isso aqui impossível de retornar
        List<Grupo> listGrupos = query.list();
        s.getTransaction().commit();
        arrayGrupos = (ArrayList<Grupo>) listGrupos;
        return arrayGrupos;
    }

    public ArrayList<Grupo> getGrupos(String siapeCoordenador) {
        String hql = "SELECT * FROM Grupo WHERE gruSiapeCoordenador = '" + siapeCoordenador + "';";
        ArrayList<Grupo> arrayGrupos;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Grupo.class));//Sem isso aqui impossível de retornar
        List<Grupo> listGrupos = query.list();
        s.getTransaction().commit();
        arrayGrupos = (ArrayList<Grupo>) listGrupos;
        return arrayGrupos;
    }
}
