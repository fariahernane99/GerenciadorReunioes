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
public class ModelEmail {
    private String remetente;
    private String nomeRemetente;
    private String senha;
    private String destinatario;
    private String mensagem;
    private String assunto;
    private boolean tipoEmail;
    private String caminhoAnexo;
    private boolean possuiAnexo;

    public boolean isPossuiAnexo() {
        return possuiAnexo;
    }

    public void setPossuiAnexo(boolean possuiAnexo) {
        this.possuiAnexo = possuiAnexo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public boolean isTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(boolean tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getCaminhoAnexo() {
        return caminhoAnexo;
    }

    public void setCaminhoAnexo(String caminhoAnexo) {
        this.caminhoAnexo = caminhoAnexo;
    }
}
