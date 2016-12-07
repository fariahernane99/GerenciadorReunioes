/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.GrupoDAO;
import gerenciadorreunioes.modelo.Reuniao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alunos
 */
public class GrupoControl {

    private GrupoDAO grupoDao = new GrupoDAO();
    private ArrayList<Grupo> arrayGrupos;
    private ReuniaoControl reuniaoControl = new ReuniaoControl();

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
        ArrayList<String> nomeGrupos = new ArrayList<>();
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

    public ArrayList<Grupo> getGruposAtaAberta(String siape) {
        AtaControl ataControl = new AtaControl();
        ArrayList<Grupo> grupos = new ArrayList<>();
        for (Grupo gru : getGrupos(siape)) {
            for (Reuniao reu : reuniaoControl.getReunioes(gru.getCodigo())) {
                Ata ata = ataControl.getAta(reu.getCodigo());
                if (reu.getGrupo().getCodigo() == gru.getCodigo()
                        && ata.getReuniao().getCodigo() == reu.getCodigo()
                        && ata.getStatus().equals("Aberta")) {
                    grupos.add(gru);
                }
            }
        }
        return grupos;
    }

    public ArrayList<Grupo> pesquisaGruposResponsavelAta(String siape) {
        ArrayList<Grupo> grupos = new ArrayList<>();
        for (Grupo grupo : getGrupos()) {
            for (Reuniao reuniao : reuniaoControl.getReunioes()) {
                if (reuniao.getSiapeResponsavelAta().equals(siape) && reuniao.getGrupo().getCodigo() == grupo.getCodigo()) {
                    grupos.add(grupo);
                }
            }
        }
        //remove elementos repetidos
        Set<Grupo> set = new HashSet<>();
        for (Grupo grupo : grupos) {
            set.add(grupo);
        }
        grupos.removeAll(grupos);
        for (Grupo grupo : set) {
            grupos.add(grupo);
        }
        return grupos;
    }

}
