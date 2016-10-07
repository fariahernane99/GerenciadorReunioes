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
@Table(name = "Reuniao")
public class Reuniao implements Serializable {

    private int codigo;
    private String nome;
    private String data;
    private String horarioInicio;
    private String horarioFim;
    private String local;
    private int siapeResponsavelAta;
    private Grupo grupo;

    @Id
    @GeneratedValue
    @Column(name = "reuCodigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "reuNome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "reuData", nullable = false)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "reuHorarioInicio")
    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Column(name = "reuHorarioFim")
    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Column(name = "reuLocal")
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Column(name = "reuSiapeResponsavelAta", nullable = false)
    public int getSiapeResponsavelAta() {
        return siapeResponsavelAta;
    }

    public void setSiapeResponsavelAta(int siapeResponsavelAta) {
        this.siapeResponsavelAta = siapeResponsavelAta;
    }

    @ManyToOne
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
