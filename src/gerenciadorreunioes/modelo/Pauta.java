/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

/**
 *
 * @author Alunos
 */
public class Pauta {

    private int pauCodigo;
    private String pauTitulo;
    private String pauDefinicao;
    private String encaminhamento;

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }
    private int pau_ataCodigo;

    public int getPauCodigo() {
        return pauCodigo;
    }

    public void setPauCodigo(int pauCodigo) {
        this.pauCodigo = pauCodigo;
    }

    public String getPauTitulo() {
        return pauTitulo;
    }

    public void setPauTitulo(String pauTitulo) {
        this.pauTitulo = pauTitulo;
    }

    public String getPauDefinicao() {
        return pauDefinicao;
    }

    public void setPauDefinicao(String pauDefinicao) {
        this.pauDefinicao = pauDefinicao;
    }

    public int getPau_ataCodigo() {
        return pau_ataCodigo;
    }

    public void setPau_ataCodigo(int pau_ataCodigo) {
        this.pau_ataCodigo = pau_ataCodigo;
    }

}
