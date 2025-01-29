import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Queue;

/**
 * Classe que representa a simulação do tráfego de veículos em um mapa, com interações em pedágios.
 * A simulação alterna entre a adição de carros e caminhões e simula o movimento dos veículos.
 * 
 * @author Matheus Piassi
 * @author Bernardo Pavani
 */
public class Simulacao {

    /**
     * Mapa que contém os itens da simulação, como os pedágios e veículos.
     */
    private Mapa mapa;
    
    /**
     * Janela de simulação para exibição visual da simulação.
     */
    private JanelaSimulacao janelaSimulacao;
    
    /**
     * Lista de pedágios na simulação.
     */
    private ArrayList<Pedagio> pedagios = new ArrayList<>();
    
    /**
     * Flag para alternar entre veículos (carro e caminhão).
     */
    private boolean alternarVeiculo = true;

    /**
     * Construtor da classe Simulacao.
     * Inicializa o mapa, cria os pedágios e a janela de simulação.
     * 
     * Adiciona 5 pedágios alternando entre {@link PedagioPessoa} e {@link PedagioAuto}.
     */
    public Simulacao() {
        mapa = new Mapa();
        for (int i = 0; i < 5; i++) {
            Pedagio pedagio;
            if (i % 2 == 0) {
                pedagio = new PedagioPessoa(new Localizacao(10 + 3 * i, 10));
            } else {
                pedagio = new PedagioAuto(new Localizacao(10 + 3 * i, 10));
            }
            pedagios.add(pedagio);
            mapa.adicionarItem(pedagio); // Supondo que o mapa possa adicionar pedágios
        }

        janelaSimulacao = new JanelaSimulacao(mapa);
    }

    /**
     * Executa a simulação por um número especificado de passos.
     * 
     * @param numPassos O número de passos (iteração) a serem executados na simulação.
     */
    public void executarSimulacao(int numPassos) {
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(1000); // Define a velocidade da animação
        }
    }

    /**
     * Executa um único passo da simulação, movimentando os veículos e processando o tráfego nos pedágios.
     */
    private void executarUmPasso() {
        Veiculo v;
        for (Pedagio pedagio : pedagios) {
            int x = pedagio.getLocalizacaoAtual().getX();
            int y = pedagio.getLocalizacaoAtual().getY();

            // Verifica se há espaço para adicionar um novo veículo
            if (!mapa.estaOcupado(new Localizacao(x + 1, y + 7))) {
                Random random = new Random();
                if (alternarVeiculo) { // Alterna entre carro e caminhão
                    double peso = 100 + (random.nextDouble() * 400); // peso maior que 100 e menor que 500
                    v = new Carro(new Localizacao(x + 1, y + 7), peso); // Exemplo de número de passageiros
                } else {
                    int numeroDeEixos = 2 + random.nextInt(2); // Exemplo de número de eixos
                    v = new Caminhao(new Localizacao(x + 1, y + 7), numeroDeEixos); // Exemplo de capacidade de carga e número de eixos
                }

                v.setLocalizacaoDestino(new Localizacao(x + 1, y));
                pedagio.adicionarCarro(v);
                mapa.adicionarItem(v);
                alternarVeiculo = !alternarVeiculo; // Alterna o tipo de veículo para a próxima iteração
            }

            // Processa a fila de carros no pedágio
            Queue<Veiculo> filaCarros = pedagio.getFilaCarros();
            Iterator<Veiculo> iterator = filaCarros.iterator();
            while (iterator.hasNext()) {
                Veiculo veiculo = iterator.next();
                
                // Calcula a próxima localização do veículo
                Localizacao proximaLocalizacao = veiculo.getLocalizacaoAtual().proximaLocalizacao(veiculo.getLocalizacaoDestino());
                
                // Verifica se o veículo chegou ao destino
                if (veiculo.getLocalizacaoAtual().equals(veiculo.getLocalizacaoDestino())) {
                    veiculo.incrementarContadorAtendimento();
                    if (veiculo.getContadorAtendimento() >= veiculo.getTempoAtendimento() + pedagio.getTempoAtendimento()) {
                        mapa.removerItem(veiculo);
                        iterator.remove(); // Remove o veículo da fila
                    } 
                } else if (!mapa.estaOcupado(proximaLocalizacao)) { // Verifica se o espaço à frente está vazio
                    if (veiculo.getPodeAvancar()) {
                        mapa.removerItem(veiculo);
                        veiculo.executarAcao();
                        mapa.adicionarItem(veiculo);
                        veiculo.setPodeAvancar();
                    } else {
                            veiculo.setPodeAvancar(); // Sem aplicação prática, serve apenas para dar um espaço em branco na animação
                    }
                }
            }
        }

        janelaSimulacao.executarAcao(); // Atualiza a janela
    }

    /**
     * Faz a simulação "esperar" por um determinado número de milissegundos.
     * 
     * @param milisegundos O número de milissegundos para aguardar.
     */
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
