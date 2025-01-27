import java.util.LinkedList;
import java.util.Queue;

public class Pedagio extends Item {
    private Queue<Veiculo> filaCarros;

    public Pedagio(Localizacao localizacao) {
        super(localizacao, "Imagens/pedagio.png");
        this.filaCarros = new LinkedList<>();
    }

    public void adicionarCarro(Veiculo veiculo) {
        filaCarros.add(veiculo);
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