package gerenciadorreunioes.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo implements Serializable {

    private int codigo;
    private String nome;
    private String descricao;
    private String siapeCoordenador;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Servidor> servidores = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "gruCodigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "gruNome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "gruDescricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "gruSiapeCoordenador", nullable = false)
    public String getSiapeCoordenador() {
        return siapeCoordenador;
    }

    public void setSiapeCoordenador(String siapeCoordenador) {
        this.siapeCoordenador = siapeCoordenador;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "Aluno_Grupo", joinColumns = @JoinColumn(name = "alg_gruCodigo"), inverseJoinColumns = @JoinColumn(name = "alg_aluMatricula"))
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "Servidor_Grupo", joinColumns = @JoinColumn(name = "seg_gruCodigo"), inverseJoinColumns = @JoinColumn(name = "seg_serSiape"))
    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

}
