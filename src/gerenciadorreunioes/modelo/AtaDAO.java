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
public class AtaDAO {

    private Connection connection;

    public AtaDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean adiciona(Ata a) {
        boolean adicionou = false;
        String sql = "insert into ATA(ataStatus,ata_reuCodigo) values (?,?);";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, a.getAtaStatus());
            stmt.setInt(2, a.getAta_reuCodigo());
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
        String sql = "DELETE FROM ATA WHERE ataCodigo = ?;";
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

    public boolean atualizar(int codigo, String status) {
        boolean atualizou = false;
        String sql = "UPDATE ATA SET ataStatus=?;";
        ArrayList<Ata> a = new ArrayList<Ata>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            a = getAtas();
            for (Ata ata : a) {
                if (ata.getAtaCodigo() == codigo) {
                    stmt.setString(1, status);
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

    public ArrayList<Ata> getAtas() {
        String sql = "SELECT * FROM ATA;";
        ArrayList<Ata> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Ata x = new Ata();
                x.setAtaCodigo(rs.getInt(1));
                x.setAtaStatus(rs.getString(2));
                x.setAta_reuCodigo(rs.getInt(3));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

}
