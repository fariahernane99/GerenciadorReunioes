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
public class AtaDAO {

    public boolean adiciona(Ata a) {
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

    public boolean deleta(int codigo) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Ata ata = manager.find(Ata.class, codigo);
            manager.remove(ata);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Ata a) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Ata ata = manager.find(Ata.class, a.getCodigo());
            ata.setStatus(a.getStatus());
            ata.setReuniao(a.getReuniao());
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Ata> getAtas() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Ata");
        ArrayList<Ata> atas = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return atas;
    }

    public Ata getAtas(int codReuniao) {
        Ata a = null;
        for (Ata ata : getAtas()) {
            if (ata.getReuniao().getCodigo() == codReuniao) {
                a = ata;
            }
        }
        return a;
    }

}
