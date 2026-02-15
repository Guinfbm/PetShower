package CasaPet;

/**
 * A classe PetMachine representa uma máquina projetada para cuidar de animais de estimação.
 * Ela fornece funcionalidades como dar banho nos pets, adicionar água e shampoo,
 * e limpar a máquina. Também gerencia o estado da máquina e do pet.
 */
public class PetMachine {

    /**
     * Indica se a máquina está limpa.
     */
    private boolean clean = true;

    /**
     * A quantidade de água na máquina (em litros).
     */
    private int water = 30;

    /**
     * A quantidade de shampoo na máquina (em litros).
     */
    private int shampoo = 10;

    /**
     * O pet atualmente na máquina. Null se nenhum pet estiver presente.
     */
    private Pet pet = null;

    /**
     * Dá um banho no pet que está atualmente na máquina.
     * Reduz os níveis de água e shampoo, e define a limpeza do pet como verdadeira.
     * Se nenhum pet estiver presente, imprime uma mensagem e sai.
     */
    public void takeShower() {
        if (this.pet == null) {
            System.out.println("Coloque o Pet na máquina de banho");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;

        pet.setClean(true);
        System.out.println("O Pet " + pet.getName() + " está limpo!");
    }

    /**
     * Adiciona água à máquina. Aumenta o nível de água em 2 litros.
     * Se o nível de água já estiver no máximo (30 litros), imprime uma mensagem e sai.
     */
    public void addWater() {
        if (water == 30) {
            System.out.println("A máquina de banho já está cheia de água");
            return;
        }
        water += 2;
    }

    /**
     * Adiciona shampoo à máquina. Aumenta o nível de shampoo em 2 litros.
     * Se o nível de shampoo já estiver no máximo (10 litros), imprime uma mensagem e sai.
     */
    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("A máquina de banho já está cheia de shampoo");
            return;
        }
        shampoo += 2;
    }

    /**
     * Obtém o nível atual de shampoo na máquina.
     *
     * @return A quantidade de shampoo em litros.
     */
    public int getShampoo() {
        return shampoo;
    }

    /**
     * Obtém o nível atual de água na máquina.
     *
     * @return A quantidade de água em litros.
     */
    public int getWater() {
        return water;
    }

    /**
     * Verifica se há um pet na máquina.
     *
     * @return Verdadeiro se um pet estiver presente, falso caso contrário.
     */
    public boolean hasPet() {
        return pet != null;
    }

    /**
     * Define um pet na máquina.
     * Se a máquina estiver suja ou já tiver um pet, imprime uma mensagem e sai.
     *
     * @param pet O pet a ser adicionado à máquina.
     */
    public void setPet(Pet pet) {
        if (this.clean) {
            System.out.println("A máquina de banho está suja, limpe antes de colocar um novo Pet");
            return;
        }
        if (hasPet()) {
            System.out.println("Já tem um Pet" + this.pet.getName() + "na máquina de banho");
            return;
        }
        this.pet = pet;
    }

    /**
     * Remove o pet atual da máquina.
     * Atualiza a limpeza da máquina com base na limpeza do pet.
     * Imprime uma mensagem indicando que o pet foi removido.
     */
    public void removePet() {
        this.clean = this.pet.isClean();
        System.out.println("O Pet " + this.pet.getName() + " está limpo e foi removido da máquina de banho");
        this.pet = null;
    }

    /**
     * Limpa a máquina reduzindo os níveis de água e shampoo.
     * Define a limpeza da máquina como verdadeira e imprime uma mensagem.
     */
    public void wash() {
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina de banho está limpa e pronta para o próximo Pet");
    }

    /**
     * Adiciona um pet à máquina.
     * Se a máquina já tiver um pet, imprime uma mensagem e sai.
     *
     * @param pet O pet a ser adicionado.
     */
    public void addPet(Pet pet) {
       if (this.pet != null) {
           System.out.println("A máquina já tem um pet. Remova o pet atual antes de adicionar outro.");
           return;
       }
       this.pet = pet;
    }

    /**
     * Obtém o pet que está atualmente na máquina.
     *
     * @return O objeto Pet atual, ou null se não houver nenhum.
     */
    public Pet getPet() {
       return this.pet;
    }
}
