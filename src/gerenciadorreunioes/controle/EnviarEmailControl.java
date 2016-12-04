/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Aluno;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import gerenciadorreunioes.modelo.ModelEmail;
import gerenciadorreunioes.modelo.Servidor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class EnviarEmailControl {

    public void enviarEmail(ModelEmail e) {
        try {
            MultiPartEmail email = new MultiPartEmail(); //Classe responsável por enviar o email
            String emailRemetente = e.getRemetente(); //gmail: testepooemail@gmail.com | hotmail: programacao451@hotmail.com
            String nomeRemetente = e.getNomeRemetente();
            String senhaRemetente = e.getSenha(); //gmail: ifmginfo | hotmail: ifmginfo12
            String hostName = "";  //gmail: smtp.gmail.com | hotmail: smtp-mail.outlook.com
            if (e.isTipoEmail()) {
                hostName = "smtp-mail.outlook.com";
            } else {
                hostName = "smtp.gmail.com";
            }
            String emailDestinatario = e.getDestinatario(); //email do destinatário
            int porta = 587;
            String portaSmtp = Integer.toString(porta); //converte a porta para String

            email.setSmtpPort(porta); //porta para envio
            email.setAuthenticator(new DefaultAuthenticator(emailRemetente, senhaRemetente)); //autenticação da conta
            email.setDebug(true);
            email.setHostName(hostName); //varia de cada servidor
            //propriedades para o envio  do email
            email.getMailSession().getProperties().put("mail.smtps.auth", true);
            email.getMailSession().getProperties().put("mail.debug", "true");
            email.getMailSession().getProperties().put("mail.smtps.port", portaSmtp);
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", portaSmtp);
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
            email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
            email.getMailSession().getProperties().put("mail.smtp.ssl.trust", hostName);
            email.setFrom(emailRemetente, nomeRemetente); //email e nome de quem está enviando o email
            email.setSubject(e.getAssunto()); //Assunto do email
            email.setMsg(e.getMensagem()); //Mensagem do email
            email.addTo(emailDestinatario); //destinatário do email
            email.setTLS(true); //define o método de criptografia
            if (e.isPossuiAnexo()) {
                EmailAttachment anexo1 = new EmailAttachment(); //Classe para anexar arquivos
                anexo1.setPath(e.getCaminhoAnexo()); //Incluindo diretório do anexo
                anexo1.setDisposition(EmailAttachment.ATTACHMENT); //Informando um email que tem anexo
                email.attach(anexo1); //Atribuindo os anexos ao email
            }
            email.send(); //envia o email
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void email(ArrayList<Servidor> servidoresDestinatarios, ArrayList<Aluno> alunosDestinatarios, String senha, String mensagem, Servidor remetente) {
        ModelEmail email = new ModelEmail();
        email.setRemetente(remetente.getEmail());
        email.setAssunto("Informação: Reunião marcada para seu grupo");
        email.setMensagem(mensagem);
        email.setTipoEmail(false);
        email.setSenha(senha);
        email.setPossuiAnexo(false);
        for (int i = 0; i < servidoresDestinatarios.size(); i++) {
            if (!servidoresDestinatarios.get(i).getSiape().equals(remetente.getSiape())) {
                email.setDestinatario(servidoresDestinatarios.get(i).getEmail());
                enviarEmail(email);
            }
        }
        for (int i = 0; i < alunosDestinatarios.size(); i++) {
                email.setDestinatario(alunosDestinatarios.get(i).getEmail());
                enviarEmail(email);
        }
    }

}
