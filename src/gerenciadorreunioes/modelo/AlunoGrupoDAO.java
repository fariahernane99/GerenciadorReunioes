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
 * @author Hernane Faria
 */
public class AlunoGrupoDAO {

    public boolean cadastrar(AlunoGrupo aluGrupo) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(aluGrupo);
            s.getTransaction().commit();
            conseguiu = true;
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean deletar(int codigo, String matricula) {
        boolean conseguiu = false;
        try {
            for (AlunoGrupo alg : getAlunosGrupos()) {
                if ((alg.getAluno().getMatricula().equals(matricula)) && (alg.getGrupo().getCodigo() == codigo)) {
                    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                    s.beginTransaction();
                    s.delete(alg);
                    s.getTransaction().commit();
                }
            }
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public boolean alterar(AlunoGrupo aluGrupo) {
        boolean conseguiu = false;
        try {
            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.saveOrUpdate(aluGrupo);
            s.getTransaction().commit();
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }

    public ArrayList<AlunoGrupo> getAlunosGrupos() {
        String hql = "SELECT * FROM Aluno_Grupo;";
        ArrayList<AlunoGrupo> arrayAlunosGrupos;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(AlunoGrupo.class));//Sem isso aqui impossível de retornar
        List<AlunoGrupo> listAlunosGrupos = query.list();
        s.getTransaction().commit();
        arrayAlunosGrupos = (ArrayList<AlunoGrupo>) listAlunosGrupos;
        return arrayAlunosGrupos;
    }

    public ArrayList<AlunoGrupo> getAlunosGrupos(int codigo) {
        String hql = "SELECT * FROM Aluno_Grupo WHERE alg_gruCodigo = " + codigo + ";";
        ArrayList<AlunoGrupo> arrayAlunosGrupos;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(AlunoGrupo.class));//Sem isso aqui impossível de retornar
        List<AlunoGrupo> listAlunosGrupos = query.list();
        s.getTransaction().commit();
        arrayAlunosGrupos = (ArrayList<AlunoGrupo>) listAlunosGrupos;
        return arrayAlunosGrupos;
    }

    public boolean removeTodosAlunosDoGrupo(int codigo) {
        boolean conseguiu = false;
        try {
            for (AlunoGrupo alg : getAlunosGrupos()) {
                if (codigo == alg.getGrupo().getCodigo()) {
                    deletar(alg.getGrupo().getCodigo(), alg.getAluno().getMatricula());
                }
            }
        } catch (Exception e) {
            conseguiu = false;
        }
        return conseguiu;
    }
}
