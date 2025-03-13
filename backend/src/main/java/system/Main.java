package system;

import system.db.dbConection;

public class Main {
    public static void main(String[] args) {
        dbConection bancoDeDados = new dbConection();
        bancoDeDados.conectarBancoTeste(); // Testa a conexão e cria a tabela
    }
}

