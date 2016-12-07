package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Aluno;
import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;

public class RedigirAtaControl {

    private AtaControl ataControl = new AtaControl();
    private AlunoControl alunoControl = new AlunoControl();
    private ServidorControl servidorControl = new ServidorControl();
    private GrupoControl grupoControl = new GrupoControl();
    private ReuniaoControl reuniaoControl = new ReuniaoControl();
    private ArrayList<Pauta> arrayPautas = new ArrayList<>();

    public ArrayList<String> retornaParticipantesDoGrupo(int gruCodigo) {
        ArrayList<Servidor> arrayServidores = servidorControl.getServidoresParticipantesDoGrupo(gruCodigo);
        ArrayList<Aluno> arrayAlunos = alunoControl.getAlunosParticipantesDoGrupo(gruCodigo);
        ArrayList<String> arrayString = new ArrayList<>();
        for (Servidor ser : arrayServidores) {
            arrayString.add(ser.getSiape() + " - " + ser.getNome());
        }
        for (Aluno alu : arrayAlunos) {
            arrayString.add(alu.getMatricula() + " - " + alu.getNome());
        }
        return arrayString;
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
    }

    public boolean verificaCampos(String titulo) {
        boolean retorno = false;
        if (titulo.equals("")) {
            retorno = true;
        }
        return retorno;
    }
}
