package gerenciadorreunioes.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class ConnectionFactory {
    
    //singleton
    private static ConnectionFactory instance = new ConnectionFactory();
    
    //constante e static - para usar sempre a mesma referência
    public static final String URL = "jdbc:mysql://localhost:3306/reunioes";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver"; 
    
    //construtor privado - padrão singleton - garantir unica instancia para todo o aplicativo
    ConnectionFactory() {
        try {
            //registra o driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERRO: Erro na conexão com o banco de dados");
        }
        return connection;
    }   
    
    
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
}


