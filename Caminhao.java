/**
 * Classe que representa um caminhão, que é um tipo de veículo.
 * Extende a classe Veiculo.
 * 
 * @author Matheus Piassi
 * @author Bernardo Pavani
 */
public class Caminhao extends Veiculo {
    
    /**
     * Número de eixos do caminhão.
     */
    private int numeroDeEixos;

    /**
     * Construtor para a classe Caminhao.
     * 
     * @param localizacao Localização inicial do caminhão.
     * @param numeroDeEixos Número de eixos do caminhão.
     */
    public Caminhao(Localizacao localizacao, int numeroDeEixos) {
        super(localizacao, "Imagens/caminhao.png");
        this.numeroDeEixos = numeroDeEixos;
    }

    /**
     * Retorna o tempo de atendimento do caminhão, que é definido pelo número de eixos.
     * 
     * @return O tempo de atendimento para o caminhão, que é igual ao número de eixos.
     */
    @Override
    public int getTempoAtendimento() {
        return numeroDeEixos; // Tempo de atendimento para caminhões
    }
}
