package pt.c07bd.s01basico.s03generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App02InsereTaxonomia
{
    public static void main(String args[])
    {
        System.out.println("BD MySQL:");
        insere("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/biblioteca", "root", "thelab");
        System.out.println();
        
        /*
        System.out.println("BD Cloudscape Derby:");
        insere("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/derby/biblioteca;create=true", "", "");

        System.out.println("BD HSQLDB:");
        insere("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:file:db/hsqldb/biblioteca;shutdown=true", "SA", "");

        System.out.println("BD MS Access:");
        insere("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:BancoDados", "", "");
        */

        System.out.println();
    }
    
    public static void insere(String driver, String bd, String usuario, String senha)
    {

        try {
            // carrega classe com implementacao para o driver
            //   neste caso o driver MySQL
            Class.forName(driver);

            // estabelece conexao com a base de dados
            Connection conexao = DriverManager.getConnection(bd, usuario, senha);

            // cria um objeto de comandos SQL para a base
            Statement comando = conexao.createStatement();

            // aciona metodo que executa comando SQL (este metodo e especialmente usado para atualizacao)
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Geral', '')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Servi�os', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Acad�mico', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Relacionamento', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Busca', 'Servi�os')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Portal', 'Servi�os')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Mail', 'Servi�os')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Vendas', 'Servi�os')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Universidade', 'Acad�mico')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('CG', 'Acad�mico')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Sociedade', 'Acad�mico')");

            // fecha comando
            comando.close();

            // fecha conexao
            conexao.close();

            System.out.println("Dados inseridos com sucesso");

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}
