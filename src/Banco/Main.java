package Banco;

import java.util.Scanner;



/**
 * Classe principal que executa a aplicação bancária.
 * Esta classe fornece um menu interativo para o usuário realizar operações bancárias
 * como consultas de saldo, depósitos, saques e pagamentos.
 */
public class Main {
    /**
     * Ponto de entrada da aplicação.
     * Inicializa o cliente e a conta bancária, e apresenta um menu de opções
     * para interação do usuário até que a opção de sair seja selecionada.
     *
     * @param args Argumentos da linha de comando (não utilizados nesta aplicação).
     */
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        System.out.println("===Bem Vindo ao Bando===");
        System.out.print("Digite o nome do cliente: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o valor do depósito inicial: ");
        double depositoInicial = leitor.nextDouble();

        Cliente cliente = new Cliente(nome, "123.456.789-00");
        ContaBancaria minhaConta = new ContaBancaria(cliente, depositoInicial);

        int opcao = 0;
        while(opcao != 7){
            System.out.println("\n--- MENU DE OPERAÇÕES ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Consultar Limite Cheque Especial");
            System.out.println("3. Depositar Dinheiro");
            System.out.println("4. Sacar Dinheiro");
            System.out.println("5. Pagar um Boleto");
            System.out.println("6. Verificar uso de Cheque Especial");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    minhaConta.consultarSaldo();
                    break;

                case 2:
                    System.out.println("Seu limite total é: R$" + minhaConta.getLimiteChequeEspecial());
                    break;
                case 3:
                    System.out.println("Valor do depósito: ");
                    double vDeposito = leitor.nextDouble();
                    minhaConta.depositar(vDeposito);
                    break;
                case 4:
                    System.out.println("Valor do saque: ");
                    double vSaque = leitor.nextDouble();
                    minhaConta.realizarPagamento(vSaque, "Saque");
                    break;
                case 5:
                    System.out.println("Valor do boleto: ");
                    double vBoleto = leitor.nextDouble();
                    minhaConta.realizarPagamento(vBoleto, "Pagamento de Boleto");
                    break;
                case 6:
                    if (minhaConta.estaUsandoChequeEspecial()) {
                        System.out.println("Você está utilizando o cheque especial. Valor utilizado: R$ " + minhaConta.getValorUsadoCheque());
                    } else {
                        System.out.println("Você não está utilizando o cheque especial.");
                    }
                    break;
                case 7:
                    System.out.println("Obrigado por usar nosso banco!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
            }
        }
        leitor.close();
    }
}
