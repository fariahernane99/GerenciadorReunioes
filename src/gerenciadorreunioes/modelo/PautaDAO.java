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
public class PautaDAO {

    public boolean adiciona(Pauta p) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(p);
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
            Pauta pauta = manager.find(Pauta.class, codigo);
            manager.remove(pauta);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Pauta p) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Pauta pauta = manager.find(Pauta.class, p.getCodigo());
            pauta.setDefinicao(p.getDefinicao());
            pauta.setEncaminhamento(p.getEncaminhamento());
            pauta.setTitulo(p.getTitulo());
            pauta.setAta(p.getAta());
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Pauta> getPautas() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Pauta");
        ArrayList<Pauta> pautas = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        JpaUtil.close();
        return pautas;
    }

    public ArrayList<Pauta> getPautas(int codAta) {
        ArrayList<Pauta> array = new ArrayList<>();
        for (Pauta pau : getPautas()) {
            if (pau.getAta().getCodigo() == codAta) {
                array.add(pau);
            }
        }
        return array;
    }

}
