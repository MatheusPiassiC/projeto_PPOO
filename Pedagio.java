import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um pedágio na simulação, onde veículos aguardam atendimento.
 */
public abstract class Pedagio extends Item {
    private Queue<Veiculo> filaCarros;
    private List<Cone> cones;

    /**
     * Cria um pedágio na localização especificada.
     * 
     * @param localizacao   Localização do pedágio no mapa.
     * @param imagemString  Caminho da imagem do pedágio.
     */
    public Pedagio(Localizacao localizacao, String imagemString) {
        super(localizacao, imagemString);
        this.filaCarros = new LinkedList<>();
        this.cones = new ArrayList<>();
        inicializarCones();
    }

    /**
     * Inicializa os cones de sinalização ao redor do pedágio.
     */
    private void inicializarCones() {
        int x = localizacao.getX();
        int y = localizacao.getY();
        cones.add(new Cone(new Localizacao(x + 2, y)));
        cones.add(new Cone(new Localizacao(x + 2, y + 1)));
        cones.add(new Cone(new Localizacao(x + 2, y + 2)));
    }

    /**
     * Retorna a lista de cones ao redor do pedágio.
     * 
     * @return Lista de cones.
     */
    public List<Cone> getCones() {
        return cones;
    }

    /**
     * Adiciona um veículo à fila de atendimento do pedágio.
     * 
     * @param veiculo Veículo a ser adicionado.
     */
    public void adicionarCarro(Veiculo veiculo) {
        filaCarros.add(veiculo);
    }

    /**
     * Retorna a fila de veículos aguardando atendimento.
     * 
     * @return Fila de veículos.
     */
    public Queue<Veiculo> getFilaCarros() {
        return filaCarros;
    }

    /**
     * Retorna o tempo necessário para atender um veículo no pedágio.
     * 
     * @return Tempo de atendimento em unidades de tempo da simulação.
     */
    public abstract int getTempoAtendimento();
}
