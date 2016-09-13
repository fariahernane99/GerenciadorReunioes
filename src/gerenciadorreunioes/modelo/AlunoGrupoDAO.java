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

/**
 *
 * @author Hernane Faria
 */
public class AlunoGrupoDAO {
    
    private Connection connection;

    public AlunoGrupoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean adiciona(String matricula, int codigoGrupo) {
        String sql = "INSERT INTO Aluno_Grupo(alg_aluMatricula, alg_gruCodigo) VALUES (?,?);";
        boolean adicionou = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, matricula);
            stmt.setInt(2, codigoGrupo);
            stmt.execute();
            stmt.close();
            adicionou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adicionou;
    }
    
    public ArrayList<AlunoGrupo> getAlunosGrupos() {
        String sql = "SELECT * FROM Aluno_Grupo;";
        ArrayList<AlunoGrupo> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AlunoGrupo x = new AlunoGrupo();
                x.setCodigo(rs.getInt(1));
                x.setAlg_aluMatricula(rs.getString(2));
                x.setAlg_gruCodigo(rs.getInt(3));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    
    public ArrayList<AlunoGrupo> getAlunosGrupos(int gruCodigo) {
        String sql = "SELECT * FROM Aluno_Grupo WHERE alg_gruCodigo = ?;";
        ArrayList<AlunoGrupo> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gruCodigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AlunoGrupo x = new AlunoGrupo();
                x.setCodigo(rs.getInt(1));
                x.setAlg_aluMatricula(rs.getString(2));
                x.setAlg_gruCodigo(rs.getInt(3));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public boolean removeTodosAlunosDoGrupo(int gruCodigo) {
        boolean removeu = false;
        String sql = "DELETE FROM Aluno_Grupo WHERE alg_gruCodigo = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gruCodigo);
            stmt.execute();
            stmt.close();
            removeu = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return removeu;
    }
    
}
