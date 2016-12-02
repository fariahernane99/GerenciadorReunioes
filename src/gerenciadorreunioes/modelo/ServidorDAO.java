package gerenciadorreunioes.modelo;

import gerenciadorreunioes.controle.GrupoControl;
import gerenciadorreunioes.conexoes.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ServidorDAO {

    public boolean adiciona(Servidor s) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(s);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleta(String siape) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Servidor servidor = manager.find(Servidor.class, siape);
            manager.remove(servidor);
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Servidor s) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Servidor servidor = manager.find(Servidor.class, s.getSiape());
            servidor.setArea(s.getArea());
            servidor.setEmail(s.getEmail());
            servidor.setNome(s.getNome());
            servidor.setSenha(s.getSenha());
            servidor.setSerCoordenador(s.getSerCoordenador());
            servidor.setSerDe(s.getSerDe());
            servidor.setSerResponsavelAta(s.getSerResponsavelAta());
            servidor.setTelefone(s.getTelefone());
            tx.commit();
            manager.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Servidor> getServidores() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Servidor");
        ArrayList<Servidor> servidores = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return servidores;
    }

    public Servidor getServidor(String siape) {
        Servidor serv = null;
        for (Servidor ser : getServidores()) {
            if (ser.getSiape().equals(siape)) {
                serv = ser;
            }
        }
        return serv;
    }

    public ArrayList<Servidor> getMembrosComuns(Servidor serAux) {
        ArrayList<Servidor> array = new ArrayList<>();
        serAux = getServidor(serAux.getSiape());
        array.add(serAux);
        for (Servidor ser : getServidores()) {
            if ((ser.getSerCoordenador() == 0) && (ser.getSerDe() == 0)) {
                array.add(ser);
            }
        }
        return array;
    }

    public ArrayList<Servidor> getServidoresDeUmGrupo(int gruCodigo) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT serSiape, serNome, serTelefone, serEmail,"
                + " serSenha, serArea, serDe, serCoordenador, serResponsavelAta  FROM Servidor"
                + " JOIN Servidor_Grupo JOIN Grupo WHERE serSiape = seg_serSiape AND"
                + " seg_gruCodigo = gruCodigo AND gruCodigo = " + gruCodigo);
        ArrayList<Servidor> servidores = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return servidores;
    }

    public ArrayList<Servidor> getDeCoordenadores() {
        ArrayList<Servidor> array = new ArrayList<>();
        for (Servidor ser : getServidores()) {
            if ((ser.getSerCoordenador() == 1) || (ser.getSerDe() == 1)) {
                array.add(ser);
            }
        }
        return array;
    }

    public ArrayList<Servidor> getServidoresDE() {
        ArrayList<Servidor> array = new ArrayList<>();
        for (Servidor ser : getServidores()) {
            if (ser.getSerDe() == 1) {
                array.add(ser);
            }
        }
        return array;
    }

    public ArrayList<Servidor> getParticipantesDoGrupo(int gruCodigo) {
        GrupoControl grupoControl = new GrupoControl();
        Grupo grupo = grupoControl.getGrupo(gruCodigo);
        ArrayList<Servidor> servidores = new ArrayList<>();
        for (Servidor ser : grupo.getServidores()) {
            servidores.add(ser);
        }
        return servidores;
    }

    public ArrayList<Servidor> getServidoresDaReuniao(int reuCodigo) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT serSiape, serNome, serTelefone, serEmail,"
                + " serSenha, serArea, serDe, serCoordenador, serResponsavelAta  FROM Servidor"
                + " JOIN Servidor_Grupo JOIN Grupo JOIN Reuniao WHERE serSiape = seg_serSiape AND"
                + " seg_gruCodigo = gruCodigo AND reu_gruCodigo = gruCodigo AND reuCodigo = " + reuCodigo);
        ArrayList<Servidor> servidores = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        return servidores;
    }

    public int getCodGrupo(String serSiape) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT gruCodigo FROM Grupo JOIN Servidor_Grupo JOIN Servidor WHERE"
                + " serSiape = seg_serSiape AND seg_gruCodigo = gruCodigo AND"
                + " serSiape = " + serSiape);
        ArrayList<Integer> cod = (ArrayList) query.getResultList();
        int codGrupo = cod.get(0);
        tx.commit();
        manager.close();
        return codGrupo;
    }

}
