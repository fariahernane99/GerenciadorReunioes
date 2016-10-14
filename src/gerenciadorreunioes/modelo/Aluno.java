/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import java.io.Serializable;
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
}
