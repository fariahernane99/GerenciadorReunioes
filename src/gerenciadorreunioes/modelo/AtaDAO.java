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
public class AtaDAO {

    public boolean cadastrar(Ata ata) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(ata);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean alterar(Ata ata) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.saveOrUpdate(ata);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean deletar(int codigo) {
        boolean conseguiu = false;
        try {
            for (Ata ata : getAtas()) {
                if (codigo == ata.getCodigo()) {
                    Ata a = ata;
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

    public ArrayList<Ata> getAtas() {
        String hql = "SELECT * FROM Ata;";
        ArrayList<Ata> arrayAtas;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Ata.class));//Sem isso aqui impossível de retornar
        List<Ata> listAtas = query.list();
        s.getTransaction().commit();
        arrayAtas = (ArrayList<Ata>) listAtas;
        return arrayAtas;
    }
}
