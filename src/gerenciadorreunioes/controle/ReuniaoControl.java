/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.AtaDAO;
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
    private AtaDAO ataDao = new AtaDAO();

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

    public ArrayList<Reuniao> getReunioes(int gruCodigo) {
        ArrayList<Reuniao> reunioes = new ArrayList<>();
        for (Reuniao reu : getReunioes()) {
            if (reu.getGrupo().getCodigo() == gruCodigo) {
                reunioes.add(reu);
            }
        }
        return reunioes;
    }

    public ArrayList<Reuniao> getReunioesAtaAberta(int gruCodigo, String siape) {
        ArrayList<Reuniao> reunioes = new ArrayList<>();
        ArrayList<Ata> atas = ataDao.getAtas();
        for (int i = 0; i < getReunioes().size(); i++) {
            for (int j = 0; j < atas.size(); j++) {
                if (siape.equals(getReunioes().get(i).getSiapeResponsavelAta())
                        && getReunioes().get(i).getCodigo() == atas.get(j).getReuniao().getCodigo()
                        && getReunioes().get(i).getGrupo().getCodigo() == gruCodigo
                        && atas.get(j).getStatus().equals("Aberta")) {
                    reunioes.add(getReunioes().get(i));
                }
            }
        }
        return reunioes;
    }

    public Reuniao getReuniao(int codReuniao) {
        return reuniaoDAO.getReuniao(codReuniao);
    }
}
