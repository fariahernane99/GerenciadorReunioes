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
 * @author Alunos
 */
public class AlunoDAO {

    private Connection connection;
    
    public AlunoDAO() {
       //inicializa a conexão com o BD
        this.connection =  ConnectionFactory.getConnection();    
    }


    public boolean adiciona(Aluno a) {
        boolean adicionou = false;
        String sql = "insert into Aluno(aluMatricula, aluNome, aluEmail) values (?,?,?);";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, a.getMatricula());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getEmail());
            // executa
            stmt.execute();
            stmt.close();
            adicionou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adicionou;
    }

    public boolean deleta(String matricula) {
        boolean deletou = false;
        String sql = "DELETE FROM Aluno WHERE aluMatricula = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, matricula);

            // executa
            stmt.execute();
            stmt.close();
            deletou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deletou;
    }

    public boolean atualizar(String matricula, String nome, String email, String antMatricula) {
        boolean atualizou = false;
        String sql = "UPDATE Aluno SET aluMatricula = ?, aluNome = ?, aluEmail = ? WHERE aluMatricula = ?;";
        ArrayList<Aluno> a = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            a = getAlunos();
            for (Aluno alu : a) {
                if (alu.getMatricula().equals(antMatricula)) {
                    stmt.setString(1, matricula);
                    stmt.setString(2, nome);
                    stmt.setString(3, email);
                    stmt.setString(4, antMatricula);
                }
            }
            stmt.execute();
            stmt.close();
            atualizou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atualizou;
    }

    public ArrayList<Aluno> getAlunos() {
        String sql = "SELECT * FROM Aluno;";
        ArrayList<Aluno> a = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Aluno x = new Aluno();
                x.setMatricula(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setEmail(rs.getString(3));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

}
