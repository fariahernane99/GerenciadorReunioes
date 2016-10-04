/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.visao;

import gerenciadorreunioes.controle.LoginControl;
import gerenciadorreunioes.controle.PautaControl;
import gerenciadorreunioes.controle.RedigirAtaControl;
import gerenciadorreunioes.modelo.Ata;
import gerenciadorreunioes.modelo.Grupo;
import gerenciadorreunioes.modelo.Pauta;
import gerenciadorreunioes.modelo.Reuniao;
import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorGrupo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igor Silva
 */
public class RedigirAtaGUI extends javax.swing.JFrame {

    private RedigirAtaControl red = new RedigirAtaControl();
    private PautaControl pautaControl = new PautaControl();
    private Servidor serAux;
    private DefaultTableModel de = new DefaultTableModel();
    private DefaultTableModel dp = new DefaultTableModel();
    private int codReuniao = 0;
    private int codGrupo = 0;
    private int codAta = 0;

    /**
     * Creates new form RedijirATA
     */
    public RedigirAtaGUI() {
        serAux = LoginControl.retornaServidorLogado();
        initComponents();
        jLabelRes.setText("Responsável pela ATA:" + serAux.getNome());
        dp.addColumn("Ponto de pauta");
        dp.addColumn("Definição");
        dp.addColumn("Encaminhamento");
        de.addColumn("Participante");
        de.addColumn("Presença");
        desabilitaTable();
        preencheComboGrupo();
    }

    public void desabilitaTable() {
        jTabbedPane1.setEnabledAt(1, false);
    }

    public String pegaNomeReuniao() {
        String selecionado = (String) jComboBoxReunioes.getSelectedItem();
        String[] pegaCodigo = selecionado.split(" - ");
        codReuniao = Integer.parseInt(pegaCodigo[0]);
        return selecionado;
    }

    public void preencheComboGrupo() {
        ArrayList<ServidorGrupo> seg = red.pesquisaServidor(serAux.getSiape());
        ArrayList<Grupo> grupos = red.retornaGrupos(seg);
        jComboBoxGrupos.removeAllItems();
        for (int i = 0; i < grupos.size(); i++) {
            jComboBoxGrupos.addItem(grupos.get(i).getCodigo() + " - " + grupos.get(i).getNome());
        }
    }

    public void preencheComboReuniao() {
        if (jComboBoxGrupos.getSelectedItem().equals(" ")) {
            JOptionPane.showMessageDialog(this, "Selecione um grupo");
        } else {
            String selecionado = (String) jComboBoxGrupos.getSelectedItem();
            String[] pegaCodigo = selecionado.split(" - ");
            codGrupo = Integer.parseInt(pegaCodigo[0]);
            jComboBoxReunioes.removeAllItems();
            ArrayList<Reuniao> reunioes = red.pesquisaReunioes(codGrupo);
            for (int i = 0; i < reunioes.size(); i++) {
                jComboBoxReunioes.addItem(reunioes.get(i).getCodigo() + " - " + reunioes.get(i).getNome());
            }
        }
    }

    public void preencheTabela() {
        String selecionado = (String) jComboBoxReunioes.getSelectedItem();
        String[] pegaCodigo = selecionado.split(" - ");
        codReuniao = Integer.parseInt(pegaCodigo[0]);
        ArrayList<ServidorGrupo> ser = red.retornaServidorGrupo(codGrupo);
        ArrayList<Servidor> servidores = red.servidores(ser);
        de.getDataVector().removeAllElements();
        for (int i = 0; i < servidores.size(); i++) {
            de.addRow(new Object[]{servidores.get(i).getSiape() + " - " + servidores.get(i).getNome()});

        }
        jTableParticipante.setModel(de);
    }

    public void pesquisaReuniaoSelecionada() {
        String selecionado = (String) jComboBoxReunioes.getSelectedItem();
        String[] pegaCodigo = selecionado.split(" - ");
        codReuniao = Integer.parseInt(pegaCodigo[0]);
        Reuniao r = red.pesquisaCertaReuniao(codReuniao);
        codReuniao = r.getCodigo();
        jTextFieldHorarioInicio.setText(r.getHorarioInicio());
    }

