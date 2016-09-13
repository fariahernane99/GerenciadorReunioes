package gerenciadorreunioes.modelo;

public class Servidor {

    private String siape;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String area;
    private int serResponsavelATA;
    private int serCoordenador;
    private int serDE;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getSerResponsavelATA() {
        return serResponsavelATA;
    }

    public void setSerResponsavelATA(int serResponsavelATA) {
        this.serResponsavelATA = serResponsavelATA;
    }

    public int getSerCoordenador() {
        return serCoordenador;
    }

    public void setSerCoordenador(int serCoordenador) {
        this.serCoordenador = serCoordenador;
    }

    public int getSerDE() {
        return serDE;
    }

    public void setSerDE(int serDE) {
        this.serDE = serDE;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return telefone;
    }

    public void setFone(String fone) {
        this.telefone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
