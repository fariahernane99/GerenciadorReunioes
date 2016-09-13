/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ServidorControl {

    private ServidorDAO servidorDao = new ServidorDAO();
    private ArrayList<Servidor> arrayServidores;
    private ArrayList<Servidor> arrayCoordenadores;

    public boolean verificaCampos(String text, String text0, String text1, String text2, String text3, String text4) {
        boolean verifica = false;
        if ((text.equals("")) || (text0.equals("")) || (text1.equals("")) || (text2.equals("")) || (text3.equals("")) || (text4.equals(""))) {
            verifica = true;
        }
        return verifica;
    }

    public boolean adiciona(Servidor x) {
        return servidorDao.adiciona(x);
    }

    public boolean atualiza(Servidor x, String siapeAntigo) {
        return servidorDao.atualizar(x.getSiape(), x.getNome(), x.getTelefone(), x.getEmail(), x.getSenha(), x.getArea(), x.getSerResponsavelATA(), x.getSerCoordenador(), x.getSerDE(), siapeAntigo);
    }

    public boolean deleta(String siape) {
        return servidorDao.deleta(siape);
    }

    public ArrayList<Servidor> lista() {
        return servidorDao.getServidores();
    }

    public ArrayList<Servidor> lista(String siape) {
        return servidorDao.getServidores(siape);
    }

    public ArrayList<Servidor> getCoordenadores() {
        return servidorDao.getCoordenadores();
    }
    
    public ArrayList<Servidor> getServidoresDE() {
        return servidorDao.getServidoresDE();
    }
    
    public ArrayList<Servidor> getMembrosComuns() {
        return servidorDao.getMembrosComuns();
    }
    
    public ArrayList<Servidor> getParticipantesDoGrupo(int gruCodigo){
        return servidorDao.getParticipantesDoGrupo(gruCodigo);
    }
    
    public String[] retornaSiapeNomeEmVetor(ArrayList<Servidor> arrayServ) {
        String[] arrayString = new String[arrayServ.size()];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayServ.get(i).getSiape() + " - " + arrayServ.get(i).getNome();
        }
        return arrayString;
    }

    public ArrayList<String> pegaSiapeNomeCoordenadores(Servidor serAux) {
        ArrayList<String> nomeGrupos = new ArrayList<>();
        ArrayList<Servidor> arrayDe = servidorDao.getServidoresDE();
        arrayServidores = servidorDao.getCoordenadores();
        for (int i = 0; i < arrayDe.size(); i++) {
            if (arrayDe.get(i).equals(serAux)) {
                nomeGrupos.add(arrayDe.get(i).getSiape() + " - " + arrayDe.get(i).getNome());
            }
        }
        for (int i = 0; i < arrayServidores.size(); i++) {
            if (arrayServidores.get(i).equals(serAux)) {
                nomeGrupos.add(arrayServidores.get(i).getSiape() + " - " + arrayServidores.get(i).getNome());
            }
        }
        for (int i = 0; i < arrayDe.size(); i++) {
            nomeGrupos.add(arrayDe.get(i).getSiape() + " - " + arrayDe.get(i).getNome());
        }

        for (int i = 0; i < arrayServidores.size(); i++) {
            nomeGrupos.add(arrayServidores.get(i).getSiape() + " - " + arrayServidores.get(i).getNome());
        }
        return nomeGrupos;
    }

    public ArrayList<String> pegaSiapeNomeServidores() {
        ArrayList<String> nomeGrupos = new ArrayList<String>();
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

}
