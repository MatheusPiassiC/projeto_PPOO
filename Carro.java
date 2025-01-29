/**
 * A classe Carro representa um carro que estende a classe Veiculo.
 * Herda os atributos e métodos da classe Veiculo e implementa o método
 * @author Matheus Piassi
 * @author Bernardo Pavani
 */
public class Carro extends Veiculo {
    private double peso;

    /**
     * Construtor para a classe Carro.
     *
     * @param localizacao A localização do carro.
     * @param peso O peso do carro.
     */
    public Carro(Localizacao localizacao, double peso) {
        super(localizacao, "Imagens/carro.png");
        this.peso = peso;
    }

    /**
     * Obtém o tempo de atendimento para o carro.
     *
     * @return O tempo de atendimento calculado com base no peso do carro.
     */
    @Override
    public int getTempoAtendimento() {
        return (int)peso/100; // Tempo de atendimento para carros
    }
}