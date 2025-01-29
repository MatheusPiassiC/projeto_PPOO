/**
 * Representa um pedágio operado por pessoas na simulação.
 */
public class PedagioPessoa extends Pedagio {

    /**
     * Cria um pedágio operado por pessoas na localização especificada.
     * 
     * @param localizacao Localização do pedágio no mapa.
     */
    public PedagioPessoa(Localizacao localizacao) {
        super(localizacao, "Imagens/pedagioPessoa.png");
    }

    /**
     * Retorna o tempo de atendimento para um pedágio operado por pessoas.
     * 
     * @return Tempo de atendimento fixo de 4 unidades de tempo.
     */
    @Override
    public int getTempoAtendimento() {
        return 4;
    }
}
