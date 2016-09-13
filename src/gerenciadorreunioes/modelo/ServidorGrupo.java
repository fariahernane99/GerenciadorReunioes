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
public class ServidorGrupo {
    
    private int codigo;
    private String seg_serSiape;
    private int seg_gruCodigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSeg_serSiape() {
        return seg_serSiape;
    }

    public void setSeg_serSiape(String seg_serSiape) {
        this.seg_serSiape = seg_serSiape;
    }

    public int getSeg_gruCodigo() {
        return seg_gruCodigo;
    }

    public void setSeg_gruCodigo(int seg_gruCodigo) {
        this.seg_gruCodigo = seg_gruCodigo;
    }
    
}
