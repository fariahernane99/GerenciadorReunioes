/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.AlunoGrupo;
import gerenciadorreunioes.modelo.AlunoGrupoDAO;
import java.util.ArrayList;

/**
 *
 * @author Hernane Faria
 */
public class AlunoGrupoControl {

    private AlunoGrupoDAO servidorGrupoDAO = new AlunoGrupoDAO();

    public boolean adiciona(String siapeMembro, int codigoGrupo) {
        return servidorGrupoDAO.adiciona(siapeMembro, codigoGrupo);
    }

    public ArrayList<AlunoGrupo> getAluGrupos() {
        return servidorGrupoDAO.getAlunosGrupos();
    }

    public ArrayList<AlunoGrupo> getAluGrupos(int gruCodigo) {
        return servidorGrupoDAO.getAlunosGrupos(gruCodigo);
    }

    public boolean removeTodosAlunosDoGrupo(int gruCodigo) {
        return servidorGrupoDAO.removeTodosAlunosDoGrupo(gruCodigo);
    }

}
