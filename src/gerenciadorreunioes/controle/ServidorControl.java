/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ServidorControl {

    private ServidorDAO servidorDao = new ServidorDAO();
    private ArrayList<Servidor> arrayServidores;
    private ArrayList<Servidor> arrayCoordenadores;
    private static MessageDigest md = null;

    public boolean verificaCampos(String text, String text0, String text1, String text2, String text3) {
        boolean verifica = false;
        if ((text.equals("")) || (text0.equals("")) || (text1.equals("")) || (text2.equals("")) || (text3.equals(""))) {
            verifica = true;
        }
        return verifica;
    }

    public boolean adiciona(Servidor x) {
        return servidorDao.adiciona(x);
    }

    public boolean atualiza(Servidor x) {
        return servidorDao.atualizar(x);
    }

    public boolean deleta(String siape) {
        return servidorDao.deleta(siape);
    }

    public ArrayList<Servidor> getServidores() {
        return servidorDao.getServidores();
    }

    public ArrayList<Servidor> getCoordenadores() {
        return servidorDao.getDeCoordenadores();
    }

    public ArrayList<Servidor> getServidoresDE() {
        return servidorDao.getServidoresDE();
    }

    public ArrayList<Servidor> getMembrosComuns(Servidor serAux) {
        return servidorDao.getMembrosComuns(serAux);
    }

    public ArrayList<Servidor> getServidoresParticipantesDoGrupo(int gruCodigo) {
        return servidorDao.getServidoresParticipantesDoGrupo(gruCodigo);
    }

    public String[] retornaSiapeNomeEmVetor(ArrayList<Servidor> arrayServ) {
        String[] arrayString = new String[arrayServ.size()];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayServ.get(i).getSiape() + " - " + arrayServ.get(i).getNome();
        }
        return arrayString;
    }
    
    public String retornaSiapeNomeEmString(String siape){
        Servidor s = servidorDao.getServidor(siape);
        return s.getSiape() + " - " + s.getNome();
    }

    public ArrayList<String> pegaSiapeNomeCoordenadores(Servidor serAux) {
        ArrayList<String> nomeServidores = new ArrayList<>();
        arrayServidores = servidorDao.getDeCoordenadores();
        // for responsavel por deixar o servidor logado em primeiro na getServidores
        for (int i = 0; i < arrayServidores.size(); i++) {
            if (arrayServidores.get(i).equals(serAux)) {
                nomeServidores.add(arrayServidores.get(i).getSiape() + " - " + arrayServidores.get(i).getNome());
            }
        }
        // for responsavel por deixar os servidores da DE em seguida na getServidores
        for (int i = 0; i < arrayServidores.size(); i++) {
            if ((!arrayServidores.get(i).equals(serAux)) && (arrayServidores.get(i).getSerDe() == 1)) {
                nomeServidores.add(arrayServidores.get(i).getSiape() + " - " + arrayServidores.get(i).getNome());
            }
        }
        // for responsavel por deixar os demais coordenadores em seguida na getServidores
        for (int i = 0; i < arrayServidores.size(); i++) {
            if ((!arrayServidores.get(i).equals(serAux)) && (arrayServidores.get(i).getSerCoordenador() == 1)) {
                nomeServidores.add(arrayServidores.get(i).getSiape() + " - " + arrayServidores.get(i).getNome());
            }
        }
        return nomeServidores;
    }

    public ArrayList<String> pegaSiapeNomeServidores() {
        ArrayList<String> nomeGrupos = new ArrayList<>();
        arrayCoordenadores = servidorDao.getServidores();
        for (int i = 0; i < arrayCoordenadores.size(); i++) {
            nomeGrupos.add(arrayCoordenadores.get(i).getSiape() + " - " + arrayCoordenadores.get(i).getNome());
        }
        return nomeGrupos;
    }

    public boolean verificaCadastro(String siape) {
        boolean encontrou = false;
        arrayServidores = servidorDao.getServidores();
        for (Servidor s : arrayServidores) {
            if (s.getSiape().equals(siape)) {
                encontrou = true;
            }
        }
        return encontrou;
    }

    public ArrayList<Servidor> getServidoresDeUmGrupo(int gruCodigo) {
        return servidorDao.getServidoresDeUmGrupo(gruCodigo);
    }

    public ArrayList<Servidor> getServidoresDaReuniao(int reuCodigo) {
        return servidorDao.getServidoresDaReuniao(reuCodigo);
    }
    
    public Servidor getServidor(String siape){
        return servidorDao.getServidor(siape);
    }

}
