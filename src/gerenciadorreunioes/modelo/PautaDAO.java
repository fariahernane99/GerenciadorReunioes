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
public class PautaDAO {

    public boolean cadastrar(Pauta pau) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(pau);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean alterar(Pauta pau) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.saveOrUpdate(pau);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean deletar(int codigo) {
        boolean conseguiu = false;
        try {
            for (Pauta pau : getPautas()) {
                if (codigo == pau.getCodigo()) {
                    Pauta a = pau;
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

    public ArrayList<Pauta> getPautas() {
        String hql = "SELECT * FROM Pauta;";
        ArrayList<Pauta> arrayPautas;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Pauta.class));//Sem isso aqui impossível de retornar
        List<Pauta> listPautas = query.list();
        s.getTransaction().commit();
        arrayPautas = (ArrayList<Pauta>) listPautas;
        return arrayPautas;
    }

    public ArrayList<Pauta> getPautas(int codAta) {
        String hql = "SELECT * FROM Pauta WHERE pau_ataCodigo = " + codAta + ";";
        ArrayList<Pauta> arrayPautas;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Grupo.class));//Sem isso aqui impossível de retornar
        List<Pauta> listPautas = query.list();
        s.getTransaction().commit();
        arrayPautas = (ArrayList<Pauta>) listPautas;
        return arrayPautas;
    }

}
