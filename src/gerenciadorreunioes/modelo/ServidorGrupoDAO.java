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
public class ServidorGrupoDAO {

    private Connection connection;

    public ServidorGrupoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean adiciona(String siapeMembro, int codigoGrupo) {
        String sql = "INSERT INTO Servidor_Grupo(seg_serSiape, seg_gruCodigo) VALUES (?,?);";
        boolean adicionou = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siapeMembro);
            stmt.setInt(2, codigoGrupo);
            stmt.execute();
            stmt.close();
            adicionou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adicionou;
    }

    public ArrayList<ServidorGrupo> getServidoresGrupos() {
        String sql = "SELECT * FROM Servidor_Grupo;";
        ArrayList<ServidorGrupo> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServidorGrupo x = new ServidorGrupo();
                x.setCodigo(rs.getInt(1));
                x.setSeg_serSiape(rs.getString(2));
                x.setSeg_gruCodigo(rs.getInt(3));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<ServidorGrupo> getServidoresGrupos(int gruCodigo) {
        String sql = "SELECT * FROM Servidor_Grupo WHERE seg_gruCodigo = ?;";
        ArrayList<ServidorGrupo> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gruCodigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServidorGrupo x = new ServidorGrupo();
                x.setCodigo(rs.getInt(1));
                x.setSeg_serSiape(rs.getString(2));
                x.setSeg_gruCodigo(rs.getInt(3));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public boolean removeTodosServidoresDoGrupo(int gruCodigo) {
        boolean removeu = false;
        String sql = "DELETE FROM Servidor_Grupo WHERE seg_gruCodigo = ?;";
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
