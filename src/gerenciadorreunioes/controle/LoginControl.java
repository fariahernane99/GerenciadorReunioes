/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.GrupoDAO;
import gerenciadorreunioes.modelo.Servidor;
import gerenciadorreunioes.modelo.ServidorDAO;
import gerenciadorreunioes.visao.TelaPrincipalCoordenadorGUI;
import gerenciadorreunioes.visao.TelaPrincipalServidorGUI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class LoginControl {

    private static Servidor servidorLogado;
    private GrupoDAO grupoDao = new GrupoDAO();
    private ServidorDAO servidorDao = new ServidorDAO();
    private ArrayList<Servidor> arrayServidores = new ArrayList();
    private static MessageDigest md = null;

    public void geraBD(){
        servidorDao.getDeCoordenadores();
    }
    
    public boolean verificaLogin(String siape, String senha) {
        senha = criptografar(senha);
        boolean encontrou = false;
        arrayServidores = servidorDao.getServidores();
        for (Servidor s : arrayServidores) {
            if ((siape.equals(s.getSiape())) && (s.getSenha().equals(senha))) {
                servidorLogado = s;
                encontrou = true;
            }
        }
        return encontrou;
    }

    public boolean abreTelaPrincipalDoServidor(String siape, String senha) {
        boolean achou = false;
        boolean encontrou = verificaLogin(siape, senha);
        if (encontrou) {
            if (servidorLogado.getSerCoordenador() == 1 || servidorLogado.getSerDe() == 1) {
                TelaPrincipalCoordenadorGUI telaPrincipal = new TelaPrincipalCoordenadorGUI();
                telaPrincipal.setVisible(true);
            } else if (servidorLogado.getSerResponsavelAta() == 1) {
                TelaPrincipalServidorGUI telaPrincipal = new TelaPrincipalServidorGUI(1);
                telaPrincipal.setVisible(true);
            } else {
                TelaPrincipalServidorGUI telaPrincipal = new TelaPrincipalServidorGUI();
                telaPrincipal.setVisible(true);
            }
            achou = true;
        }
        return achou;
    }

    public static Servidor retornaServidorLogado() {
        return servidorLogado;
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
            hexString.toLowerCase().getChars(hexString.length() - 2,
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