    public void preencheComboPauta() {
        Ata a = red.pesquisaAta(codReuniao);
        codAta = a.getAtaCodigo();
        ArrayList<Pauta> pautas = pautaControl.getPautas(a.getAtaCodigo());
        jComboBoxPontoPauta.removeAllItems();
        for (int i = 0; i < pautas.size(); i++) {
            jComboBoxPontoPauta.addItem(pautas.get(i).getCodigo() + " - " + pautas.get(i).getTitulo());
        }
        preencheTabelaPontos();
    }

    public void preencheTabelaPontos() {
        Ata a = red.pesquisaAta(codReuniao);
        codAta = a.getAtaCodigo();
        ArrayList<Pauta> pautas = pautaControl.getPautas(a.getAtaCodigo());
        dp.getDataVector().removeAllElements();
        for (int i = 0; i < pautas.size(); i++) {
            dp.addRow(new Object[]{pautas.get(i).getCodigo() + " - " + pautas.get(i).getTitulo(), pautas.get(i).getDefinicao(),
                pautas.get(i).getEncaminhamento()});

        }
        jTablePontos.setModel(dp);
    }

    public String pegaTituloPauta() {
        String selecionado = (String) jComboBoxPontoPauta.getSelectedItem();
        return selecionado;
    }

    public void confirmaPonto() {
        Pauta p = new Pauta();
        String pauta = pegaTituloPauta();
        String[] pegaTitulo = pauta.split(" - ");
        p.setCodigo(Integer.parseInt(pegaTitulo[0]));
        p.setTitulo(pegaTitulo[1]);
        boolean flag = red.verificaCamposPauta(jTextAreaDefinicao.getText(), jTextAreaEncaminhamento.getText());
        if (flag) {
            JOptionPane.showMessageDialog(this, "Preencha os campos de encaminhamento e definição");
        } else {
            p.setDefinicao(jTextAreaDefinicao.getText());
            p.setEncaminhamento(jTextAreaEncaminhamento.getText());
            p.setPau_ataCodigo(codAta);
            red.atualizaPauta(p);
            JOptionPane.showMessageDialog(this, "Ponto registrado com sucesso!!");
        }
    }

    public void criaNovoPonto() {
        Pauta p = new Pauta();
        String titulo = JOptionPane.showInputDialog("Informe o título do novo ponto de pauta");
        p.setTitulo(titulo);
        p.setPau_ataCodigo(codAta);
        p.setEncaminhamento("-");
        p.setDefinicao("-");
        if (red.verificaCampos(titulo)) {
            JOptionPane.showMessageDialog(this, "Título da pauta vazio, tente novamente.");
        } else {
            red.adicionaPauta(p);
            ArrayList<Pauta> array = pautaControl.getPautas(codAta);
            for (Pauta pauta : array) {
                if (pauta.getTitulo().equals(p.getTitulo())) {
                    p = pauta;
                }
            }
            JOptionPane.showMessageDialog(this, "Novo ponto adicionado com sucesso!!");
            jComboBoxPontoPauta.addItem(p.getCodigo() + " - " + p.getTitulo());
        }
        preencheTabelaPontos();
    }

    public void selecionaPauta() {
        String selecionado = (String) jComboBoxPontoPauta.getSelectedItem();
        if (selecionado == null) {
            preencheComboPauta();
        } else {
            String[] pegaCodigo = selecionado.split(" - ");
            int cod = Integer.parseInt(pegaCodigo[0]);
            Pauta p = red.retornaPauta(cod);
            jTextAreaDefinicao.setText(p.getDefinicao());
            jTextAreaEncaminhamento.setText(p.getEncaminhamento());
        }
    }

