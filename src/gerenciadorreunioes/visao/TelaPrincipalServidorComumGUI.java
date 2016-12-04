/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class TelaPrincipalServidorComumGUI extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalNova
     */
    /*
    MODIFICAR A PARTIR DAQUI !!!!! 
    SE FOR RESPONSAVEL POR ATA, INICIALIZA O CONSTRUTOR COM PARAMETRO
    SE NAO, INICIALIZA COM CONSTRUTOR SEM PARAMETRO !!!
     */
    public TelaPrincipalServidorComumGUI() {
        initComponents();
        jMenuItemRedigirAta.setEnabled(false);
    }

    public TelaPrincipalServidorComumGUI(int i) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        jButtonImprimirAta = new javax.swing.JButton();
        jButtonBuscarAta = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCoordenador = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuATAs = new javax.swing.JMenu();
        jMenuItemImprimirAta = new javax.swing.JMenuItem();
        jMenuItemConsultaAta = new javax.swing.JMenuItem();
        jMenuItemRedigirAta = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tela Principal de Servidor - Gerenciador de Reuniões");
        setResizable(false);

        jToolBar2.setRollover(true);

        jButtonImprimirAta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir.jpg"))); // NOI18N
        jButtonImprimirAta.setFocusable(false);
        jButtonImprimirAta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonImprimirAta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButtonImprimirAta);

        jButtonBuscarAta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar.png"))); // NOI18N
        jButtonBuscarAta.setToolTipText("Consultar Ata");
        jButtonBuscarAta.setFocusable(false);
        jButtonBuscarAta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarAta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAtaActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonBuscarAta);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sair.png"))); // NOI18N
        jButtonSair.setText("SAIR");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 40, 480, 260);

        jLabelCoordenador.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        jLabelCoordenador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCoordenador.setText("BEM VINDO, COORDENADOR!");
        jPanel2.add(jLabelCoordenador);
        jLabelCoordenador.setBounds(0, 10, 540, 23);

        jMenuATAs.setText("ATAs");

        jMenuItemImprimirAta.setText("Imprimir ATA");
        jMenuItemImprimirAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirAtaActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemImprimirAta);

        jMenuItemConsultaAta.setText("Consulltar ATA");
        jMenuItemConsultaAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAtaActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemConsultaAta);

        jMenuItemRedigirAta.setText("Redigir ATA");
        jMenuItemRedigirAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedigirAtaActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemRedigirAta);

        jMenuBar1.add(jMenuATAs);

        jMenuSobre.setText("Sobre");
        jMenuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSobreMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemImprimirAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirAtaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemImprimirAtaActionPerformed

    private void jMenuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSobreMouseClicked
         JOptionPane.showMessageDialog(this, "Desenvolvido por World Systems \n Desenvolvedores: Hernane Marcos de Faria Júnior \n Igor Ribeiro da Silva \n Técnico em Informática III - IFMG Formiga");
    }//GEN-LAST:event_jMenuSobreMouseClicked

    private void jMenuItemRedigirAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedigirAtaActionPerformed
        new RedigirAtaGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemRedigirAtaActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new LoginGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonBuscarAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAtaActionPerformed
        new ConsultarAtaGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBuscarAtaActionPerformed

    private void jMenuItemConsultaAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAtaActionPerformed
        new ConsultarAtaGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemConsultaAtaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarAta;
    private javax.swing.JButton jButtonImprimirAta;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCoordenador;
    private javax.swing.JMenu jMenuATAs;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemConsultaAta;
    private javax.swing.JMenuItem jMenuItemImprimirAta;
    private javax.swing.JMenuItem jMenuItemRedigirAta;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

}
