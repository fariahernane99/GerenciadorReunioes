/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Alunos
 */
@Entity
@Table(name = "Aluno")
public class Aluno implements Serializable {

    private String matricula;
    private String nome;
    private String email;
    private Set<Grupo> grupos = new HashSet<>(); //tabela N para N

    @Id
    @Column(name = "aluMatricula", nullable = false)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Column(name = "aluNome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "aluEmail", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @ManyToMany
    @JoinTable(name = "Aluno_Grupo", joinColumns = @JoinColumn(name = "alg_aluMatricula"), inverseJoinColumns = @JoinColumn(name = "alg_gruCodigo"))
    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
    
}
