/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.GrupoDAO;
import gerenciadorreunioes.modelo.Reuniao;
import gerenciadorreunioes.modelo.ReuniaoDAO;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor Silva
 */
public class ReuniaoControl {

    private ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
    private GrupoDAO gruDao = new GrupoDAO();
    private ArrayList<Servidor> serv = new ArrayList<>();
    private Reuniao r = new Reuniao();

    public boolean deleta(int codigo) {
        return reuniaoDAO.deleta(codigo);
    }

    public boolean adiciona(Reuniao x) {
        return reuniaoDAO.adiciona(x);
    }

    public boolean atualiza(Reuniao x) {
        return reuniaoDAO.atualizar(x);
    }

    public ArrayList<Reuniao> getReunioes() {
        return reuniaoDAO.getReunioes();
    }

    public ArrayList<Grupo> getGrupos() {
        return gruDao.getGrupos();
    }

    public int codReuniao(String nome) {
        int codReuniao = 0;
        ArrayList<Reuniao> arrayReunioes = ReuniaoControl.this.getReunioes();
        for (int i = 0; i < arrayReunioes.size(); i++) {
            if (arrayReunioes.get(i).getNome().equals(nome)) {
                codReuniao = arrayReunioes.get(i).getCodigo();
            }
        }
        return codReuniao;
    }

    public boolean verificaDataVazia(String data) {
        boolean vazio = false;
        if (data.equals("")) {
            vazio = true;
        }
        return vazio;
    }

    public boolean verificaCampos(int tamanho, String data, String horarioInicio, String local) {
        boolean verifica = false;
        if ((tamanho < 1) || (data.equals("")) || (horarioInicio.equals("")) || (local.equals(""))) {
            verifica = true;
        }
        return verifica;
    }

    public Grupo pesquisaGrupo(String siape) {
        Grupo x = new Grupo();
        for (int i = 0; i < getGrupos().size(); i++) {
            if (siape.equals(getGrupos().get(i).getSiapeCoordenador())) {
                x = getGrupos().get(i);
            }
        }
        return x;
    }

    public ArrayList<Reuniao> getReunioes(int codGrupo) {
        ArrayList<Reuniao> reunioes = new ArrayList<>();
        for (Reuniao reu : this.getReunioes()) {
            if (reu.getGrupo().getCodigo() == codGrupo){
                reunioes.add(reu);
            }
        }
        return reunioes;
    }

    public ArrayList<Reuniao> retornaReunioesDeUmGrupo(int codGrupo) {
        return reuniaoDAO.retornaReunioesDeUmGrupo(codGrupo);
    }

    public Reuniao getReuniao(int codReuniao) {
        return reuniaoDAO.getReuniao(codReuniao);
    }

    public void setServidoresDaReuniao(int codGrupo) {
        serv = reuniaoDAO.retornaServidoresReuniao(codGrupo);
    }

    public Reuniao retornaReuniao() {
        return r;
    }

    public ArrayList<String> getServidoresDaReuniao() {
        ArrayList<String> servidores = new ArrayList<>();
        for (int i = 0; i < serv.size(); i++) {
            servidores.add(serv.get(i).getNome());
        }
        return servidores;
    }

}
