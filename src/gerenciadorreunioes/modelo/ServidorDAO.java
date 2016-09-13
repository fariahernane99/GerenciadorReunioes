package gerenciadorreunioes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServidorDAO {

    private Connection connection;

    public ServidorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean adiciona(Servidor m) {
        boolean adicionou = false;
        String sql = "INSERT INTO Servidor(serSiape, serNome, serTelefone, serEmail, serSenha, serArea, serDE, serCoordenador, serResponsavelATA) VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, m.getSiape());
            stmt.setString(2, m.getNome());
            stmt.setString(3, m.getFone());
            stmt.setString(4, m.getEmail());
            stmt.setString(5, m.getSenha());
            stmt.setString(6, m.getArea());
            stmt.setInt(7, m.getSerDE());
            stmt.setInt(8, m.getSerCoordenador());
            stmt.setInt(9, m.getSerResponsavelATA());
            stmt.execute();
            stmt.close();
            adicionou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adicionou;
    }

    public boolean deleta(String siape) {
        boolean deletou = false;
        String sql = "DELETE FROM Servidor WHERE serSiape = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siape);
            stmt.execute();
            stmt.close();
            deletou = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deletou;
    }

    public boolean atualizar(String siape, String nome, String telefone, String email, String senha, String area, int serResponsavelATA, int serCoordenador, int serDE, String siapeAntigo) {
        boolean atualizou = false;
        String sql = "UPDATE Servidor SET serSiape = ?, serNome = ?, serTelefone = ?, serEmail = ?, serSenha = ?, serArea = ?,  serDE = ?, serCoordenador = ?, serResponsavelATA = ? WHERE serSiape = ?;";
        ArrayList<Servidor> s = getServidores();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (Servidor ser : s) {
                if (ser.getSiape().equals(siapeAntigo)) {
                    stmt.setString(1, siape);
                    stmt.setString(2, nome);
                    stmt.setString(3, telefone);
                    stmt.setString(4, email);
                    stmt.setString(5, senha);
                    stmt.setString(6, area);
                    stmt.setInt(7, serDE);
                    stmt.setInt(8, serCoordenador);
                    stmt.setInt(9, serResponsavelATA);
                    stmt.setString(10, siapeAntigo);
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

    public ArrayList<Servidor> getServidores() {
        String sql = "SELECT * FROM Servidor;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<Servidor> getMembrosComuns() {
        String sql = "SELECT * FROM Servidor WHERE serDe = 0 AND serCoordenador = 0;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<Servidor> getServidores(String siapeCoordenador) {
        String sql = "SELECT * FROM Servidor JOIN Servidor_Grupo JOIN Grupo WHERE serSiape = seg_serSiape AND seg_gruCodigo = gruCodigo AND gruSiapeCoordenador = ?;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siapeCoordenador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<Servidor> getCoordenadores() {
        String sql = "SELECT * FROM Servidor WHERE serCoordenador = 1;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<Servidor> getServidoresDE() {
        String sql = "SELECT * FROM Servidor WHERE serDe = 1;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public ArrayList<Servidor> getParticipantesDoGrupo(int gruCodigo) {
        String sql = "SELECT serSiape, serNome, serTelefone, serEmail, serSenha, serArea, serDe, serCoordenador, serResponsavelAta "
                + "FROM Servidor JOIN Servidor_Grupo JOIN Grupo "
                + "WHERE serSiape = seg_serSiape AND gruCodigo = seg_gruCodigo AND gruCodigo = ?;";
        ArrayList<Servidor> s = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gruCodigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor x = new Servidor();
                x.setSiape(rs.getString(1));
                x.setNome(rs.getString(2));
                x.setFone(rs.getString(3));
                x.setEmail(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setArea(rs.getString(6));
                x.setSerDE(rs.getInt(7));
                x.setSerCoordenador(rs.getInt(8));
                x.setSerResponsavelATA(rs.getInt(9));
                s.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

}
