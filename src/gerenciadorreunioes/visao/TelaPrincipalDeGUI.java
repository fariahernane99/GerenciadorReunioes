/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.modelo.Servidor;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class TelaPrincipalDeGUI extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalNova
     */
    private Servidor serAux;

    public TelaPrincipalDeGUI() {
        initComponents();
        serAux = LoginControl.retornaServidorLogado();
        if (serAux.getSerResponsavelAta() == 0) {
            jMenuItemRedigirATA.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonGerenciarGrupos = new javax.swing.JButton();
        jButtonGerenciarServidores = new javax.swing.JButton();
        jButtonGerenciarReunioes = new javax.swing.JButton();
        jButtonGerenciarAlunos = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButtonMudarStatusATA = new javax.swing.JButton();
        jButtonImprimirAta = new javax.swing.JButton();
        jButtonBuscarATA = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGerenciar = new javax.swing.JMenu();
        jMenuItemGerenciarGrupos = new javax.swing.JMenuItem();
        jMenuItemGerenciarServidores = new javax.swing.JMenuItem();
        jMenuItemGerenciarReunioes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuATAs = new javax.swing.JMenu();
        jMenuItemMudaStatusATA = new javax.swing.JMenuItem();
        jMenuItemImprimirATA = new javax.swing.JMenuItem();
        jMenuItemConsultaATA = new javax.swing.JMenuItem();
        jMenuItemRedigirATA = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Sair");
        jLabel3.setToolTipText("Sair da programa");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Reuniões");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N

        jToolBar1.setRollover(true);

        jButtonGerenciarGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/grupo-de-usuarios-de_318-48680.jpg"))); // NOI18N
        jButtonGerenciarGrupos.setToolTipText("Gerenciar Grupos");
        jButtonGerenciarGrupos.setFocusable(false);
        jButtonGerenciarGrupos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGerenciarGrupos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGerenciarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarGruposActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGerenciarGrupos);

        jButtonGerenciarServidores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pessoa-importante_318-10744.jpg"))); // NOI18N
        jButtonGerenciarServidores.setToolTipText("Gerenciar Servidores");
        jButtonGerenciarServidores.setFocusable(false);
        jButtonGerenciarServidores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGerenciarServidores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGerenciarServidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarServidoresActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGerenciarServidores);

        jButtonGerenciarReunioes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reuniao-de-negocios-dos-homens_318-62509.png"))); // NOI18N
        jButtonGerenciarReunioes.setToolTipText("Gerenciar Reuniões");
        jButtonGerenciarReunioes.setFocusable(false);
        jButtonGerenciarReunioes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGerenciarReunioes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGerenciarReunioes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarReunioesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGerenciarReunioes);

        jButtonGerenciarAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alunos.png"))); // NOI18N
        jButtonGerenciarAlunos.setToolTipText("Gerenciar Alunos");
        jButtonGerenciarAlunos.setFocusable(false);
        jButtonGerenciarAlunos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGerenciarAlunos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGerenciarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarAlunosActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGerenciarAlunos);

        jToolBar2.setRollover(true);

        jButtonMudarStatusATA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/images.png"))); // NOI18N
        jButtonMudarStatusATA.setToolTipText("Mudar Status da Ata");
        jButtonMudarStatusATA.setFocusable(false);
        jButtonMudarStatusATA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMudarStatusATA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMudarStatusATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMudarStatusATAActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonMudarStatusATA);

        jButtonImprimirAta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir-simbolo-interface-de-uma-maquina-impressora_318-67390.jpg"))); // NOI18N
        jButtonImprimirAta.setToolTipText("Imprimir Ata");
        jButtonImprimirAta.setFocusable(false);
        jButtonImprimirAta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonImprimirAta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonImprimirAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirAtaActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonImprimirAta);

        jButtonBuscarATA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar.png"))); // NOI18N
        jButtonBuscarATA.setToolTipText("Consultar Ata");
        jButtonBuscarATA.setFocusable(false);
        jButtonBuscarATA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarATA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarATAActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonBuscarATA);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sair.png"))); // NOI18N
        jButtonSair.setText("SAIR");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jMenuGerenciar.setText("Gerenciar");

        jMenuItemGerenciarGrupos.setText("Grupos");
        jMenuItemGerenciarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarGruposActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemGerenciarGrupos);

        jMenuItemGerenciarServidores.setText("Servidores");
        jMenuItemGerenciarServidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarServidoresActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemGerenciarServidores);

        jMenuItemGerenciarReunioes.setText("Reuniões");
        jMenuItemGerenciarReunioes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarReunioesActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemGerenciarReunioes);

        jMenuItem1.setText("Alunos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItem1);

        jMenuBar1.add(jMenuGerenciar);

        jMenuATAs.setText("ATAs");

        jMenuItemMudaStatusATA.setText("Mudar Status da ATA");
        jMenuItemMudaStatusATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMudaStatusATAActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemMudaStatusATA);

        jMenuItemImprimirATA.setText("Imprimir ATA");
        jMenuItemImprimirATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirATAActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemImprimirATA);

        jMenuItemConsultaATA.setText("Consulltar ATA");
        jMenuItemConsultaATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaATAActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemConsultaATA);

        jMenuItemRedigirATA.setText("Redigir ATA");
        jMenuItemRedigirATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedigirATAActionPerformed(evt);
            }
        });
        jMenuATAs.add(jMenuItemRedigirATA);

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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGerenciarServidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarServidoresActionPerformed
        new GerenciarServidoresGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemGerenciarServidoresActionPerformed

    private void jMenuItemImprimirATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirATAActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jMenuItemImprimirATAActionPerformed

    private void jMenuItemGerenciarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarGruposActionPerformed
        new GerenciarGruposGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemGerenciarGruposActionPerformed

    private void jMenuItemGerenciarReunioesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarReunioesActionPerformed
        new GerenciarReunioesGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemGerenciarReunioesActionPerformed

    private void jMenuItemMudaStatusATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMudaStatusATAActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jMenuItemMudaStatusATAActionPerformed

    private void jMenuItemConsultaATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaATAActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jMenuItemConsultaATAActionPerformed

    private void jMenuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSobreMouseClicked
        JOptionPane.showMessageDialog(this, "Desenvolvido por World Systems \n Desenvolvedores: Hernane Marcos de Faria Júnior \n Igor Ribeiro da Silva \n Técnico em Informática III - IFMG Formiga");
    }//GEN-LAST:event_jMenuSobreMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new GerenciarAlunosGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemRedigirATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedigirATAActionPerformed
        new RedigirAtaGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemRedigirATAActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonBuscarATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarATAActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jButtonBuscarATAActionPerformed

    private void jButtonImprimirAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirAtaActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jButtonImprimirAtaActionPerformed

    private void jButtonMudarStatusATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMudarStatusATAActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não foi implementado !!!");
    }//GEN-LAST:event_jButtonMudarStatusATAActionPerformed

    private void jButtonGerenciarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarAlunosActionPerformed
        new GerenciarAlunosGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGerenciarAlunosActionPerformed

    private void jButtonGerenciarReunioesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarReunioesActionPerformed
        new GerenciarReunioesGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGerenciarReunioesActionPerformed

    private void jButtonGerenciarServidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarServidoresActionPerformed
        new GerenciarServidoresGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGerenciarServidoresActionPerformed

    private void jButtonGerenciarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarGruposActionPerformed
        new GerenciarGruposGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGerenciarGruposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarATA;
    private javax.swing.JButton jButtonGerenciarAlunos;
    private javax.swing.JButton jButtonGerenciarGrupos;
    private javax.swing.JButton jButtonGerenciarReunioes;
    private javax.swing.JButton jButtonGerenciarServidores;
    private javax.swing.JButton jButtonImprimirAta;
    private javax.swing.JButton jButtonMudarStatusATA;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenuATAs;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGerenciar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemConsultaATA;
    private javax.swing.JMenuItem jMenuItemGerenciarGrupos;
    private javax.swing.JMenuItem jMenuItemGerenciarReunioes;
    private javax.swing.JMenuItem jMenuItemGerenciarServidores;
    private javax.swing.JMenuItem jMenuItemImprimirATA;
    private javax.swing.JMenuItem jMenuItemMudaStatusATA;
    private javax.swing.JMenuItem jMenuItemRedigirATA;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
