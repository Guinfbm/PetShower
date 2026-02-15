package CasaPet;

/**
 * Classe que representa um animal de estimação (Pet).
 * Possui atributos para armazenar o nome e o estado de limpeza do animal.
 */
public class Pet {

    // Nome do animal de estimação
    private String name;

    // Indica se o animal está limpo ou sujo
    private Boolean clean;

    /**
     * Construtor que cria um novo pet com um nome especificado.
     * O pet é inicializado como sujo (clean = false).
     * @param name o nome do pet
     */
    public Pet(String name) {
        this.name = name;
        this.clean = false;
    }

    /**
     * Retorna o nome do pet.
     * @return o nome do animal
     */
    public String getName() {
        return name;
    }

    /**
     * Define um novo nome para o pet.
     * @param name o novo nome do animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Verifica se o pet está limpo.
     * @return true se o pet está limpo, false se está sujo
     */
    public Boolean isClean() {
        return clean;
    }

    /**
     * Define o estado de limpeza do pet.
     * @param clean true para marcar como limpo, false para sujo
     */
    public void setClean(Boolean clean) {
        this.clean = clean;
    }
}
