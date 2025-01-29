import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Pedagio extends Item {
    private Queue<Veiculo> filaCarros;
    private List<Cone> cones;

    public Pedagio(Localizacao localizacao, String imagemString) {
        super(localizacao, imagemString);
        this.filaCarros = new LinkedList<>();
        this.cones = new ArrayList<>();
        inicializarCones();
    }

    private void inicializarCones() {
        int x = localizacao.getX();
        int y = localizacao.getY();
        // Adiciona 3 cones à direita do pedágio, com um espaço em branco entre eles
        cones.add(new Cone(new Localizacao(x + 2 , y)));
        cones.add(new Cone(new Localizacao(x + 2, y + 1)));
        cones.add(new Cone(new Localizacao(x + 2, y + 2)));
    }

    public List<Cone> getCones() {
        return cones;
    }

    public void adicionarCarro(Veiculo veiculo) {
        filaCarros.add(veiculo);
    }

    public Queue<Veiculo> getFilaCarros() {
        return filaCarros;
    }

    public void processarCarro() {
        if (!filaCarros.isEmpty()) {
            Veiculo veiculo = filaCarros.poll();
            // Processar o veículo (ex: cobrar pedágio, liberar passagem, etc.)
        }
    }

    @Override
    public void executarAcao() {
        processarCarro();
    }
}