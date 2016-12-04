/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import gerenciadorreunioes.conexoes.JpaUtil;
import gerenciadorreunioes.controle.GrupoControl;
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
            GrupoControl grupoControl = new GrupoControl();
            for (int i = 0; i < grupoControl.getGrupos().size(); i++) {
                if (grupoControl.getGrupos().get(i).getAlunos().contains(aluno)) {
                    grupoControl.getGrupos().get(i).getAlunos().remove(aluno);
                    grupoControl.atualiza(grupoControl.getGrupos().get(i));
                }
            }
            manager.remove(aluno);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Aluno a) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Aluno aluno = manager.find(Aluno.class, a.getMatricula());
            aluno.setNome(a.getNome());
            aluno.setEmail(a.getEmail());
            tx.commit();
            manager.close();
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
        return alunos;
    }

    public ArrayList<Aluno> getAlunosParticipantesDoGrupo(int gruCodigo) {
        GrupoControl grupoControl = new GrupoControl();
        Grupo grupo = grupoControl.getGrupo(gruCodigo);
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Aluno alu : grupo.getAlunos()) {
            alunos.add(alu);
        }
        return alunos;
    }

    public ArrayList<Aluno> getAlunosDeUmGrupo(int gruCodigo) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT aluMatricula, aluNome, aluEmail FROM Aluno"
                + " JOIN Aluno_Grupo JOIN Grupo WHERE aluMatricula = alg_aluMatricula AND"
                + " alg_gruCodigo = gruCodigo AND gruCodigo = " + gruCodigo);
        ArrayList<Aluno> alunos = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return alunos;
    }

    public ArrayList<Aluno> getAlunosDaReuniao(int reuCodigo) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT aluMatricula, aluNome, aluEmail FROM Aluno"
                + " JOIN Aluno_Grupo JOIN Grupo JOIN Reuniao WHERE aluMatricula = alg_aluMatricula AND"
                + " alg_gruCodigo = gruCodigo AND reu_gruCodigo = gruCodigo AND reuCodigo = " + reuCodigo);
        ArrayList<Aluno> alunos = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return alunos;
    }

}
