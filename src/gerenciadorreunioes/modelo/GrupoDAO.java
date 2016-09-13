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
 * @author GAMBÁ
 */
public class GrupoDAO {

    // a conexão com o banco de dados
    private Connection connection;
    
    public GrupoDAO() {
       //inicializa a conexão com o BD
        this.connection =  ConnectionFactory.getConnection();    
    }
    

    public boolean adiciona(Grupo g) {
        String sql = "insert into Grupo(gruNome, gruDescricao, gruSiapeCoordenador) values (?,?,?);";
        boolean adicionou = false;

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, g.getNome());
            stmt.setString(2, g.getDescricao());
            stmt.setString(3, g.getSiapeCoordenador());
            // executa
            stmt.execute();
            stmt.close();
            adicionou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adicionou;
    }

    public boolean deleta(int codigo) {
        boolean deletou = false;
        String sql = "delete from Grupo where gruCodigo = ?;";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa
            stmt.execute();
            stmt.close();
            deletou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deletou;
    }

    public boolean atualizar(int codigo, String nome, String descricao, String siapeCoordenador) {
        boolean atualizou = false;
        String sql = "UPDATE Grupo SET gruNome = ?, gruDescricao = ?, gruSiapeCoordenador = ? WHERE gruCodigo = ?;";
        ArrayList<Grupo> g = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            g = getGrupos();
            for (Grupo gru : g) {
                if (gru.getCodigo() == codigo) {
                    stmt.setString(1, nome);
                    stmt.setString(2, descricao);
                    stmt.setString(3, siapeCoordenador);
                    stmt.setInt(4, codigo);
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

    public ArrayList<Grupo> getGrupos() {
        String sql = "select * from Grupo;";
        ArrayList<Grupo> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Grupo x = new Grupo();
                x.setCodigo(rs.getInt(1));
                x.setNome(rs.getString(2));
                x.setDescricao(rs.getString(3));
                x.setSiapeCoordenador(rs.getString(4));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public ArrayList<Grupo> getGrupos(String siapeCoordenador) {
        String sql = "SELECT * FROM Grupo WHERE gruSiapeCoordenador = ?;";
        ArrayList<Grupo> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, siapeCoordenador);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Grupo x = new Grupo();
                x.setCodigo(rs.getInt(1));
                x.setNome(rs.getString(2));
                x.setDescricao(rs.getString(3));
                x.setSiapeCoordenador(rs.getString(4));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

}
