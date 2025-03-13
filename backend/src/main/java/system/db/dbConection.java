package system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConection {
    // URL de conexão para o banco de dados H2
    private static final String URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";  // Armazenamento local
    private static final String USER = "sa";  // Usuário do banco
    private static final String PASSWORD = "";  // Senha (vazia por padrão)

    // Método para conectar e criar uma tabela simples
    public void conectarBanco() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conectado ao banco de dados.");

            // Criando a tabela 'laboratorios'
            String sqlLaboratorio = "CREATE TABLE IF NOT EXISTS laboratorios ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "nome VARCHAR(255) NOT NULL)";

            // Criando a tabela 'remedios'
            String sqlRemedios = "CREATE TABLE IF NOT EXISTS remedios ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "nome VARCHAR(255) NOT NULL, "
                + "principioAtivo VARCHAR(150), "
                + "posologia VARCHAR(150), "
                + "indicacoes VARCHAR(255), "
                + "contraIndicacoes VARCHAR(255), "
                + "ativo BOOLEAN, "
                + "laboratorio_id INT, "
                + "CONSTRAINT fk_laboratorio FOREIGN KEY (laboratorio_id) REFERENCES laboratorios(id), "
                + "categoria VARCHAR(150))";

            // Executando os comandos SQL
            try (Statement statement = connection.createStatement()) {
                statement.execute(sqlLaboratorio);
                System.out.println("Tabela 'laboratorios' criada com sucesso.");

                statement.execute(sqlRemedios);
                System.out.println("Tabela 'remedios' criada com sucesso.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void conectarBancoTeste() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:C:/Users/jtral/Desktop/Projeto Kaynan novo/backend/db", "sa", "password")) {
            System.out.println("Conectado ao banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
