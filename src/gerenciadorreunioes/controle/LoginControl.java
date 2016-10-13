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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class LoginControl {

    private static Servidor servidorAux;
    private ServidorDAO servidorDAO = new ServidorDAO();
    private ArrayList<Servidor> arrayServidores = new ArrayList();
    private static MessageDigest md = null;

    public LoginControl() {
        arrayServidores = servidorDAO.getServidores();
    }

    public boolean verificaLogin(String siape, String senha) {
        senha = criptografar(senha);
        boolean encontrou = false;
        for (Servidor s : arrayServidores) {
            if ((siape.equals(s.getSiape())) && (s.getSenha().equalsIgnoreCase(senha))) {
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
            //se o servidor for da Diretoria de Ensino abre a tela da DE
            if (servidorAux.getSerDe() == 1) {
                TelaPrincipalDeGUI telaPrincipal = new TelaPrincipalDeGUI();
                telaPrincipal.setVisible(true);
            } else if (servidorAux.getSerCoordenador() == 1) {
                TelaPrincipalCoordenadorGUI telaPrincipal = new TelaPrincipalCoordenadorGUI();
                telaPrincipal.setVisible(true);
            } else if (servidorAux.getSerResponsavelAta() == 1) {
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
    
    static {
        //Try catch referente ao algoritmo do MD5 e seus possiveis erros
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
 
    
  private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;
 
        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() -2,
            hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }
 
  
public static String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }

}
