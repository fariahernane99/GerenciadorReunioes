/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.GrupoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class GrupoControl {

    private GrupoDAO grupoDao = new GrupoDAO();
    private ArrayList<Grupo> arrayGrupos;

    public boolean verificaCampoNome(String text) {
        boolean verifica = false;
        if (text.equals("")) {
            verifica = true;
        }
        return verifica;
    }

    public String[] listaGruposEmVetorDeString(String siapeCoordenador) {
        ArrayList<Grupo> arrayGrupo;
        arrayGrupo = getGrupos(siapeCoordenador);
        String[] arrayString = new String[arrayGrupo.size()];
        int i = 0;
        for (Grupo g : arrayGrupo) {
            arrayString[i] = g.getCodigo() + " - " + g.getNome();
            i++;
        }
        return arrayString;
    }

    public String[] listaGruposEmVetorDeString() {
        ArrayList<Grupo> arrayGrupo;
        arrayGrupo = getGrupos();
        String[] arrayString = new String[arrayGrupo.size()];
        int i = 0;
        for (Grupo g : arrayGrupo) {
            arrayString[i] = g.getCodigo() + " - " + g.getNome();
            i++;
        }
        return arrayString;
    }

    public boolean deleta(int codigo) {
        return grupoDao.deleta(codigo);
    }

    public boolean atualiza(Grupo x) {
        return grupoDao.atualizar(x);
    }

    public boolean adiciona(Grupo x) {
        return grupoDao.adiciona(x);
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getGrupos();
    }

    public ArrayList<Grupo> getGrupos(String siapeCoordenador) {
        return grupoDao.getGrupos(siapeCoordenador);
    }

    public ArrayList<String> pegaCodigoNomeGrupos() {
        ArrayList<String> nomeGrupos = new ArrayList<String>();
        arrayGrupos = grupoDao.getGrupos();
        for (int i = 0; i < arrayGrupos.size(); i++) {
            nomeGrupos.add(arrayGrupos.get(i).getCodigo() + " - " + arrayGrupos.get(i).getNome());
        }
        return nomeGrupos;
    }

    public int retornaCodigoGrupo(Grupo x) {
        int codigoGrupo = -1;
        arrayGrupos = grupoDao.getGrupos();
        for (Grupo g : arrayGrupos) {
            if ((g.getNome().equals(x.getNome())) && (g.getDescricao().equals(x.getDescricao())) && (g.getSiapeCoordenador().equals(x.getSiapeCoordenador()))) {
                codigoGrupo = g.getCodigo();
            }
        }
        return codigoGrupo;
    }

    public Grupo retornaGrupoPeloCodigo(int codigo) {
        Grupo aux = new Grupo();
        for (Grupo g : arrayGrupos) {
            if (g.getCodigo() == codigo) {
                aux = g;
            }
        }
        return aux;
    }

    public boolean removeTodosServidoresDoGrupo(int codGrupo) {
        return grupoDao.removeTodosServidoresDoGrupo(codGrupo);
    }

    public boolean removeTodosAlunosDoGrupo(int codGrupo) {
        return grupoDao.removeTodosAlunosDoGrupo(codGrupo);
    }

    public ArrayList<Grupo> pesquisaGruposDoResponsavelAta(String siape) {
        return grupoDao.getGruposDoResponsavelAta(siape);
    }

    public Grupo getGrupo(int gruCodigo) {
        return grupoDao.getGrupo(gruCodigo);
    }
    
}
