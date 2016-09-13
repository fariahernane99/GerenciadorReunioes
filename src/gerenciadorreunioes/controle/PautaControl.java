package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.PautaDAO;
import java.util.ArrayList;

public class PautaControl {

    private PautaDAO pautaDAO = new PautaDAO();

    public boolean deleta(int codigo) {
        return pautaDAO.deleta(codigo);
    }

    public boolean adiciona(Pauta x) {
        return pautaDAO.adiciona(x);
    }

    public boolean atualiza(Pauta x) {
        return pautaDAO.atualizar(x.getPauCodigo(), x.getPauTitulo(), x.getPauDefinicao(),x.getEncaminhamento(),x.getPau_ataCodigo());
    }

    public ArrayList<Pauta> getPautas() {
        return pautaDAO.getPautas();
    }
    
    public ArrayList<Pauta> getPautas(int codAta) {
        return pautaDAO.getPautas(codAta);
    }
}
