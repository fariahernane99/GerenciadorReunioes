package gerenciadorreunioes.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo implements Serializable {

    private int codigo;
    private String nome;
    private String descricao;
    private String siapeCoordenador;

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

    @Column(name = "gruDescricao", nullable = false)
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

}
