package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.PautaDAO;
import java.util.ArrayList;

public class PautaControl {

    private PautaDAO pautaDAO = new PautaDAO();

    public boolean deleta(int codigo) {
        return pautaDAO.deletar(codigo);
    }

    public boolean adiciona(Pauta x) {
        return pautaDAO.cadastrar(x);
    }

    public boolean atualiza(Pauta x) {
        return pautaDAO.alterar(x);
    }

    public ArrayList<Pauta> getPautas() {
        return pautaDAO.getPautas();
    }
    
    public ArrayList<Pauta> getPautas(int codAta) {
        return pautaDAO.getPautas(codAta);
    }
}
