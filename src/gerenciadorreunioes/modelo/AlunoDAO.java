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
public class AlunoDAO {

    public boolean cadastrar(Aluno alu) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(alu);
            s.getTransaction().commit();
            conseguiu = true;
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean alterar(Aluno alu) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(alu);
            s.getTransaction().commit();
            conseguiu = true;
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean deletar(String matricula) {
        boolean conseguiu = false;
        try {
            for (Aluno alu : getAlunos()) {
                if (matricula.equals(alu.getMatricula())) {
                    Aluno a = alu;
                    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                    s.beginTransaction();
                    s.delete(a);
                    s.getTransaction().commit();
                }
            }
            conseguiu = true;
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public ArrayList<Aluno> getAlunos() {
        String hql = "SELECT * FROM Aluno;";
        ArrayList<Aluno> arrayAlunos;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Aluno.class));//Sem isso aqui impossível de retornar
        List<Aluno> listAlunos = query.list();
        s.getTransaction().commit();
        arrayAlunos = (ArrayList<Aluno>) listAlunos;
        return arrayAlunos;
    }
}
