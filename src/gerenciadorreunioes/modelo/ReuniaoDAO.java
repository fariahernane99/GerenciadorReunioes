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
public class ReuniaoDAO {

    public boolean adiciona(Reuniao r) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(r);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleta(int codigo) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Reuniao reuniao = manager.find(Reuniao.class, codigo);
            manager.remove(reuniao);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Reuniao r) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Reuniao reuniao = manager.find(Reuniao.class, r.getCodigo());
            reuniao.setData(r.getData());
            reuniao.setNome(r.getNome());
            reuniao.setHorarioInicio(r.getHorarioInicio());
            reuniao.setHorarioFim(r.getHorarioFim());
            reuniao.setLocal(r.getLocal());
            reuniao.setSiapeResponsavelAta(r.getSiapeResponsavelAta());
            reuniao.setGrupo(r.getGrupo());
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Reuniao> getReunioes() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Reuniao");
        ArrayList<Reuniao> reunioes = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        JpaUtil.close();
        return reunioes;
    }

    public ArrayList<Reuniao> retornaReunioesDeUmGrupo(int codGrupo) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT * FROM Reuniao WHERE"
                + " reu_gruCodigo = " + codGrupo + ";");
        ArrayList<Reuniao> reunioes = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        JpaUtil.close();
        return reunioes;
    }

}