    public void finalizarReunião() {
        boolean flag = red.verificaCamposReuniao(pegaNomeReuniao(), jTextFieldHorarioInicio.getText(), jTextFieldHorarioFim.getText(), jTextFieldLocal.getText());
        if (flag) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos (Horário de início,Horário do fim e local).");
        } else {
            System.out.println(jTextFieldHorarioInicio.getText());
            System.out.println(jTextFieldHorarioFim.getText());
            System.out.println(jTextFieldLocal.getText());
            red.atualizaReuniao(codReuniao, jTextFieldHorarioInicio.getText(), jTextFieldHorarioFim.getText(), jTextFieldLocal.getText());
            JOptionPane.showMessageDialog(this, "Ata finalizada !!!.");

        }

    }

    public void verificaReuniaoSelecionada() {
        boolean flag = red.verificaCampos(jTextFieldHorarioInicio.getText());
        if (flag) {
            JOptionPane.showMessageDialog(this, "Informe corretamente a reunião e o horário de início desta.");
        } else {
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            preencheComboPauta();
        }
    }

    public void verificaDados() {
        String selecionado = (String) jComboBoxReunioes.getSelectedItem();
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Informe a reunião");
        } else {
            preencheTabela();
            pesquisaReuniaoSelecionada();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParticipante = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonProsseguir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxReunioes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabelRes = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldHorarioInicio = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonCriarNovoPonto = new javax.swing.JButton();
        jTextFieldHorarioFim = new javax.swing.JTextField();
        jPanelDefinicoes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDefinicao = new javax.swing.JTextArea();
        jPanelEncaminhamentos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaEncaminhamento = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePontos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButtonRegistrarDefinicao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLocal = new javax.swing.JTextField();
        jComboBoxPontoPauta = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Redigir ATA", 2, 2, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setText("Grupo:");

        jComboBoxGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxGruposMouseClicked(evt);
            }
        });
        jComboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGruposActionPerformed(evt);
            }
        });

        jTableParticipante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Participante", "Presença"
            }
        ));
        jScrollPane1.setViewportView(jTableParticipante);

        jLabel2.setText("Lista de Presença:");

        jButtonProsseguir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download.png"))); // NOI18N
        jButtonProsseguir.setText("Prosseguir");
        jButtonProsseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProsseguirActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecionar Reunião");

        jComboBoxReunioes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxReunioesMouseClicked(evt);
            }
        });
        jComboBoxReunioes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReunioesActionPerformed(evt);
            }
        });

        jLabel5.setText("Dados da Reunião:");

        jLabelRes.setText("Responsável pela ATA:");

        jLabel7.setText("Horário de início da reunião:");

        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar Reunião");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jButtonProsseguir)
                            .addGap(27, 27, 27))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxGrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxReunioes, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelRes)
                        .addGap(146, 146, 146)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPesquisa)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxReunioes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPesquisa)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRes)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonProsseguir)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Início", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Redigir ATA", 2, 0, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download2.jpg"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download (1).jpg"))); // NOI18N
        jButtonFinalizar.setText("Finalizar Reunião");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Ponto de Pauta:");

        jButtonCriarNovoPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/i54.jpg"))); // NOI18N
        jButtonCriarNovoPonto.setText("Criar Novo Ponto de Pauta");
        jButtonCriarNovoPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarNovoPontoActionPerformed(evt);
            }
        });

        jTextFieldHorarioFim.setToolTipText("Horário do término da reunião");

        jPanelDefinicoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Definições sobre o ponto de pauta"));

        jTextAreaDefinicao.setColumns(20);
        jTextAreaDefinicao.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDefinicao);

        javax.swing.GroupLayout jPanelDefinicoesLayout = new javax.swing.GroupLayout(jPanelDefinicoes);
        jPanelDefinicoes.setLayout(jPanelDefinicoesLayout);
        jPanelDefinicoesLayout.setHorizontalGroup(
            jPanelDefinicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanelDefinicoesLayout.setVerticalGroup(
            jPanelDefinicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );

        jPanelEncaminhamentos.setBorder(javax.swing.BorderFactory.createTitledBorder("Encaminhamentos sobre o Ponto de pauta"));

        jTextAreaEncaminhamento.setColumns(20);
        jTextAreaEncaminhamento.setRows(5);
        jScrollPane4.setViewportView(jTextAreaEncaminhamento);

        javax.swing.GroupLayout jPanelEncaminhamentosLayout = new javax.swing.GroupLayout(jPanelEncaminhamentos);
        jPanelEncaminhamentos.setLayout(jPanelEncaminhamentosLayout);
        jPanelEncaminhamentosLayout.setHorizontalGroup(
            jPanelEncaminhamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncaminhamentosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        jPanelEncaminhamentosLayout.setVerticalGroup(
            jPanelEncaminhamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Pontos de Pauta Cadastrados"));

        jTablePontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ponto de Pauta", "Definição", "Encaminhamentos"
            }
        ));
        jScrollPane5.setViewportView(jTablePontos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setText("Horário do fim da Reunião:");

        jButtonRegistrarDefinicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        jButtonRegistrarDefinicao.setText("Registrar Definição");
        jButtonRegistrarDefinicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarDefinicaoActionPerformed(evt);
            }
        });

        jLabel6.setText("Local da reunião:");

        jComboBoxPontoPauta.setFocusTraversalPolicyProvider(true);
        jComboBoxPontoPauta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxPontoPautaFocusLost(evt);
            }
        });
        jComboBoxPontoPauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPontoPautaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPontoPauta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCriarNovoPonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDefinicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHorarioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLocal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFinalizar)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEncaminhamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jButtonRegistrarDefinicao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jButtonCriarNovoPonto))
                    .addComponent(jComboBoxPontoPauta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDefinicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEncaminhamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRegistrarDefinicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVoltar)
                            .addComponent(jButtonFinalizar)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldHorarioFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Redigir Ata", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProsseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProsseguirActionPerformed
        verificaReuniaoSelecionada();
    }//GEN-LAST:event_jButtonProsseguirActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(0, true);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        finalizarReunião();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jComboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGruposActionPerformed
        preencheComboReuniao();
    }//GEN-LAST:event_jComboBoxGruposActionPerformed

    private void jButtonCriarNovoPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarNovoPontoActionPerformed
        criaNovoPonto();
    }//GEN-LAST:event_jButtonCriarNovoPontoActionPerformed

    private void jComboBoxGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGruposMouseClicked

    }//GEN-LAST:event_jComboBoxGruposMouseClicked

    private void jComboBoxReunioesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxReunioesMouseClicked

    }//GEN-LAST:event_jComboBoxReunioesMouseClicked

    private void jComboBoxReunioesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReunioesActionPerformed

    }//GEN-LAST:event_jComboBoxReunioesActionPerformed

    private void jButtonRegistrarDefinicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarDefinicaoActionPerformed
        confirmaPonto();
        preencheComboPauta();
    }//GEN-LAST:event_jButtonRegistrarDefinicaoActionPerformed

    private void jComboBoxPontoPautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPontoPautaActionPerformed
        selecionaPauta();
    }//GEN-LAST:event_jComboBoxPontoPautaActionPerformed

    private void jComboBoxPontoPautaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxPontoPautaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPontoPautaFocusLost

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        verificaDados();
    }//GEN-LAST:event_jButtonPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarNovoPonto;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonProsseguir;
    private javax.swing.JButton jButtonRegistrarDefinicao;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JComboBox<String> jComboBoxPontoPauta;
    private javax.swing.JComboBox<String> jComboBoxReunioes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelRes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelDefinicoes;
    private javax.swing.JPanel jPanelEncaminhamentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableParticipante;
    private javax.swing.JTable jTablePontos;
    private javax.swing.JTextArea jTextAreaDefinicao;
    private javax.swing.JTextArea jTextAreaEncaminhamento;
    private javax.swing.JTextField jTextFieldHorarioFim;
    private javax.swing.JTextField jTextFieldHorarioInicio;
    private javax.swing.JTextField jTextFieldLocal;
    // End of variables declaration//GEN-END:variables
}
