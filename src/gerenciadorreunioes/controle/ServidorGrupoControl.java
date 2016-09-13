/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.ServidorGrupo;
import gerenciadorreunioes.modelo.ServidorGrupoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ServidorGrupoControl {

    ServidorGrupoDAO servidorGrupoDAO = new ServidorGrupoDAO();

    public boolean adiciona(String siapeMembro, int codigoGrupo) {
        return servidorGrupoDAO.adiciona(siapeMembro, codigoGrupo);
    }
    
    public ArrayList<ServidorGrupo> getSerGrupos(){
        return servidorGrupoDAO.getServidoresGrupos();
    }
    
    public ArrayList<ServidorGrupo> getSerGrupos(int gruCodigo){
        return servidorGrupoDAO.getServidoresGrupos(gruCodigo);
    }
    
    public boolean removeTodosServidoresDoGrupo(int gruCodigo){
        return servidorGrupoDAO.removeTodosServidoresDoGrupo(gruCodigo);
    }

}
