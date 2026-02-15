package CasaPet;

import java.util.Scanner;

/**
 * Classe principal para interação com a PetMachine via console.
 * Fornece um menu de opções para controlar o processo de banho de pets.
 */
public class Main {

    /**
     * Instância da máquina de banho de pets.
     */
    private final static PetMachine petMachine = new PetMachine();

    /**
     * Scanner para leitura da entrada do usuário.
     */
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que executa o loop do menu da aplicação.
     * Permite ao usuário escolher entre várias operações da máquina.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        int option;

        do {
            System.out.println("===Escolha uma da opções===");
            System.out.println("1- Dar banho no pet");
            System.out.println("2- Adicionar água");
            System.out.println("3- Adicionar shampoo");
            System.out.println("4- Verificar agua da máquina");
            System.out.println("5- Verificar shampoo da máquina");
            System.out.println("6- Verificar se tem pet na máquina");
            System.out.println("7- Colocar pet na máquina");
            System.out.println("8- Tirar pet da máquina");
            System.out.println("9- Limpar máquina de banho");
            System.out.println("0- Sair");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1 -> petMachine.takeShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> new Main().setPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida, tente novamente");
            }
        } while (option != 0 && option >= 0 && option <= 9);

        scanner.close();
    }

    /**
     * Adiciona água à máquina de banho e notifica o usuário.
     */
    private static void setWater() {
        petMachine.addWater();
        System.out.println("Adicionando água na máquina de banho...");
    }

    /**
     * Adiciona shampoo à máquina de banho e notifica o usuário.
     */
    private static void setShampoo() {
        petMachine.addShampoo();
        System.out.println("Adicionando Shampoo na máquina de banho...");
    }

    /**
     * Verifica e exibe a quantidade atual de água na máquina.
     */
    private static void verifyWater() {
        var amount = petMachine.getWater();
        System.out.println("A máquina de banho tem " + amount + " litros de água");
    }

    /**
     * Verifica e exibe a quantidade atual de shampoo na máquina.
     */
    private static void verifyShampoo() {
        var amount = petMachine.getShampoo();
        System.out.println("A máquina de banho tem " + amount + " litros de shampoo");
    }

    /**
     * Verifica se há um pet atualmente na máquina e exibe o status.
     */
    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem um pet na máquina de banho" : "Não tem um pet na máquina de banho");
    }

    /**
     * Solicita o nome do pet ao usuário e o coloca na máquina de banho.
     * Cria uma nova instância de Pet com o nome fornecido.
     */
    public void setPetMachine() {
        String name = "";
        while (name.isEmpty()) {
            System.out.println("Informe o nome do pet:");
            name = scanner.nextLine();
        }
        Pet pet = new Pet(name);
        petMachine.addPet(pet);
        System.out.println("Colocando o pet " + pet.getName() + " na máquina de banho...");
    }

    /**
     * Exibe o nome do pet que está atualmente na máquina, se houver um.
     */
    public void getPetMachine() {
        Pet pet = petMachine.getPet();
        if (pet != null) {
            System.out.println("O pet na máquina é: " + pet.getName());
        } else {
            System.out.println("Não há nenhum pet na máquina.");
        }
    }
}
