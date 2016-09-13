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
public class PautaDAO {

    private Connection connection;
    
    public PautaDAO() {
       //inicializa a conexão com o BD
        this.connection =  ConnectionFactory.getConnection();    
    }
    

    public boolean adiciona(Pauta p) {
        boolean adicionou = false;
        String sql = "insert into Pauta(pauTitulo,pauDefinicao,pau_ataCodigo,pauEncaminhamento) values (?,?,?,?);";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, p.getPauTitulo());
            stmt.setString(2, p.getPauDefinicao());
            stmt.setInt(3, p.getPau_ataCodigo());
            stmt.setString(4, p.getEncaminhamento());
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
        String sql = "DELETE FROM Pauta WHERE pauCodigo = ?;";
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

    public boolean atualizar(int codigo, String titulo, String definicao, String encaminhamento, int pau_ataCodigo) {
        boolean atualizou = false;
        String sql = "UPDATE Pauta SET pauTitulo = ?, pauDefinicao = ?, pauEncaminhamento = ?, pau_ataCodigo = ? WHERE pauCodigo=?;";
        ArrayList<Pauta> a = new ArrayList<>();
        a=getPautas();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (Pauta pauta : a) {
                if (pauta.getPauCodigo() == codigo) {
                    stmt.setString(1, titulo);
                    stmt.setString(2, definicao);
                    stmt.setString(3, encaminhamento);
                    stmt.setInt(4, pau_ataCodigo);
                    stmt.setInt(5, codigo);
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

    public ArrayList<Pauta> getPautas() {
        String sql = "SELECT * FROM Pauta;";
        ArrayList<Pauta> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Pauta x = new Pauta();
                x.setPauCodigo(rs.getInt(1));
                x.setPauTitulo(rs.getString(2));
                x.setPauDefinicao(rs.getString(3));
                x.setPau_ataCodigo(rs.getInt(4));
                x.setEncaminhamento(rs.getString(5));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public ArrayList<Pauta> getPautas(int codAta) {
        String sql = "SELECT * FROM Pauta WHERE pau_ataCodigo = ?;";
        ArrayList<Pauta> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codAta);
            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Pauta x = new Pauta();
                x.setPauCodigo(rs.getInt(1));
                x.setPauTitulo(rs.getString(2));
                x.setPauDefinicao(rs.getString(3));
                x.setPau_ataCodigo(rs.getInt(4));
                x.setEncaminhamento(rs.getString(5));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
}
