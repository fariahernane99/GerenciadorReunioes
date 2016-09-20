/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.AlunoControl;
import gerenciadorreunioes.controle.AlunoGrupoControl;
import gerenciadorreunioes.controle.GrupoControl;
import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.controle.ServidorControl;
import gerenciadorreunioes.controle.ServidorGrupoControl;
import gerenciadorreunioes.modelo.Aluno;
import gerenciadorreunioes.modelo.AlunoGrupo;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorGrupo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class GerenciarGruposGUI extends javax.swing.JFrame {

    private GrupoControl grupoControl = new GrupoControl();
    private Grupo grupoAux;
    private ServidorControl servControl = new ServidorControl();
    private Servidor serAux;
    private ServidorGrupoControl servGrupoControl = new ServidorGrupoControl();
    private AlunoGrupoControl aluGrupoControl = new AlunoGrupoControl();
    private AlunoControl alunoControl = new AlunoControl();
    private LoginControl loginControl = new LoginControl();
    private DefaultListModel modelo = new DefaultListModel();
    private ArrayList<Grupo> arrayGrupos;
    private ArrayList<Servidor> arrayServidores;
    private ArrayList<Servidor> arrayCoordenadores;
    private ArrayList<Aluno> arrayAlunos;

    /**
     * Creates new form CadastroDeGrupo
     */
    public GerenciarGruposGUI() {
        initComponents();
        limpaCombosLista();
        preencheVetoresDeServidoresEAlunos();
        serAux = LoginControl.retornaServidorLogado();
        listaGrupos();
        atualizaComboCoordenadores(serAux);
        atualizaComboServidoresAlunos();
        resetaBotoes();
        resetaCampos();
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
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jComboBoxCoordenadores = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListGrupos = new javax.swing.JList<String>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxParticipantes = new javax.swing.JComboBox<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListParticipantes = new javax.swing.JList<String>();
        jLabel4 = new javax.swing.JLabel();
        jButtonInserirParticipante = new javax.swing.JButton();
        jButtonExcluirParticipante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manusear Grupos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Grupo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome do departamento ou entidade:");

        jLabel2.setText("Descrição(Opcional):");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jComboBoxCoordenadores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select nome completo servidores where serCoordenadores = 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCoordenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCoordenadoresActionPerformed(evt);
            }
        });

        jLabel5.setText("Selecione o coordenador do grupo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCoordenadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBoxCoordenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gravar.PNG"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grupos Cadastrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jListGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListGruposMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListGrupos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participantes do Grupo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(null);

        jLabel3.setText("Selecione o Participante:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 30, 140, 20);

        jComboBoxParticipantes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select nome completo servidor e alunos", "Item 2", "Item 3", "Item 4" }));
        jComboBoxParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxParticipantesActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBoxParticipantes);
        jComboBoxParticipantes.setBounds(10, 50, 220, 20);

        jListParticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListParticipantesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListParticipantes);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(10, 130, 290, 140);

        jLabel4.setText("Participantes Cadastrados:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 110, 250, 14);

        jButtonInserirParticipante.setMnemonic('I');
        jButtonInserirParticipante.setText("Inserir Participante");
        jButtonInserirParticipante.setToolTipText("Inserir participante no grupo");
        jButtonInserirParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirParticipanteActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonInserirParticipante);
        jButtonInserirParticipante.setBounds(10, 80, 130, 23);

        jButtonExcluirParticipante.setText("Excluir Participante");
        jButtonExcluirParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirParticipanteActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonExcluirParticipante);
        jButtonExcluirParticipante.setBounds(150, 80, 123, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        editaGrupo();
        cadastraTodosOsParticipantes();
        listaGrupos();
        resetaBotoes();
        resetaCampos();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        cadastraGrupo();
        cadastraTodosOsParticipantes();
        listaGrupos();
        resetaBotoes();
        resetaCampos();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        loginControl.abreTelaPrincipalDoServidor(serAux.getSiape(), serAux.getSenha());
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        excluiGrupo();
        listaGrupos();
        resetaBotoes();
        resetaCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jListGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListGruposMouseClicked
        jogaElementosNosCampos();
    }//GEN-LAST:event_jListGruposMouseClicked

    private void jButtonInserirParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirParticipanteActionPerformed
        insereParticipante();
        jListParticipantes.removeAll();
        jListParticipantes.setModel(modelo);
    }//GEN-LAST:event_jButtonInserirParticipanteActionPerformed

    private void jButtonExcluirParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirParticipanteActionPerformed
        if (jListParticipantes.getSelectedValue().equals(jComboBoxCoordenadores.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Impossível excluir o servidor que está marcando a Reunião !!!");
        } else {
            deletaParticipante();
            jListParticipantes.removeAll();
            jListParticipantes.setModel(modelo);
            JOptionPane.showMessageDialog(this, "O participante foi deletado com sucesso !!!");
        }
        jButtonExcluirParticipante.setEnabled(false);
        jButtonInserirParticipante.setEnabled(true);
    }//GEN-LAST:event_jButtonExcluirParticipanteActionPerformed

    private void jComboBoxCoordenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCoordenadoresActionPerformed
        jListParticipantes.removeAll();
        modelo.removeAllElements();
        modelo.addElement((String) jComboBoxCoordenadores.getSelectedItem());
        jListParticipantes.setModel(modelo);
    }//GEN-LAST:event_jComboBoxCoordenadoresActionPerformed

    private void jComboBoxParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxParticipantesActionPerformed
        jButtonExcluirParticipante.setEnabled(false);
        jButtonInserirParticipante.setEnabled(true);
    }//GEN-LAST:event_jComboBoxParticipantesActionPerformed

    private void jListParticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListParticipantesMouseClicked
        jButtonExcluirParticipante.setEnabled(true);
        jButtonInserirParticipante.setEnabled(false);
    }//GEN-LAST:event_jListParticipantesMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirParticipante;
    private javax.swing.JButton jButtonInserirParticipante;
    private javax.swing.JComboBox<String> jComboBoxCoordenadores;
    private javax.swing.JComboBox<String> jComboBoxParticipantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListGrupos;
    private javax.swing.JList<String> jListParticipantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void cadastraGrupo() {
        boolean vazio = grupoControl.verificaCampoNome(jTextFieldNome.getText());
        if (vazio) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode ficar vazio !!!");
        } else {
            int codigoGrupo = -1;
            Grupo x = new Grupo();
            x.setNome(jTextFieldNome.getText());
            x.setDescricao(jTextAreaDescricao.getText());
            x.setSiapeCoordenador(pegaSiapeDoCoordenador((String) jComboBoxCoordenadores.getSelectedItem()));
            boolean add = grupoControl.adiciona(x);
            codigoGrupo = grupoControl.retornaCodigoGrupo(x);
            if (add) {
                grupoAux = grupoControl.retornaGrupoPeloCodigo(codigoGrupo);
                JOptionPane.showMessageDialog(this, "O grupo foi criado com sucesso !!!");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível adicionar esse grupo !!!");
            }
        }
    }

    private void editaGrupo() {
        boolean vazio = grupoControl.verificaCampoNome(jTextFieldNome.getText());
        if (vazio) {
            JOptionPane.showMessageDialog(this, "O campo 'nome' não pode ficar vazio !!!");
        } else {
            Grupo x = new Grupo();
            x.setCodigo(pegaGrupoSelecionadoNaLista().getCodigo());
            x.setNome(jTextFieldNome.getText());
            x.setDescricao(jTextAreaDescricao.getText());
            x.setSiapeCoordenador(pegaSiapeDoCoordenador((String) jComboBoxCoordenadores.getSelectedItem()));
            servGrupoControl.removeTodosServidoresDoGrupo(x.getCodigo());
            aluGrupoControl.removeTodosAlunosDoGrupo(x.getCodigo());
            boolean verifica = grupoControl.atualiza(x);
            if (verifica) {
                JOptionPane.showMessageDialog(this, "Grupo atualizado com sucesso !!!");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar esse grupo !!!");
            }
        }
    }

    private void excluiGrupo() {
        boolean excluiu = grupoControl.deleta(pegaCodigoGrupo());
        if (excluiu) {
            JOptionPane.showMessageDialog(this, "Excluído com sucesso!!!");
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível excluir!!!");
        }
    }

    private int pegaCodigoGrupo() {
        String selecionado = (String) jListGrupos.getSelectedValue();
        String[] pegaCodigo = selecionado.split(" - ");
        int codigo = Integer.parseInt(pegaCodigo[0]);
        return codigo;
    }

    private void listaGrupos() {
        jListGrupos.removeAll();
        if (serAux.getSerDe() == 1) {
            jListGrupos.setListData(grupoControl.listaGruposEmVetorDeString());
        } else {
            jListGrupos.setListData(grupoControl.listaGruposEmVetorDeString(serAux.getSiape()));
        }
    }

    private String pegaSiapeDoCoordenador(String siapeENome) {
        String[] tupla = siapeENome.split(" - ");
        String siape = "";
        arrayCoordenadores = servControl.getCoordenadores();
        for (Servidor co : arrayCoordenadores) {
            if (co.getSiape().equals(tupla[0])) {
                siape = co.getSiape();
            }
        }
        return siape;
    }

    private Grupo pegaGrupoSelecionadoNaLista() {
        String selecionado = (String) jListGrupos.getSelectedValue();
        if (selecionado != null) {
            String[] pegaCodigo = selecionado.split(" - ");
            int codigo = Integer.parseInt(pegaCodigo[0]);
            arrayGrupos = grupoControl.getGrupos();
            for (Grupo g : arrayGrupos) {
                if (g.getCodigo() == codigo) {
                    grupoAux = g;
                }
            }
        }
        return grupoAux;
    }

    private void insereParticipante() {
        boolean encontrou = false;
        String participante = (String) jComboBoxParticipantes.getSelectedItem();
        for (int i = 0; i < modelo.size(); i++) {
            if (modelo.get(i).equals(participante)) {
                encontrou = true;
            }
        }
        if (encontrou) {
            JOptionPane.showMessageDialog(this, "Esse participante já está cadastrado !!!");
        } else {
            modelo.addElement(participante);
        }
    }

    private void deletaParticipante() {
        int i = jListParticipantes.getSelectedIndex();
        modelo.remove(i);
    }

    private void cadastraTodosOsParticipantes() {
        for (int i = 0; i < jListParticipantes.getModel().getSize(); i++) {
            String[] elemento = jListParticipantes.getModel().getElementAt(i).split(" - ");
            cadastraCadaParticipanteAoGrupo(elemento[0], elemento[1]);
        }
    }

    private void cadastraCadaParticipanteAoGrupo(String codigo, String nome) {
        Servidor par = new Servidor();
        Aluno part = new Aluno();
        boolean cadastrouServ = false, cadastrouAlu = false;
        for (Servidor ser : arrayServidores) {
            if ((ser.getSiape().equals(codigo)) && (ser.getNome().equals(nome))) {
                par = ser;
                cadastrouServ = true;
            }
        }
        for (Aluno alu : arrayAlunos) {
            if ((alu.getMatricula().equals(codigo)) && (alu.getNome().equals(nome))) {
                part = alu;
                cadastrouAlu = true;
            }
        }
        if (cadastrouServ) {
            ServidorGrupo ser = new ServidorGrupo();
            ser.setGrupo(grupoAux);
            ser.setServidor(par);
            servGrupoControl.adiciona(ser);
        } else if (cadastrouAlu) {
            AlunoGrupo alu = new AlunoGrupo();
            alu.setGrupo(grupoAux);
            alu.setAluno(part);
            aluGrupoControl.adiciona(alu);
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível cadastrar o participante de siape/matrícula: " + codigo + "!");
        }
    }

    private void jogaElementosNosCampos() {
        pegaGrupoSelecionadoNaLista();
        if (jListGrupos.getModel().getSize() > 0) {
            jTextFieldNome.setText(grupoAux.getNome());
            jTextAreaDescricao.setText(grupoAux.getDescricao());
            jButtonCadastrar.setEnabled(false);
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jogaTodosParticipantesJList(grupoAux.getCodigo());
        } else {
            JOptionPane.showMessageDialog(this, "Sem informação !!!");
            jButtonCadastrar.setEnabled(true);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
        }
    }

    private void atualizaComboCoordenadores(Servidor serAux) {
        jComboBoxCoordenadores.removeAllItems();
        if (serAux.getSerDe() == 1) {
            ArrayList<String> arrayString = servControl.pegaSiapeNomeCoordenadores(serAux);
            for (String s : arrayString) {
                jComboBoxCoordenadores.addItem(s);
            }
        } else {
            jComboBoxCoordenadores.addItem(serAux.getSiape() + " - " + serAux.getNome());
        }

    }

    private void preencheVetoresDeServidoresEAlunos() {
        arrayServidores = servControl.lista();
        arrayAlunos = alunoControl.getAlunos();
    }

    private void atualizaComboServidoresAlunos() {
        jComboBoxParticipantes.removeAllItems();
        ArrayList<String> arrayString = servControl.pegaSiapeNomeServidores();
        for (String s : arrayString) {
            jComboBoxParticipantes.addItem(s);
        }
        arrayString = alunoControl.pegaMatriculaNomeAlunos();
        for (String s : arrayString) {
            jComboBoxParticipantes.addItem(s);
        }
    }

    private void limpaCombosLista() {
        jListGrupos.removeAll();
        jListParticipantes.removeAll();
        jComboBoxParticipantes.removeAll();
        jComboBoxCoordenadores.removeAll();
    }

    private void resetaCampos() {
        jTextFieldNome.setText("");
        jTextAreaDescricao.setText("");
        modelo.removeAllElements();
        jListParticipantes.setModel(modelo);
    }

    private void resetaBotoes() {
        jButtonCadastrar.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonInserirParticipante.setEnabled(true);
        jButtonExcluirParticipante.setEnabled(false);
    }

    private void jogaTodosParticipantesJList(int gruCodigo) {
        ArrayList<ServidorGrupo> arrayServGrupo = servGrupoControl.getSerGrupos(gruCodigo);
        ArrayList<AlunoGrupo> arrayAluGrupo = aluGrupoControl.getAluGrupos(gruCodigo);
        modelo.removeAllElements();
        arrayServidores = servControl.lista();
        for (int i = 0; i < arrayServGrupo.size(); i++) {
            for (Servidor s : arrayServidores) {
                if (s.getSiape().equals(arrayServGrupo.get(i).getServidor().getSiape())) {
                    modelo.addElement(s.getSiape() + " - " + s.getNome());
                }
            }
        }
        arrayAlunos = alunoControl.getAlunos();
        for (int i = 0; i < arrayAluGrupo.size(); i++) {
            for (Aluno a : arrayAlunos) {
                if (a.getMatricula().equals(arrayAluGrupo.get(i).getAluno().getMatricula())) {
                    modelo.addElement(a.getMatricula() + " - " + a.getNome());
                }
            }
        }
        jListParticipantes.setModel(modelo);
    }

}
