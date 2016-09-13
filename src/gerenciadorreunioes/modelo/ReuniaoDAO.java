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
public class ReuniaoDAO {

    private Connection connection;

    public ReuniaoDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean adiciona(Reuniao m) {
        boolean adicionou = false;
        String sql = "insert into Reuniao(reuNome,reuData,reuHorarioInicio,reuHorarioFim,reuLocal,reuSiapeResponsavelAta,reu_gruCodigo) values (?,?,?,?,?,?,?);";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getData());
            stmt.setString(3, m.getReuHorarioInicio());
            stmt.setString(4, m.getReuHorarioFim());
            stmt.setString(5, m.getReuLocal());
            stmt.setInt(6, m.getReuSiapeResponsavelATA());
            stmt.setInt(7, m.getReu_gruCodigo());
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
        String sql = "delete from Reuniao where reuCodigo = ?;";
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

    public boolean atualizar(int codigo, String nome, String data, String horarioInicio, String horarioFim, String local, int reuSiapeResponsavelATA, int reu_gruCodigo) {
        boolean atualizou = false;
        String sql = "update Reuniao set reuCodigo=?, reuNome=?, reuData=?, reuHorarioInicio=?, reuHorarioFim=?, reuLocal=?, reuSiapeResponsavelATA=?, reu_gruCodigo=? where reuCodigo=?;";
        ArrayList<Reuniao> s = new ArrayList<Reuniao>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            s = getReunioes();
            for (Reuniao reu : s) {
                if (reu.getCodigo() == codigo) {
                    stmt.setInt(1, codigo);
                    stmt.setString(2, nome);
                    stmt.setString(3, data);
                    stmt.setString(4, horarioInicio);
                    stmt.setString(5, horarioFim);
                    stmt.setString(6, local);
                    stmt.setInt(7, reuSiapeResponsavelATA);
                    stmt.setInt(8, reu_gruCodigo);

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
    
    public boolean atualizarFinal(int codigo,String horarioInicio,String horarioFim, String local) {
        boolean atualizou = false;
        String sql = "update Reuniao set reuHorarioInicio = ?, reuHorarioFim = ?, reuLocal = ?  where reuCodigo = ?;";
        ArrayList<Reuniao> s = new ArrayList<Reuniao>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            s = getReunioes();
            for (Reuniao reu : s) {
                if (reu.getCodigo() == codigo) {
                    stmt.setString(1, horarioInicio);
                    stmt.setString(2, horarioFim);
                    stmt.setString(3, local);
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

    public ArrayList<Reuniao> getReunioes() {
        String sql = "select * from Reuniao;";
        ArrayList<Reuniao> s = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Reuniao x = new Reuniao();
                x.setCodigo(rs.getInt(1));
                x.setNome(rs.getString(2));
                x.setData(rs.getString(3));
                x.setReuHorarioInicio(rs.getString(4));
                x.setReuHorarioFim(rs.getString(5));
                x.setReuLocal(rs.getString(6));
                x.setReuSiapeResponsavelATA(rs.getInt(7));
                x.setReu_gruCodigo(rs.getInt(8));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

}
