package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Aluno;
import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.Reuniao;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;

public class RedigirAtaControl {

    private AtaControl ataControl = new AtaControl();
    private AlunoControl alunoControl = new AlunoControl();
    private ServidorControl servidorControl = new ServidorControl();
    private GrupoControl grupoControl = new GrupoControl();
    private ReuniaoControl reuniaoControl = new ReuniaoControl();
    private ArrayList<Pauta> arrayPautas = new ArrayList<>();

    public ArrayList<String> retornaParticipantesDaReuniao(int reuCodigo) {
        ArrayList<Servidor> arrayServidores = servidorControl.getServidoresDaReuniao(reuCodigo);
        ArrayList<Aluno> arrayAlunos = alunoControl.getAlunosDaReuniao(reuCodigo);
        ArrayList<String> arrayString = new ArrayList<>();
        for (Servidor ser : arrayServidores) {
            arrayString.add(ser.getSiape() + " - " + ser.getNome());
        }
        for (Aluno alu : arrayAlunos) {
            arrayString.add(alu.getMatricula() + " - " + alu.getNome());
        }
        return arrayString;
    }

    /*
    public ArrayList<ServidorGrupo> retornaServidorGrupo(int codigo) {
        return serv.getServidoresGrupos(codigo);
    }

    public ArrayList<ServidorGrupo> pesquisaServidor(String siape) {
        segGru = s.getSerGrupos();
        ArrayList<ServidorGrupo> sg = new ArrayList<>();
        for (int i = 0; i < segGru.size(); i++) {
            if (segGru.get(i).getServidor().getSiape().equals(siape)) {
                sg.add(segGru.get(i));
            }
        }
        return sg;
    }

    public ArrayList<Grupo> retornaGrupos(ArrayList<ServidorGrupo> sgg) {
        ArrayList<Grupo> gru = new ArrayList<Grupo>();
        for (int i = 0; i < getGrupos().size(); i++) {
            for (int j = 0; j < sgg.size(); j++) {
                if (getGrupos().get(i).getCodigo() == sgg.get(j).getGrupo().getCodigo()) {
                    gru.add(getGrupos().get(i));
                }
            }
        }
        return gru;
    }

    public Ata getAta(int codReuniao) {
        Ata ata = new Ata();
        for (int i = 0; i < getReunioes().size(); i++) {
            for (int j = 0; j < getAtas().size(); j++) {
                if (getReunioes().get(i).getCodigo() == getAtas().get(j).getCodigo()) {
                    ata = getAtas().get(j);
                }
            }
        }
        return ata;
    }

    public ArrayList<Reuniao> pesquisaReunioes(int codGrupo) {
        ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
        for (int i = 0; i < getReunioes().size(); i++) {
            if (getReunioes().get(i).getGrupo().getCodigo() == codGrupo) {
                reunioes.add(getReunioes().get(i));
            }
        }
        return reunioes;
    }

    public ArrayList<Servidor> servidores(ArrayList<ServidorGrupo> s) {
        ArrayList<Servidor> r = new ArrayList<Servidor>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < getServidores().size(); j++) {
                if (s.get(i).getServidor().getSiape().equals(getServidores().get(j).getSiape())) {
                    r.add(getServidores().get(i));
                }
            }
        }
        return r;
    }

    public Reuniao pesquisaCertaReuniao(int codReuniao) {
        Reuniao x = new Reuniao();
        for (int i = 0; i < getReunioes().size(); i++) {
            if (getReunioes().get(i).getCodigo() == codReuniao) {
                x = getReunioes().get(i);
            }
        }
        return x;
    }

    public boolean verificaCampos(String text1) {
        boolean r = false;
        if (text1.equals("")) {
            r = true;
        }
        return r;
    }

    public Pauta retornaPauta(int cod) {
        Pauta r = new Pauta();
        for (int i = 0; i < getPautas().size(); i++) {
            if (getPautas().get(i).getCodigo() == cod) {
                r = getPautas().get(i);
            }
        }
        return r;
    }

    public boolean verificaCamposReuniao(String text0, String text1, String text2, String text3) {
        boolean retorno = false;
        if (text0.equals("") || text1.equals("") || text2.equals("") || text3.equals("")) {
            retorno = true;
        }
        return retorno;
    }

    public boolean verificaCamposPauta(String text0, String text1) {
        boolean retorno = false;
        if (text0.equals("") || text1.equals("")) {
            retorno = true;
        }
        return retorno;
    }*/
    
    public boolean verificaCamposReuniao(String text0, String text1, String text2, String text3) {
        boolean retorno = false;
        if (text0.equals("") || text1.equals("") || text2.equals("") || text3.equals("")) {
            retorno = true;
        }
        return retorno;
    }
    
    public boolean verificaCamposPauta(String text0, String text1) {
        boolean retorno = false;
        if (text0.equals("") || text1.equals("")) {
            retorno = true;
        }
        return retorno;
    }

    public boolean verificaCampos(String titulo) {
        boolean retorno = false;
        if (titulo.equals("")) {
            retorno = true;
        }
        return retorno;
    }
}
