package gerenciadorreunioes.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo implements Serializable {

    private int codigo;
    private String nome;
    private String descricao;
    private String siapeCoordenador;
    private Set<Servidor> servidores = new HashSet<>();

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

    @ManyToMany(mappedBy = "grupos")
    public Set<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(Set<Servidor> servidores) {
        this.servidores = servidores;
    }

}
