/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.AtaControl;
import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor Silva
 */
public class MudarStatusAtaGUI extends javax.swing.JFrame {

    private Servidor coordenador;
    private AtaControl ataControl = new AtaControl();
    private final ArrayList<Ata> atasGruposCoordenador;
    private DefaultListModel modelo = new DefaultListModel();
    private Ata ata = new Ata();

    public MudarStatusAtaGUI() {
        initComponents();
        coordenador = LoginControl.retornaServidorLogado();
        atasGruposCoordenador = ataControl.getAtasDeUmGrupo(coordenador.getSiape());
        listaAtas();
    }

    private void listaAtas() {
        modelo.removeAllElements();
        for (Ata a : atasGruposCoordenador) {
            if (a.getStatus().equalsIgnoreCase("Em Revisão") || a.getStatus().equalsIgnoreCase("Concluída") || a.getStatus().equalsIgnoreCase("Assinada")) {
                modelo.addElement(a.getCodigo() + " - " + a.getReuniao().getNome() + " - " + a.getStatus());
            }
        }
        jListAtas.setModel(modelo);
    }

    private void mudaStatusAtaSelecionada() {
        String selecionado = (String) jListAtas.getSelectedValue();
        String[] pegaCodigo = selecionado.split(" - ");
        int codigo = Integer.parseInt(pegaCodigo[0]);
        for (Ata a : atasGruposCoordenador) {
            if (a.getCodigo() == codigo) {
                ata = a;
            }
        }
        if (ata.getStatus().equalsIgnoreCase("Em Revisão")) {
            jLabelStatusAtual.setText("Em Revisão");
            jRadioButtonConcluida.setEnabled(true);
            jRadioButtonConcluida.setSelected(true);
            jRadioButtonAssinada.setEnabled(false);
            jRadioButtonAssinada.setSelected(false);
            jRadioButtonFechada.setEnabled(false);
            jRadioButtonFechada.setSelected(false);
        } else if (ata.getStatus().equalsIgnoreCase("Concluída")) {
            jLabelStatusAtual.setText("Concluída");
            jRadioButtonConcluida.setEnabled(false);
            jRadioButtonConcluida.setSelected(false);
            jRadioButtonAssinada.setEnabled(true);
            jRadioButtonAssinada.setSelected(true);
            jRadioButtonFechada.setEnabled(false);
            jRadioButtonFechada.setSelected(false);
        } else {
            jLabelStatusAtual.setText("Assinada");
            jRadioButtonConcluida.setEnabled(false);
            jRadioButtonConcluida.setSelected(false);
            jRadioButtonAssinada.setEnabled(false);
            jRadioButtonAssinada.setSelected(false);
            jRadioButtonFechada.setEnabled(true);
            jRadioButtonFechada.setSelected(true);
        }
    }

    private void confirmaAlteracao() {
        if (jLabelStatusAtual.getText().equalsIgnoreCase("Em Revisão")){
            ata.setStatus("Concluída");
        } else if (jLabelStatusAtual.getText().equalsIgnoreCase("Concluída")){
            ata.setStatus("Assinada");
        } else {
            ata.setStatus("Fechada");
        }
        ataControl.atualiza(ata);
        JOptionPane.showMessageDialog(this, "Ata atualizada com sucesso !!!");
        listaAtas();
    }

    private void cancelar() {
        if (coordenador.getSerCoordenador() == 1 || coordenador.getSerDe() == 1) {
            new TelaPrincipalCoordenadorGUI().setVisible(true);
        } else if (coordenador.getSerResponsavelAta() == 1) {
            new TelaPrincipalServidorGUI(1).setVisible(true);
        } else {
            new TelaPrincipalServidorGUI().setVisible(true);
        }
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAtas = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonAssinada = new javax.swing.JRadioButton();
        jRadioButtonFechada = new javax.swing.JRadioButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelStatusAtual = new javax.swing.JLabel();
        jRadioButtonConcluida = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mudar Status da Ata - Gerenciador de Reuniões");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mudar Status de uma ATA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setText("Status atual:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ATAs disponíveis", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jListAtas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAtasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAtas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Mudar para:");

        jRadioButtonAssinada.setText("Assinada");

        jRadioButtonFechada.setText("Fechada");

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelStatusAtual.setText("Status");

        jRadioButtonConcluida.setText("Concluída");
        jRadioButtonConcluida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConcluidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonConcluida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonAssinada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonFechada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelStatusAtual)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConcluida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAssinada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonFechada)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListAtasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAtasMouseClicked
        mudaStatusAtaSelecionada();
    }//GEN-LAST:event_jListAtasMouseClicked

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        confirmaAlteracao();
        listaAtas();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonConcluidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConcluidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonConcluidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelStatusAtual;
    private javax.swing.JList<String> jListAtas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonAssinada;
    private javax.swing.JRadioButton jRadioButtonConcluida;
    private javax.swing.JRadioButton jRadioButtonFechada;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
