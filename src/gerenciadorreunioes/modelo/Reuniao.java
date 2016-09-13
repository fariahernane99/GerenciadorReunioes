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
public class Reuniao {

    private int codigo;
    private String nome;
    private String data;
    private String reuHorarioInicio;
    private String reuHorarioFim;
    private String reuLocal;
    private int reuSiapeResponsavelATA;
    private int reu_gruCodigo;

    public int getReu_gruCodigo() {
        return reu_gruCodigo;
    }

    public void setReu_gruCodigo(int reu_gruCodigo) {
        this.reu_gruCodigo = reu_gruCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getReuHorarioInicio() {
        return reuHorarioInicio;
    }

    public void setReuHorarioInicio(String reuHorarioInicio) {
        this.reuHorarioInicio = reuHorarioInicio;
    }

    public String getReuHorarioFim() {
        return reuHorarioFim;
    }

    public void setReuHorarioFim(String reuHorarioFim) {
        this.reuHorarioFim = reuHorarioFim;
    }

    public String getReuLocal() {
        return reuLocal;
    }

    public void setReuLocal(String reuLocal) {
        this.reuLocal = reuLocal;
    }

    public int getReuSiapeResponsavelATA() {
        return reuSiapeResponsavelATA;
    }

    public void setReuSiapeResponsavelATA(int reuSiapeResponsavelATA) {
        this.reuSiapeResponsavelATA = reuSiapeResponsavelATA;
    }

}
