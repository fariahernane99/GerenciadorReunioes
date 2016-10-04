/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alunos
 */
@Entity
@Table(name = "Pauta")
public class Pauta implements Serializable {

    private int codigo;
    private String titulo;
    private String definicao;
    private String encaminhamento;
    private Ata ata;

    @Id
    @GeneratedValue
    @Column(name = "pauCodigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "pauEncaminhamento", nullable = false)
    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    @Column(name = "pauTitulo", nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "pauDefinicao", nullable = false)
    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    @ManyToOne
    public Ata getAta() {
        return ata;
    }

    public void setAta(Ata ata) {
        this.ata = ata;
    }

}
