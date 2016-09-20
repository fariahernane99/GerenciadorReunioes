/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.AtaDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class AtaControl {

    private AtaDAO ataDAO = new AtaDAO();

    public boolean deleta(int codigo) {
        return ataDAO.deletar(codigo);
    }

    public boolean adiciona(Ata x) {
        return ataDAO.cadastrar(x);
    }

    public boolean atualiza(Ata x) {
        return ataDAO.alterar(x);
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

}
