/**
 * Representa um pedágio automático na simulação.
 */
public class PedagioAuto extends Pedagio {

    /**
     * Cria um pedágio automático na localização especificada.
     * 
     * @param localizacao Localização do pedágio no mapa.
     */
    public PedagioAuto(Localizacao localizacao) {
        super(localizacao, "Imagens/pedagioAuto.png");
    }

    /**
     * Retorna o tempo de atendimento para um pedágio automático.
     * 
     * @return Tempo de atendimento fixo de 2 unidades de tempo.
     */
    @Override
    public int getTempoAtendimento() {
        return 2;
    }
}
