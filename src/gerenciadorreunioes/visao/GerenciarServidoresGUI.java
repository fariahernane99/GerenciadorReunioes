/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.controle.ServidorControl;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Alunos
 */
public class GerenciarServidoresGUI extends javax.swing.JFrame {

    private DefaultListModel modelo = new DefaultListModel();
    private ServidorControl controleServ = new ServidorControl();
    private ArrayList<Servidor> arrayServ;
    private Servidor serAux;
    private Servidor aux;

    /**
     * Creates new form InserirMembro
     */
    public GerenciarServidoresGUI() {
        initComponents();
        serAux = LoginControl.retornaServidorLogado();
        listaServidores();
        resetaBotoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSiape = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldArea = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonCoordenador = new javax.swing.JRadioButton();
        jRadioButtonDE = new javax.swing.JRadioButton();
        jRadioButtonMembro = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Membros", 2, 2));

        jLabel7.setText("SIAPE:");

        jLabel3.setText("Nome Completo:");

        jLabel4.setText("E-Mail:");

        jLabel5.setText("Telefone:");

        jLabel6.setText("Senha:");

        jLabel8.setText("Área:");

        jLabel9.setText("Qualificação:");

        buttonGroup1.add(jRadioButtonCoordenador);
        jRadioButtonCoordenador.setText("Coordenador");
        jRadioButtonCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCoordenadorActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDE);
        jRadioButtonDE.setText("Funcionário DE");
        jRadioButtonDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDEActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMembro);
        jRadioButtonMembro.setText("Membro Comum");
        jRadioButtonMembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMembroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldSiape, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldFone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldArea, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jRadioButtonCoordenador)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButtonDE)
                    .addComponent(jRadioButtonMembro))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCoordenador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMembro))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Membros Cadastrados\n", 2, 0));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gravar.PNG"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dialog-close.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sair.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButtonCadastrar)
                .addGap(45, 45, 45)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButtonCancelar)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        new TelaPrincipalDeGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        cadastra();
        listaServidores();
        resetaBotoes();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        edita();
        listaServidores();
        resetaBotoes();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jRadioButtonCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCoordenadorActionPerformed
        jRadioButtonCoordenador.setSelected(true);
        jRadioButtonDE.setSelected(false);
        jRadioButtonMembro.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCoordenadorActionPerformed

    private void jRadioButtonDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDEActionPerformed
        jRadioButtonCoordenador.setSelected(false);
        jRadioButtonDE.setSelected(true);
        jRadioButtonMembro.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDEActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        exclui();
        listaServidores();
        resetaBotoes();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jRadioButtonMembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMembroActionPerformed
        jRadioButtonCoordenador.setSelected(false);
        jRadioButtonDE.setSelected(false);
        jRadioButtonMembro.setSelected(true);
    }//GEN-LAST:event_jRadioButtonMembroActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jogaElementosNosCampos();
        jButtonCadastrar.setEnabled(false);
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jList1MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButtonCoordenador;
    private javax.swing.JRadioButton jRadioButtonDE;
    private javax.swing.JRadioButton jRadioButtonMembro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFone;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSiape;
    // End of variables declaration//GEN-END:variables

    private void cadastra() {
        boolean vazio = controleServ.verificaCampos(jTextFieldNome.getText(), jTextFieldSiape.getText(),
                jTextFieldArea.getText(), jTextFieldEmail.getText(), jTextFieldFone.getText(), jPasswordField1.getText());
        if (vazio) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
        } else if (controleServ.verificaCadastro(jTextFieldSiape.getText())) {
            JOptionPane.showMessageDialog(null, "Já existe um servidor com esse siape !!!");
        } else {
            Servidor s = new Servidor();
            s.setSiape(jTextFieldSiape.getText());
            s.setNome(jTextFieldNome.getText());
            s.setEmail(jTextFieldEmail.getText());
            s.setFone(jTextFieldFone.getText());
            s.setSenha(jPasswordField1.getText());
            s.setArea(jTextFieldArea.getText());
            boolean controle = false;
            if (!(jRadioButtonCoordenador.isSelected()) && !(jRadioButtonDE.isSelected()) && !(jRadioButtonMembro.isSelected())) {
                JOptionPane.showMessageDialog(this, "Selecione uma opção de Servidor !!!");
            } else {
                s.setSerCoordenador(converteBooleanParaInt(jRadioButtonCoordenador));
                s.setSerDE(converteBooleanParaInt(jRadioButtonDE));
                s.setSerResponsavelATA(0);
                controle = true;
            }
            if (controle) {
                boolean verifica = controleServ.adiciona(s);
                if (verifica) {
                    JOptionPane.showMessageDialog(null, "O membro foi adicionado com sucesso !!!");
                    limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar esse servidor !!!");
                }
            }
        }
    }

    private void edita() {
        boolean vazio = controleServ.verificaCampos(jTextFieldNome.getText(), jTextFieldSiape.getText(),
                jTextFieldArea.getText(), jTextFieldEmail.getText(), jTextFieldFone.getText(), jPasswordField1.getText());
        if (vazio) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode ficar vazio !!!");
        } else {
            Servidor s = new Servidor();
            s.setSiape(jTextFieldSiape.getText());
            s.setNome(jTextFieldNome.getText());
            s.setEmail(jTextFieldEmail.getText());
            s.setFone(jTextFieldFone.getText());
            s.setSenha(jPasswordField1.getText());
            s.setArea(jTextFieldArea.getText());
            if (!(jRadioButtonCoordenador.isSelected()) && !(jRadioButtonDE.isSelected()) && !(jRadioButtonMembro.isSelected())) {
                JOptionPane.showMessageDialog(this, "Selecione uma opção de Servidor !!!");
            } else {
                s.setSerCoordenador(converteBooleanParaInt(jRadioButtonCoordenador));
                s.setSerDE(converteBooleanParaInt(jRadioButtonDE));
                s.setSerResponsavelATA(0);
            }
            boolean verifica = controleServ.atualiza(s, pegaSiapeAntigo());
            if (verifica) {
                JOptionPane.showMessageDialog(null, "O servidor foi atualizado com sucesso !!!");
                limpaCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar esse servidor !!!");
            }
        }
    }

    private void exclui() {
        String cod = pegaSiapeAntigo();
        boolean add = controleServ.deleta(cod);
        if (add) {
            JOptionPane.showMessageDialog(null, "O membro foi excluído com sucesso com sucesso !!!");
            limpaCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível excluir esse servidor !!!");
        }
    }

    private Servidor pegaServidorSelecionadoNaLista() {
        String selecionado = (String) jList1.getSelectedValue();
        String[] pegaCodigo = selecionado.split(" - ");
        String siape = pegaCodigo[0];
        arrayServ = controleServ.lista();
        for (Servidor s : arrayServ) {
            if (s.getSiape().equals(siape)) {
                aux = s;
            }
        }
        return aux;
    }

    private int converteBooleanParaInt(JRadioButton r) {
        int controle = 0;
        if (r.isSelected()) {
            controle = 1;
        }
        return controle;
    }

    private void jogaElementosNosCampos() {
        if (jList1.getModel().getSize() > 0) {
            aux = pegaServidorSelecionadoNaLista();
            jTextFieldSiape.setText(aux.getSiape());
            jTextFieldNome.setText(aux.getNome());
            jTextFieldEmail.setText(aux.getEmail());
            jTextFieldFone.setText(aux.getFone());
            jTextFieldArea.setText(aux.getArea());
            jPasswordField1.setText(aux.getSenha());
            for (Servidor s : arrayServ) {
                if (s.getSiape().equals(aux.getSiape())) {
                    if (s.getSerCoordenador() == 1) {
                        jRadioButtonCoordenador.setSelected(true);
                        jRadioButtonDE.setSelected(false);
                        jRadioButtonMembro.setSelected(false);
                    } else if (s.getSerDE() == 1) {
                        jRadioButtonCoordenador.setSelected(false);
                        jRadioButtonDE.setSelected(true);
                        jRadioButtonMembro.setSelected(false);
                    } else {
                        jRadioButtonCoordenador.setSelected(false);
                        jRadioButtonDE.setSelected(false);
                        jRadioButtonMembro.setSelected(true);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sem informação !!!");
        }

    }

    private void listaServidores() {
        modelo.removeAllElements();
        if (serAux.getSerCoordenador() == 1) {
            arrayServ = controleServ.getMembrosComuns();
        } else {
            arrayServ = controleServ.lista();
        }
        for (Servidor s : arrayServ) {
            modelo.addElement(s.getSiape() + " - " + s.getNome());
        }
        jList1.setModel(modelo);
    }

    private String pegaSiapeAntigo() {
        String selecionado = (String) jList1.getSelectedValue();
        String[] pegaCodigo = selecionado.split(" - ");
        String siape = pegaCodigo[0];
        return siape;
    }

    private void resetaBotoes() {
        jButtonCadastrar.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        if (serAux.getSerCoordenador() == 1) {
            jRadioButtonCoordenador.setEnabled(false);
            jRadioButtonDE.setEnabled(false);
            jRadioButtonMembro.setSelected(true);
        }
    }

    private void limpaCampos() {
        jTextFieldSiape.setText("");
        jTextFieldNome.setText("");
        jTextFieldEmail.setText("");
        jTextFieldFone.setText("");
        jPasswordField1.setText("");
        jTextFieldArea.setText("");
    }

}
