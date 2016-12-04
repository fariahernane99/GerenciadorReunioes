package gerenciadorreunioes.controle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import static gerenciadorreunioes.conexoes.ConnectionFactory.getConnection;
import java.text.DateFormat;
import java.text.ParseException;

public class GeraRelatório {

    public static void geraAta(int reuCodigo,String resAta,ArrayList<String> servidores,ArrayList<String> pontosPauta) throws ParseException {
        HashMap parameters = new HashMap();
        parameters.put("reuCodigo", reuCodigo);
        parameters.put("servidores", servidores);
        parameters.put("pontosPauta", pontosPauta);
        parameters.put("responsavelAta", resAta);
        geraRelatorio("Ata", "Ata", parameters);
    }

    public static void geraAtasConcluidas(java.util.Date d1, java.util.Date d2, String serSiape) {
        HashMap parameters = new HashMap();
        parameters.put("serSiape", serSiape);
        parameters.put("dataInicio", d1);
        parameters.put("dataFim", d2);
        geraRelatorio("AtasConcluidas", "AtasConcluidas", parameters);
    }

    public static void geraAtasFechadas(java.util.Date d1, java.util.Date d2,String serSiape) {
        HashMap parameters = new HashMap();
        parameters.put("serSiape", serSiape);
        parameters.put("dataInicio", d1);
        parameters.put("dataFim", d2);
        geraRelatorio("AtasFechadas", "AtasFechadas", parameters);
    }

    public static void geraRelatorio(String jrxml, String nomeArquivo, HashMap param) {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");
            Connection con = getConnection();
            Map parameters = param;
            JasperReport report = JasperCompileManager.compileReport("src/relatorios/" + jrxml + ".jrxml");
            JasperPrint impressao = JasperFillManager.fillReport(report, parameters, con);
            JasperExportManager.exportReportToPdfFile(impressao, "relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            File arquivo = new File("relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar o Relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }
}
