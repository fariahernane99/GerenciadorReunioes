/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import gerenciadorreunioes.jpa.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Alunos
 */
public class AlunoDAO {

    public boolean adiciona(Aluno a) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(a);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleta(String matricula) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Aluno aluno = manager.find(Aluno.class, matricula);
            manager.remove(aluno);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(String matricula, String nome, String email, String antMatricula) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Aluno aluno = manager.find(Aluno.class, antMatricula);
            aluno.setMatricula(matricula);
            aluno.setNome(nome);
            aluno.setEmail(email);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Aluno> getAlunos() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Aluno");
        ArrayList<Aluno> alunos = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        JpaUtil.close();
        return alunos;
    }

}
