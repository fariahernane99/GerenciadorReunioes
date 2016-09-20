/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Alunos
 */
public class ReuniaoDAO {

    public boolean cadastrar(Reuniao reu) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(reu);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean alterar(Reuniao reu) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.saveOrUpdate(reu);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean deletar(int codigo) {
        boolean conseguiu = false;
        try {
            for (Reuniao reu : getReunioes()) {
                if (codigo == reu.getCodigo()) {
                    Reuniao a = reu;
                    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                    s.beginTransaction();
                    s.delete(a);
                    s.getTransaction().commit();
                }
            }
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public ArrayList<Reuniao> getReunioes() {
        String hql = "SELECT * FROM Reuniao;";
        ArrayList<Reuniao> arrayReunioes;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Reuniao.class));//Sem isso aqui impossível de retornar
        List<Reuniao> listReunioes = query.list();
        s.getTransaction().commit();
        arrayReunioes = (ArrayList<Reuniao>) listReunioes;
        return arrayReunioes;
    }
}
