package Persistencia;

import Classes.Agencia;
import Classes.Cliente;
import Classes.GeradorCPF;
import ExceptionsAndInterfaces.ValorInvalidoException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TesteDados {
    public static void main(String[] args) {
        try {
            // Carregar lista de clientes
            List<Cliente> clientes = PersistenciaDados.carregarClientes();

            // Verificar se há clientes cadastrados
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado no sistema.");
                return;
            }

            // Exibir cabeçalho
            System.out.println("==========================================");
            System.out.println("        CLIENTES CADASTRADOS");
            System.out.println("==========================================");
            System.out.printf("%-15s %-20s %-15s %-20s%n",
                    "CPF", "NOME", "DATA NASC.", "AGÊNCIA");
            System.out.println("------------------------------------------");

            // Exibir cada cliente
            for (Cliente cliente : clientes) {
                System.out.printf("%-15s %-20s %-15s %-20s%n",
                        cliente.getCPF(),
                        cliente.getNome(),
                        new SimpleDateFormat("dd/MM/yyyy").format(cliente.getData_nascimento()),
                        cliente.getAgencia().getNmAgencia());
            }

            System.out.println("==========================================");
            System.out.println("Total de clientes: " + clientes.size());

        } catch (Exception e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}