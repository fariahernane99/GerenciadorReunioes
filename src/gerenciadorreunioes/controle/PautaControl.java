package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.PautaDAO;
import java.util.ArrayList;

public class PautaControl {

    private PautaDAO pautaDAO = new PautaDAO();
    ArrayList<Pauta> pontos = new ArrayList<>();

    public boolean deleta(int codigo) {
        return pautaDAO.deleta(codigo);
    }

    public boolean adiciona(Pauta x) {
        return pautaDAO.adiciona(x);
    }

    public boolean atualiza(Pauta x) {
        return pautaDAO.atualizar(x);
    }

    public ArrayList<Pauta> getPautas() {
        return pautaDAO.getPautas();
    }

    public ArrayList<Pauta> getPautas(int codAta) {
        return pautaDAO.getPautas(codAta);
    }

    public Pauta getPauta(int cod) {
        return pautaDAO.getPauta(cod);
    }
    
    public void pegaPontosPauta(ArrayList<Pauta> pontos) {
        this.pontos=pontos;
    }
    
    public ArrayList<String> retornaPontos(){
        ArrayList<String> pautasDiscutidas = new ArrayList<String>();
        for (int i = 0; i < pontos.size(); i++) {
            String s = pontos.get(i).getTitulo() + "." + pontos.get(i).getDefinicao();
            pautasDiscutidas.add(s);
        }
        return pautasDiscutidas;
    }
    
    
}
