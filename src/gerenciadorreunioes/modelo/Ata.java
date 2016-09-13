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
public class Ata {
    private int ataCodigo;
    private String ataStatus;
    private int ata_reuCodigo;

    public int getAta_reuCodigo() {
        return ata_reuCodigo;
    }

    public void setAta_reuCodigo(int ata_reuCodigo) {
        this.ata_reuCodigo = ata_reuCodigo;
    }

    public int getAtaCodigo() {
        return ataCodigo;
    }

    public void setAtaCodigo(int ataCodigo) {
        this.ataCodigo = ataCodigo;
    }

    public String getAtaStatus() {
        return ataStatus;
    }

    public void setAtaStatus(String ataStatus) {
        this.ataStatus = ataStatus;
    }
    
}
