/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.AtaDAO;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.Reuniao;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class AtaControl {

    private AtaDAO ataDAO = new AtaDAO();

    public boolean deleta(int codigo) {
        return ataDAO.deleta(codigo);
    }

    public boolean adiciona(Ata x) {
        return ataDAO.adiciona(x);
    }

    public boolean atualiza(Ata x) {
        return ataDAO.atualizar(x);
    }

    public ArrayList<Ata> getAtas() {
        return ataDAO.getAtas();
    }

    public int codAta(int codReuniao) {
        int codAta = 0;
        ArrayList<Ata> ata = getAtas();
        for (int i = 0; i < ata.size(); i++) {
            if (ata.get(i).getReuniao().getCodigo() == codReuniao) {
                codAta = ata.get(i).getCodigo();
            }
        }
        return codAta;
    }

    public Ata getAta(int codReuniao) {
        return ataDAO.getAta(codReuniao);
    }

    public ArrayList<Ata> getAtasDeUmGrupo(String siape) {
        ArrayList<Ata> atas = new ArrayList<>();
        GrupoControl grupoControl = new GrupoControl();
        ReuniaoControl reuniaoControl = new ReuniaoControl();
        for (Grupo gru : grupoControl.getGrupos(siape)) {
            for (Reuniao reu : reuniaoControl.getReunioes(gru.getCodigo())) {
                atas.add(getAta(reu.getCodigo()));
            }
        }

        return atas;
    }

}
