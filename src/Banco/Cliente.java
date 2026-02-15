package Banco;

/**
 * Representa um cliente de um banco.
 * Esta classe armazena as informações pessoais do cliente, como nome e CPF.
 */
public class Cliente {
    /**
     * O nome do cliente.
     */
    public String nome;

    /**
     * O número do CPF (Cadastro de Pessoas Físicas) do cliente.
     */
    public String cpf;

    /**
     * Construtor da classe Cliente.
     * Inicializa os atributos nome e CPF com os valores fornecidos.
     *
     * @param nome O nome do cliente.
     * @param cpf O CPF do cliente.
     */
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
}
