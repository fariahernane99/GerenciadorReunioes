/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorDAO;
import gerenciadorreunioes.visao.TelaPrincipalDeGUI;
import gerenciadorreunioes.visao.TelaPrincipalCoordenadorGUI;
import gerenciadorreunioes.visao.TelaPrincipalServidorComumGUI;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class LoginControl {

    private static Servidor servidorAux;
    private ServidorDAO servidorDAO = new ServidorDAO();
    private ArrayList<Servidor> arrayServidores = new ArrayList();

    public LoginControl() {
        arrayServidores = servidorDAO.getServidores();
    }

    public boolean verificaLogin(String siape, String senha) {
        boolean encontrou = false;
        for (Servidor s : arrayServidores) {
            if ((siape.equals(s.getSiape())) && (s.getSenha().equals(senha))) {
                servidorAux = s;
                encontrou = true;
            }
        }
        return encontrou;
    }

    public boolean abreTelaPrincipalDoServidor(String siape, String senha) {
        boolean achou = false;
        boolean encontrou = verificaLogin(siape, senha);
        if (encontrou) {
            if (servidorAux.getSerDE() == 1) {
                TelaPrincipalDeGUI telaPrincipal = new TelaPrincipalDeGUI();
                telaPrincipal.setVisible(true);
            } else if (servidorAux.getSerCoordenador() == 1) {
                TelaPrincipalCoordenadorGUI telaPrincipal = new TelaPrincipalCoordenadorGUI();
                telaPrincipal.setVisible(true);
            } else if (servidorAux.getSerResponsavelATA() == 1) {
                TelaPrincipalServidorComumGUI telaPrincipal = new TelaPrincipalServidorComumGUI(1);
                telaPrincipal.setVisible(true);
            } else {
                TelaPrincipalServidorComumGUI telaPrincipal = new TelaPrincipalServidorComumGUI();
                telaPrincipal.setVisible(true);
            }
            achou = true;
        }
        return achou;
    }

    public static Servidor retornaServidorLogado() {
        return servidorAux;
    }

}
