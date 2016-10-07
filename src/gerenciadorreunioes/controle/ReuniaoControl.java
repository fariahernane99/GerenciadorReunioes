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
import java.util.ArrayList;

/**
 *
 * @author Igor Silva
 */
public class ReuniaoControl {

    private ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
    private GrupoDAO gruDao = new GrupoDAO();

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
        ArrayList<Reuniao> arrayReunioes = getReunioes();
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

    public ArrayList<Reuniao> reunioes(int codGru) {
        ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
        for (int i = 0; i < getReunioes().size(); i++) {
            if (codGru == getReunioes().get(i).getCodigo()) {
                reunioes.add(getReunioes().get(i));
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

}
