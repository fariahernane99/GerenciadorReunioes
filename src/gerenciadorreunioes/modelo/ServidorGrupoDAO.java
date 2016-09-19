/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Alunos
 */
public class ServidorGrupoDAO {
    
    public void cadastrar(ServidorGrupo ser) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(ser);
        s.getTransaction().commit();
    }

    public ArrayList<ServidorGrupo> getServidoresGrupos() {
        String hql = "SELECT * FROM Servidor_Grupo;";
        ArrayList<ServidorGrupo> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<ServidorGrupo> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<ServidorGrupo>) listServidores;
        return arrayServidores;
    }
    
    public ArrayList<ServidorGrupo> getServidoresGrupos(int gruCodigo) {
        String hql = "SELECT * FROM Servidor_Grupo WHERE seg_gruCodigo = " + gruCodigo + ";";
        ArrayList<ServidorGrupo> arrayServidores;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Servidor.class));//Sem isso aqui impossível de retornar
        List<ServidorGrupo> listServidores = query.list();
        s.getTransaction().commit();
        arrayServidores = (ArrayList<ServidorGrupo>) listServidores;
        return arrayServidores;
    }
    
    public void deletar(int codigo, String matricula) {
        for (ServidorGrupo ser : getServidoresGrupos()) {
            if ((ser.getServidor().getSiape().equals(matricula)) && (ser.getGrupo().getCodigo() == codigo)) {
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(ser);
                s.getTransaction().commit();
            }
        }
    }
    
    public void removeTodosAlunosDoGrupo(int codigo) {
        for (ServidorGrupo ser : getServidoresGrupos()) {
            if (codigo == ser.getGrupo().getCodigo()) {
                deletar(ser.getGrupo().getCodigo(), ser.getServidor().getSiape());
            }
        }
    }

}