import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.util.Queue;

public class Simulacao {
    private Mapa mapa;
    private JanelaSimulacao janelaSimulacao;
    private List<Pedagio> pedagios = new ArrayList<>();
    private boolean alternarVeiculo = true;

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

    public void executarSimulacao(int numPassos) {
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(1000); // Define a velocidade da animação
        }
    }

    private void executarUmPasso() {
        Veiculo v;
        for (Pedagio pedagio : pedagios) {
            int x = pedagio.getLocalizacaoAtual().getX();
            int y = pedagio.getLocalizacaoAtual().getY();

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

        Queue<Veiculo> filaCarros = pedagio.getFilaCarros();
        Iterator<Veiculo> iterator = filaCarros.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
                
            Localizacao proximaLocalizacao = veiculo.getLocalizacaoAtual().proximaLocalizacao(veiculo.getLocalizacaoDestino());
                    // Verifica se o veículo chegou ao destino
            if (veiculo.getLocalizacaoAtual().equals(veiculo.getLocalizacaoDestino())) {
                veiculo.incrementarContadorAtendimento();
                if(veiculo.getContadorAtendimento() >= veiculo.getTempoAtendimento() + pedagio.getTempoAtendimento()){
                    mapa.removerItem(veiculo);
                    iterator.remove(); // Remove o veículo da fila
        
                } 
            } else 
                // Verifica se o espaço à frente está vazio
                if (!mapa.estaOcupado(proximaLocalizacao)) {
                    if(veiculo.getPodeAvancar()){
                        mapa.removerItem(veiculo);
                        veiculo.executarAcao();
                        mapa.adicionarItem(veiculo);
                        veiculo.setPodeAvancar();
                    } else {
                        veiculo.setPodeAvancar();
                    }
                    //veiculo.setPodeAvancar();

                }
                //veiculo.resetarContadorAtendimento();
                
            }
        }

        janelaSimulacao.executarAcao(); // Atualiza a janela
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}