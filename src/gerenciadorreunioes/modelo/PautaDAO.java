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

    public void cadastrar(Pauta pau) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(pau);
        s.getTransaction().commit();
    }

    public void alterar(Pauta pau) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(pau);
        s.getTransaction().commit();
    }

    public void deletar(int codigo) {
        for (Pauta pau : getPautas()) {
            if (codigo == pau.getCodigo()) {
                Pauta a = pau;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(a);
                s.getTransaction().commit();
            }
        }
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

    public ArrayList<Grupo> getPautas(String siapeCoordenador) {
        String hql = "SELECT * FROM Pauta WHERE pau_ataCodigo = " + siapeCoordenador + ";";
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